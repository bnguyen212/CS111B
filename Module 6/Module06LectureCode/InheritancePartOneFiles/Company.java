
public class Company {

	public static void main(String[] args) {
		
		Employee.Status s = Employee.Status.FULL_TIME;
		
		Employee e1 = new Employee("Wally Worker", "W157", "555-555-5555", s);
		Employee e2 = new Employee("Sam Slacker", "A872", "555-555-5555", Employee.Status.INACTIVE);
		
		SalariedPaidEmployee s1 = new SalariedPaidEmployee("Mark Monies", "M513", 50000);
		HourlyPaidEmployee h1 = new HourlyPaidEmployee("Hank Hourly", "H158", 10);
		HourlyPaidEmployee h2 = new HourlyPaidEmployee("Minnie Minimum", "M531", 10);
		UnpaidEmployee u1 = new UnpaidEmployee("Irvie Intern", "I009");
		
	}

}
