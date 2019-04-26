
public class Player {
	
	private String name;
	private int jerseyNumber;
	private double highScore;
	
	public Player(String initialName, int initialJerseyNumber, double initialHighScore) {
		name = initialName;
		jerseyNumber = initialJerseyNumber;
		highScore = initialHighScore;
	}
	
	public String getName() {
		return name;
	}
	public int getJerseyNumber() {
		return jerseyNumber;
	}
	public double getHighScore() {
		return highScore;
	}
	public void setName(String newName) {
		name = newName;
	}

	// no setter for jersey number
	
	public void setHighScore(double newHighScore) {
		if(newHighScore >= 0) {
			highScore = newHighScore;
		}
	}
	
	public String toString() {
		return name + " #" + jerseyNumber + " (High Score: " + highScore + ")";
	}
	
	
	
	

}
