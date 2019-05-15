
public class NonPerishableFood extends Food {

	public NonPerishableFood(String name, String brand, double price, int weight) {
		super(name, brand, price, weight);
	}
	
	@Override
	public void orderItem() {
		System.out.println("Order from cheapest supplier: "+ getBrand() + " " + getName());
	}
}
