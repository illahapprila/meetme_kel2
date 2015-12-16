import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class solvecase16 {

	public static void main(String[] args) throws ParseException {
		// set meeting planner
		MeetingPlanner Dropadi = new MeetingPlanner();
		Dropadi.setName("Dropadi");

		// set participant
		Participant Yudistira = new Participant();
		Yudistira.setName("Yudistira");
		Participant Bima = new Participant();
		Bima.setName("Bima");
		Participant Arjuna = new Participant();
		Arjuna.setName("Arjuna");

		// YUDISTIRA BUSYTIME
		// BUSYTIME 1
		Date fromDate = setDate("2015-12-31 09:00:00");
		Date toDate = setDate("2015-12-31 15:00:00");
		BusyTime yudistiraBusyTime1 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 17:00:00");
		toDate = setDate("2015-12-31 18:00:00");
		BusyTime yudistiraBusyTime2 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-31 20:00:00");
		toDate = setDate("2015-12-31 21:00:00");
		BusyTime yudistiraBusyTime3 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2016-01-01 07:00:00");
		toDate = setDate("2016-01-01 09:00:00");
		BusyTime yudistiraBusyTime4 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime4);
		// BUSYTIME 5
		fromDate = setDate("2016-01-01 13:00:00");
		toDate = setDate("2016-01-01 15:00:00");
		BusyTime yudistiraBusyTime5 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime5);

		// BIMA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 07:00:00");
		toDate = setDate("2015-12-31 09:00:00");
		BusyTime bimaBusyTime1 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 11:00:00");
		toDate = setDate("2015-12-31 14:00:00");
		BusyTime bimaBusyTime2 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-31 16:00:00");
		toDate = setDate("2015-12-31 20:00:00");
		BusyTime bimaBusyTime3 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2016-01-01 07:00:00");
		toDate = setDate("2016-01-01 10:00:00");
		BusyTime bimaBusyTime4 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime4);
		// BUSYTIME 5
		fromDate = setDate("2016-01-01 15:00:00");
		toDate = setDate("2016-01-01 18:00:00");
		BusyTime bimaBusyTime5 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime5);
		// BUSYTIME 6
		fromDate = setDate("2016-01-01 21:00:00");
		toDate = setDate("2016-01-01 22:00:00");
		BusyTime bimaBusyTime6 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime6);

		// ARJUNA BUSY TIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 07:00:00");
		toDate = setDate("2015-12-31 07:00:00");
		BusyTime arjunaBusyTime1 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 09:00:00");
		toDate = setDate("2015-12-31 11:00:00");
		BusyTime arjunaBusyTime2 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-31 13:00:00");
		toDate = setDate("2015-12-31 15:00:00");
		BusyTime arjunaBusyTime3 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2015-12-31 16:00:00");
		toDate = setDate("2015-12-31 17:00:00");
		BusyTime arjunaBusyTime4 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime4);
		// BUSYTIME 5
		fromDate = setDate("2015-12-31 19:00:00");
		toDate = setDate("2015-12-31 21:00:00");
		BusyTime arjunaBusyTime5 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime5);
		// BUSYTIME 6
		fromDate = setDate("2016-01-01 07:00:00");
		toDate = setDate("2016-01-01 08:00:00");
		BusyTime arjunaBusyTime6 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime6);
		// BUSYTIME 7
		fromDate = setDate("2016-01-01 11:00:00");
		toDate = setDate("2016-01-01 13:00:00");
		BusyTime arjunaBusyTime7 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime7);
		// BUSYTIME 8
		fromDate = setDate("2016-01-01 19:00:00");
		toDate = setDate("2016-01-01 21:00:00");
		BusyTime arjunaBusyTime8 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime8);

		// set Event
		MeetingEvent meetingEvent = new MeetingEvent();
		meetingEvent.setTitle("Meeting Event");
		meetingEvent.setMeetingPlanner(Dropadi);
		meetingEvent.setMeetingDurationInMinutes(2 * 60);
		meetingEvent.setStartMeetingEvent(0);
		meetingEvent.setEndMeetingEvent(23);
		Date eventFromDate = setDate("2015-12-31 00:00:00");
		meetingEvent.setFromDate(eventFromDate);
		Date eventToDate = setDate("2016-01-01 23:00:00");
		meetingEvent.setToDate(eventToDate);

		// add participant
		meetingEvent.addParticipant(Yudistira);
		meetingEvent.addParticipant(Bima);
		meetingEvent.addParticipant(Arjuna);
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
