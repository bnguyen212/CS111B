public class Beer extends Beverage {
	
private static final boolean RESTRICTED_STATUS = true;
	
	public Beer(String name, String brand, double price, 
			ContainerType containerType) {
		super(name, brand, price, RESTRICTED_STATUS, containerType);
	}

	
	@Override
	public void orderItem() {
		super.orderItem();
		System.out.println("Preference for local breweries");
	}
}
