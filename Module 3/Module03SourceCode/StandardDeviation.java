import java.util.*;

public class StandardDeviation {

	public static void main(String[] args) {
		int[] numbers1 = {1, 1, 1, 1, 1, 1};
		System.out.println("Standard deviation is " + standardDeviation(numbers1));
		
		int[] numbers2 = {0, 1, 2, 3, 4, 5, 6};
		System.out.println("Standard deviation is " + standardDeviation(numbers2));

		System.out.println("How many numbers do you want to use?");
		Scanner scan = new Scanner(System.in);
		int numValues = Integer.parseInt(scan.nextLine());
		System.out.println("Do you want to give the size of the random number range? yes/no");	
		String userChoice = scan.nextLine();
		
		int sizeRange;
		if(userChoice.equalsIgnoreCase("yes")) {
			System.out.println("What size range?");
			sizeRange = Integer.parseInt(scan.nextLine());
		} else {
			sizeRange = 1000;
		}
		int[] userRandomNumbers = createRandomArray(numValues, sizeRange);
		System.out.println("Standard deviation of that many random values is " + standardDeviation(userRandomNumbers));
		

	}
	
	private static int[] createRandomArray(int size, int sizeRange) {
		int[] numbers = new int[size];
		Random generator = new Random();
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = generator.nextInt(sizeRange);
		}
		return numbers;
	}
	
	public static double standardDeviation(int[] numbers) {
		double average = average(numbers);
		double sum = 0;
		for(int number : numbers) {
			double absoluteValueDifference = Math.abs(number - average);
			double differenceSquared = Math.pow(absoluteValueDifference, 2); // squares the difference
			sum += differenceSquared;
		}
		double fraction = sum / numbers.length;
		return Math.sqrt(fraction);
		
	}
	public static double average(int[] numbers) {
		int total = 0;
		for(int number: numbers) {
			total += number;
		}
		return total / (numbers.length * 1.0);
	}

}
