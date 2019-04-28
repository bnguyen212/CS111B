import java.time.*;

public class Donation {

	private double amount;
	private LocalDate date;
	
	public static final double DEFAULT_DONATION_AMOUNT = 25;
	
	public Donation(double amount, LocalDate date) {
		this.amount = amount;
		this.date = date;
		// date = new LocalDate(2005, Month.MAY, 25);
	}
	
	public Donation(LocalDate date) {
		this(DEFAULT_DONATION_AMOUNT, date);
	}
	
	public Donation(double amount) {
		this(amount, LocalDate.now());
	}
	
	public Donation() {
		this(DEFAULT_DONATION_AMOUNT, LocalDate.now());
	}
	
	public double getAmount() {
		return amount;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setAmount(double amount) {
		if(amount >= 0) {
			this.amount = amount;
		}
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public String toString() {
		return "Amount: " + amount + " made on " + date;
	}
	
	
	
}
