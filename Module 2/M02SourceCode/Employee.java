
public class Employee {

	private String name, id, phone;
	
	public Employee(String theName, String theId, String thePhone) {
		name = theName;
		id = theId;
		phone = thePhone;
	}
	
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getPhone() {
		return phone;
	}
	
	public void setName(String theNewName) {
		name = theNewName;
	}

	public void setPhone(String theNewPhone) {
		phone = theNewPhone;
	}
	
	public String toString() {
		String s = name + " (" + id + ")";
		return s;
	}
	
	public void pay() {
		System.out.println("Paying employee " + name);
	}
	
	public void review() {
		System.out.println("Conducting a review of " + name);
	}
	
	public void benefits() {
		System.out.println("Processing benefits for " + name);
	}
	
}

