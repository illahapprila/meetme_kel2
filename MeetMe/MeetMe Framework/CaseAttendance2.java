import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaseAttendance2 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		MeetingPlanner Dropadi = new MeetingPlanner();

		Dropadi.setName("Dropadi X");

		Participant a = new Participant();
		a.setName("AA");
		Date fromDate;
		Date toDate;
		a.addBusyTime("2016-01-02 00:00:00", "2016-01-04 00:00:00");
		a.addBusyTime("2016-01-06 00:00:00", "2016-01-08 00:00:00");
		Participant b = new Participant();
		b.setName("BB");
		b.addBusyTime("2016-01-02 00:00:00", "2016-01-04 00:00:00");
		b.addBusyTime("2016-01-06 00:00:00", "2016-01-08 00:00:00");
		Participant c = new Participant();
		c.setName("CC");
		c.addBusyTime("2016-01-02 00:00:00", "2016-01-04 00:00:00");
		c.addBusyTime("2016-01-06 00:00:00", "2016-01-08 00:00:00");

		Participant d = new Participant();
		d.setName("DD");
		fromDate = setDate("2016-01-02 00:00:00");
		toDate = setDate("2016-01-04 00:00:00");
		BusyTime dBusyTime1 = new BusyTime(fromDate, toDate);
		d.addBusyTime(dBusyTime1);
		fromDate = setDate("2016-01-05 00:00:00");
		toDate = setDate("2016-01-08 00:00:00");
		dBusyTime1 = new BusyTime(fromDate, toDate);
		d.addBusyTime(dBusyTime1);

		Participant e = new Participant();
		e.setName("EE");
		fromDate = setDate("2016-01-02 00:00:00");
		toDate = setDate("2016-01-04 00:00:00");
		BusyTime eBusyTime1 = new BusyTime(fromDate, toDate);
		e.addBusyTime(eBusyTime1);
		fromDate = setDate("2016-01-05 00:00:00");
		toDate = setDate("2016-01-08 00:00:00");
		eBusyTime1 = new BusyTime(fromDate, toDate);
		e.addBusyTime(eBusyTime1);

		Participant f = new Participant();
		f.setName("FF");
		fromDate = setDate("2016-01-02 00:00:00");
		toDate = setDate("2016-01-04 00:00:00");
		BusyTime fBusyTime1 = new BusyTime(fromDate, toDate);
		f.addBusyTime(fBusyTime1);
		fromDate = setDate("2016-01-05 00:00:00");
		toDate = setDate("2016-01-09 00:00:00");
		fBusyTime1 = new BusyTime(fromDate, toDate);
		f.addBusyTime(fBusyTime1);

		Participant g = new Participant();
		g.setName("GG");
		fromDate = setDate("2016-01-01 00:00:00");
		toDate = setDate("2016-01-04 00:00:00");
		BusyTime gBusyTime1 = new BusyTime(fromDate, toDate);
		g.addBusyTime(gBusyTime1);
		g.setName("GG");
		fromDate = setDate("2016-01-05 00:00:00");
		toDate = setDate("2016-01-09 00:00:00");
		gBusyTime1 = new BusyTime(fromDate, toDate);
		g.addBusyTime(gBusyTime1);

		Participant h = new Participant();
		h.setName("HH");
		fromDate = setDate("2016-01-02 00:00:00");
		toDate = setDate("2016-01-09 00:00:00");
		BusyTime hBusyTime1 = new BusyTime(fromDate, toDate);
		h.addBusyTime(hBusyTime1);

		Participant i = new Participant();
		i.setName("II");
		fromDate = setDate("2016-01-02 00:00:00");
		toDate = setDate("2016-01-09 00:00:00");
		BusyTime iBusyTime1 = new BusyTime(fromDate, toDate);
		i.addBusyTime(iBusyTime1);

		Participant j = new Participant();
		j.setName("JJ");
		fromDate = setDate("2016-01-01 00:00:00");
		toDate = setDate("2016-01-09 00:00:00");
		BusyTime jBusyTime1 = new BusyTime(fromDate, toDate);
		j.addBusyTime(jBusyTime1);

		Participant k = new Participant();
		k.setName("KK");
		fromDate = setDate("2016-01-02 00:00:00");
		toDate = setDate("2016-01-09 00:00:00");
		BusyTime kBusyTime1 = new BusyTime(fromDate, toDate);
		k.addBusyTime(kBusyTime1);

		Participant l = new Participant();
		l.setName("LL");
		fromDate = setDate("2016-01-02 00:00:00");
		toDate = setDate("2016-01-09 00:00:00");
		BusyTime lBusyTime1 = new BusyTime(fromDate, toDate);
		l.addBusyTime(lBusyTime1);

		Participant m = new Participant();
		m.setName("MM");
		fromDate = setDate("2016-01-01 00:00:00");
		toDate = setDate("2016-01-09 00:00:00");
		BusyTime mBusyTime1 = new BusyTime(fromDate, toDate);
		m.addBusyTime(mBusyTime1);

		// Meeting Event
		MeetingEvent meetingEvent = new MeetingEvent();
		meetingEvent.setTitle("Rapat Jurusan");
		meetingEvent.setMeetingPlanner(Dropadi);
		meetingEvent.setMeetingDurationInMinutes(1 * 24 * 60);
		Date eventFromDate = setDate("2016-01-01 00:00:00");
		meetingEvent.setFromDate(eventFromDate);
		Date eventToDate = setDate("2016-01-09 00:00:00");
		meetingEvent.setToDate(eventToDate);

		meetingEvent.getAttendanceRequirement().getNecessaryPerson().setName("Orang Penting");
		meetingEvent.getAttendanceRequirement().addNecessaryPerson(a);
		meetingEvent.getAttendanceRequirement().addNecessaryPerson(b);
		meetingEvent.getAttendanceRequirement().addNecessaryPerson(c);

		Attendance attendance = new Attendance();
		attendance.setMinimumAttendance(3);
		attendance.setName("Kelompok 2");
		attendance.getPersons().add(d);
		attendance.getPersons().add(e);
		attendance.getPersons().add(f);
		attendance.getPersons().add(g);
		meetingEvent.getAttendanceRequirement().getRepresentativePerson().add(attendance);

		attendance = new Attendance();
		attendance.setMinimumAttendance(1);
		attendance.setName("Kelompok 3");
		attendance.getPersons().add(h);
		attendance.getPersons().add(i);
		attendance.getPersons().add(j);
		meetingEvent.getAttendanceRequirement().getRepresentativePerson().add(attendance);

		meetingEvent.getAttendanceRequirement().addNonNecessaryPerson(k);
		meetingEvent.getAttendanceRequirement().addNonNecessaryPerson(l);
		meetingEvent.getAttendanceRequirement().addNonNecessaryPerson(m);

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
