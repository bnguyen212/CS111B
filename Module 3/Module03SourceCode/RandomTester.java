import java.util.*;

public class RandomTester {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Random generator = new Random();
	
		int size = 10000;	  // how many numbers to generate
		int lowerBound = 10;  // inclusive lower bound
		int higherBound = 20; // inclusive upper bound
		int shift = 3;		  // shift of the numbers from 0
		
		for(int i=0; i<size; i++) {
			int numberToAdd = generator.nextInt(higherBound - lowerBound + 1) + shift;  // can change + to other operations!
			numbers.add(numberToAdd);
		}
		
		printRandomNumberResults(numbers);
	}
	
	
	
	
	public static void printRandomNumberResults(ArrayList<Integer> list) {
		Collections.sort(list);
		//System.out.println(list);
		if(!list.isEmpty()) {
			int currentCompareNumber = list.get(0);
			int currentCount = 0;
			for(int i=0; i<list.size(); i++) {
				int number = list.get(i);
				if(number == currentCompareNumber) {
					currentCount++;
				} else {
					System.out.println(currentCompareNumber + ": \t" + currentCount + " times");
					currentCompareNumber = number;
					currentCount = 1;
				}
			}
			if(currentCount != 0) {
				System.out.println(currentCompareNumber + ": \t" + currentCount + " times");
			}
			
		}
	}

}
