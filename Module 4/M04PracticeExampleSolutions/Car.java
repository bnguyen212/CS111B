
public class Car {

	private String make, model;
	private int year;
	
	private static final int EARLIEST_CAR_YEAR = 1886;
	public static final int DEFAULT_YEAR = 2019;
	
	// even better: use the java.time package! feel free to check it out!
	// import java.time.Year;
	// private static final int DEFAULT_YEAR = Year.now().getValue();
	
	public Car(String make, String model) {
		this(make, model, DEFAULT_YEAR);
	}
	public Car(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		if(year >= EARLIEST_CAR_YEAR) {
			this.year = year;
		}
	}
	public String toString() {
		return year + " " + make + " " + model;
	}
	public void drive() {
		System.out.println("Vroom vroom!");
	}
	
	public static boolean sameMakeModel(Car car1, Car car2) {
		return car1.make.equalsIgnoreCase(car2.make) && 
				car1.model.equalsIgnoreCase(car2.model);
	}
	
}
