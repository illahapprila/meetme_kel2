import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaseYudi1 {
	/**
	 * @param args
	 * @throws ParseException
	 * 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		MeetingPlanner Dropadi = new MeetingPlanner();

		Dropadi.setName("Dropadi X");

		Participant Yudistira = new Participant();
		Yudistira.setName("Yudistira Sulung Pandawa");
		Participant Bima = new Participant();
		Bima.setName("Bima Energi Kuku");
		Participant Arjuna = new Participant();
		Arjuna.setName("Arjuna Mencari Cinta");
		// Participant Nakula = new Participant();
		// Participant Sadewa = new Participant();

		// YUDISTIRA BUSYTIME
		// BUSYTIME 1
		Date fromDate = setDate("2016-01-01 00:00:00");
		Date toDate = setDate("2016-01-01 12:00:00");
		BusyTime yudistiraBusyTime1 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2016-01-01 12:00:00");
		toDate = setDate("2016-01-01 24:00:00");
		BusyTime yudistiraBusyTime2 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime2);

		// BIMA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2016-01-01 00:00:00");
		toDate = setDate("2016-01-02 00:00:00");
		BusyTime bimaBusyTime1 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime1);
		// BUSYTIME 2
		// fromDate = setDate("2016-01-01 00:00:00");
		// toDate = setDate("2016-01-02 00:00:00");
		// BusyTime bimaBusyTime2 = new BusyTime(fromDate,toDate);
		// Bima.addBusyTime(bimaBusyTime2);

		// create event
		MeetingEvent meetingEvent = new MeetingEvent();
		meetingEvent.setTitle("Malam Keakraban(Makrab)");
		meetingEvent.setMeetingPlanner(Dropadi);
		meetingEvent.setMeetingDurationInMinutes(4);
		meetingEvent.setStartMeetingEvent(7);
		meetingEvent.setEndMeetingEvent(20);

		Date eventFromDate = setDate("2016-01-01 00:00:00");
		meetingEvent.setFromDate(eventFromDate);
		Date eventToDate = setDate("2016-01-02 12:00:00");
		meetingEvent.setToDate(eventToDate);

		// add participant
		meetingEvent.addParticipant(Yudistira);
		meetingEvent.addParticipant(Bima);
		// meetingEvent.addParticipant(Arjuna);

		// meetingEvent.addParticipant(Nakula);
		// meetingEvent.addParticipant(Sadewa);

		meetingEvent.setMeetingPlannerAsParticipant(false);
		if (meetingEvent.isMeetingPlannerAsParticipant()) {

		}

		PlausibleTimeCalculatorInterface plausibleTimeCalculator = new JoePlausibleTimeCalculator(10, 100);
		meetingEvent.setPlausibleTimeCalculator(plausibleTimeCalculator);
		meetingEvent.setPlausibleTime(meetingEvent.countPlausibleTimes());

		printMeetingEventInfo(meetingEvent);
		printPlausibleTime(meetingEvent);

		// System.out.println(+meetingEvent.numberOfParticipant());
	}

	public static void printMeetingEventInfo(MeetingEvent meetingEvent) {
		System.out.println("Title : " + meetingEvent.getTitle());
		System.out.println("Meeting Planer :" + meetingEvent.getMeetingPlanner().getName());
		System.out.println("From : " + meetingEvent.getFromDate());
		System.out.println("Until : " + meetingEvent.getToDate());

		System.out.println("The Participants and Their Busy Times");
		for (Person participant : meetingEvent.getParticipants()) {
			System.out.println("Name: " + participant.getName());
			System.out.println("Busy Times:");
			for (BusyTime busyTime : participant.getBusyCalendar().getBusyTimes()) {
				System.out.println("From: " + busyTime.getFrom() + " To: " + busyTime.getTo() + " Duration : "
						+ busyTime.getDuration());
			}
		}

	}

	public static void printPlausibleTime(MeetingEvent meetingEvent) {
		int IndexPlausibleTime = 0;
		System.out.println("Plausible Time : ");

		if (meetingEvent.getPlausibleTimes() != null) {
			for (PlausibleTime plausibleTime : meetingEvent.getPlausibleTimes()) {
				System.out.println("Plausible time " + (IndexPlausibleTime + 1) + " from : " + plausibleTime.getFrom()
						+ " To : " + plausibleTime.getTo());
				IndexPlausibleTime++;
			}
			System.out.println("Number of Plausible Time : " + meetingEvent.getPlausibleTimes().size());
		} else {
			System.out.println("Plausible Time is not Available");
		}
	}

	public static Date setDate(String dateString) throws ParseException {
		Date date;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
		date = formatter.parse(dateString);
		return date;
	}
}
