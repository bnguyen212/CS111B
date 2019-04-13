
public class Car {

	private String make, model;
	private int year;
	
	private static final int EARLIEST_CAR_YEAR = 1886;

	public Car(String initialMake, String initialModel, int initialYear) {
		make = initialMake;
		model = initialModel;
		year = initialYear;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String newMake) {
		make = newMake;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String newModel) {
		model = newModel;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int newYear) {
		if(newYear >= EARLIEST_CAR_YEAR) {
			year = newYear;
		}
	}
	public String toString() {
		return year + " " + make + " " + model;
	}
	public void drive() {
		System.out.println("Vroom vroom!");
	}
	
}
