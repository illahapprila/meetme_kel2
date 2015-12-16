import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

public class Testcase19 {
	@Test
	public void test() throws ParseException {
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
		Participant Nakula = new Participant();
		Nakula.setName("Nakula");
		Participant Sadewa = new Participant();
		Sadewa.setName("Sadewa");
		Participant Kresna = new Participant();
		Kresna.setName("Kresna");
		Participant Bisma = new Participant();
		Bisma.setName("Bisma");
		Participant Srikandi = new Participant();
		Srikandi.setName("Srikandi");
		Participant GatotKaca = new Participant();
		GatotKaca.setName("Gatot Kaca");
		Participant Kunti = new Participant();
		Kunti.setName("Kunti");
		Participant Duryudana = new Participant();
		Duryudana.setName("Duryudana");
		Participant Destrarasta = new Participant();
		Destrarasta.setName("Destrarasta");
		Participant Dorna = new Participant();
		Dorna.setName("Dorna");
		Participant Wicitrawirya = new Participant();
		Wicitrawirya.setName("Wicitrawirya");
		Participant Semar = new Participant();
		Semar.setName("Semar");

		// YUDISTIRA BUSYTIME
		// BUSYTIME 1
		Date fromDate = setDate("2015-12-31 00:00:00");
		Date toDate = setDate("2015-12-31 06:00:00");
		BusyTime yudistiraBusyTime1 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 09:00:00");
		toDate = setDate("2015-12-31 15:00:00");
		BusyTime yudistiraBusyTime2 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-31 17:00:00");
		toDate = setDate("2015-12-31 18:00:00");
		BusyTime yudistiraBusyTime3 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2015-12-31 20:00:00");
		toDate = setDate("2015-12-31 23:00:00");
		BusyTime yudistiraBusyTime4 = new BusyTime(fromDate, toDate);
		Yudistira.addBusyTime(yudistiraBusyTime4);

		// BIMA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 00:00:00");
		toDate = setDate("2015-12-31 09:00:00");
		BusyTime bimaBusyTime1 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 11:00:00");
		toDate = setDate("2015-12-31 14:00:00");
		BusyTime bimaBusyTime2 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-31 16:00:00");
		toDate = setDate("2015-12-31 20:00:00");
		BusyTime bimaBusyTime3 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2015-12-31 22:00:00");
		toDate = setDate("2015-12-31 23:00:00");
		BusyTime bimaBusyTime4 = new BusyTime(fromDate, toDate);
		Bima.addBusyTime(bimaBusyTime4);

		// ARJUNA BUSY TIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 00:00:00");
		toDate = setDate("2015-12-31 07:00:00");
		BusyTime arjunaBusyTime1 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 09:00:00");
		toDate = setDate("2015-12-31 11:00:00");
		BusyTime arjunaBusyTime2 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-31 13:00:00");
		toDate = setDate("2015-12-31 14:00:00");
		BusyTime arjunaBusyTime3 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2015-12-31 16:00:00");
		toDate = setDate("2015-12-31 17:00:00");
		BusyTime arjunaBusyTime4 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime4);
		// BUSYTIME 5
		fromDate = setDate("2015-12-31 19:00:00");
		toDate = setDate("2015-12-31 23:00:00");
		BusyTime arjunaBusyTime5 = new BusyTime(fromDate, toDate);
		Arjuna.addBusyTime(arjunaBusyTime5);

