import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestCase12 {

	@Test
	public void test() throws ParseException {
		MeetingPlanner Dropadi = new MeetingPlanner();
		Dropadi.setName("Dropadi X");

		Participant Yudistira = new Participant();
		Yudistira.setName("Yudistira Sulung Pandawa");
		Participant Bima = new Participant();
		Bima.setName("Bima Energi Kuku");
		// Participant Arjuna = new Participant();
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
		toDate = setDate("2016-01-02 08:00:00");
		BusyTime yudistiraBusyTime2 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime2);

		// BIMA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2016-01-01 00:00:00");
		toDate = setDate("2016-01-02 00:00:00");
		BusyTime bimaBusyTime1 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2016-01-02 00:00:00");
		toDate = setDate("2016-01-02 12:00:00");
		BusyTime bimaBusyTime2 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime2);

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

		assertEquals(null, meetingEvent.getPlausibleTimes());
	}

	public static Date setDate(String dateString) throws ParseException {
		Date date;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
		date = formatter.parse(dateString);
		return date;
	}
}
