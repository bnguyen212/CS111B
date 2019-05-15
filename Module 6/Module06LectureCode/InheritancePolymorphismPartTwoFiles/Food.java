
public abstract class Food extends StoreItem {

	private int weight; // in grams
	
	private static final boolean RESTRICTED_STATUS = false;
	
	public Food(String name, String brand, double price, int weight) {
		super(name, brand, price, RESTRICTED_STATUS);
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if(weight > 0) {
			this.weight = weight;
		}
	}

	
	@Override
	public String toString() {
		return super.toString() + "\nFood Item, weight = " + weight + " grams";
	}
	
}
