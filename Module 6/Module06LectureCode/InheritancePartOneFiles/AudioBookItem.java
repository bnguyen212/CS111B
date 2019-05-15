
public class AudioBookItem extends AudioItem {

	private String author;
	private int numChapters;
	
	public AudioBookItem(String title, double price, int numSeconds, String author, int numChapters) {
		super(title, price, numSeconds);
		this.author = author;
		this.numChapters = numChapters;
	}

	public String getAuthor() {
		return author;
	}
	public int getNumChapters() {
		return numChapters;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setNumChapters(int numChapters) {
		if(numChapters >=1) {
			this.numChapters = numChapters;
		}
	}

	@Override
	public void playSample() {
		System.out.println("Sampling " + getTitle() + "(1 chapter out of " + numChapters + ")");
	}
	
	@Override
	public String toString() {
		String s = super.toString();
		s += "\n\tAuthor: " + author +
				"\n\tNumber of Chapters: " + numChapters;
		return s;
	}
	
}
