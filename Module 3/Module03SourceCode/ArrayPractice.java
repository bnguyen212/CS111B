import java.util.Arrays;
import java.util.Random;

public class ArrayPractice {

	public static void main(String[] args) {
		/* without an initializer list
		int[] primes; // declares the array
		primes = new int[4]; // initializes primes to hold 4 integers
		primes[0] = 2;
		primes[1] = 3;
		primes[2] = 5;
		primes[3] = 7;
		// primes[4] = 11; // code will compile! but run time crash!
		// primes[-1] = 13; // code will compile! but run time crash!
		 */
		/* with an initializer list */
		int[] primes = {2, 3, 5, 7};
		System.out.println("the primes array will hold " + primes.length + " numbers");
		System.out.println("the first prime number is " + primes[0]);
		System.out.println("the last prime number is " + primes[primes.length-1]);
		
		String[] names = new String[3];
		names[0] = "Jessica";
		names[1] = "Jennifer";
		names[2] = "Jeffrey";
		System.out.println("the first name is " + names[0] + " and the last is " + names[names.length-1]);
		
		// must be declared and initialized in the same statement!!
		String[] names2 = {"Jessica", "Jennifer", "Jeffrey"};
		for(String name : names2) {
			System.out.println(name.toUpperCase());
			name = name.toUpperCase();
		}
		System.out.println("after the for-each, to show that you can't update with for-each!");
		for(int i=0; i<names2.length; i++) {
			System.out.println(names2[i]);
		}
		
		
		char[] grades = new char[5];
		grades[0] = 'a';
		grades[1] = 'b';
		grades[2] = 'c';
		grades[3] = 'd';
		grades[4] = 'f';
		System.out.println("the highest grade is " + grades[0] + " and the lowest is " + grades[grades.length-1]);

		char[] grades2 = {'a', 'b', 'c', 'd', 'f'};
		
		int[] numbers = new int[100];
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = i+1;
		}
		
		int[] multiplesOfThree = new int[100];
		for(int i=0; i<multiplesOfThree.length; i++) {
			// I want 0 to hold 3, 1 to hold 6, 2 to hold 9, and so on
			int factor = i+1;
			multiplesOfThree[i] = factor * 3;
		}
		
		String[] oddStrings = new String[50];
		for(int i=0; i<oddStrings.length; i++) {
			// I want 0 to hold 1, 1 to hold 3, 2 to hold 5, 3 to hold 7
			int numberValue = (i*2) + 1;
			oddStrings[i] = Integer.toString(numberValue); // option 1
			//oddStrings[i] = numberValue + ""; // option 2
		}
		

		boolean[] truesFalses = new boolean[100];
		for(int i=0; i<truesFalses.length; i++) {
			Random generator = new Random();
			truesFalses[i] = generator.nextBoolean();
		}
		
		for(int i=0; i<truesFalses.length; i++) {
			//System.out.println(truesFalses[i]);
		}
		
		for(boolean bool : truesFalses) {
			//System.out.println(bool);
		}
		
		System.out.println(Arrays.toString(truesFalses));

	}

}
