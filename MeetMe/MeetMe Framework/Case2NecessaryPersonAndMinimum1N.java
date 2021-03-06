import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class Case2NecessaryPersonAndMinimum1N {

	@Test
	public void test() throws ParseException {
		MeetingPlanner Dropadi = new MeetingPlanner();
		Dropadi.setName("Dropadi");

		// set participant
		Participant Yudistira = new Participant();
		Yudistira.setName("Yudistira");
		Participant Bima = new Participant();
		Bima.setName("Bima");
		Participant Arjuna = new Participant();
		Arjuna.setName("Arjuna");
		Participant Nakula = new Participant();
		Arjuna.setName("Nakula");
		Participant Sadewa = new Participant();
		Arjuna.setName("Sadewa");

		// YUDISTIRA BUSYTIME
		// BUSYTIME 1
		Date fromDate = setDate("2015-12-31 00:00:00");
		Date toDate = setDate("2015-12-31 09:00:00");
		BusyTime yudistiraBusyTime1 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 13:00:00");
		toDate = setDate("2015-12-31 17:00:00");
		BusyTime yudistiraBusyTime2 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2016-1-1 9:00:00");
		toDate = setDate("2016-1-1 13:00:00");
		BusyTime yudistiraBusyTime3 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime3);

		// Bima BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 00:00:00");
		toDate = setDate("2015-12-31 12:00:00");
		BusyTime bimaBusyTime1 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 14:00:00");
		toDate = setDate("2015-12-31 22:00:00");
		BusyTime bimaBusyTime2 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2016-1-1 00:00:00");
		toDate = setDate("2016-1-1 24:00:00");
		BusyTime bimaBusyTime3 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime3);

		// Arjuna BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 02:00:00");
		toDate = setDate("2015-12-31 11:00:00");
		BusyTime arjunaBusyTime1 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 14:00:00");
		toDate = setDate("2015-12-31 24:00:00");
		BusyTime arjunaBusyTime2 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime2);

		// Nakula BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 04:00:00 ");
		toDate = setDate("2015-12-31 20:00:00");
		BusyTime nakulaBusyTime1 = new BusyTime(fromDate, toDate);
		Nakula.addBusyTime(nakulaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2016-1-1 00:00:00 ");
		toDate = setDate("2016-1-1 09:00:00");
		BusyTime nakulaBusyTime2 = new BusyTime(fromDate, toDate);
		Nakula.addBusyTime(nakulaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2016-1-1 13:00:00 ");
		toDate = setDate("2016-1-1 24:00:00");
		BusyTime nakulaBusyTime3 = new BusyTime(fromDate, toDate);
		Nakula.addBusyTime(nakulaBusyTime3);

		// Sadewa BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 10:00:00 ");
		toDate = setDate("2015-12-31 13:00:00");
		BusyTime sadewaBusyTime1 = new BusyTime(fromDate, toDate);
		Sadewa.addBusyTime(sadewaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 16:00:00 ");
		toDate = setDate("2015-12-31 22:00:00");
		BusyTime sadewaBusyTime2 = new BusyTime(fromDate, toDate);
		Sadewa.addBusyTime(sadewaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2016-1-1 05:00:00 ");
		toDate = setDate("2016-1-1 17:00:00");
		BusyTime sadewaBusyTime3 = new BusyTime(fromDate, toDate);
		Nakula.addBusyTime(sadewaBusyTime3);

		// set Event
		MeetingEvent meetingEvent = new MeetingEvent();
		meetingEvent.setTitle("Makrab");
		meetingEvent.setMeetingPlanner(Dropadi);
		meetingEvent.setMeetingDurationInMinutes(1 * 60);
		Date eventFromDate = setDate("2015-12-31 00:00:00");
		meetingEvent.setFromDate(eventFromDate);
		Date eventToDate = setDate("2016-1-1 23:00:00");
		meetingEvent.setToDate(eventToDate);

		// add participant
		meetingEvent.addParticipant(Yudistira);
		meetingEvent.addParticipant(Bima);
		meetingEvent.addParticipant(Arjuna);
		meetingEvent.addParticipant(Nakula);
		meetingEvent.addParticipant(Sadewa);

		// NecessaryPerson
		meetingEvent.getAttendanceRequirement().addNecessaryPerson(Bima);
		meetingEvent.getAttendanceRequirement().addNecessaryPerson(Arjuna);

		Attendance attendance = new Attendance();
		attendance.setMinimumAttendance(1);
		attendance.setName("Kembaran");
		attendance.getPersons().add(Nakula);
		attendance.getPersons().add(Sadewa);
		meetingEvent.getAttendanceRequirement().getRepresentativePerson().add(attendance);

		PlausibleTimeCalculatorInterface plausibleTimeCalculator = new Kel2PlausibleTimeCalculator();
		meetingEvent.setPlausibleTimeCalculator(plausibleTimeCalculator);
		meetingEvent.setPlausibleTime(meetingEvent.countPlausibleTimes());

		ArrayList<PlausibleTime> plausibleTimes = new ArrayList<PlausibleTime>();
		PlausibleTime plausibleTime = new PlausibleTime();

		// add plausible time 1
		Date fromPlausibleTime = setDate("2015-12-31 13:00:00");
		Date toPlausibleTime = setDate("2015-12-31 14:00:00");
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
