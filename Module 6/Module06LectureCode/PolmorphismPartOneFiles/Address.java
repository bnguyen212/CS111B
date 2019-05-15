
public class Address {
	
	private String street, city, state, zip;
	
	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZip() {
		return zip;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@Override
	public String toString() {
		return street + "\n" + city + ", " + state + " " + zip;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Address) {
			Address otherAddress = (Address) obj;
			return street.equalsIgnoreCase(otherAddress.street) &&
					city.equalsIgnoreCase(otherAddress.city) &&
					state.equalsIgnoreCase(otherAddress.state) &&
					zip.equalsIgnoreCase(otherAddress.zip);
		} else {
			return false;
		}
	}

}
