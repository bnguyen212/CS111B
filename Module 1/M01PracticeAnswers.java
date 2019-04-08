import java.util.*;

public class M01PracticeAnswers {

	public static void main(String[] args) {

		int a = 2, b = 3, c = 5, d = 6;
		double x = 3.0, y = 4.0;

		System.out.println((c / b) + (c / y));

		// write code here to invoke and test the methods!

		// if you want to read in a value from the user and then
		// pass that value to a method as an actual parameter,
		// you can use this Scanner object
		Scanner scan = new Scanner(System.in);


	}

	public static void printPizzaPerPerson(int numberOfPizzas, int numberOfPeople) {
		double pizzaPerPerson = ((double) numberOfPizzas) / (1.0 * numberOfPeople);
		// you must convert one of the operands to a double using one of these methods
		// you don't need to use both- i just put them here for demonstration
		// test your code with numberOfPizzas = 2 and numberOfPeople = 5 and make sure
		// it prints 0.4 pizzas per person

		System.out.println("There will be " + pizzaPerPerson + " pizzas per person.");
	}

	// use constants instead of hard-coded values!
	public final static int INCHES_IN_FOOT = 12;
	public final static int FEET_IN_YARD = 3;
	public final static int INCHES_IN_YARD = INCHES_IN_FOOT * FEET_IN_YARD;
	public final static int YARDS_IN_MILE = 1760;
	public final static int INCHES_IN_MILE = INCHES_IN_YARD * YARDS_IN_MILE;

	public static void printDistanceBreakdown(int totalInches) {
		int miles = totalInches / INCHES_IN_MILE;
		int leftOverInches = totalInches % INCHES_IN_MILE;
		int yards = leftOverInches / INCHES_IN_YARD;
		leftOverInches = leftOverInches % INCHES_IN_YARD;
		int feet = leftOverInches / INCHES_IN_FOOT;
		leftOverInches = leftOverInches % INCHES_IN_FOOT;
		System.out.println(totalInches + " inches is equivalent to " + miles + " miles, " + yards + " yards, " + feet
				+ " feet, and " + leftOverInches + " inches.");
	}

	public static int calculateInches(int inches, int feet, int yards, int miles) {
		return inches + feet * INCHES_IN_FOOT + yards * INCHES_IN_YARD + miles * INCHES_IN_MILE;
	}


	// unlike the example in the vide, this is in a complete method!
	public static int numberOfDaysInMonth(int monthNumber, boolean leapYear) {
		int numberOfDays;
		switch (monthNumber) {
		case 1:	case 3:	case 5:	case 7:	case 8:	case 10:	case 12:
			numberOfDays = 31;
			break;
		case 4:	case 6:	case 9:	case 11:
			numberOfDays = 30;
			break;
		case 2:
			numberOfDays = (leapYear ? 29 : 28);
			break;
		default:
			System.out.println("Invalid month number.");
			numberOfDays = -1;
			break;
		}
		return numberOfDays;
	}


	// note that you were not required to put this code inside a complete method;
	// you could have written the code directly in main
	public static void printAgeStatements(int age) {
		System.out.println("Here is what you can do at age " + age);
		switch (age) {
		// by listing the values from largest to smallest, you can
		// leverage the "fall through" behavior of the switch to
		// reduce duplicated code
		case 22: case 23: case 24: case 25:

			System.out.println("You can rent a car.");
		case 19: case 20: case 21:
			System.out.println("You can buy alcohol.");
		case 17: case 18:
			System.out.println("You can vote.");
		case 15: case 16:
			System.out.println("You can drive.");
			break; // break needed here so the default message isn't printed for all ages!
		default:
			System.out.println("No information available for that age.");

		}
	}


