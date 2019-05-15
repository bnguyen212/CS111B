
public abstract class PaidEmployee extends Employee {

	public PaidEmployee(String name, String id, String phone, Status status) {
		super(name, id, phone, status);
	}
	
	// all paid employees get benefits- so the method goes in the parent class
	// all child classes will implement the same way, so we implement it once-
	// in the parent
	public void benefits() {
		if(getStatus().getBenefits()) {
			System.out.println("Processing benefits for " + getName());
		} else { 
			System.out.println("This employee does not receive benefits.");
		}
	}
	
	@Override
	public void review() {
		System.out.println("Conducting review of " + getName());
	}
	
	// all paid employees will be paid- so the method goes in the parent class
	// because the child classes implement this method differently, we make it abstract
	public abstract void pay();
}
