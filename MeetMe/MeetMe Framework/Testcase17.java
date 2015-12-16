import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

public class Testcase17 {

	@Test
	public void test() throws ParseException {
		// set meeting planner
		MeetingPlanner Dropadi = new MeetingPlanner();
		Dropadi.setName("Dropadi");

		// set participant
		Participant DropadiX = new Participant();
		DropadiX.setName("Dropadi");

		// YUDISTIRA BUSYTIME
		// BUSYTIME 1
		Date fromDate = setDate("2015-12-31 00:00:00");
		Date toDate = setDate("2015-12-31 15:00:00");
		BusyTime DropadiXBusyTime1 = new BusyTime(fromDate, toDate);
		DropadiX.addBusyTime(DropadiXBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 19:00:00");
		toDate = setDate("2015-12-31 23:00:00");
		BusyTime DropadiXBusyTime2 = new BusyTime(fromDate, toDate);
		DropadiX.addBusyTime(DropadiXBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2016-01-01 00:00:00");
		toDate = setDate("2016-01-01 23:00:00");
		BusyTime DropadiXBusyTime3 = new BusyTime(fromDate, toDate);
		DropadiX.addBusyTime(DropadiXBusyTime3);

		// set Event
		MeetingEvent meetingEvent = new MeetingEvent();
		meetingEvent.setTitle("Meeting Event");
		meetingEvent.setMeetingPlanner(Dropadi);
		meetingEvent.setMeetingPlannerAsParticipant(true);
		meetingEvent.setMeetingDurationInMinutes(2 * 60);
		Date eventFromDate = setDate("2015-12-31 00:00:00");
		meetingEvent.setFromDate(eventFromDate);
		Date eventToDate = setDate("2016-01-01 23:00:00");
		meetingEvent.setToDate(eventToDate);

		meetingEvent.setMeetingPlannerAsParticipant(false);
		if (meetingEvent.isMeetingPlannerAsParticipant()) {
			// add participant
			meetingEvent.addParticipant(DropadiX);
			PlausibleTimeCalculatorInterface plausibleTimeCalculator = new JoePlausibleTimeCalculator(10, 100);
			meetingEvent.setPlausibleTimeCalculator(plausibleTimeCalculator);
			meetingEvent.setPlausibleTime(meetingEvent.countPlausibleTimes());
		}

		ArrayList<PlausibleTime> plausibleTimes = new ArrayList<PlausibleTime>();
		PlausibleTime plausibleTime = new PlausibleTime();

		// add plausible time 1
		Date fromPlausibleTime = setDate("2015-12-31 15:00:00");
		Date toPlausibleTime = setDate("2015-12-31 17:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);

		int i = 0;

		for (PlausibleTime plausibleTime2 : meetingEvent.getPlausibleTimes()) {
			assertEquals(null, plausibleTime2.getFrom());
			assertEquals(null, plausibleTime2.getTo());
			i++;
		}

	}

	public static Date setDate(String dateString) throws ParseException {
		Date date;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
		date = formatter.parse(dateString);
		return date;
	}

}
