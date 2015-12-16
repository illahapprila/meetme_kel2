import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

public class TestCase8 {

	@Test
	public void test() throws ParseException {
		MeetingPlanner Dropadi = new MeetingPlanner();
		Dropadi.setName("Dropadi X");
		MeetingPlanner Arjuna = new MeetingPlanner();
		Dropadi.setName("Arjuna X");

		Participant Yudistira = new Participant();
		Yudistira.setName("Yudistira Sulung Pandawa");
		Participant Bima = new Participant();
		Bima.setName("Bima Energi Kuku");

		// YUDISTIRA BUSYTIME
		// BUSYTIME 1
		Date fromDate = setDate("2015-11-01 00:00:00");
		Date toDate = setDate("2015-11-01 24:00:00");
		BusyTime yudistiraBusyTime1 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime1);

		// BIMA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-11-03 00:00:00");
		toDate = setDate("2015-11-03 24:00:00");
		BusyTime bimaBusyTime1 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime1);

		// create event
		Date eventFromDate;
		Date eventToDate;
		boolean isMeetingEventCreated = false;
		MeetingEvent meetingEvent = new MeetingEvent();

		// meeting event pertama
		if (isMeetingEventCreated == false) {
			meetingEvent.setTitle("Malam Keakraban(Makrab)");
			meetingEvent.setMeetingPlanner(Dropadi);
			meetingEvent.setMeetingDurationInMinutes(24 * 60);
			isMeetingEventCreated = true;

			eventFromDate = setDate("2015-11-01 00:00:00");
			meetingEvent.setFromDate(eventFromDate);
			eventToDate = setDate("2015-11-03 00:00:00");
			meetingEvent.setToDate(eventToDate);
		}

		// meeting event kedua
		if (isMeetingEventCreated == false) {
			meetingEvent.setTitle("Malam Keakraban(Makrab)2");
			meetingEvent.setMeetingPlanner(Arjuna);
			meetingEvent.setMeetingDurationInMinutes(8 * 60);
			isMeetingEventCreated = true;

			eventFromDate = setDate("2015-11-03 00:00:00");
			meetingEvent.setFromDate(eventFromDate);
			eventToDate = setDate("2015-11-05 24:00:00");
			meetingEvent.setToDate(eventToDate);
		}

		// add participant
		meetingEvent.addParticipant(Yudistira);
		meetingEvent.addParticipant(Bima);

		PlausibleTimeCalculatorInterface plausibleTimeCalculator = new JoePlausibleTimeCalculator(10, 100);
		meetingEvent.setPlausibleTimeCalculator(plausibleTimeCalculator);
		meetingEvent.setPlausibleTime(meetingEvent.countPlausibleTimes());

		ArrayList<PlausibleTime> plausibleTimes = new ArrayList<PlausibleTime>();
		PlausibleTime plausibleTime = new PlausibleTime();

		Date fromPlausibleTime = setDate("2015-11-02 00:00:00");
		Date toPlausibleTime = setDate("2015-11-03 00:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);

		assertEquals(fromPlausibleTime, plausibleTime.getFrom());
		assertEquals(toPlausibleTime, plausibleTime.getTo());
	}

	public static Date setDate(String dateString) throws ParseException {
		Date date;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
		date = formatter.parse(dateString);
		return date;
	}

}
