
public class DieTester {

	public static void main(String[] args) {
		Die die2;
		Die die1 = new Die(6);

		Die die3 = new Die(); // initial value of faceValue is 1
		
		/*
		System.out.println("The default value of a die is " + Die.DEFAULT_FACE_VALUE);
		
		System.out.println(die3.getFaceValue());
		System.out.println(die1.getFaceValue());
		die1.setFaceValue(2);
		System.out.println(die1.getFaceValue());
		die1.setFaceValue(-1);
		System.out.println(die1.getFaceValue());
		
		System.out.println(die1.toString());
		System.out.println(die1);
		System.out.println(die3);
		
		die1.toString(); // MISTAKE!
		
		String dieString = die1.toString();
		String upperDieString = (die1.toString()).toUpperCase();
		System.out.println(upperDieString);
		String twoDiceString = die1 + " and " + die3;
		System.out.println(twoDiceString);
	
		die1.roll();
		*/
		Die die4 = new Die();
		System.out.println(die4);
		die4.roll();
		System.out.println(die4);
		int mostRecentRoll = die4.roll();
		System.out.println(die4);
		System.out.println("Most recent roll was: " + mostRecentRoll);
		for(int i=0; i<10; i++) {
			die4.roll();
		}
		int currentValue = die4.getFaceValue();
		System.out.println("Current value is " + currentValue);
		System.out.println(die4);
		
		Die die5 = new Die();
		System.out.println(die5);
		int times = die5.getNumberRolls();
		
		Die die6 = new Die();
		System.out.println(die6);
		int matches = die6.countMatches(6, 60);
		System.out.println("You got " + matches + " matches.");
		System.out.println(die6);
		
		
	}

}
