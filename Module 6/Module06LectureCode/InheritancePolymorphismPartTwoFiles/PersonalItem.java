
public class PersonalItem extends StoreItem implements Taxable {

	public PersonalItem(String name, String brand, double price, boolean restricted) {
		super(name, brand, price, restricted);
	}

	@Override
	public String toString() {
		return super.toString() + "\nPersonal Item";
	}
	
	@Override
	public double taxedPrice() {
		return getPrice() + (getPrice() * TAX_RATE);
	}
	
	@Override
	public void orderItem() {
		System.out.println("Order from cheapest distributor: "+ getBrand() + " " + getName());
	}

}
