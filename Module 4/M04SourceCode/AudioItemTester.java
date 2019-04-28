
public class AudioItemTester {

	public static void main(String[] args) {
		AudioItem item1 = new AudioItem("Rainbow Connection", 0.99, 185);
		AudioItem item2 = new AudioItem("Java Early Objects", 59.99, 100565);
		
		item1.playSample();
		item2.playSample();
		
		System.out.println(item2);

		System.out.println("So far, there have been " + AudioItem.getNumberOfAudioItems() + " items created.");
	
		AudioStoreAccount account1 = new AudioStoreAccount("Andy Audiofile", "AI457", 10);
		account1.addItem(item1);
		System.out.println(account1);
		account1.addItem(item2);
		System.out.println(account1);
		System.out.println(account1.getItemList());
		
		System.out.println("So far, there has been " + AudioStoreAccount.getTotalMoneySpent() + " money spent");
		
	}

}
