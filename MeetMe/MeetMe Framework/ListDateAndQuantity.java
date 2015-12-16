import java.util.ArrayList;

public class ListDateAndQuantity {
	private ArrayList<DateAndQuantity> dateAndQuantities = new ArrayList<DateAndQuantity>();

	public void addListDateAndQuantity(DateAndQuantity dateAndQuantity) {
		dateAndQuantities.add(dateAndQuantity);
	}

	public ArrayList<DateAndQuantity> getDateAndQuantities() {
		return dateAndQuantities;
	}

	public void setDateAndQuantities(ArrayList<DateAndQuantity> dateAndQuantities) {
		this.dateAndQuantities = dateAndQuantities;
	}
}
