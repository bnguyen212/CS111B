import java.util.*;

public class AudioItemTester {

	public static void main(String[] args) {

		System.out.println("Welcome to the Audio Store");
		Scanner scan = new Scanner(System.in);

		ArrayList<AudioItem> itemList = new ArrayList<AudioItem>();

		for (int i = 0; i < 3; i++) {

			System.out.println("Enter the title:");
			String title = scan.nextLine();

			System.out.println("Enter the price:");
			double price = Double.parseDouble(scan.nextLine());

			System.out.println("Enter the number of seconds:");
			int duration = Integer.parseInt(scan.nextLine());

			AudioItem item; // the declared type of item is "AudioItem"
			System.out.println("Enter M for music item, B for book item:");
			String userType = scan.nextLine();

			if (userType.equalsIgnoreCase("M")) {
				System.out.println("Enter the artist:");
				String artist = scan.nextLine();

				System.out.println("Enter the genre: ");
				String genre = scan.nextLine();

				item = new AudioMusicItem(title, price, duration, artist, genre); 
				// actual type of item is AudioMusicItem
				
			} else { // userType equals "B"
				System.out.println("Enter the author:");
				String author = scan.nextLine();

				System.out.println("Enter the number of chapters:");
				int numChapters = Integer.parseInt(scan.nextLine());

				item = new AudioBookItem(title, price, duration, author, numChapters); 
				// actual type of item is AudioBookItem
				
				
			}

			itemList.add(item);
		}
		// toString and playSample both exist in AudioItem, so the compiler is happy! 
		// System.out.println(item.toString());
		// item.playSample();

		// at run time, the JVM figures out the actual type and invokes
		// the playSample method from that class- the class of the *actual type*

		for (AudioItem item : itemList) {
			System.out.println(item);
			item.playSample();
			
			// print out the genres only if it's a music item
			if(item instanceof AudioMusicItem) {
				AudioMusicItem musicItem = (AudioMusicItem) item;
				System.out.println("The genre is " + musicItem.getGenre());
			}
			
			// print out the author only if it's a book item
			if(item instanceof AudioBookItem) {
				AudioBookItem bookItem = (AudioBookItem) item;
				System.out.println("The author is " + bookItem.getAuthor());
			}
		}

	}

}
