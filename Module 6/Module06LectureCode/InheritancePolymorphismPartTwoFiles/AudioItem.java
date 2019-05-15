
public abstract class AudioItem implements Downloadable, Comparable<AudioItem> {

	private String title;
	private double price;
	private int numSeconds;
	
	public static final double DEFAULT_PRICE = 0.99;
	
	private static int numAudioItems = 0;
	
	public AudioItem(String title, double price, int numSeconds) {
		this.title = title;
		this.price = price;
		this.numSeconds = numSeconds;
		numAudioItems++;
	}
	
	public AudioItem(String title, int numSeconds) {
		this(title, DEFAULT_PRICE, numSeconds);
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
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPrice(double price) {
		if(price >= 0) {
			this.price = price;
		}
	}
	public void setNumSeconds(int numSeonds) {
		if(numSeonds > 0) {
			this.numSeconds = numSeonds;
		}
	}
	
	
	public static int getNumberOfAudioItems() {
		return numAudioItems;
	}
	
	@Override
	public String toString() {
		String s ="Title: " + title 
				+ "\n\tPrice: " + price
				+ "\n\tDuration: " + numSeconds + " seconds";
		return s;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof AudioItem) {
			AudioItem otherAudioItem = (AudioItem) obj;
			
			boolean sameTitle, samePrice, sameDuration;
			
			if(this.title.equalsIgnoreCase(otherAudioItem.title)) {
				sameTitle = true;
			} else {
				sameTitle = false;
			}
			if(this.numSeconds == otherAudioItem.numSeconds) {
				sameDuration = true;
			} else {
				sameDuration = false;
			}
			// sameDuration = numSeconds == otherAudioItem.numSeconds;
			
			if(Math.abs(this.price - otherAudioItem.price) < 0.0001) {
				samePrice = true;
			} else {
				samePrice = false;
			}
			
			return sameTitle && sameDuration && samePrice;
			
		} else {
			return false;
		}
	}	
	
	// the method goes in the parent class because all child classes will have this functionality/behavior
	// the method will be abstract because the child classes will implement the method differently
	public abstract void playSample();
	
	@Override
	public void download() {
		System.out.println("Downloading item " + title);
	}
	
	@Override
	public int compareTo(AudioItem otherItem) {
		if(title.equalsIgnoreCase(otherItem.title)) {
			if(price < otherItem.price) {
				return -1; // any negative number
			} else if (price > otherItem.price) {
				return 1; // any positive number
			} else {
				return 0;
			}
			
			//return Double.compare(price,  otherItem.price);
			
		} else {
			return title.compareToIgnoreCase(otherItem.title);
		}
	}
	
	
	
	
	
	
	

}
