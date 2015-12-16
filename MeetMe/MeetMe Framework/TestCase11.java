import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

public class TestCase11 {

	@Test
	public void test() throws ParseException {
		// set meeting planner
		MeetingPlanner Dropadi = new MeetingPlanner();
		Dropadi.setName("Dropadi");

		// set participant
		Participant Yudistira = new Participant();
		Yudistira.setName("Yudistira");
		Participant Bima = new Participant();
		Bima.setName("Bima");

		// YUDISTIRA BUSYTIME
		// BUSYTIME 1
		Date fromDate = setDate("2016-01-01 10:05:00");
		Date toDate = setDate("2016-01-01 12:00:00");
		BusyTime yudistiraBusyTime1 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime1);

		// BIMA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2016-01-01 00:00:00");
		toDate = setDate("2016-01-01 07:00:00");
		BusyTime bimaBusyTime1 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime1);

		// set Event
		MeetingEvent meetingEvent = new MeetingEvent();
		meetingEvent.setTitle("Meeting Event");
		meetingEvent.setMeetingPlanner(Dropadi);
		meetingEvent.setMeetingDurationInMinutes(1 * 60);
		Date eventFromDate = setDate("2016-01-01 00:00:00");
		meetingEvent.setFromDate(eventFromDate);
		Date eventToDate = setDate("2016-01-01 12:00:00");
		meetingEvent.setToDate(eventToDate);

		// add participant
		meetingEvent.addParticipant(Yudistira);
		meetingEvent.addParticipant(Bima);

		PlausibleTimeCalculatorInterface plausibleTimeCalculator = new JoePlausibleTimeCalculator(1, 100);
		meetingEvent.setPlausibleTimeCalculator(plausibleTimeCalculator);
		meetingEvent.setPlausibleTime(meetingEvent.countPlausibleTimes());

		ArrayList<PlausibleTime> plausibleTimes = new ArrayList<PlausibleTime>();
		PlausibleTime plausibleTime = new PlausibleTime();

		// add plausible time 1
		Date fromPlausibleTime = setDate("2016-01-01 07:00:00");
		Date toPlausibleTime = setDate("2016-01-01 08:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 2
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2016-01-01 08:00:00");
		toPlausibleTime = setDate("2016-01-01 09:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 3
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2016-01-01 09:00:00");
		toPlausibleTime = setDate("2016-01-01 10:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);

		printPlausibleTime(meetingEvent);

		int i = 0;
		for (PlausibleTime plausibletime : meetingEvent.getPlausibleTimes()) {
			assertEquals(plausibleTimes.get(i).getFrom(), plausibletime.getFrom());
			assertEquals(plausibleTimes.get(i).getTo(), plausibletime.getTo());
			i++;
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
