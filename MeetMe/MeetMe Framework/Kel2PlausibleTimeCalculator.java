import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Kel2PlausibleTimeCalculator implements PlausibleTimeCalculatorInterface {

	private ArrayList<PlausibleTime> listOfPlausibleTime = new ArrayList<PlausibleTime>();
	ArrayList<NumberOfPerson> listNumberOfPerson;
	ArrayList<ProspectivePerson> listDateAndPerson = new ArrayList<ProspectivePerson>();
	private ArrayList<Duration> durations = new ArrayList<Duration>();
	private int totalOfPlausibleTime = 0;
	private int totalOfCandidateTime;

	private int slotTime;
	private int satisfactionLevel;

	@Override
	public ArrayList<PlausibleTime> calculatePlausibleTimes(MeetingEvent meetingEvent) {
		this.slotTime = getNumberSlotTime(meetingEvent);
		totalOfCandidateTime = countTotalCandidateTime(meetingEvent.getFromDate(), meetingEvent.getToDate())
				/ this.slotTime;
		ArrayList<DateAndQuantity> candidateTimes = new ArrayList<DateAndQuantity>();
		meetingEvent.getAttendanceRequirement().getNecessaryPerson().setMaximalAttendance();
		meetingEvent.getAttendanceRequirement().getNecessaryPerson().setMinimumAttendance(
				meetingEvent.getAttendanceRequirement().getNecessaryPerson().getMaximalAttendance());
		candidateTimes = createTableCandidateTime(totalOfCandidateTime, meetingEvent);
		candidateTimes = inputQuantityOfCandidateTime(totalOfCandidateTime, candidateTimes,
				meetingEvent.getAttendanceRequirement().getNecessaryPerson().getPersons());
		listOfPlausibleTime = inputListOfPlausibleTime(totalOfCandidateTime, candidateTimes, meetingEvent,
				meetingEvent.getAttendanceRequirement().getNecessaryPerson().getMaximalAttendance(),
				meetingEvent.getAttendanceRequirement().getNecessaryPerson().getMinimumAttendance());

		candidateTimes = new ArrayList<DateAndQuantity>();
		int i = 0;
		for (PlausibleTime plausibleTime : listOfPlausibleTime) {
			DateAndQuantity dateAndQuantity = new DateAndQuantity();
			dateAndQuantity.setTitleDate(plausibleTime.getFrom());
			dateAndQuantity.setQuantity(0);
			candidateTimes.add(dateAndQuantity);
			i++;
		}

		for (Attendance attendance : meetingEvent.getAttendanceRequirement().getRepresentativePerson()) {
			attendance.setMaximalAttendance();
			candidateTimes = inputQuantityOfCandidateTime(i, candidateTimes, attendance.getPersons());
			listOfPlausibleTime = new ArrayList<PlausibleTime>();
			listOfPlausibleTime = inputListOfPlausibleTime(i, candidateTimes, meetingEvent,
					attendance.getMinimumAttendance(), attendance.getMaximalAttendance());
			candidateTimes = new ArrayList<DateAndQuantity>();
			i = 0;
			for (PlausibleTime plausibleTime : listOfPlausibleTime) {
				DateAndQuantity dateAndQuantity = new DateAndQuantity();
				dateAndQuantity.setTitleDate(plausibleTime.getFrom());
				dateAndQuantity.setQuantity(0);
				candidateTimes.add(dateAndQuantity);
				i++;
			}
		}
		candidateTimes = inputQuantityOfCandidateTime(i, candidateTimes,
				meetingEvent.getAttendanceRequirement().getNonNecessaryPerson().getPersons());

		System.out.println("-Date and Participant-");
		for (ProspectivePerson dateAndPerson : listDateAndPerson) {
			System.out.println("Tanggal : " + dateAndPerson.getDate());
			for (Person person : dateAndPerson.getPerson()) {
				System.out.println(person.getName());
			}
		}

		return listOfPlausibleTime;
	}

	public void checkDateMeetingEvent(MeetingEvent meetingEvent) {
		if ((int) meetingEvent.getToDate().getTime() < (int) meetingEvent.getFromDate().getTime()) {
			Date temp = new Date();
			temp = meetingEvent.getFromDate();
			meetingEvent.setFromDate(meetingEvent.getToDate());
			meetingEvent.setToDate(temp);
		}
	}

	public int getNumberSlotTime(MeetingEvent meetingEvent) {
		int numberOfListDuration;
		int factorNumberOfSlotTime;
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
		factorNumberOfSlotTime = durations.get(0).getDuration();

		for (int i = 0; i < numberOfListDuration; i++) {
			factorNumberOfSlotTime = findFactor(factorNumberOfSlotTime, durations.get(i).getDuration());
		}

		return factorNumberOfSlotTime;
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
		int totalOfCandidateTime;
		totalOfCandidateTime = (int) ((dateTo.getTime() - dateFrom.getTime()) / (60 * 1000));
		return totalOfCandidateTime;

	}

	public ArrayList<DateAndQuantity> createTableCandidateTime(int totalOfCandidateTime, MeetingEvent meetingEvent) {
		// Membuat Table Candidate Time (List Waktu yang Disediakan oleh Meeting
		// Planner sebagai Kandidat Waktu Rapat)
		ArrayList<DateAndQuantity> listOfCandidateTime = new ArrayList<DateAndQuantity>();
		listNumberOfPerson = new ArrayList<NumberOfPerson>();
		listDateAndPerson = new ArrayList<ProspectivePerson>();
		System.out.println("Candidate Times");
		for (int candidateTime = 0; candidateTime < totalOfCandidateTime; candidateTime++) {
			Calendar calendarFrom = Calendar.getInstance();
			calendarFrom.setTime(meetingEvent.getFromDate());
			calendarFrom.add(Calendar.MINUTE, candidateTime * this.slotTime);
			DateAndQuantity dAQ = new DateAndQuantity();
			dAQ.setTitleDate(calendarFrom.getTime());
			dAQ.setQuantity(0);
			listOfCandidateTime.add(dAQ);

			NumberOfPerson numberOfPerson = new NumberOfPerson();
			numberOfPerson.setTitle(calendarFrom.getTime());
			numberOfPerson.setQuantity(0);
			listNumberOfPerson.add(numberOfPerson);

			ProspectivePerson dateAndPerson = new ProspectivePerson();
			dateAndPerson.setDate(calendarFrom.getTime());
			listDateAndPerson.add(dateAndPerson);
			System.out.println(dateAndPerson.getDate());
		}
		return listOfCandidateTime;
	}

	public ArrayList<DateAndQuantity> inputQuantityOfCandidateTime(int totalOfCandidateTime,
			ArrayList<DateAndQuantity> candidateTimes, ArrayList<Person> persons) {
		// Mengisi data kuantitas Table Candidate Time berdasarkan jumlah
		// participant yang memiliki waktu sibuk di jam tertentu
		int indexcandidateTimes = 0;
		candidateTimes.get(indexcandidateTimes).getTitleDate().getTime();
		Calendar busyFrom = Calendar.getInstance();
		System.out.println();
		System.out.println("Participant and their busy time : ");
		for (Person participant : persons) {
			for (NumberOfPerson numberOfPerson : listNumberOfPerson) {
				numberOfPerson.setQuantity(0);
			}
			if (participant.getBusyCalendar().getBusyTimes() != null) {
				for (BusyTime busyTime : participant.getBusyCalendar().getBusyTimes()) {
					// System.out.println("Participant :
					// "+participant.getName()+"
					// range : "+busyTime.getDuration());
					busyFrom.setTime(busyTime.getFrom());
					for (int i = 0; i < busyTime.getDuration() / this.slotTime; i++) {
						indexcandidateTimes = 0;
						for (indexcandidateTimes = 0; indexcandidateTimes < (totalOfCandidateTime); indexcandidateTimes++) {
							if (candidateTimes.get(indexcandidateTimes).getTitleDate().getTime() >= busyFrom.getTime()
									.getTime()) {
								if (isBusyTimeSameWithCandidateTime(busyFrom, candidateTimes, indexcandidateTimes)) {
									candidateTimes.get(indexcandidateTimes)
											.setQuantity(candidateTimes.get(indexcandidateTimes).getQuantity() + 1);
								}
							}
						}
						for (NumberOfPerson numberOfPerson : listNumberOfPerson) {
							if ((long) numberOfPerson.getTitle().getTime() == (long) busyFrom.getTime().getTime()) {
								numberOfPerson.setQuantity(numberOfPerson.getQuantity() + 1);
							}
						}
						busyFrom.add(Calendar.MINUTE, this.slotTime);
					}
				}
			}
			System.out.println("Participant name : " + participant.getName());
			for (NumberOfPerson numberOfPerson : listNumberOfPerson) {
				System.out.println(
						"Tanggal : " + numberOfPerson.getTitle() + " Jumlah : " + numberOfPerson.getQuantity());
				if (numberOfPerson.getQuantity() == 0) {
					for (ProspectivePerson dateAndPerson : listDateAndPerson) {
						if (dateAndPerson.getDate().getTime() == numberOfPerson.getTitle().getTime()) {
							dateAndPerson.getPerson().add(participant);
						}
					}
				}
			}
			System.out.println();
		}
		return candidateTimes;
	}

	public ArrayList<PlausibleTime> inputListOfPlausibleTime(int totalOfCandidateTime,
			ArrayList<DateAndQuantity> listOfCandidateTime, MeetingEvent meetingEvent, int minimum, int maximum) {
		// Mengisi list Plausible Time berdasarkan jumlah waktu sibuk setiap
		// participan dan meeting constraint
		PlausibleTime plausibleTime = new PlausibleTime();
		ArrayList<PlausibleTime> plausibleTimes = new ArrayList<PlausibleTime>();
		int counter = 0;
		for (DateAndQuantity dateAndQuantity : listOfCandidateTime) {
			if (dateAndQuantity.getQuantity() <= (maximum - minimum)) {
				if (counter == 0) {
					plausibleTime = new PlausibleTime();
					plausibleTime.setFrom(dateAndQuantity.getTitleDate());
				}
				counter++;
			} else {
				counter = 0;
			}
			if (counter == meetingEvent.getMeetingDurationInMinutes() / this.slotTime) {
				Date date = new Date();
				date.setTime(dateAndQuantity.getTitleDate().getTime() + this.slotTime * 60 * 1000);
				plausibleTime.setTo(date);
				plausibleTimes.add(plausibleTime);
				counter = 0;
			}
		}
		return plausibleTimes;
	}

	public boolean isBusyTimeSameWithCandidateTime(Calendar busyFrom, ArrayList<DateAndQuantity> listOfCandidateTime,
			int index) {
		// apakah waktu sibuk participant sama dengan candidate time yang ada di
		// list ?
		if (busyFrom.getTime().getTime() == listOfCandidateTime.get(index).getTitleDate().getTime()) {
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

	// public int setMinimalAttendance(int satisfactionLevel, MeetingEvent
	// meetingEvent) {
	// int number = 0;
	// int numberOfParticipant = meetingEvent.numberOfParticipant();
	// number = numberOfParticipant - (satisfactionLevel * numberOfParticipant /
	// 100);
	// return number;
	// }

	public ArrayList<Duration> getDurations() {
		return durations;
	}

	public void setDurations(ArrayList<Duration> durations) {
		this.durations = durations;
	}
}