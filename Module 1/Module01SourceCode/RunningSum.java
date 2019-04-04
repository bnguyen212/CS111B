import java.util.Scanner;


public class RunningSum {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the Running Sum Program!");
	
		// second version- sum up a pre-specified number of numbers
		int sum = 0;
		System.out.println("How many numbers do you want to sum?");
		int numberOfNumbers = scan.nextInt();
		
		for(int i=0; i<numberOfNumbers; i++) {
			System.out.println("Enter a number:");
			int userNumber = scan.nextInt();
			sum += userNumber;
		}
		System.out.println("The sum is " + sum);
		
		
		/* first version- sum up numbers until the user enters 0
		System.out.println("Enter numbers between 1 and 100 (inclusive) to be summed. Enter \"0\" to quit.");
		
		
		boolean keepReadingInNumbers = true;
		int sum = 0;

		do {
			System.out.println("Enter a number:");
			int userNumber = scan.nextInt();
			
			if(userNumber==0) {
				keepReadingInNumbers = false;
			} else if(userNumber >= 1 && userNumber <= 100){
				sum += userNumber;
			} else {
				System.out.println("That is an invalid number.");
			}
		} while(keepReadingInNumbers);
		
		System.out.println("The sum is " + sum);
		
		*/
	}

}
