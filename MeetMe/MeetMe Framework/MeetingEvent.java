import java.util.ArrayList;
import java.util.Date;

public class MeetingEvent {

	private PlausibleTimeCalculatorInterface plausibleTimeCalculator;
	private ArrayList<PlausibleTime> plausibleTimes = new ArrayList<PlausibleTime>();

	private String title;
	private MeetingPlanner meetingPlanner;
	private ArrayList<Person> participants = new ArrayList<Person>();
	private boolean isMeetingPlannerAsParticipant = false;

	private AttendanceRequirement attendanceRequirement = new AttendanceRequirement();
	private MeetingConstraint meetingConstraint = new MeetingConstraint();

	private int meetingDurationInMinutes;

	private ArrayList<ProspectivePerson> dateAndPersons = new ArrayList<ProspectivePerson>();

	// tanggal awal yg diperbolehkan terjadinya meeting event
	private Date fromDate;

	// tanggal akhir yang diperbolehkan terjadinya meeting event
	private Date toDate;

	// waktu awal meeting event yang dibolehkan
	private int startMeetingEvent;

	// waktu akhir meeting event yang dibolehkan
	private int endMeetingEvent;

	private Location location;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MeetingConstraint getMeetingConstraint() {
		return meetingConstraint;
	}

	public void setMeetingConstraint(MeetingConstraint meetingConstraint) {
		this.meetingConstraint = meetingConstraint;
	}

	public PlausibleTimeCalculatorInterface getPlausibleTimeCalculator() {
		return plausibleTimeCalculator;
	}

	public boolean isMeetingPlannerAsParticipant() {
		return isMeetingPlannerAsParticipant;
	}

	public void setMeetingPlannerAsParticipant(boolean isMeetingPlannerParticipant) {
		this.isMeetingPlannerAsParticipant = isMeetingPlannerParticipant;
	}

	public int getMeetingDurationInMinutes() {
		return meetingDurationInMinutes;
	}

	public void setMeetingDurationInMinutes(int meetingDurationInMinutes) {
		this.meetingDurationInMinutes = meetingDurationInMinutes;
	}

	public void setPlausibleTimeCalculator(PlausibleTimeCalculatorInterface plausibleTimeCalculator) {
		this.plausibleTimeCalculator = plausibleTimeCalculator;
	}

	public MeetingPlanner getMeetingPlanner() {
		return meetingPlanner;
	}

	public void setMeetingPlanner(MeetingPlanner meetingPlanner) {
		this.meetingPlanner = meetingPlanner;
	}

	public ArrayList<Person> getParticipants() {
		return participants;
	}

	public void addParticipant(Participant participant) {
		this.participants.add(participant);
	}

	public void setParticipants(ArrayList<Person> participants) {
		this.participants = participants;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public void setPlausibleTime(ArrayList<PlausibleTime> plausibleTimes) {
		this.plausibleTimes = plausibleTimes;
	}

	public ArrayList<PlausibleTime> getPlausibleTimes() {
		return plausibleTimes;
	}

	public ArrayList<PlausibleTime> countPlausibleTimes() {
		return plausibleTimeCalculator.calculatePlausibleTimes(this);
	}

	public int getStartMeetingEvent() {
		return startMeetingEvent;
	}

	public void setStartMeetingEvent(int startEvent) {
		this.startMeetingEvent = startEvent;
	}

	public int getEndMeetingEvent() {
		return endMeetingEvent;
	}

	public void setEndMeetingEvent(int endEvent) {
		this.endMeetingEvent = endEvent;
	}

	public AttendanceRequirement getAttendanceRequirement() {
		return attendanceRequirement;
	}

	public void setAttendanceRequirement(AttendanceRequirement attendanceRequirement) {
		this.attendanceRequirement = attendanceRequirement;
	}

	public int numberOfParticipant() {
		int number = 0;

		for (@SuppressWarnings("unused")
		Person participant : this.participants) {
			number++;
		}
		return number;
	}

	public ArrayList<ProspectivePerson> getDateAndPersons() {
		return dateAndPersons;
	}

	public void setDateAndPersons(ArrayList<ProspectivePerson> dateAndPersons) {
		this.dateAndPersons = dateAndPersons;
	}

}
