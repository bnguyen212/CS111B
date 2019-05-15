public abstract class Instrument {
	
	private String maker;
	private double price;

	public Instrument(String maker, double price) {
		this.maker = maker;
		this.price = price;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price > 0) {
			this.price = price;
		}
	}

	@Override
	public String toString() {
		return maker + "\t$" + price;
	}
	public abstract void tune();
}

