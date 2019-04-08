import java.util.*;

public class HomeworkM1Driver {

	public static void main(String[] args) {

		// System.out.println("******TESTING PRINT AVERAGE");
		// System.out.print("Should print 2.0: " );
		// printAverage(1, 2, 3);
		// System.out.print("Should print 1.33333 (repeating): " );
		// printAverage(1, 2, 1);
		// System.out.print("Should print 0.0: " );
		// printAverage(1, -1, 0);
		// System.out.print("Should print 2.33333 (repeating): " );
		// printAverage(1, -1, 7);

		// System.out.println("\n\n******TESTING CALCULATE MILES");
		// System.out.println("Should print 6.337984: " + calculateMiles(10, 200));
		// System.out.println("Should print 0.0621371: " + calculateMiles(0, 100));
		// System.out.println("Should print 68.972181: " + calculateMiles(111, 0));
		// System.out.println("Should print 2.496047307: " + calculateMiles(4, 17));

		// System.out.println("\n\n******TESTING CALCULATE VOLUME");
		// System.out.println("Should print 2 gallons, 1 quart, 0 pints, 1 cup, and 2 ounces left over.");
		// printGallonQuartPintCupOz(298);
		// System.out.println("Should print 75 gallons, 2 quart, 1 pints, 1 cup, and 5 ounces left over.");
		// printGallonQuartPintCupOz(9693);

		// System.out.println("\n\n******TESTING ISOCELES");
		// System.out.println("Should print Not a triangle and false");
		// System.out.println(isIsoscelesTriangle(1, 2, 4));
		// System.out.println("\nShould print Not a triangle and false");
		// System.out.println(isIsoscelesTriangle(4, 5, 1));
		// System.out.println("\nShould print Not a triangle and false");
		// System.out.println(isIsoscelesTriangle(5, 5, 10));
		// System.out.println("\nShould print true");
		// System.out.println(isIsoscelesTriangle(5, 9, 5));
		// System.out.println("\nShould print Equilateral triangle and false");
		// System.out.println(isIsoscelesTriangle(5, 5, 5));
		// System.out.println("\nShould print Scalene triangle and false");
		// System.out.println(isIsoscelesTriangle(3, 4, 5));
		// System.out.println("\nShould print true");
		// System.out.println(isIsoscelesTriangle(3, 2, 3));

		// System.out.println("\n\n******TESTING READ IN POSITIVE");
		// double userNumber = 0;
		// Scanner scan = new Scanner(System.in);
		// while (userNumber <= 0) {
		// 	System.out.println("Please enter a positive number:");
		// 	userNumber = scan.nextDouble();
		// }

		System.out.println("\n\n******TESTING NAME ECHO");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter in 10 names.");
		for (int count = 1; count <= 10; count++) {
			System.out.print("Please enter name #" + count + ": ");
			String name = scan.nextLine();
			while (name.length() == 0) {
				System.out.print("Please enter a valid name: ");
				name = scan.nextLine();
			}
			System.out.printf("Hello, %s!\n", name);
		}


	}

	public static void printAverage(int num1, int num2, int num3) {
		System.out.println((num1 + num2 + num3)/3.0);
	}

	final static double MILES_IN_METER = 0.000621371;
	public static double calculateMiles(double kilometers, double meters)  {
		return kilometers * MILES_IN_METER * 1000 + meters * MILES_IN_METER;
	}

	final static int OZ_IN_CUP = 8;
	final static int OZ_IN_PINT = 16;
	final static int OZ_IN_QUART = 32;
	final static int OZ_IN_GALLON = 128;
	public static void printGallonQuartPintCupOz(int ounces) {
		int	gallon = ounces / OZ_IN_GALLON;
		int leftoverOunces = ounces % 128;
		int quart = leftoverOunces / OZ_IN_QUART;
		leftoverOunces %= 32;
		int	pint = leftoverOunces / OZ_IN_PINT;
		leftoverOunces %= 16;
		int	cup = leftoverOunces / OZ_IN_CUP;
		leftoverOunces %= 8;
		System.out.printf("%s gallons, %s quarts, %s pints, %s cups, and %s ounces left over.\n", gallon, quart, pint, cup, leftoverOunces);
	}

	public static boolean isIsoscelesTriangle(int a, int b, int c) {
		if (a + b > c && a + c > b && b + c > a) {
			if (a == b && a == c) {
				System.out.println("Equilateral triangle");
				return false;
			} else if (a == b || b == c || a == c) {
				return true;
			} else {
				System.out.println("Scalene triangle");
				return false;
			}
		} else {
			System.out.println("Not a triangle");
			return false;
		}
	}

}
