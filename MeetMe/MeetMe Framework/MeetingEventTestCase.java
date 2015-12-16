import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class MeetingEventTestCase {

	MeetingEvent meetingEvent = new MeetingEvent();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
	String dateFrom = "2016-01-01 00:00:00";
	String dateTo = "2016-01-02 12:00:00";

	@Test
	public void testgetTittle() {

		meetingEvent.setTitle("Malam Keakraban");
		meetingEvent.setMeetingDurationInMinutes(3);

		assertEquals("Malam Keakraban", meetingEvent.getTitle());
	}

	@Test
	public void isMeetingPlannerAsParticapantFalse() {
		MeetingPlanner Dropadi = new MeetingPlanner();
		meetingEvent.setMeetingPlanner(Dropadi);
		meetingEvent.setMeetingPlannerAsParticipant(false);

		assertFalse(meetingEvent.isMeetingPlannerAsParticipant());
	}

	@Test
	public void testgetMeetingDurationInHours() {
		meetingEvent.setMeetingDurationInMinutes(3);

		assertEquals(3, meetingEvent.getMeetingDurationInMinutes());
	}

	@Test
	public void testgetFromDate() throws ParseException {
		Date eventFromDate = formatter.parse(dateFrom);
		meetingEvent.setFromDate(eventFromDate);

		assertEquals(eventFromDate, meetingEvent.getFromDate());
	}

	@Test
	public void testgetToDate() throws ParseException {
		Date eventToDate = formatter.parse(dateTo);
		meetingEvent.setToDate(eventToDate);

		assertEquals(eventToDate, meetingEvent.getToDate());
	}

}
