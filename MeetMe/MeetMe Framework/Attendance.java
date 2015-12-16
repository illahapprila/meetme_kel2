import java.util.ArrayList;

public class Attendance {
	private ArrayList<Person> persons = new ArrayList<Person>();
	private int minimumAttendance;
	private int maximalAttendance;
	private String name;

	public ArrayList<Person> getPersons() {
		return persons;
	}

	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}

	public int getMinimumAttendance() {
		return minimumAttendance;
	}

	public void setMinimumAttendance(int minimumAttendance) {
		this.minimumAttendance = minimumAttendance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaximalAttendance() {
		return maximalAttendance;
	}

	public void setMaximalAttendance(int maximalAttendance) {
		this.maximalAttendance = maximalAttendance;
	}

	@SuppressWarnings("unused")
	public void setMaximalAttendance() {
		this.maximalAttendance = 0;
		for (Person person : this.persons) {
			this.maximalAttendance++;
		}
	}
}
