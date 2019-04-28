
public class Dog {

	private String name;
	private int age;
	private boolean vaccinated;
	
	public Dog(String initialName, int initialAge, boolean initialVaccinated) {
		name = initialName;
		age = initialAge;
		vaccinated = initialVaccinated;
	}
	public String getName() {
		return name;
	}
	public void setName(String newName) {
		name = newName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int newAge) {
		if(newAge >= 0) {
			age = newAge;
		}
	}
	public boolean isVaccinated() {
		return vaccinated;
	}
	public void setVaccinated(boolean newVaccinated) {
		vaccinated = newVaccinated;
	}

	public String toString() {	
		return name + "\tAge: " + age + "\t" + (vaccinated ? "Vaccinated" : "Not Vaccinated");
	}
	public void vaccinate() {
		vaccinated = true;
	}
	public void bark() {
		System.out.println("\"Bark! Bark! Bark\" -" + name);
	}
	public void hadABirthday() {
		age++;
	}
}
