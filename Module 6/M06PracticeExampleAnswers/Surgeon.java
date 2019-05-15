
public class Surgeon extends Doctor {
//rite a child class called Surgeon, described by a name and specialty
	private String specialty;
	
	public Surgeon(String name, String specialty) {
		super(name);
		this.specialty = specialty;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\tSurgical Specialty: " + specialty;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Surgeon) {
			Surgeon otherSurgeon = (Surgeon) obj;
			return super.equals(otherSurgeon) && this.specialty.equalsIgnoreCase(otherSurgeon.specialty);
			// access the parent version of equals!
		} else {
			return false;
		}
	}
}
