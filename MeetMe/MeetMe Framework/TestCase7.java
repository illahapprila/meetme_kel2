import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

public class TestCase7 {

	@Test
	public void testPlausibleTimeCase7() throws ParseException {
		MeetingPlanner Dropadi = new MeetingPlanner();
		Dropadi.setName("Dropadi X");

		Participant Yudistira = new Participant();
		Yudistira.setName("Yudistira Sulung Pandawa");
		Participant Bima = new Participant();
		Bima.setName("Bima Energi Kuku");

		// YUDISTIRA BUSYTIME
		// BUSYTIME 1
		Date fromDate = setDate("2015-11-01 00:00:00");
		Date toDate = setDate("2015-11-02 00:00:00");
		BusyTime yudistiraBusyTime1 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime1);

		// BIMA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-11-03 00:00:00");
		toDate = setDate("2015-11-04 00:00:00");
		BusyTime bimaBusyTime1 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime1);

		// create event
		MeetingEvent meetingEvent = new MeetingEvent();
		meetingEvent.setTitle("Malam Keakraban(Makrab)");
		meetingEvent.setMeetingPlanner(Dropadi);
		meetingEvent.setMeetingDurationInMinutes(12 * 60);

		Date eventFromDate = setDate("2015-11-01 00:00:00");
		meetingEvent.setFromDate(eventFromDate);
		Date eventToDate = setDate("2015-11-06 00:00:00");
		meetingEvent.setToDate(eventToDate);

		// add participant
		meetingEvent.addParticipant(Yudistira);
		meetingEvent.addParticipant(Bima);

		PlausibleTimeCalculatorInterface plausibleTimeCalculator = new JoePlausibleTimeCalculator(10, 100);
		meetingEvent.setPlausibleTimeCalculator(plausibleTimeCalculator);
		meetingEvent.setPlausibleTime(meetingEvent.countPlausibleTimes());

		ArrayList<PlausibleTime> plausibleTimes = new ArrayList<PlausibleTime>();
		PlausibleTime plausibleTime = new PlausibleTime();

		// add plausible time 1
		Date fromPlausibleTime = setDate("2015-11-02 00:00:00");
		Date toPlausibleTime = setDate("2015-11-02 12:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 2
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-02 12:00:00");
		toPlausibleTime = setDate("2015-11-03 00:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 3
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-04 00:00:00");
		toPlausibleTime = setDate("2015-11-04 12:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 4
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-04 12:00:00");
		toPlausibleTime = setDate("2015-11-05 00:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 5
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-05 00:00:00");
		toPlausibleTime = setDate("2015-11-05 12:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 6
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-05 12:00:00");
		toPlausibleTime = setDate("2015-11-06 00:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);

		int i = 0;

		for (PlausibleTime plausibleTime2 : meetingEvent.getPlausibleTimes()) {
			assertEquals(plausibleTimes.get(i).getFrom(), plausibleTime2.getFrom());
			assertEquals(plausibleTimes.get(i).getTo(), plausibleTime2.getTo());
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
