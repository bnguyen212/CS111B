public class Sweatshirt extends Shirt {
	
	private boolean hooded;
	
	private final static boolean DEFAULT_HOODED = true;
	
	public Sweatshirt(Shirt.Size size, String color, double price, boolean hooded) {
		super(size, color, price);
		this.hooded = hooded;
	}
	public Sweatshirt(Shirt.Size size, String color, double price) {
		this(size, color, price, DEFAULT_HOODED);
	}

	public boolean isHooded() {
		return hooded;
	}
	public void setHooded(boolean hooded) {
		this.hooded = hooded;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\tHooded? " + (hooded ? "Yes" : "No");
		
	}
}

