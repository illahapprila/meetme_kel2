import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TestCase3 {

	@Test
	public void test() throws ParseException {
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
		Date fromDate = setDate("2015-12-31 00:00:00");
		Date toDate = setDate("2015-12-31 06:00:00");
		BusyTime yudistiraBusyTime1 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 9:00:00");
		toDate = setDate("2015-12-31 15:00:00");
		BusyTime yudistiraBusyTime2 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-31 17:00:00");
		toDate = setDate("2015-12-31 19:00:00");
		BusyTime yudistiraBusyTime3 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2015-12-31 20:00:00");
		toDate = setDate("2015-12-31 24:00:00");
		BusyTime yudistiraBusyTime4 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime4);
		// BUSYTIME 5
		fromDate = setDate("2016-1-1 00:00:00");
		toDate = setDate("2016-1-1 03:00:00");
		BusyTime yudistiraBusyTime5 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime5);
		// BUSYTIME 6
		fromDate = setDate("2016-1-1 04:00:00");
		toDate = setDate("2016-1-1 10:00:00");
		BusyTime yudistiraBusyTime6 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime6);
		// BUSYTIME 7
		fromDate = setDate("2016-1-1 13:00:00");
		toDate = setDate("2016-1-1 16:00:00");
		BusyTime yudistiraBusyTime7 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime7);

		// Bima BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 01:00:00");
		toDate = setDate("2015-12-31 04:00:00");
		BusyTime bimaBusyTime1 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 06:00:00");
		toDate = setDate("2015-12-31 10:00:00");
		BusyTime bimaBusyTime2 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-31 11:00:00");
		toDate = setDate("2015-12-31 15:00:00");
		BusyTime bimaBusyTime3 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2015-12-31 16:00:00");
		toDate = setDate("2015-12-31 21:00:00");
		BusyTime bimaBusyTime4 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime4);
		// BUSYTIME 5
		fromDate = setDate("2016-1-1 01:00:00");
		toDate = setDate("2016-1-1 03:00:00");
		BusyTime bimaBusyTime5 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime5);
		// BUSYTIME 6
		fromDate = setDate("2016-1-1 04:00:00");
		toDate = setDate("2016-1-1 06:00:00");
		BusyTime bimaBusyTime6 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime6);
		// BUSYTIME 7
		fromDate = setDate("2016-1-1 07:00:00");
		toDate = setDate("2016-1-1 11:00:00");
		BusyTime bimaBusyTime7 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime7);
		// BUSYTIME 8
		fromDate = setDate("2016-1-1 15:00:00");
		toDate = setDate("2016-1-1 18:00:00");
		BusyTime bimaBusyTime8 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime8);
		// BUSYTIME 9
		fromDate = setDate("2016-1-1 21:00:00");
		toDate = setDate("2016-1-1 24:00:00");
		BusyTime bimaBusyTime9 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime9);

		// Arjuna BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 01:00:00");
		toDate = setDate("2015-12-31 03:00:00");
		BusyTime arjunaBusyTime1 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 04:00:00");
		toDate = setDate("2015-12-31 08:00:00");
		BusyTime arjunaBusyTime2 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-31 09:00:00");
		toDate = setDate("2015-12-31 12:00:00");
		BusyTime arjunaBusyTime3 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2015-12-31 13:00:00");
		toDate = setDate("2015-12-31 15:00:00");
		BusyTime arjunaBusyTime4 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime4);
		// BUSYTIME 5
		fromDate = setDate("2015-12-31 16:00:00");
		toDate = setDate("2015-12-31 18:00:00");
		BusyTime arjunaBusyTime5 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime5);
		// BUSYTIME 6
		fromDate = setDate("2015-12-31 19:00:00");
		toDate = setDate("2015-12-31 22:00:00");
		BusyTime arjunaBusyTime6 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime6);
		// BUSYTIME 7
		fromDate = setDate("2015-12-31 23:00:00");
		toDate = setDate("2015-12-31 24:00:00");
		BusyTime arjunaBusyTime7 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime7);
		// BUSYTIME 8
		fromDate = setDate("2016-1-1 00:00:00");
		toDate = setDate("2016-1-1 06:00:00");
		BusyTime arjunaBusyTime8 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime8);
		// BUSYTIME 9
		fromDate = setDate("2016-1-1 07:00:00");
		toDate = setDate("2016-1-1 09:00:00");
		BusyTime arjunaBusyTime9 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime9);
		// BUSYTIME 10
		fromDate = setDate("2016-1-1 12:00:00");
		toDate = setDate("2016-1-1 14:00:00");
		BusyTime arjunaBusyTime10 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime10);
		// BUSYTIME 11
		fromDate = setDate("2016-1-1 19:00:00");
		toDate = setDate("2016-1-1 22:00:00");
		BusyTime arjunaBusyTime11 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime11);

		// set Event
		MeetingEvent meetingEvent = new MeetingEvent();
		meetingEvent.setTitle("Makrab");
		meetingEvent.setMeetingPlanner(Dropadi);
		meetingEvent.setMeetingDurationInMinutes(1 * 60);
		Date eventFromDate = setDate("2015-12-31 00:00:00");
		meetingEvent.setFromDate(eventFromDate);
		Date eventToDate = setDate("2016-1-1 23:00:00");
		meetingEvent.setToDate(eventToDate);

		// add participant
		meetingEvent.addParticipant(Yudistira);
		meetingEvent.addParticipant(Bima);
		meetingEvent.addParticipant(Arjuna);

		PlausibleTimeCalculatorInterface plausibleTimeCalculator = new JoePlausibleTimeCalculator(10, 100);
		meetingEvent.setPlausibleTimeCalculator(plausibleTimeCalculator);
		meetingEvent.setPlausibleTime(meetingEvent.countPlausibleTimes());

		ArrayList<PlausibleTime> plausibleTimes = new ArrayList<PlausibleTime>();
		PlausibleTime plausibleTime = new PlausibleTime();

		// add plausible time 1
		Date fromPlausibleTime = setDate("2015-12-31 15:00:00");
		Date toPlausibleTime = setDate("2015-12-31 16:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 2
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2016-1-1 11:00:00");
		toPlausibleTime = setDate("2016-1-1 12:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 3
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2016-1-1 18:00:00");
		toPlausibleTime = setDate("2016-1-1 19:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);

		int i = 0;

		for (PlausibleTime plausibleTime2 : meetingEvent.getPlausibleTimes()) {
			assertEquals(plausibleTimes.get(i).getFrom(), plausibleTime2.getFrom());
			assertEquals(plausibleTimes.get(i).getTo(), plausibleTime2.getTo());
			i++;
		}

		printMeetingEventInfo(meetingEvent);
		printPlausibleTime(meetingEvent);
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
