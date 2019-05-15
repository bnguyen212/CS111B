
public class SalariedPaidEmployee extends Employee {
	
	private int salary;
	
	public SalariedPaidEmployee(String name, String id, String phone, Status status, int salary) {
		super(name, id, phone, status);
		this.salary = salary;
	}
	public SalariedPaidEmployee(String name, String id, int salary) {
		this(name, id, Employee.COMPANY_PHONE, Employee.DEFAULT_STATUS, salary);
		//super(name, id); this.salary = salary;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		if(salary > 0) {
			this.salary = salary;
		}
	}

	@Override
	public String toString() {
		String s = super.toString();
		s += "\n\tSalary: " + salary;
		return s;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SalariedPaidEmployee) {
			SalariedPaidEmployee otherEmp = (SalariedPaidEmployee) obj;
			return super.equals(obj) && this.salary == otherEmp.salary;
		} else {
			return false;
		}
	}
	
	@Override
	public void pay() {
		System.out.println("Paying salary " + salary + "/52.");
	}
	
	public void vacation() {
		System.out.println("Processing vacation for "  + getName());
	}
	
	
	
	
}
