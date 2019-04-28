
public class PairOfDiceTester {

	public static void main(String[] args) {
		PairOfDice pair1 = new PairOfDice();
		
		pair1.roll();
		System.out.println(pair1);
		
		int doubleCount = 0;
		for(int i=0; i<100; i++) {
			pair1.roll();
			if(pair1.isDoubles()) {
				doubleCount++;
			}
		}
		System.out.println("I rolled " + doubleCount + " doubles.");

	}

}
