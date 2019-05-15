
public class Customer {
	private String name, id;
	private Address address;
	
	public Customer(String name, String id, Address address) {
		this.name = name;
		this.id = id;
		this.address = address;
	}
	
	public void inviteSale() {
		System.out.println("Inviting " + name + " to a sale in " + address.getCity());
	}
	
	public void birthdayReward() {
		System.out.println("Sending a coupon for 5% off to " + name + " for their birthday.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		String s = name + "\n" +
				"ID: " + id + "\n" +
				address.toString();
		return s;
				
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Customer) {
			Customer otherCustomer = (Customer) obj;
			return id.equals(otherCustomer.id);
		} else {
			return false;
		}
	}

	

}
