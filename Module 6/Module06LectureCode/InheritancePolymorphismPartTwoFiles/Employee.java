
public abstract class Employee implements Comparable<Employee> {

	private String name, id, phone;
	private Status status;
	
	public static final String COMPANY_PHONE = "555-5555";
	public static final Status DEFAULT_STATUS = Status.FULL_TIME;
	
	static enum Status {
		FULL_TIME(true, "Full"), PART_TIME(true, "Part"), INACTIVE(false, "Inactive");
		
		private boolean benefits;
		private String outputText;
		
		private Status(boolean benefits, String outputText) {
			this.benefits = benefits;
			this.outputText = outputText;
		}
		
		public boolean getBenefits() {
			return this.benefits;
		}
		
		public String toString() {
			return outputText;
		}
	};
	
	public Employee(String name, String id, String phone, Status status) {
		this.name = name;
		this.id = id;
		this.phone = phone;
		this.status = status;
	}
	
	public Employee(String name, String id, Status status) {
		this(name, id, COMPANY_PHONE, status);
	}
	public Employee(String name, String id) {
		this(name, id, COMPANY_PHONE, DEFAULT_STATUS);
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
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		String s = name + " (" + id + ")";
		return s;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee otherEmployee = (Employee) obj;
			//return this.id.equals(otherEmployee.id);
			//return this.id.equalsIgnoreCase(otherEmployee.id);
			return this.name.equalsIgnoreCase(otherEmployee.name) &&
					this.id.equalsIgnoreCase(otherEmployee.id) &&
					this.phone.equalsIgnoreCase(otherEmployee.phone) &&
					this.status.equals(otherEmployee.status);
			
			
		} else {
			return false;
		}
		
	}
	
	
	
	// belongs in the parent class because all child classes 
	// will have this functionality
	// this method is abstract because the child classes
	// will have different implementations
	public abstract void review();
	
	
	@Override
	public int compareTo(Employee otherEmployee) {
		if(name.equalsIgnoreCase(otherEmployee.name)) {
			// if the names are the same, order by ID
			return id.compareToIgnoreCase(otherEmployee.id);
		} else {
			// if the names are different, order by name
			return name.compareToIgnoreCase(otherEmployee.name);
		}
	}
	
	
	/*
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Employee) {
			Employee otherEmp = (Employee) obj;
			return id.compareTo(otherEmp.id);
		} else {
			throw new ClassCastException();
		}
	}
	*/
	
	
}

