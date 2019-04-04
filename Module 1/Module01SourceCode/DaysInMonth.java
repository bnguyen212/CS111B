import java.util.Scanner;

public class DaysInMonth {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the number of the month:");
		int monthNumber = scan.nextInt();
		/*
		if(monthNumber==1 || monthNumber==3 || monthNumber==5 || monthNumber==7
				|| monthNumber==8 || monthNumber==10 || monthNumber==12) {
			System.out.println("There are 31 days in that month.");
		} else if(monthNumber==4 || monthNumber==6 || monthNumber==9 || monthNumber==11) {
			System.out.println("There are 30 days in that month.");
		} else if(monthNumber==12) {
			System.out.println("There are either 28 or 29 days in that month.");
		} else { // monthNumber is not 1-12
			System.out.println("That is an invalid month number.");
		}
		*/
		
		switch(monthNumber) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println("There are 31 days in that month.");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println("There are 30 days in that month.");
				break;
			case 2:
				System.out.println("There are 28 or 29 days in that month.");
				break;
			default:
				System.out.println("That is an invalid month number.");
		}
		
	}

}
