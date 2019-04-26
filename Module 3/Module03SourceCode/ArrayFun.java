import java.util.Arrays;
import java.util.Random;


public class ArrayFun {

	public static void main(String[] args) {
		
		int[] numbers = new int[100];
		
		// fills an array with random numbers between 0 and 499 (inclusive)
		Random generator = new Random();
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = generator.nextInt(500);
		}
		
		System.out.println(Arrays.toString(numbers));
		
		int maxVal = findMaxValue(numbers);
		System.out.println("The largest number in the array is " + maxVal);
		
	//	displayBackwards(numbers);
		
		printGreaterThan(numbers, 400);
				
	}
	
	public static void printGreaterThan(int[] values, int testValue) {
		for(int n : values) {
			if(n > testValue) {
				System.out.println(n);
			}
		}
		/* for(int i=0; i<values.length; i++) {
		 * 	if(values[i] > testValue) {
		 * 		System.out.println(values[i]);
		 * }
		 * }
		 */
	}
	
	public static void displayBackwards(int[] values) {
		for(int i=values.length-1; i>=0; i--) {
			System.out.println(values[i]);
		}
	}
		
	public static int findMaxValue(int[] values) {
		
		int maxValue = values[0];
		
		for(int i=0; i<values.length; i++) {
			if(values[i] > maxValue) {
				maxValue = values[i];
			}
		}		
		return maxValue;
		
	}
	
	
}
