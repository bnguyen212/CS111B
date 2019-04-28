import java.util.ArrayList;
import java.time.*;

public class Donor {

	private String name, phone;
	private ArrayList<Donation> donationList;
	
	public Donor(String name, String phone) {
		this.name = name;
		this.phone = phone;
		donationList = new ArrayList<Donation>();
	}
	
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public ArrayList<Donation> getDonationList() {
		return donationList;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String toString() {
		return name + " ("  + phone + ") ";
	}
	
	
	public boolean makeDonation(double amount) {
		return makeDonation(amount, LocalDate.now());
	}
	public boolean makeDonation(double amount, LocalDate date) {
		Donation donation = new Donation(amount, date);
		return donationList.add(donation);
	}
	public boolean makeDonation(Donation donation) {
		return donationList.add(donation);
	}
	
	public double getTotalDonations() {
		double totalDonations = 0;
		for(Donation d : donationList) {
			double dAmount = d.getAmount();
			totalDonations += dAmount;
		}
		return totalDonations;
	}
	
	
	
	
	
}
