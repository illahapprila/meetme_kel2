import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestCase6 {

	@Test
	public void test() throws ParseException {
		MeetingPlanner Dropadi = new MeetingPlanner();
		Dropadi.setName("Dropadi X");

		Participant Yudistira = new Participant();
		Yudistira.setName("Yudistira Sulung Pandawa");
		Participant Bima = new Participant();
		Bima.setName("Bima Energi Kuku");

		// YUDISTIRA BUSYTIME
		// BUSYTIME 1
		Date fromDate = setDate("2015-10-30 00:00:00");
		int durasi = 3;
		BusyTime yudistiraBusyTime1 = new BusyTime(fromDate, durasi);
		Yudistira.addBusyTime(yudistiraBusyTime1);

		// BIMA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-10-31 00:00:00");
		durasi = 3;
		BusyTime bimaBusyTime1 = new BusyTime(fromDate, durasi);
		Bima.addBusyTime(bimaBusyTime1);

		// create event
		MeetingEvent meetingEvent = new MeetingEvent();
		meetingEvent.setTitle("Malam Keakraban(Makrab)");
		meetingEvent.setMeetingPlanner(Dropadi);
		meetingEvent.setMeetingDurationInMinutes(1 * 60);

		Date eventFromDate = setDate("2015-11-01 00:00:00");
		meetingEvent.setFromDate(eventFromDate);
		Date eventToDate = setDate("2015-11-02 24:00:00");
		meetingEvent.setToDate(eventToDate);

		// add participant
		meetingEvent.addParticipant(Yudistira);
		meetingEvent.addParticipant(Bima);

		PlausibleTimeCalculatorInterface plausibleTimeCalculator = new JoePlausibleTimeCalculator(10, 100);
		meetingEvent.setPlausibleTimeCalculator(plausibleTimeCalculator);
		meetingEvent.setPlausibleTime(meetingEvent.countPlausibleTimes());

		// to busytime participant 1
		Date toDate1 = setDate("2015-11-01 03:00:00");
		// to busytime participant 2
		Date toDate2 = setDate("2015-11-02 03:00:00");

		assertEquals(setDate("2015-11-01 03:00:00"), toDate1);
		assertEquals(setDate("2015-11-02 03:00:00"), toDate2);

	}

	public static Date setDate(String dateString) throws ParseException {
		Date date;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
		date = formatter.parse(dateString);
		return date;
	}

}
