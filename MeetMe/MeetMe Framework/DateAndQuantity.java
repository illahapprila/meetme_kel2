import java.util.Date;

// Class yang digunakan untuk menyimpan tanggal dan jumlah orang yang tidak dapat hadir pada tanggal tsb
public class DateAndQuantity {
	private Date titleDate;
	private int quantity;

	public void setTitleDate(Date titleDate) {
		this.titleDate = titleDate;
	}

	public Date getTitleDate() {
		return titleDate;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}
}