
public class AudioItemTester {

	public static void main(String[] args) {
		AudioItem item1 = new AudioItem("Rainbow Connection", 0.99, 185);
		AudioItem item2 = new AudioItem("Java Early Objects", 59.99, 100565);
		
		System.out.println(item1);
		System.out.println(item2);
		
		AudioItem item3 = new AudioItem("Rainbow Connection", 0.99, 185);
		AudioItem item4 = item1;
		
		System.out.println("item1 and item3 equal? " + item1.equals(item3));
		System.out.println("item1 and item4 equal? " + item1.equals(item4));
		
		String s1 = "hello";
		String s2 = new String("hello");
		System.out.println("equal strings? " + s1.equals(s2));
		
		/*
		item1.playSample();
		item2.playSample();
		
		System.out.println(item2);

		System.out.println("There are " + AudioItem.getNumberOfAudioItems() + " items in the system.");
		
		AudioStoreAccount account1 = new AudioStoreAccount("Andy Audiofile", "AI457", 10);
		account1.addItem(item1);
		System.out.println(account1);
		account1.addItem(item2);
		System.out.println(account1);
		System.out.println(account1.getItemList());
		*/
	}

}
