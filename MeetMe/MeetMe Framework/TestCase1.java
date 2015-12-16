import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TestCase1 {

	@Test
	public void test() throws ParseException {
		// set meeting planner
		MeetingPlanner Dropadi = new MeetingPlanner();
		Dropadi.setName("Dropadi");

		// set participant
		Participant Yudistira = new Participant();
		Yudistira.setName("Yudistira");

		// YUDISTIRA BUSYTIME
		// BUSYTIME 1
		Date fromDate = setDate("2015-11-22 00:00:00");
		Date toDate = setDate("2015-11-22 06:00:00");
		BusyTime yudistiraBusyTime1 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-11-22 9:00:00");
		toDate = setDate("2015-11-22 15:00:00");
		BusyTime yudistiraBusyTime2 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-11-22 10:00:00");
		toDate = setDate("2015-11-22 14:00:00");
		BusyTime yudistiraBusyTime3 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2015-11-22 17:00:00");
		toDate = setDate("2015-11-22 24:00:00");
		BusyTime yudistiraBusyTime4 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime4);

		// set Event
		MeetingEvent meetingEvent = new MeetingEvent();
		meetingEvent.setTitle("Meeting Event");
		meetingEvent.setMeetingPlanner(Dropadi);
		meetingEvent.setMeetingDurationInMinutes(1 * 60);
		Date eventFromDate = setDate("2015-11-22 00:00:00");
		meetingEvent.setFromDate(eventFromDate);
		Date eventToDate = setDate("2015-11-22 23:00:00");
		meetingEvent.setToDate(eventToDate);

		// boolean benargak = false;
		// Calendar calendar = Calendar.getInstance();
		//
		// if(eventToDate.getYear() < Calendar.YEAR){
		// benargak = true;
		// }
		//
		// assertEquals(true,benargak);
		// add participant
		meetingEvent.addParticipant(Yudistira);

		PlausibleTimeCalculatorInterface plausibleTimeCalculator = new JoePlausibleTimeCalculator(10, 100);
		meetingEvent.setPlausibleTimeCalculator(plausibleTimeCalculator);
		meetingEvent.setPlausibleTime(meetingEvent.countPlausibleTimes());

		ArrayList<PlausibleTime> plausibleTimes = new ArrayList<PlausibleTime>();
		PlausibleTime plausibleTime = new PlausibleTime();

		// add plausible time 1
		Date fromPlausibleTime = setDate("2015-11-22 06:00:00");
		Date toPlausibleTime = setDate("2015-11-22 07:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 2
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-22 07:00:00");
		toPlausibleTime = setDate("2015-11-22 08:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 3
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-22 08:00:00");
		toPlausibleTime = setDate("2015-11-22 09:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 4
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-22 15:00:00");
		toPlausibleTime = setDate("2015-11-22 16:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 5
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-22 16:00:00");
		toPlausibleTime = setDate("2015-11-22 17:00:00");
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
