import java.util.ArrayList;

public class BusyCalendar {
	private ArrayList<BusyTime> busyTimes = new ArrayList<BusyTime>();

	public void addBusytime(BusyTime busyTime) {
		busyTimes.add(busyTime);
	}

	public ArrayList<BusyTime> getBusyTimes() {
		return busyTimes;
	}

	public void setBusyTimes(ArrayList<BusyTime> busyTimes) {
		this.busyTimes = busyTimes;
	}

}
