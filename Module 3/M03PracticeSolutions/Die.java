import java.util.Random;

public class Die {

	private int faceValue; // declaration statement
	private int numberRolls;
	// public static final int DEFAULT_FACE_VALUE = 1; // all die objects start with a 1 facing up
	public static final int MINIMUM_FACE_VALUE = 1, MAXIMUM_FACE_VALUE = 6;
		
	public Die(int initialFaceValue) {
		faceValue = initialFaceValue;
		numberRolls = 0;
	}
		
	public Die() {
		numberRolls = 0;
		roll();
	}
	
	public int getFaceValue() {
		return faceValue;
	}
	
	public void setFaceValue(int newFaceValue) {
		if(newFaceValue >= MINIMUM_FACE_VALUE && newFaceValue <= MAXIMUM_FACE_VALUE) {
			faceValue = newFaceValue;
		} else {
			System.out.println("Error: invalid face value. Object not modified.");
		}
	}
	
	public int getNumberRolls() {
		return numberRolls;
	}
	
	// not including a setter for number of rolls- that value is only changed by the roll method
	
	
	public String toString() {
		return "Die Value: " + faceValue + " (rolled " + numberRolls + " times)";
	}
	
	public int roll() {
		numberRolls++;
		Random generator = new Random();
		faceValue = generator.nextInt(MAXIMUM_FACE_VALUE - MINIMUM_FACE_VALUE + 1) + MINIMUM_FACE_VALUE;
		return faceValue;		
	}
	
	public int countMatches(int targetValue, int timesToRoll) {
		int matches = 0;
		for(int i=0; i<timesToRoll; i++) {
			int currentRoll = roll();
			if(currentRoll == targetValue) {
				matches++;
			}
		}
		return matches;
	}
	
	
	
	
	
	
	
}
