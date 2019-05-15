public class Shirt implements Comparable<Shirt> {
	private Size size;
	private String color;
	private double price;
	
	

	enum Size { SMALL, MEDIUM, LARGE }

	public Shirt(Size size, String color, double price) {
		this.size = size;
		this.color = color;
		this.price = price;
	}

	public Size getSize() {
		return size;
	}

	public String getColor() {
		return color;
	}

	public double getPrice() {
		return price;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setPrice(double price) {
		if (price > 0) {
			this.price = price;
		}
	}

	@Override
	public String toString() {
		return "Size = " + size + "\t" + "Color = " + color + "\t" + "Price = " + price;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Shirt) {
			Shirt otherShirt = (Shirt) obj;
			return this.size.equals(otherShirt.size) && // because this is enum, could also write this.size==otherShirt.size
					this.color.equalsIgnoreCase(otherShirt.color) &&
					Math.abs(this.price - otherShirt.price) < 0.0001; // avoid comparing doubles with == because of precision
		} else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Shirt otherShirt) {
		if(Math.abs(this.price - otherShirt.price) < 0.0001) { // prices are equal
			return color.compareToIgnoreCase(otherShirt.color);
		} else if(this.price > otherShirt.price) {
			return 10; // any positive number
		} else { // this.price < otherShirt.price
			return -10; // any negative number
		}
	}
	/*
	@Override
	public int compareTo(Shirt otherShirt) {
		if(this.size.compareTo(otherShirt.size)==0) {
			return color.compareToIgnoreCase(otherShirt.color);
		} else  {
			return this.size.ordinal()-otherShirt.size.ordinal(); 
		}
	}
	*/
	
	
	
}
