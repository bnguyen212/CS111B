
public class Company {

	public static void main(String[] args) {
		
		Employee.Status s1 = Employee.Status.FULL_TIME;
		
		Employee e1 = new Employee("Wally Worker", "W157", "555-555-5555", s1);
		Employee e2 = new Employee("Sam Slacker", "A872", "555-555-5555", Employee.Status.INACTIVE);
		/*
		e1.pay();
		System.out.println(e2);
		
		e2.setPhone("555-CALLSAM");
		System.out.println(e2);
		System.out.println(e2.getPhone());
		e2.review();
		*/
		e1.benefits();
		e2.benefits();
		
		System.out.println(Employee.Status.FULL_TIME);

	}

}
