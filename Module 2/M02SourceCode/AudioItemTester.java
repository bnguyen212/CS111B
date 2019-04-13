
public class AudioItemTester {

	public static void main(String[] args) {
		AudioItem item1 = new AudioItem("Rainbow Connection", 0.99, 185);
		AudioItem item2 = new AudioItem("Java Early Objects", 59.99, 100565);
		
		item1.playSample();
		
		System.out.println(item2);

	}

}
