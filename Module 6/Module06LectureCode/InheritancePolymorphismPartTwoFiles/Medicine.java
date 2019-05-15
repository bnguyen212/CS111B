
public class Medicine extends PersonalItem implements Expirable {

	public Medicine(String name, String brand, double price, boolean restricted) {
		super(name, brand, price, restricted);
	}
	
	@Override
	public void checkExpirationStatus() {
		System.out.println("Check status of " + getName());
	}
	
	@Override
	public void orderItem() {
		System.out.println("Order from pharmacy: "+ getBrand() + " " + getName());
	}

	
}
