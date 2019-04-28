
public class RetailItem {
	 
	 private String description;
	 private int units;
	 private double price; // note that because of precision, double should not actually be used to represent money; for now, we'll use it
	 private PriceRange priceRange;
	 
	 public static double DEFAULT_PRICE = 1;
	 
	 public static enum PriceRange {
		 LOW(0,10), MEDIUM (10, 100), HIGH(100);
		 
		 private double minInclusive, maxExclusive;
		 private PriceRange(double min, double max) {
			 this.minInclusive = min;
			 this.maxExclusive = max;
		 }
		 private PriceRange(double min) {
			 this(min, Double.MAX_VALUE);
		 }
		 public boolean priceInRange(double price) {
			 return minInclusive <= price && price < maxExclusive;
		 }
		 public static PriceRange getRange(double price) {
			 PriceRange[] priceRanges = PriceRange.values();
			 for(PriceRange priceRange : priceRanges) {
				 if(priceRange.priceInRange(price)) {
					 return priceRange;
				 }
			 }
			 return null;
		 }
	 }
	 
 
	 public RetailItem(String description, int units) {
		 this(description, units, DEFAULT_PRICE);
	 }
	 public RetailItem(String description, int units, double price) {
		 this.description = description;
		 this.units = units;
		 this.price = price;
		 this.priceRange = PriceRange.getRange(price);
	 }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		if(units >= 0) {
			this.units = units;
		}
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if(price >= 0) {
			this.price = price;
			this.priceRange = PriceRange.getRange(price);
		}
	}
	
	public PriceRange getPriceRange() {
		return this.priceRange;
	}
	
	// omitting setter for priceRange- this can only be updated when the price is updated
	
	public String toString() {
		return description + " (" + units + " units; $" + price + " each)";
	}
	
	public void useageTest() {
		System.out.println("Testing the item to ensure it is in working condition.");
	}

	public boolean sell(int numberSold) {
		if(units >= numberSold) {
			units -= numberSold;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean samePrice(RetailItem item1, RetailItem item2) {
		return Math.abs(item1.price - item2.price) < 0.0001;
		// note that because of precision, doubles should not be compared directly!
		// instead, take the difference and compare the absolute value to some small threshold
	}

}