		// NAKULA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 00:00:00");
		toDate = setDate("2015-12-31 07:00:00");
		BusyTime nakulaBusyTime1 = new BusyTime(fromDate, toDate);
		Nakula.addBusyTime(nakulaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 18:00:00");
		toDate = setDate("2015-12-31 23:00:00");
		BusyTime nakulaBusyTime2 = new BusyTime(fromDate, toDate);
		Nakula.addBusyTime(nakulaBusyTime2);

		// SADEWA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 00:00:00");
		toDate = setDate("2015-12-31 07:00:00");
		BusyTime sadewaBusyTime1 = new BusyTime(fromDate, toDate);
		Sadewa.addBusyTime(sadewaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 10:00:00");
		toDate = setDate("2015-12-31 12:00:00");
		BusyTime sadewaBusyTime2 = new BusyTime(fromDate, toDate);
		Sadewa.addBusyTime(sadewaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-31 15:00:00");
		toDate = setDate("2015-12-31 16:00:00");
		BusyTime sadewaBusyTime3 = new BusyTime(fromDate, toDate);
		Sadewa.addBusyTime(sadewaBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2015-12-31 18:00:00");
		toDate = setDate("2015-12-31 23:00:00");
		BusyTime sadewaBusyTime4 = new BusyTime(fromDate, toDate);
		Sadewa.addBusyTime(sadewaBusyTime4);

		// KRESNA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 00:00:00");
		toDate = setDate("2015-12-31 06:00:00");
		BusyTime kresnaBusyTime1 = new BusyTime(fromDate, toDate);
		Kresna.addBusyTime(kresnaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 11:00:00");
		toDate = setDate("2015-12-31 23:00:00");
		BusyTime kresnaBusyTime2 = new BusyTime(fromDate, toDate);
		Kresna.addBusyTime(kresnaBusyTime2);

		// BISMA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 00:00:00");
		toDate = setDate("2015-12-31 06:00:00");
		BusyTime bismaBusyTime1 = new BusyTime(fromDate, toDate);
		Bisma.addBusyTime(bismaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 09:00:00");
		toDate = setDate("2015-12-31 13:00:00");
		BusyTime bismaBusyTime2 = new BusyTime(fromDate, toDate);
		Bisma.addBusyTime(bismaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-31 16:00:00");
		toDate = setDate("2015-12-31 23:00:00");
		BusyTime bismaBusyTime3 = new BusyTime(fromDate, toDate);
		Bisma.addBusyTime(bismaBusyTime3);

		// BISMA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 00:00:00");
		toDate = setDate("2015-12-31 06:00:00");
		BusyTime srikandiBusyTime1 = new BusyTime(fromDate, toDate);
		Srikandi.addBusyTime(srikandiBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 08:00:00");
		toDate = setDate("2015-12-31 12:00:00");
		BusyTime srikandiBusyTime2 = new BusyTime(fromDate, toDate);
		Srikandi.addBusyTime(srikandiBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-31 14:00:00");
		toDate = setDate("2015-12-31 15:00:00");
		BusyTime srikandiBusyTime3 = new BusyTime(fromDate, toDate);
		Srikandi.addBusyTime(srikandiBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2015-12-31 17:00:00");
		toDate = setDate("2015-12-31 23:00:00");
		BusyTime srikandiBusyTime4 = new BusyTime(fromDate, toDate);
		Srikandi.addBusyTime(srikandiBusyTime4);

		// GATOT KACA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 00:00:00");
		toDate = setDate("2015-12-31 06:00:00");
		BusyTime gatotkacaBusyTime1 = new BusyTime(fromDate, toDate);
		GatotKaca.addBusyTime(gatotkacaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 08:00:00");
		toDate = setDate("2015-12-31 09:00:00");
		BusyTime gatotkacaBusyTime2 = new BusyTime(fromDate, toDate);
		GatotKaca.addBusyTime(gatotkacaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-31 11:00:00");
		toDate = setDate("2015-12-31 15:00:00");
		BusyTime gatotkacaBusyTime3 = new BusyTime(fromDate, toDate);
		GatotKaca.addBusyTime(gatotkacaBusyTime3);
		// BUSYTIME 4
		fromDate = setDate("2015-12-31 17:00:00");
		toDate = setDate("2015-12-31 23:00:00");
		BusyTime gatotkacaBusyTime4 = new BusyTime(fromDate, toDate);
		GatotKaca.addBusyTime(gatotkacaBusyTime4);

		// KUNTI BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 00:00:00");
		toDate = setDate("2015-12-31 06:00:00");
		BusyTime kuntiBusyTime1 = new BusyTime(fromDate, toDate);
		Kunti.addBusyTime(kuntiBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 08:00:00");
		toDate = setDate("2015-12-31 14:00:00");
		BusyTime kuntiBusyTime2 = new BusyTime(fromDate, toDate);
		Kunti.addBusyTime(kuntiBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-31 16:00:00");
		toDate = setDate("2015-12-31 23:00:00");
		BusyTime kuntiBusyTime3 = new BusyTime(fromDate, toDate);
		Kunti.addBusyTime(kuntiBusyTime3);

		// DURYUDANA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 00:00:00");
		toDate = setDate("2015-12-31 07:00:00");
		BusyTime duryudanaBusyTime1 = new BusyTime(fromDate, toDate);
		Duryudana.addBusyTime(duryudanaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 12:00:00");
		toDate = setDate("2015-12-31 13:00:00");
		BusyTime duryudanaBusyTime2 = new BusyTime(fromDate, toDate);
		Duryudana.addBusyTime(duryudanaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-31 16:00:00");
		toDate = setDate("2015-12-31 23:00:00");
		BusyTime duryudanaBusyTime3 = new BusyTime(fromDate, toDate);
		Duryudana.addBusyTime(duryudanaBusyTime3);

		// DESTRARASTA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 00:00:00");
		toDate = setDate("2015-12-31 06:00:00");
		BusyTime destrarastaBusyTime1 = new BusyTime(fromDate, toDate);
		Destrarasta.addBusyTime(destrarastaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 10:00:00");
		toDate = setDate("2015-12-31 23:00:00");
		BusyTime destrarastaBusyTime2 = new BusyTime(fromDate, toDate);
		Destrarasta.addBusyTime(destrarastaBusyTime2);

		// DORNA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 00:00:00");
		toDate = setDate("2015-12-31 05:00:00");
		BusyTime dornaBusyTime1 = new BusyTime(fromDate, toDate);
		Dorna.addBusyTime(dornaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 09:00:00");
		toDate = setDate("2015-12-31 12:00:00");
		BusyTime dornaBusyTime2 = new BusyTime(fromDate, toDate);
		Dorna.addBusyTime(dornaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-31 20:00:00");
		toDate = setDate("2015-12-31 23:00:00");
		BusyTime dornaBusyTime3 = new BusyTime(fromDate, toDate);
		Dorna.addBusyTime(dornaBusyTime3);

		// WICITRAWIRYA BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 00:00:00");
		toDate = setDate("2015-12-31 07:00:00");
		BusyTime wicitrawiryaBusyTime1 = new BusyTime(fromDate, toDate);
		Wicitrawirya.addBusyTime(wicitrawiryaBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 11:00:00");
		toDate = setDate("2015-12-31 15:00:00");
		BusyTime wicitrawiryaBusyTime2 = new BusyTime(fromDate, toDate);
		Wicitrawirya.addBusyTime(wicitrawiryaBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-31 18:00:00");
		toDate = setDate("2015-12-31 23:00:00");
		BusyTime wicitrawiryaBusyTime3 = new BusyTime(fromDate, toDate);
		Wicitrawirya.addBusyTime(wicitrawiryaBusyTime3);

		// SEMAR BUSYTIME
		// BUSYTIME 1
		fromDate = setDate("2015-12-31 00:00:00");
		toDate = setDate("2015-12-31 06:00:00");
		BusyTime semarBusyTime1 = new BusyTime(fromDate, toDate);
		Semar.addBusyTime(semarBusyTime1);
		// BUSYTIME 2
		fromDate = setDate("2015-12-31 08:00:00");
		toDate = setDate("2015-12-31 12:00:00");
		BusyTime semarBusyTime2 = new BusyTime(fromDate, toDate);
		Semar.addBusyTime(semarBusyTime2);
		// BUSYTIME 3
		fromDate = setDate("2015-12-31 15:00:00");
		toDate = setDate("2015-12-31 23:00:00");
		BusyTime semarBusyTime3 = new BusyTime(fromDate, toDate);
		Semar.addBusyTime(semarBusyTime3);

		// set Event
		MeetingEvent meetingEvent = new MeetingEvent();
		meetingEvent.setTitle("Meeting Event");
		meetingEvent.setMeetingPlanner(Dropadi);
		meetingEvent.setMeetingDurationInMinutes(2 * 60);
		Date eventFromDate = setDate("2015-12-31 00:00:00");
		meetingEvent.setFromDate(eventFromDate);
		Date eventToDate = setDate("2015-12-31 23:00:00");
		meetingEvent.setToDate(eventToDate);

		// add participant
		meetingEvent.addParticipant(Yudistira);
		meetingEvent.addParticipant(Bima);
		meetingEvent.addParticipant(Arjuna);
		meetingEvent.addParticipant(Nakula);
		meetingEvent.addParticipant(Sadewa);
		meetingEvent.addParticipant(Kresna);
		meetingEvent.addParticipant(Bisma);
		meetingEvent.addParticipant(Srikandi);
		meetingEvent.addParticipant(GatotKaca);
		meetingEvent.addParticipant(Kunti);
		meetingEvent.addParticipant(Duryudana);
		meetingEvent.addParticipant(Destrarasta);
		meetingEvent.addParticipant(Dorna);
		meetingEvent.addParticipant(Wicitrawirya);
		meetingEvent.addParticipant(Semar);

		PlausibleTimeCalculatorInterface plausibleTimeCalculator = new JoePlausibleTimeCalculator(10, 100);
		meetingEvent.setPlausibleTimeCalculator(plausibleTimeCalculator);
		meetingEvent.setPlausibleTime(meetingEvent.countPlausibleTimes());

		ArrayList<PlausibleTime> plausibleTimes = new ArrayList<PlausibleTime>();
		PlausibleTime plausibleTime = new PlausibleTime();

		assertEquals(null, meetingEvent.getPlausibleTimes());

	}

	public static Date setDate(String dateString) throws ParseException {
		Date date;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
		date = formatter.parse(dateString);
		return date;
	}

}
