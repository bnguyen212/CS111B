import java.text.NumberFormat;

public class Beverage {

	public static enum BeverageType {
		
		MILK(0, "Milk"), SODA(0.05, "Soda"), BEER(0.1, "Beer");
		
		private double taxRate;
		private String displayString;

		private BeverageType(double taxRate, String displayString) {
			this.taxRate = taxRate;
			this.displayString = displayString;
		}

		public double getTaxRate() {
			return taxRate;
		}
		
		public String toString() {
			return displayString;
		}
	}
	
	private String name;
	private BeverageType type;
	private double cost;

	public Beverage(String name, BeverageType type, double cost) {
		this.name = name;
		this.type = type;
		this.cost = cost;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BeverageType getType() {
		return type;
	}

	public void setType(BeverageType type) {
		this.type = type;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		if(cost>=0) {
			this.cost = cost;
		}
	}

	public double calculateTotalCost() {
		return cost + (cost * type.getTaxRate());
	}
	
	public String toString() {
		return name + "\tType:" + type.toString() + "\tCost:" + NumberFormat.getCurrencyInstance().format(cost) +
				"\t(" + NumberFormat.getCurrencyInstance().format(calculateTotalCost()) + " with tax)";
	}

}
