
public class DieTester {

	public static void main(String[] args) {
		Die d1 = new Die(5);
		System.out.println(d1.getFaceValue());	
		
		int badValue = -1;
		d1.setFaceValue(badValue);
		System.out.println(d1.getFaceValue());
		System.out.println(d1);
		System.out.println(d1.roll());
		System.out.println(d1.roll());
		d1.roll();
		int roll1 = d1.roll();
		int roll2 = d1.roll();
		System.out.println("roll1 + roll2 is " + (roll1+roll2));
		
		for(int i=0; i < 10; i++) {
			d1.roll();
			System.out.println(d1);
		}
	}

}
