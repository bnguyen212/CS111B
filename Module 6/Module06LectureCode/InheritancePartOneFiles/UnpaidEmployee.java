
public class UnpaidEmployee extends Employee {
	
	public UnpaidEmployee(String name, String id) {
		super(name, id);
	}
	
	@Override
	public void pay() {
		System.out.println("This employee is not paid.");
	}
	
	@Override
	public void review() {
		System.out.println("Completing review for college credit.");
	}

	@Override
	public void benefits() {
		System.out.println("Unpaid employees do not receive benefits.");
	}
}
