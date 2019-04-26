import java.util.*;

public class BubbleSorter {

	public static void main(String[] args) {	
		int[] numbers = new int[100];
		Random generator = new Random();
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = generator.nextInt(100) + 1;
		}
		System.out.println(Arrays.toString(numbers));
		bubbleSort(numbers);
		System.out.println(Arrays.toString(numbers));
		
		int[] nearlySortedNumbers = {10, 1, 2, 3, 4, 5};
		bubbleSort(nearlySortedNumbers);
		System.out.println(Arrays.toString(nearlySortedNumbers));
	}
	
	public static void bubbleSort(int[] numbers) {
		boolean sorted = false;
		for(int i=0; i<numbers.length-1 && !sorted; i++) {
			System.out.println("in the outer loop");
			boolean madeASwap = false;
			for(int j=0; j<numbers.length-1-i; j++) {
				if(numbers[j] > numbers[j+1]) {
					madeASwap = true;
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
			if(!madeASwap) {
				sorted = true;
			}
		}
	}


}
