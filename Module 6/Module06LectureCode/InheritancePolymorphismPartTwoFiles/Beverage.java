
public class Beverage extends StoreItem implements Taxable {

	public enum ContainerType { PLASTIC, GLASS, CARDBOARD, ALUMINUM };
	
	private ContainerType containerType;
	
	public Beverage(String name, String brand, double price, boolean restricted,
			ContainerType containerType) {
		super(name, brand, price, restricted);
		this.containerType = containerType;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nBeverage Item, container: " + containerType;
	}
	
	@Override
	public double taxedPrice() {
		return getPrice() + (getPrice() * TAX_RATE);
	}
	
	public ContainerType getContainerType() {
		return containerType;
	}
	
	public void setContainerType(ContainerType containerType) {
		this.containerType = containerType;
	}
	
	@Override
	public void orderItem() {
		System.out.println("Order from beverage distributer: "+ getBrand() + " " + getName());
	}
	
}
