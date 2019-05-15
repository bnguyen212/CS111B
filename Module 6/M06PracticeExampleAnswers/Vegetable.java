public class Vegetable extends Food {
	
	private boolean isGreen;
	public static final boolean DEFAULT_IS_GREEN = true;
	
	public Vegetable(String name, boolean isGreen) {
		super(name);
		this.isGreen = isGreen;
	}
	public Vegetable(String name) {
		this(name, DEFAULT_IS_GREEN);
	}
	
	public boolean isGreen() {
		return isGreen;
	}
	public void setGreen(boolean isGreen) {
		this.isGreen = isGreen;
	}
	
	@Override
	public String toString() {
		return super.toString() + (isGreen ? " (Green" : " (" ) + " Vegetable)";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Vegetable) {
			Vegetable otherVegetable = (Vegetable) obj;
			return this.getName().equalsIgnoreCase(otherVegetable.getName()) &&
					// cannot invoke super.equals(obj) because equals is not written in Food
					// need to use getName() to access the name because name is private
					this.isGreen==otherVegetable.isGreen;
		} else {
			return false;
		}
	}
}
