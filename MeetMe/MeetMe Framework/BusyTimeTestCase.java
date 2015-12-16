import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;

public class BusyTimeTestCase {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
	String dateFrom = "2016-01-01 00:00:00";
	String dateTo = "2016-01-02 12:00:00";

	@Test
	public void testgetFrom() throws ParseException {

		String dateTest = "2016-01-01 00:00:00";
		Date busyTimecase = formatter.parse(dateTest);
		Date busyTimefrom = formatter.parse(dateFrom);
		Date busyTimeto = formatter.parse(dateTo);

		BusyTime busyTimeTest = new BusyTime(busyTimefrom, busyTimeto);

		assertEquals(busyTimecase, busyTimeTest.getFrom());
	}

	@Test
	public void testgetTo() throws ParseException {

		String dateTest = "2016-01-02 12:00:00";
		Date busyTimecase = formatter.parse(dateTest);
		Date busyTimefrom = formatter.parse(dateFrom);
		Date busyTimeto = formatter.parse(dateTo);

		BusyTime busyTimeTest = new BusyTime(busyTimefrom, busyTimeto);

		assertEquals(busyTimecase, busyTimeTest.getTo());
	}

	@Test
	public void testgetDuration() throws ParseException {
		Date busyTimefrom = formatter.parse(dateFrom);
		Date busyTimeto = formatter.parse(dateTo);

		BusyTime busyTimeTest = new BusyTime(busyTimefrom, busyTimeto);

		assertEquals(36, busyTimeTest.getDuration());
	}

}
