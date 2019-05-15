
public class PreferredCustomer extends Customer {
	
	private int years; // years they have been a customer
	
	public PreferredCustomer(String name, String id, Address address, int years) {
		super(name, id, address);
		this.years = years;
	}
	
	@Override
	public void inviteSale() {
		super.inviteSale();
		System.out.println("Hey- you can come 2 days early!");
	}
	
	@Override 
	public void birthdayReward() {
		if(years < 10) {
			System.out.println("Sending a coupon for 10% off to " + getName() + " for their birthday.");
		} else {
			System.out.println("Sending a coupon for 15% off to " + getName() + " for their birthday.");
		}
	}
	
	public int getYears() {
		return years;
	}
	
	public void setYears(int years) {
		if(years >= 5) {
			this.years = years;
		} else {
			System.out.println("Invalid value for a Preferred Customer.");
		}
	}
	
	@Override
	public String toString() {
		String s = super.toString();
		s += "\nPreferred Customer for " + years + " years";
		return s;
	}

}
