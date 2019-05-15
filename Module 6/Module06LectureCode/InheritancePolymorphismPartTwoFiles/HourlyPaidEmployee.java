public class HourlyPaidEmployee extends PaidEmployee {
	private double hourlyRate;
	
	public static final double DEFAULT_HOURLY_RATE = 9.00;
	
	public HourlyPaidEmployee(String name, String id, String phone, Status status, double hourlyRate) {
		super(name, id, phone, status);
		this.hourlyRate = hourlyRate;
	}
	public HourlyPaidEmployee(String name, String id, double hourlyRate) {
		this(name, id, Employee.COMPANY_PHONE, Employee.DEFAULT_STATUS, hourlyRate);
	}
	public HourlyPaidEmployee(String name, String id) {
		this(name, id, Employee.COMPANY_PHONE, Employee.DEFAULT_STATUS, DEFAULT_HOURLY_RATE);
	}
	public double getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(double hourlyRate) {
		if(hourlyRate > 0) {
			this.hourlyRate = hourlyRate;
		}
	}
	@Override
	public String toString() {
		String s = super.toString();
		s += "\n\tRate: " + hourlyRate;
		return s;
	}
	
	
	@Override
	public void pay() {
		System.out.println("Paying hourly at rate of " + hourlyRate + " per hour.");
	}

	public void personalTime() {
		System.out.println("Processing personal time for " + getName());
	}
	
}
