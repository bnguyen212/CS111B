
public class Doctor {

	private String name;

	public Doctor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Doctor) {
			Doctor otherDoctor = (Doctor) obj;
			return this.name.equalsIgnoreCase(otherDoctor.name);
		} else {
			return false;
		}
	}
}
