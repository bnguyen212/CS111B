import java.util.*;

public class AudioItemTester {

	public static void main(String[] args) {
		
		// the declared type of the items in the ArrayList is AudioItem
		ArrayList<AudioItem> itemList = new ArrayList<AudioItem>();
		itemList.add(new AudioMusicItem("Piano Man", 240, "Billy Joel", "Singalong"));
		itemList.add(new AudioBookItem("Harry Potter Complete Collection", 240.99, 417600, "J.K. Rowling", 198));
		itemList.add(new AudioMusicItem("Don't Stop Believing", 0.49, 185, "Journey", "Rock"));
		itemList.add(new AudioMusicItem("I Want to Hold Your Hand", 1.29, 158, "Beatles", "Classic"));
		itemList.add(new AudioBookItem("Watership Down", 20.99, 54000, "Richard Adams", 47));
		itemList.add(new AudioMusicItem("I Will Always Love You", 0.49, 173, "Dolly Parton", "Country"));
		itemList.add(new AudioMusicItem("I Will Always Love You", 173, "Whitney Houston", "Country"));
	
		// not allowed because AudioItem is abstract
		// AudioItem item1 = new AudioItem("title", 0, 0);
		
		Collections.sort(itemList);
		for(AudioItem item : itemList) {
			System.out.println(item.getTitle() + " Price: " + item.getPrice());
		}
		for(AudioItem item : itemList) {
			item.playSample();
		}
		
		// an interface can be the declared type
		// the actual type can be any class that implements that interface
		Streamable s = new AudioMusicItem("song title", 0, 0, "artist", "genre");
		
		ArrayList<Streamable> streamingList = new ArrayList<Streamable>();
		for(AudioItem item : itemList) {
			if(item instanceof Streamable) {
				Streamable streamable = (Streamable) item;
				streamingList.add(streamable);
			}
		}
		//System.out.println("Streaming Collection:\n" + streamingList);
		
	}

}
