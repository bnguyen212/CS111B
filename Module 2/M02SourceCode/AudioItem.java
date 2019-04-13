
public class AudioItem {

	private String title;
	private double price;
	private int numSeconds;
	
	public AudioItem(String theTitle, double thePrice, int theNumSeconds) {
		title = theTitle;
		price = thePrice;
		numSeconds = theNumSeconds;
	}
	
	public String getTitle() {
		return title;
	}
	public double getPrice() {
		return price;
	}
	public int getNumSeconds() {
		return numSeconds;
	}
	
	public void setTitle(String theNewTitle) {
		title = theNewTitle;
	}
	public void setPrice(double theNewPrice) {
		if(theNewPrice >= 0) {
			price = theNewPrice;
		}
	}
	
	public void setNumSeconds(int theNewNumSeconds) {
		if(theNewNumSeconds > 0) {
			numSeconds = theNewNumSeconds;
		}
	}
	
	public String toString() {
		String s ="Title: " + title 
				+ "\n\tPrice: " + price
				+ "\n\tDuration: " + numSeconds + " seconds";
		return s;
	}
	
	public void playSample() {
		System.out.println("Sampling " + title + " (5 seconds out of " + numSeconds + ")");
	}
	
	
	
}
