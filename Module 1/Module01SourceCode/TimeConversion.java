import java.util.Scanner;

public class TimeConversion {

	private final static int NUMBER_OF_SECONDS_IN_A_MINUTE = 60;
	private final static int NUMBER_OF_SECONDS_IN_AN_HOUR = 3600;
	
	public static void main(String[] args) {

		System.out.println("Welcome to the Time Converter!");
		Scanner scan = new Scanner(System.in);
		int hours, minutes, seconds, totalSeconds;

		System.out.println("Enter the number of hours:");
		hours = scan.nextInt();
		
		System.out.println("Enter the number of minutes:");
		minutes = scan.nextInt();
		
		System.out.println("Enter the number of seconds:");
		seconds = scan.nextInt();
		
		totalSeconds = seconds;
		totalSeconds += (minutes * NUMBER_OF_SECONDS_IN_A_MINUTE);
		totalSeconds += (hours * NUMBER_OF_SECONDS_IN_AN_HOUR);
		
		System.out.println("That is " + totalSeconds + " seconds.");
		
	}

}
