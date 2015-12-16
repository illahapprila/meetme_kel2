import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

public class TestCase14 {

	@Test
	public void Kemungkinan1() throws ParseException {
		// set meeting planner
		MeetingPlanner Dropadi = new MeetingPlanner();
		Dropadi.setName("Dropadi");

		// set participant
		Participant Yudistira = new Participant();
		Yudistira.setName("Yudistira");
		Participant Bima = new Participant();
		Bima.setName("Bima");
		Participant Arjuna = new Participant();
		Arjuna.setName("Arjuna");

		// EVENT MAKRAB

		// YUDISTIRA BUSYTIME
		// BUSYTIME 1
		Date fromDate = setDate("2015-11-22 00:00:00");
		Date toDate = setDate("2015-11-22 05:00:00");
		BusyTime yudistiraBusyTime1 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-11-22 07:00:00");
		toDate = setDate("2015-11-22 10:00:00");
		BusyTime yudistiraBusyTime2 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-11-22 13:00:00");
		toDate = setDate("2015-11-22 14:00:00");
		BusyTime yudistiraBusyTime3 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2015-11-22 17:00:00");
		toDate = setDate("2015-11-22 23:00:00");
		BusyTime yudistiraBusyTime4 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime4);

		// BIMA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-11-22 00:00:00");
		toDate = setDate("2015-11-22 05:00:00");
		BusyTime bimaBusyTime1 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-11-22 07:00:00");
		toDate = setDate("2015-11-22 11:00:00");
		BusyTime bimaBusyTime2 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-11-22 13:00:00");
		toDate = setDate("2015-11-22 15:00:00");
		BusyTime bimaBusyTime3 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2015-11-22 17:00:00");
		toDate = setDate("2015-11-22 20:00:00");
		BusyTime bimaBusyTime4 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime4);

		// ARJUNA BUSY TIME
		// BUSYTIME 1
		fromDate = setDate("2015-11-22 00:00:00");
		toDate = setDate("2015-11-22 04:00:00");
		BusyTime arjunaBusyTime1 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-11-22 07:00:00");
		toDate = setDate("2015-11-22 10:00:00");
		BusyTime arjunaBusyTime2 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-11-22 13:00:00");
		toDate = setDate("2015-11-22 16:00:00");
		BusyTime arjunaBusyTime3 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2015-11-22 19:00:00");
		toDate = setDate("2015-11-23 00:00:00");
		BusyTime arjunaBusyTime4 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime4);

		// set event
		MeetingEvent meetingEvent = new MeetingEvent();
		meetingEvent.setTitle("Rapat Makrab");
		meetingEvent.setMeetingPlanner(Dropadi);
		meetingEvent.setMeetingDurationInMinutes(1 * 60);
		Date eventFromDate = setDate("2015-11-22 00:00:00");
		meetingEvent.setFromDate(eventFromDate);
		Date eventToDate = setDate("2015-11-22 23:00:00");
		meetingEvent.setToDate(eventToDate);

		// add participant
		meetingEvent.addParticipant(Yudistira);
		meetingEvent.addParticipant(Bima);
		meetingEvent.addParticipant(Arjuna);

		PlausibleTimeCalculatorInterface plausibleTimeCalculator = new JoePlausibleTimeCalculator(10, 100);
		meetingEvent.setPlausibleTimeCalculator(plausibleTimeCalculator);
		meetingEvent.setPlausibleTime(meetingEvent.countPlausibleTimes());

		ArrayList<PlausibleTime> plausibleTimes = new ArrayList<PlausibleTime>();
		PlausibleTime plausibleTime = new PlausibleTime();

		// add plausible time 1
		Date fromPlausibleTime = setDate("2015-11-22 05:00:00");
		Date toPlausibleTime = setDate("2015-11-22 06:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 2
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-22 06:00:00");
		toPlausibleTime = setDate("2015-11-22 07:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 3
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-22 11:00:00");
		toPlausibleTime = setDate("2015-11-22 12:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 4
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-22 12:00:00");
		toPlausibleTime = setDate("2015-11-22 13:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 5
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-22 16:00:00");
		toPlausibleTime = setDate("2015-11-22 17:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);

		int i = 0;

		for (PlausibleTime plausibleTime2 : meetingEvent.getPlausibleTimes()) {
			assertEquals(plausibleTimes.get(i).getFrom(), plausibleTime2.getFrom());
			assertEquals(plausibleTimes.get(i).getTo(), plausibleTime2.getTo());
			i++;
		}

		// EVENT RAPAT NONTON
		// set Event
		MeetingEvent meetingEvent1 = new MeetingEvent();
		meetingEvent1.setTitle("Rapat Nonton");
		meetingEvent1.setMeetingPlanner(Dropadi);
		meetingEvent1.setMeetingDurationInMinutes(1 * 60);
		eventFromDate = setDate("2015-11-22 00:00:00");
		meetingEvent1.setFromDate(eventFromDate);
		eventToDate = setDate("2015-11-22 23:00:00");
		meetingEvent1.setToDate(eventToDate);

		// add participant
		meetingEvent1.addParticipant(Yudistira);
		meetingEvent1.addParticipant(Bima);
		meetingEvent1.addParticipant(Arjuna);

		PlausibleTimeCalculatorInterface plausibleTimeCalculator2 = new JoePlausibleTimeCalculator(10, 100);
		meetingEvent1.setPlausibleTimeCalculator(plausibleTimeCalculator2);
		meetingEvent1.setPlausibleTime(meetingEvent1.countPlausibleTimes());

		ArrayList<PlausibleTime> plausibleTimes1 = new ArrayList<PlausibleTime>();
		PlausibleTime plausibleTime1 = new PlausibleTime();

		// add plausible time 1
		fromPlausibleTime = setDate("2015-11-22 05:00:00");
		toPlausibleTime = setDate("2015-11-22 06:00:00");
		plausibleTime1.setFrom(fromPlausibleTime);
		plausibleTime1.setTo(toPlausibleTime);
		plausibleTimes1.add(plausibleTime1);
		// add plausible time 2
		plausibleTime1 = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-22 06:00:00");
		toPlausibleTime = setDate("2015-11-22 07:00:00");
		plausibleTime1.setFrom(fromPlausibleTime);
		plausibleTime1.setTo(toPlausibleTime);
		plausibleTimes1.add(plausibleTime1);
		// add plausible time 3
		plausibleTime1 = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-22 11:00:00");
		toPlausibleTime = setDate("2015-11-22 12:00:00");
		plausibleTime1.setFrom(fromPlausibleTime);
		plausibleTime1.setTo(toPlausibleTime);
		plausibleTimes1.add(plausibleTime1);
		// add plausible time 4
		plausibleTime1 = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-22 12:00:00");
		toPlausibleTime = setDate("2015-11-22 13:00:00");
		plausibleTime1.setFrom(fromPlausibleTime);
		plausibleTime1.setTo(toPlausibleTime);
		plausibleTimes1.add(plausibleTime1);
		// add plausible time 5
		plausibleTime1 = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-22 16:00:00");
		toPlausibleTime = setDate("2015-11-22 17:00:00");
		plausibleTime1.setFrom(fromPlausibleTime);
		plausibleTime1.setTo(toPlausibleTime);
		plausibleTimes1.add(plausibleTime1);

		int i1 = 0;

		for (PlausibleTime plausibleTime2 : meetingEvent1.getPlausibleTimes()) {
			assertEquals(plausibleTimes1.get(i1).getFrom(), plausibleTime2.getFrom());
			assertEquals(plausibleTimes1.get(i1).getTo(), plausibleTime2.getTo());
			i1++;
		}

	}

	@Test
	public void Kemungkinan2() throws ParseException {
		// set meeting planner
		MeetingPlanner Dropadi = new MeetingPlanner();
		Dropadi.setName("Dropadi");

		// set participant
		Participant Yudistira = new Participant();
		Yudistira.setName("Yudistira");
		Participant Bima = new Participant();
		Bima.setName("Bima");
		Participant Arjuna = new Participant();
		Arjuna.setName("Arjuna");

		// EVENT MAKRAB

		// YUDISTIRA BUSYTIME
		// BUSYTIME 1
		Date fromDate = setDate("2015-11-22 00:00:00");
		Date toDate = setDate("2015-11-22 05:00:00");
		BusyTime yudistiraBusyTime1 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-11-22 07:00:00");
		toDate = setDate("2015-11-22 10:00:00");
		BusyTime yudistiraBusyTime2 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-11-22 13:00:00");
		toDate = setDate("2015-11-22 14:00:00");
		BusyTime yudistiraBusyTime3 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2015-11-22 17:00:00");
		toDate = setDate("2015-11-22 23:00:00");
		BusyTime yudistiraBusyTime4 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime4);

		// BIMA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-11-22 00:00:00");
		toDate = setDate("2015-11-22 06:00:00");
		BusyTime bimaBusyTime1 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-11-22 07:00:00");
		toDate = setDate("2015-11-22 11:00:00");
		BusyTime bimaBusyTime2 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-11-22 13:00:00");
		toDate = setDate("2015-11-22 15:00:00");
		BusyTime bimaBusyTime3 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2015-11-22 17:00:00");
		toDate = setDate("2015-11-22 20:00:00");
		BusyTime bimaBusyTime4 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime4);

		// ARJUNA BUSY TIME
		// BUSYTIME 1
		fromDate = setDate("2015-11-22 00:00:00");
		toDate = setDate("2015-11-22 04:00:00");
		BusyTime arjunaBusyTime1 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-11-22 07:00:00");
		toDate = setDate("2015-11-22 10:00:00");
		BusyTime arjunaBusyTime2 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-11-22 13:00:00");
		toDate = setDate("2015-11-22 16:00:00");
		BusyTime arjunaBusyTime3 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2015-11-22 19:00:00");
		toDate = setDate("2015-11-23 00:00:00");
		BusyTime arjunaBusyTime4 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime4);

		// set Event
		MeetingEvent meetingEvent = new MeetingEvent();
		meetingEvent.setTitle("Rapat Makrab");
		meetingEvent.setMeetingPlanner(Dropadi);
		meetingEvent.setMeetingDurationInMinutes(1 * 60);
		Date eventFromDate = setDate("2015-11-22 00:00:00");
		meetingEvent.setFromDate(eventFromDate);
		Date eventToDate = setDate("2015-11-22 23:00:00");
		meetingEvent.setToDate(eventToDate);

		// add participant
		meetingEvent.addParticipant(Yudistira);
		meetingEvent.addParticipant(Bima);
		meetingEvent.addParticipant(Arjuna);

		PlausibleTimeCalculatorInterface plausibleTimeCalculator = new JoePlausibleTimeCalculator(10, 100);
		meetingEvent.setPlausibleTimeCalculator(plausibleTimeCalculator);
		meetingEvent.setPlausibleTime(meetingEvent.countPlausibleTimes());

		ArrayList<PlausibleTime> plausibleTimes = new ArrayList<PlausibleTime>();
		PlausibleTime plausibleTime = new PlausibleTime();

		// add plausible time 1
		Date fromPlausibleTime = setDate("2015-11-22 06:00:00");
		Date toPlausibleTime = setDate("2015-11-22 07:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 2
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-22 11:00:00");
		toPlausibleTime = setDate("2015-11-22 12:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 3
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-22 12:00:00");
		toPlausibleTime = setDate("2015-11-22 13:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);
		// add plausible time 4
		plausibleTime = new PlausibleTime();
		fromPlausibleTime = setDate("2015-11-22 16:00:00");
		toPlausibleTime = setDate("2015-11-22 17:00:00");
		plausibleTime.setFrom(fromPlausibleTime);
		plausibleTime.setTo(toPlausibleTime);
		plausibleTimes.add(plausibleTime);

		int i = 0;

		for (PlausibleTime plausibleTime2 : meetingEvent.getPlausibleTimes()) {
			assertEquals(plausibleTimes.get(i).getFrom(), plausibleTime2.getFrom());
			assertEquals(plausibleTimes.get(i).getTo(), plausibleTime2.getTo());
			i++;
		}

		// EVENT RAPAT NONTON

		// YUDISTIRA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-14 00:00:00");
		toDate = setDate("2015-12-14 05:00:00");
		yudistiraBusyTime1 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-14 07:00:00");
		toDate = setDate("2015-12-14 09:00:00");
		yudistiraBusyTime2 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-14 13:00:00");
		toDate = setDate("2015-12-14 14:00:00");
		yudistiraBusyTime3 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2015-12-14 17:00:00");
		toDate = setDate("2015-12-14 23:00:00");
		yudistiraBusyTime4 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime4);

		// BIMA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-14 00:00:00");
		toDate = setDate("2015-12-14 05:00:00");
		bimaBusyTime1 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-14 06:00:00");
		toDate = setDate("2015-12-14 14:00:00");
		bimaBusyTime2 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-14 18:00:00");
		toDate = setDate("2015-12-15 00:00:00");
		bimaBusyTime3 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime3);

		// ARJUNA BUSY TIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-14 00:00:00");
		toDate = setDate("2015-12-14 04:00:00");
		arjunaBusyTime1 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-14 07:00:00");
		toDate = setDate("2015-12-14 10:00:00");
		arjunaBusyTime2 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-14 11:00:00");
		toDate = setDate("2015-12-14 15:00:00");
		arjunaBusyTime3 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2015-12-14 17:00:00");
		toDate = setDate("2015-12-14 22:00:00");
		arjunaBusyTime4 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime4);

		// set Event
		MeetingEvent meetingEvent1 = new MeetingEvent();
		meetingEvent1.setTitle("Rapat Nonton");
		meetingEvent1.setMeetingPlanner(Dropadi);
		meetingEvent1.setMeetingDurationInMinutes(1 * 60);
		eventFromDate = setDate("2015-12-14 00:00:00");
		meetingEvent1.setFromDate(eventFromDate);
		eventToDate = setDate("2015-12-14 23:00:00");
		meetingEvent1.setToDate(eventToDate);

		// add participant
		meetingEvent1.addParticipant(Yudistira);
		meetingEvent1.addParticipant(Bima);
		meetingEvent1.addParticipant(Arjuna);

		PlausibleTimeCalculatorInterface plausibleTimeCalculator2 = new JoePlausibleTimeCalculator(10, 100);
		meetingEvent1.setPlausibleTimeCalculator(plausibleTimeCalculator2);
		meetingEvent1.setPlausibleTime(meetingEvent1.countPlausibleTimes());

		ArrayList<PlausibleTime> plausibleTimes1 = new ArrayList<PlausibleTime>();
		PlausibleTime plausibleTime1 = new PlausibleTime();

		// add plausible time 1
		fromPlausibleTime = setDate("2015-12-14 05:00:00");
		toPlausibleTime = setDate("2015-12-14 06:00:00");
		plausibleTime1.setFrom(fromPlausibleTime);
		plausibleTime1.setTo(toPlausibleTime);
		plausibleTimes1.add(plausibleTime1);
		// add plausible time 2
		plausibleTime1 = new PlausibleTime();
		fromPlausibleTime = setDate("2015-12-14 15:00:00");
		toPlausibleTime = setDate("2015-12-14 16:00:00");
		plausibleTime1.setFrom(fromPlausibleTime);
		plausibleTime1.setTo(toPlausibleTime);
		plausibleTimes1.add(plausibleTime1);
		// add plausible time 3
		plausibleTime1 = new PlausibleTime();
		fromPlausibleTime = setDate("2015-12-14 16:00:00");
		toPlausibleTime = setDate("2015-12-14 17:00:00");
		plausibleTime1.setFrom(fromPlausibleTime);
		plausibleTime1.setTo(toPlausibleTime);
		plausibleTimes1.add(plausibleTime1);

		int i1 = 0;

		for (PlausibleTime plausibleTime2 : meetingEvent1.getPlausibleTimes()) {
			assertEquals(plausibleTimes1.get(i1).getFrom(), plausibleTime2.getFrom());
			assertEquals(plausibleTimes1.get(i1).getTo(), plausibleTime2.getTo());
			i1++;
		}

	}

	public static Date setDate(String dateString) throws ParseException {
		Date date;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
		date = formatter.parse(dateString);
		return date;
	}

}
