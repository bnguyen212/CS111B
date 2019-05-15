
public class Company {

	public static void main(String[] args) {
	
	
		Employee e1 = new SalariedPaidEmployee("Mark Monies", "M513", 50000);
		Employee e2 = new HourlyPaidEmployee("Hank Hourly", "H158", 10);
		Employee e3 = new HourlyPaidEmployee("Minnie Minimum", "M531");
		Employee e4 = new UnpaidEmployee("Irvie Intern", "I009");
		
		
		// the version of the method that is invoked is based on the *actual type*
		e1.pay(); // invokes pay from SalariedPaidEmployee
		e4.pay(); // invokes pay from UnpaidEmployee
		
		// the compiler requires that the method exist in the *declared* type
		//e1.vacation(); // cannot do this- because Employee has no vacation method
	}

}
