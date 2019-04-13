
public class PracticeDriver {

	public static void main(String[] args) {
		Dog dog = new Dog("Spot", 3, false);
		System.out.println(dog);
		dog.setAge(-3);
		System.out.println(dog);
		dog.hadABirthday();
		dog.vaccinate();
		System.out.println(dog);
		dog.bark();

		System.out.println("");
		Computer comp = new Computer("Lenovo", "ThinkPad", 1536000);
		System.out.println(comp);
		System.out.println("Can store a 2TB file? " + comp.canStoreFile(2000000));
		
		System.out.println("");
		RetailItem mp3Player = new RetailItem("Portable MP3 Player", 100, 19.99);
		System.out.println(mp3Player);
		System.out.println("Sell 200 units. Successful? " + mp3Player.sell(200));
		System.out.println("Sell 75 units. Successful? " + mp3Player.sell(75));
		System.out.println(mp3Player);
		mp3Player.soundTest();
		
		System.out.println("");
		Car car = new Car("Toyota", "Rav4", 2014);
		System.out.println(car);
		car.setYear(1000);
		System.out.println(car);
		car.drive();
	}

}