	// use constants to represent numeric literal values, especially when they are used more than once!
	public static final int LOW_INCOME_LEVEL = 50000;
	public static final int HIGH_INCOME_LEVEL = 100000;
	public static final int MINIMUM_YEARS_WORKED = 2;
	public static boolean isEligibleWithoutCosigner(int income, int numberOfYearsWorked) {
		// an if/else-if/else is the best conditional structure here because there
		// are three branches and exactly one will be executed

		// be careful about border values- make sure the exact values of 50,000 and 100,000
		// are accounted for; be careful about years worked < 2, not <=

		if(income > HIGH_INCOME_LEVEL) {
			return true; // approved because income above 100,000 (note the > not >=)
		} else if(income <= HIGH_INCOME_LEVEL && income >= LOW_INCOME_LEVEL) {
			// note that the income<=10000 part of this conditional could be omitted because we already know
			// that is true since the first if failed; i include it anyhow for clarity in reading
			if(numberOfYearsWorked < MINIMUM_YEARS_WORKED) {
				return false; // in middle income range but worked less than 2 years- cosigner needed
			} else {
				return true; // in middle income range and worked 2 years or more; approved
			}
		} else { // income < LOW_INCOME_LEVEL
		// else is best here (not else-if) but it can be helpful to put the condition in a comment (as above)
			return false; // cosigner needed because income below 50,000
		}
	}

	public static boolean isLeapYear(int year) {
		// first definition

		if(year%4==0) { // leap years are divisible by 4
			if(year%100==0 && year%400!=0) {
				return false; // the exception that a year is divisible by 4, 100, and NOT 400
			} else {
				return true;
			}
		} else { // if not divisible by 4, it's not a leap year
			return false;
		}

		// second definition
		/*
		if( (year%4==0 && year%100!=0) ||
				year%400==0)
			return true;
		else {
			return false;
		}
		*/
	}


	// use constants for numeric literals
	public static final int TAX_BRACKET_1 = 15000;
	public static final int TAX_BRACKET_2 = 30000;
	public static final double TAX_RATE_1 = 0.05;
	public static final double TAX_RATE_2 = 0.10;

	public static double taxesOwed(int income) { // could also use a double for income
		double taxesOwed = 0;
		if(income > TAX_BRACKET_1) { // no taxes on the first 15000

			if(income <= TAX_BRACKET_2) { // income between 15001 and 30000 (inclusive)
				int taxableIncomeInBracket1 = income - TAX_BRACKET_1;
				taxesOwed += TAX_RATE_1 * taxableIncomeInBracket1;
			} else { // income above 30000
				int taxableIncomeInBracket1 = TAX_BRACKET_2 - TAX_BRACKET_1;
				taxesOwed += TAX_RATE_1 * taxableIncomeInBracket1;

				int taxableIncomeInBracket2 = income - TAX_BRACKET_2;
				taxesOwed += TAX_RATE_2 * taxableIncomeInBracket2;
			}
		}
		return taxesOwed;
	}


	// a while loop is good here because we don't know in advance how many times the loop will execute
	// (in fact, that is what we are trying to figure out!)
	public static int howManyHalves(int value)  {
		int times = 0;
		while(value > 0) {
			value = value/2;
			times++;
		}
		return times;
	}


	// a for loop is best here because we know in advance how many times we want the loop to execute
	public static int sumIntegers(int low, int high) {
		int sum = 0;
		for(int i=low; i<=high; i++) {
			sum+=i;
		}
		return sum;
	}

	// note that you were not required to put this code inside a complete method;
	// you could have written the code directly in main;
	// note, if writing in main: you would read the number in from the user
	// using a Scanner; because I have the code in a method, I've sent it in
	// as a parameter
	public static void printDigitInformation(int number) {
		int numberZeros=0, numberOdd=0, numberEven=0;

		while(number>0) {
			if(number%10==0) { // if the number is divisible by 10, the last digit must be a 0
				numberZeros++;
			} else if(number%2==0) { // if the number is even, the last digit must be even
				numberEven++;
			} else {
				numberOdd++;
			}
			number = number / 10; // use integer division to "cut off" the last digit
		}
		System.out.println("That number has " + numberEven + " even digit"
				+ ((numberEven!=1) ? "s, " : ", ")
				+ numberOdd + " odd digit"
				+ ((numberOdd!=1) ? "s, and " : ", and ")
				+ numberZeros + " zero"
				+ ((numberZeros!=1) ? "es." : "."));
	}

	public static void printSquare(int size) {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print("X");
			}
			System.out.println();
		}
	}

}
