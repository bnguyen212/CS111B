
public class UnpaidEmployee extends Employee {
	
	public UnpaidEmployee(String name, String id) {
		super(name, id);
	}	

	@Override
	public void review() {
		System.out.println("Completing review for college credit.");
	}
	
}
