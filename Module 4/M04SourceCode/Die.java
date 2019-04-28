import java.util.Random;

public class Die {
	
	private int faceValue;
	private Random generator;
	
	// public final static int DEFAULT_INITIAL_FACE_VALUE = 1;
	public final static int MIN_VALUE = 1;
	public final static int MAX_VALUE = 6;

	public Die(int facevalue) {
		this.faceValue = facevalue;
		generator = new Random();
	}
	
	public Die() {
		generator = new Random();
		roll();
	}
	

	public int getFaceValue() {
		return faceValue;
	}
	
	public void setFaceValue(int facevalue) {
		if(facevalue >= MIN_VALUE && facevalue <= MAX_VALUE) {
			this.faceValue = facevalue;
		} else {
			System.out.println("That is an invalid value.");
		}
	}
	
	public String toString() {
		return "Die Value: " + faceValue;
	}
	
	public int roll() {
		int newValue = generator.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
		faceValue = newValue;
		return faceValue;
	}
	public int roll(int numTimes) {
		for(int i=0; i<numTimes; i++) {
			roll();
		}
		return faceValue;
	}
	
	
	
	
	
	
	
	
	
	
}
