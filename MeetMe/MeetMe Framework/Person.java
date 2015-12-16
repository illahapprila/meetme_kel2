import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {

	private String name;
	private BusyCalendar busyCalendar = new BusyCalendar();

	public void addBusyTime(BusyTime busyTime) {
		busyCalendar.addBusytime(busyTime);
	}

	public void addBusyTime(String dateFrom, String dateTo) throws ParseException {
		Date from = convertStringToDate(dateFrom);
		Date to = convertStringToDate(dateTo);
		BusyTime busyTime = new BusyTime(from, to);
		busyCalendar.addBusytime(busyTime);
	}

	public Date convertStringToDate(String stringDate) throws ParseException {
		Date date;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
		date = formatter.parse(stringDate);
		return date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BusyCalendar getBusyCalendar() {
		return busyCalendar;
	}

	public void setBusyCalendar(BusyCalendar busyCalendar) {
		this.busyCalendar = busyCalendar;
	}

}
