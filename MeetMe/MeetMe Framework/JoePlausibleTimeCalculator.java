import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class JoePlausibleTimeCalculator implements PlausibleTimeCalculatorInterface {

	private ArrayList<PlausibleTime> listOfPlausibleTime = new ArrayList<PlausibleTime>();
	private ArrayList<Duration> durations = new ArrayList<Duration>();
	private int totalOfPlausibleTime = 0;
	private int totalOfCandidateTime;

	private int slotTime;
	private int satisfactionLevel;

	@Override
	public ArrayList<PlausibleTime> calculatePlausibleTimes(MeetingEvent meetingEvent) {
		checkDateMeetingEvent(meetingEvent);
		this.slotTime = getNumberSlotTime(meetingEvent);
		// this.slotTime = 1;
		totalOfCandidateTime = countTotalCandidateTime(meetingEvent.getFromDate(), meetingEvent.getToDate())
				/ this.slotTime;
		System.out.println("totalOfCandidateTime : " + (totalOfCandidateTime));
		ArrayList<DateAndQuantity> candidateTimes = new ArrayList<DateAndQuantity>();

		// Membuat Table Candidate Time (List Waktu yang Disediakan oleh Meeting
		// Planner sebagai Kandidat Waktu Rapat)
		candidateTimes = createTableCandidateTime(totalOfCandidateTime, meetingEvent);

		// Mengisi data kuantitas Table Candidate Time berdasarkan jumlah
		// participant yang memiliki waktu sibuk di jam tertentu
		candidateTimes = inputQuantityOfCandidateTime(meetingEvent, totalOfCandidateTime, candidateTimes);

		for (int candidatTime = 0; candidatTime <= totalOfCandidateTime - 1; candidatTime++) {
			System.out.println("Date : " + candidateTimes.get(candidatTime).getTitleDate() + " Quantity :"
					+ candidateTimes.get(candidatTime).getQuantity());
		}

		// Mengisi list Plausible Time berdasarkan jumlah waktu sibuk setiap
		// participan dan meeting constraint
		listOfPlausibleTime = inputListOfPlausibleTime(totalOfCandidateTime, candidateTimes, meetingEvent);

		return listOfPlausibleTime;
	}

	public void checkDateMeetingEvent(MeetingEvent meetingEvent) {
		Calendar calendarFrom = Calendar.getInstance();
		Calendar calendarTo = Calendar.getInstance();
		calendarFrom.setTime(meetingEvent.getFromDate());
		calendarTo.setTime(meetingEvent.getToDate());

		if ((int) calendarTo.getTime().getTime() < (int) calendarFrom.getTime().getTime()) {
			Date temp = new Date();
			temp = meetingEvent.getFromDate();
			meetingEvent.setFromDate(meetingEvent.getToDate());
			meetingEvent.setToDate(temp);
		}
	}

	public int getNumberSlotTime(MeetingEvent meetingEvent) {
		int numberOfListDuration;
		int fpb;
		ArrayList<Duration> durations = new ArrayList<Duration>();
		Duration test = new Duration();
		test.setDuration(countTotalCandidateTime(meetingEvent.getFromDate(), meetingEvent.getToDate()));
		durations.add(test);
		test = new Duration();
		test.setDuration(meetingEvent.getMeetingDurationInMinutes());
		durations.add(test);

		numberOfListDuration = 2;
		for (Person participant : meetingEvent.getParticipants()) {
			for (BusyTime busyTime : participant.getBusyCalendar().getBusyTimes()) {
				test = new Duration();
				test.setDuration(busyTime.getDuration());
				durations.add(test);
				numberOfListDuration++;
				test = new Duration();
				test.setDuration(countTotalCandidateTime(meetingEvent.getFromDate(), busyTime.getFrom()));
				durations.add(test);
				numberOfListDuration++;
			}
		}

		fpb = durations.get(0).getDuration();
		// for(Duration duration : durations){
		// System.out.println("IEU EUY DELE : "+duration.getDuration());
		// fpb = FPB(duration.getDuration());
		// }

		for (int i = 0; i < numberOfListDuration; i++) {
			fpb = findFactor(fpb, durations.get(i).getDuration());
		}

		System.out.println("IEU EUY !! : " + fpb);

		return fpb;
	}

	private int findFactor(int value1, int value2) {
		// Algoritma Euclidean
		int temporary = 0;
		while (value2 != 0) {
			temporary = value1 % value2;
			value1 = value2;
			value2 = temporary;
		}
		return value1;
	}

	public int countTotalCandidateTime(Date dateFrom, Date dateTo) {
		// Modul yang digunakan untuk mencari total Candidate Time berdasarkan
		// jumlah minutes (hours)
		int totalCandidateTime;
		Calendar calendarFrom = Calendar.getInstance();
		Calendar calendarTo = Calendar.getInstance();
		calendarFrom.setTime(dateFrom);
		calendarTo.setTime(dateTo);

		// total = (int) ((calendarTo.getTime().getTime() -
		// calendarFrom.getTime().getTime()) / (3600 * 1000));
		totalCandidateTime = (int) ((calendarTo.getTime().getTime() - calendarFrom.getTime().getTime()) / (60 * 1000));
		// total = total / this.slotTime;
		
		return totalCandidateTime;

	}

	public ArrayList<DateAndQuantity> createTableCandidateTime(int totalOfCandidateTime, MeetingEvent meetingEvent) {
		// Membuat Table Candidate Time (List Waktu yang Disediakan oleh Meeting
		// Planner sebagai Kandidat Waktu Rapat)
		ArrayList<DateAndQuantity> listOfCandidateTime = new ArrayList<DateAndQuantity>();
		;
		for (int candidateTime = 0; candidateTime <= totalOfCandidateTime; candidateTime++) {
			Calendar calendarFrom = Calendar.getInstance();
			calendarFrom.setTime(meetingEvent.getFromDate());
			calendarFrom.add(Calendar.MINUTE, candidateTime * this.slotTime);
			DateAndQuantity dAQ = new DateAndQuantity();
			dAQ.setTitleDate(calendarFrom.getTime());
			dAQ.setQuantity(0);
			listOfCandidateTime.add(dAQ);
		}
		return listOfCandidateTime;

	}

	public ArrayList<DateAndQuantity> inputQuantityOfCandidateTime(MeetingEvent meetingEvent, int totalOfCandidateTime,
			ArrayList<DateAndQuantity> candidateTimes) {
		// Mengisi data kuantitas Table Candidate Time berdasarkan jumlah
		// participant yang memiliki waktu sibuk di jam tertentu
		int indexcandidateTimes = 0;
		Calendar busyFrom = Calendar.getInstance();
		for (Person participant : meetingEvent.getParticipants()) {
			for (BusyTime busyTime : participant.getBusyCalendar().getBusyTimes()) {
				// System.out.println("Participant : "+participant.getName()+"
				// range : "+busyTime.getDuration());
				busyFrom.setTime(busyTime.getFrom());
				for (int i = 0; i < busyTime.getDuration() / this.slotTime; i++) {
					indexcandidateTimes = 0;
					for (indexcandidateTimes = 0; indexcandidateTimes <= (totalOfCandidateTime); indexcandidateTimes++) {
						if (isBusyTimeSameWithCandidateTime(busyFrom, candidateTimes, indexcandidateTimes)) {
							candidateTimes.get(indexcandidateTimes)
									.setQuantity(candidateTimes.get(indexcandidateTimes).getQuantity() + 1);
							// System.out.println("busyTime :
							// "+busyFrom.getTime()+ " Pembanding :
							// "+listOfCandidateTime.get(indexListOfCandidateTime).getTitleDate());
						}
					}
					busyFrom.add(Calendar.MINUTE, this.slotTime);
				}
			}
		}

		return candidateTimes;

	}

	public ArrayList<PlausibleTime> inputListOfPlausibleTime(int totalOfCandidateTime,
			ArrayList<DateAndQuantity> listOfCandidateTime, MeetingEvent meetingEvent) {
		// Mengisi list Plausible Time berdasarkan jumlah waktu sibuk setiap
		// participan dan meeting constraint
		int totalFreeTime = 0;
		// int totalSlot = 0;
		int indexOfCandidateTime;
		int minimalAttendance = setMinimalAttendance(this.satisfactionLevel, meetingEvent);
		PlausibleTime plausibleTime;

		ArrayList<PlausibleTime> listOfPlausibleTime = new ArrayList<PlausibleTime>();
		System.out.println("Attendance : " + minimalAttendance);
		for (indexOfCandidateTime = 0; indexOfCandidateTime < (totalOfCandidateTime); indexOfCandidateTime++) {
			if (listOfCandidateTime.get(indexOfCandidateTime).getQuantity() == 0) {
				plausibleTime = new PlausibleTime();
				plausibleTime.setFrom(listOfCandidateTime.get(indexOfCandidateTime).getTitleDate());

				// totalFreeTime++;
				while (indexOfCandidateTime < (totalOfCandidateTime)
						// && listOfCandidateTime.get(indexOfCandidateTime +
						// 1).getQuantity() == 0
						&& totalFreeTime < (meetingEvent.getMeetingDurationInMinutes() / this.slotTime)) {
					indexOfCandidateTime++;
					totalFreeTime++;
				}

				if (totalFreeTime == meetingEvent.getMeetingDurationInMinutes() / this.slotTime) {
					plausibleTime.setTo(listOfCandidateTime.get(indexOfCandidateTime).getTitleDate());
					listOfPlausibleTime.add(plausibleTime);
					// totalSlot++;
					totalFreeTime = 0;
					indexOfCandidateTime--;
				}

				// if (totalSlot >= this.slotTime) {
				// indexOfCandidateTime = totalOfCandidateTime;
				// }
			}
		}

		if (listOfPlausibleTime.isEmpty()) { // Jika plausible time tidak
												// ditemukan
			return null;
		} else {
			return listOfPlausibleTime;
		}
	}

	public boolean isBusyTimeSameWithCandidateTime(Calendar busyFrom, ArrayList<DateAndQuantity> listOfCandidateTime,
			int indexListOfCandidateTime) {
		// apakah waktu sibuk participant sama dengan candidate time yang ada di
		// list ?
		if ((busyFrom.getTime().getYear() == listOfCandidateTime.get(indexListOfCandidateTime).getTitleDate().getYear())
				&& (busyFrom.getTime().getMonth() == listOfCandidateTime.get(indexListOfCandidateTime).getTitleDate()
						.getMonth())
				&& (busyFrom.getTime().getDate() == listOfCandidateTime.get(indexListOfCandidateTime).getTitleDate()
						.getDate())
				&& (busyFrom.getTime().getHours() == listOfCandidateTime.get(indexListOfCandidateTime).getTitleDate()
						.getHours())
				&& (busyFrom.getTime().getMinutes() == listOfCandidateTime.get(indexListOfCandidateTime).getTitleDate()
						.getMinutes())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isNoBusyTime(ArrayList<DateAndQuantity> listOfCandidateTime, int indexListOfandidatTime) {
		// apakah list tersebut tidak memiliki busy time ?
		if (listOfCandidateTime.get(indexListOfandidatTime).getQuantity() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean thereIsStillNoBusyTime(int totalOfCandidateTime, ArrayList<DateAndQuantity> listOfCandidateTime,
			int indexOfCandidatDate) {
		// apakah participant masih memiliki waktu kosong ?
		if (indexOfCandidatDate < totalOfCandidateTime
				&& listOfCandidateTime.get(indexOfCandidatDate + 1).getQuantity() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public JoePlausibleTimeCalculator(int slotTime, int satisfactionLevel) {
		this.setSlotTime(slotTime);
		this.setSatisfactionLevel(satisfactionLevel);
		// this.minimalParticipant = 0;
	}

	public int gettotalOfPlausibletime() {
		return totalOfPlausibleTime;
	}

	public ArrayList<PlausibleTime> listOfPlausibleTime() {
		return listOfPlausibleTime;
	}

	public int getSlotTime() {
		return slotTime;
	}

	public void setSlotTime(int slotTime) {
		this.slotTime = slotTime;
	}

	public int getSatisfactionLevel() {
		return satisfactionLevel;
	}

	public void setSatisfactionLevel(int satisfactionLevel) {
		this.satisfactionLevel = satisfactionLevel;
	}

	public int setMinimalAttendance(int satisfactionLevel, MeetingEvent meetingEvent) {
		int numberOfMinimalAttendance = 0;
		int numberOfParticipant = meetingEvent.numberOfParticipant();
		numberOfMinimalAttendance = numberOfParticipant - (satisfactionLevel * numberOfParticipant / 100);
		return numberOfMinimalAttendance;
	}

	public ArrayList<Duration> getDurations() {
		return durations;
	}

	public void setDurations(ArrayList<Duration> durations) {
		this.durations = durations;
	}
}