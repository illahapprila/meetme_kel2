import java.util.ArrayList;
import java.util.Date;

public class ProspectivePerson {
	private Date date;
	private ArrayList<Person> person = new ArrayList<Person>();

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<Person> getPerson() {
		return person;
	}

	public void setPerson(ArrayList<Person> person) {
		this.person = person;
	}
}
