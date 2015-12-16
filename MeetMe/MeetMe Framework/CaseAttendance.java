import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaseAttendance {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		MeetingPlanner Dropadi = new MeetingPlanner();
		Dropadi.setName("Dropadi X");

		Participant a = new Participant();
		a.setName("AA");
		Date fromDate = setDate("2016-01-01 00:00:00");
		Date toDate = setDate("2016-01-02 00:00:00");
		// BusyTime aBusyTime1 = new BusyTime(fromDate, toDate);
		// a.addBusyTime(aBusyTime1);
		a.addBusyTime("2016-01-01 00:00:00", "2016-01-02 00:00:00");
		Participant b = new Participant();
		b.setName("BB");
		fromDate = setDate("2016-01-01 00:00:00");
		toDate = setDate("2016-01-02 00:00:00");
		BusyTime bBusyTime1 = new BusyTime(fromDate, toDate);
		b.addBusyTime(bBusyTime1);
		Participant c = new Participant();
		c.setName("CC");
		fromDate = setDate("2016-01-01 00:00:00");
		toDate = setDate("2016-01-02 00:00:00");
		BusyTime cBusyTime1 = new BusyTime(fromDate, toDate);
		c.addBusyTime(cBusyTime1);

		Participant d = new Participant();
		d.setName("DD");
		fromDate = setDate("2016-01-03 00:00:00");
		toDate = setDate("2016-01-04 00:00:00");
		BusyTime dBusyTime1 = new BusyTime(fromDate, toDate);
		d.addBusyTime(dBusyTime1);

		Participant e = new Participant();
		e.setName("EE");
		fromDate = setDate("2016-01-03 00:00:00");
		toDate = setDate("2016-01-04 00:00:00");
		BusyTime eBusyTime1 = new BusyTime(fromDate, toDate);
		e.addBusyTime(eBusyTime1);

		Participant f = new Participant();
		f.setName("FF");
		fromDate = setDate("2016-01-03 00:00:00");
		toDate = setDate("2016-01-04 00:00:00");
		BusyTime fBusyTime1 = new BusyTime(fromDate, toDate);
		f.addBusyTime(fBusyTime1);

		Participant g = new Participant();
		g.setName("GG");
		fromDate = setDate("2016-01-03 00:00:00");
		toDate = setDate("2016-01-04 00:00:00");
		BusyTime gBusyTime1 = new BusyTime(fromDate, toDate);
		g.addBusyTime(gBusyTime1);

		Participant h = new Participant();
		h.setName("HH");
		fromDate = setDate("2016-01-03 00:00:00");
		toDate = setDate("2016-01-04 00:00:00");
		BusyTime hBusyTime1 = new BusyTime(fromDate, toDate);
		h.addBusyTime(hBusyTime1);

		// Meeting Event
		MeetingEvent meetingEvent = new MeetingEvent();
		meetingEvent.setTitle("Rapat Jurusan");
		meetingEvent.setMeetingPlanner(Dropadi);
		meetingEvent.setMeetingDurationInMinutes(1 * 24 * 60);
		Date eventFromDate = setDate("2016-01-01 00:00:00");
		meetingEvent.setFromDate(eventFromDate);
		Date eventToDate = setDate("2016-01-05 00:00:00");
		meetingEvent.setToDate(eventToDate);

		meetingEvent.getAttendanceRequirement().getNecessaryPerson().setName("Orang Penting");
		meetingEvent.getAttendanceRequirement().addNecessaryPerson(a);
		meetingEvent.getAttendanceRequirement().addNecessaryPerson(b);
		meetingEvent.getAttendanceRequirement().addNecessaryPerson(c);

		Attendance attendance = new Attendance();
		attendance.setMinimumAttendance(2);
		attendance.setName("Kelompok 2");
		attendance.getPersons().add(d);
		attendance.getPersons().add(e);
		attendance.getPersons().add(f);
		attendance.getPersons().add(g);
		attendance.getPersons().add(h);
		meetingEvent.getAttendanceRequirement().getRepresentativePerson().add(attendance);

		PlausibleTimeCalculatorInterface plausibleTimeCalculator = new Kel2PlausibleTimeCalculator();
		meetingEvent.setPlausibleTimeCalculator(plausibleTimeCalculator);
		meetingEvent.setPlausibleTime(meetingEvent.countPlausibleTimes());

		printMeetingEventInfo(meetingEvent);
		printPlausibleTime(meetingEvent);
	}

	public static Date setDate(String dateString) throws ParseException {
		Date date;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
		date = formatter.parse(dateString);
		return date;
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
}
