import java.util.Scanner;

public class TimeConversionReverse {

	private final static int NUMBER_OF_SECONDS_IN_A_MINUTE = 60;
	private final static int NUMBER_OF_SECONDS_IN_AN_HOUR = 3600;

	public static void main(String[] args) {
		System.out.println("Welcome to the Reverse Time Converter!");
		Scanner scan = new Scanner(System.in);
		
		int seconds, minutes, hours, totalSeconds;
		
		System.out.println("Enter the total number of seconds:");
		totalSeconds = scan.nextInt();
		
		hours = totalSeconds / NUMBER_OF_SECONDS_IN_AN_HOUR;
		totalSeconds = totalSeconds % NUMBER_OF_SECONDS_IN_AN_HOUR;
		// could also say: totalSeconds %= NUMBER_OF_SECONDS_IN_AN_HOUR
		
		minutes = totalSeconds / NUMBER_OF_SECONDS_IN_A_MINUTE;
		totalSeconds = totalSeconds % NUMBER_OF_SECONDS_IN_A_MINUTE;
		
		seconds = totalSeconds;
		
		System.out.println("That is " + hours + " hours, " + minutes + " minutes, and " + seconds + " seconds.");
		
	}

}
