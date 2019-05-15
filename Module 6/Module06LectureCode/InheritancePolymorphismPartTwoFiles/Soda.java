public class Soda extends Beverage {
	
	private static final boolean RESTRICTED_STATUS = false;
	public static final double SODA_TAX = 0.50;
	
	public Soda(String name, String brand, double price, 
			ContainerType containerType) {
		super(name, brand, price, RESTRICTED_STATUS, containerType);
	}
	
	@Override
	public double taxedPrice() {
		return super.taxedPrice() + SODA_TAX;
	}

}
