import java.util.Date;

public class BusyTime {

	private Date from;
	private Date to;
	private int duration;

	// constructor
	public BusyTime(Date from, Date to) {
		this.from = from;
		this.to = to;
		this.duration = (int) ((this.to.getTime() - this.from.getTime()) / (60 * 1000));
	}

	public BusyTime(Date from, int duration) {
		this.from = from;
		this.duration = duration;
		this.to = new Date((long) (this.from.getTime() + (this.duration * 60 * 1000)));
	}

	public BusyTime(int duration, Date to) {
		this.to = to;
		this.duration = duration;
		this.from = new Date((long) (this.to.getTime() - (this.duration * 60 * 1000)));
	}

	public BusyTime(BusyTime busyTime) {
		this.from = busyTime.getFrom();
		this.to = busyTime.getTo();
		this.duration = busyTime.getDuration();
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}