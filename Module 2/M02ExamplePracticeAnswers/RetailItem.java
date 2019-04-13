
public class RetailItem {
	 
	 private String description;
	 private int units;
	 private double price; // note that because of precision, double should not actually be used to represent money; for now, we'll use it
	 
	 public RetailItem(String initialDescription, int initialUnits, double initialPrice) {
		 description = initialDescription;
		 units = initialUnits;
		 price = initialPrice;
	 }

	public String getDescription() {
		return description;
	}

	public void setDescription(String newDescription) {
		description = newDescription;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int newUnits) {
		if(newUnits >= 0) {
			units = newUnits;
		}
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double newPrice) {
		if(newPrice >= 0) {
			price = newPrice;
		}
	}
	public String toString() {
		return description + " (" + units + " units; $" + price + " each)";
	}
	public boolean sell(int numberSold) {
		if(units >= numberSold) {
			units -= numberSold;
			return true;
		} else {
			return false;
		}
	}
	public void soundTest() {
		System.out.println("Listen to that clear sound!");
	}

}
