public class Viola extends Instrument implements Breakable, Comparable<Viola> {
	
	public static double MINIMUM_SIZE = 10; // inches
	public static double MAXIMUM_SIZE = 20; // inches
	
	private double size;
	
	public Viola(String maker, double price, double size) {
		super(maker, price);
		this.size = size;
	}
	
	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		if(size >= MINIMUM_SIZE && size <= MAXIMUM_SIZE) {
			this.size = size;
		}
	}
	
	@Override
	public String toString() {
		return "Viola by " + super.toString() + "\tSize: " + size + " inches";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Viola) {
			Viola otherViola = (Viola) obj;
			return this.getMaker().equalsIgnoreCase(otherViola.getMaker()) &&
					Math.abs(this.getPrice()-otherViola.getPrice()) < 0.0001 &&
					Math.abs(this.size-otherViola.size) < 0.0001 ;
		} else {
			return false;
		}
	}
	
	@Override 
	public void tune() {
		System.out.println("Tuning the viola!");
	}
	
	@Override
	public void careInstructions() {
		System.out.println("Store in a case. Clean off the rosin. Avoid overusing rosin. Store at appropriate temperature.");
	}
	
	@Override
	public int compareTo(Viola otherViola) {
		if(this.getMaker().compareToIgnoreCase(otherViola.getMaker())==0) {
			if(Math.abs(this.size - otherViola.size) < 0.0001) {
				return 0;
			} else {
				return (int) Math.round(this.size - otherViola.size);
			}
		} else {
			return this.getMaker().compareToIgnoreCase(otherViola.getMaker());
		}
	}
}
