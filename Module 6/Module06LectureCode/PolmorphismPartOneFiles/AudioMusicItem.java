
public class AudioMusicItem extends AudioItem {

	private String artist, genre;

	public AudioMusicItem(String title, double price, int numSeconds, String artist, String genre) {
		super(title, price, numSeconds);
		this.artist = artist;
		this.genre = genre;
	}
	public AudioMusicItem(String title, int numSeconds, String artist, String genre) {
		super(title, numSeconds);
		this.artist = artist;
		this.genre = genre;
//		this(title, AudioItem.DEFAULT_PRICE, numSeconds, artist, genre);
	}
	
	public String getArtist() {
		return artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	@Override
	public void playSample() {
		System.out.println("Sampling " + getTitle() + "(30 seconds out of " + getNumSeconds() +")");
	}
	
	@Override
	public String toString() {
		String parentString = super.toString();
		parentString += "\n\tArtist: " + artist + 
				"\n\tGenre: " + genre;
		return parentString;
				
	}
	
	
	
}
