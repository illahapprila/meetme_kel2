import java.util.ArrayList;

public class AttendanceRequirement {
	private Attendance necessaryPerson = new Attendance();
	private Attendance nonNecessaryPerson = new Attendance();
	private ArrayList<Attendance> representativePerson = new ArrayList<Attendance>();

	public Attendance getNecessaryPerson() {
		return necessaryPerson;
	}

	public void setNecessaryPerson(Attendance necessaryPerson) {
		this.necessaryPerson = necessaryPerson;
	}

	public Attendance getNonNecessaryPerson() {
		return nonNecessaryPerson;
	}

	public void setNonNecessaryPerson(Attendance nonNecessaryPerson) {
		this.nonNecessaryPerson = nonNecessaryPerson;
	}

	public void addNecessaryPerson(Person person) {
		necessaryPerson.getPersons().add(person);
	}

	public ArrayList<Attendance> getRepresentativePerson() {
		return representativePerson;
	}

	public void setRepresentativePerson(ArrayList<Attendance> representativePerson) {
		this.representativePerson = representativePerson;
	}

	public void addNonNecessaryPerson(Person person) {
		nonNecessaryPerson.getPersons().add(person);
	}
}
