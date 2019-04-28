
public class Bird {

	private String name;
	private int age;
	
	private static int youngBirdCount = 0;
	private static int YOUNG_AGE_RANGE = 1;
	
	public Bird(String name, int age) {
		this.name = name;
		this.age = age;
		
		if(this.age <= YOUNG_AGE_RANGE) {
			Bird.youngBirdCount++;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	// omitting a direct setter for age- this should only change if a bird has a birthday
	
	public static int getNumberOfYoungBirds() {
		return Bird.youngBirdCount;
	}
	
	// omitting a direct setter for the count- this should only be updated when birds are created or have birthdays
	
	public String toString() {
		return name + " (" + age + " years old)";
	}

	public void birthday() {
		int oldAge = this.age;
		this.age++;
		if(oldAge <= YOUNG_AGE_RANGE && this.age > YOUNG_AGE_RANGE) {
			Bird.youngBirdCount--;
		}
	}
}

