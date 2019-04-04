import java.util.Scanner;

public class MathProgram {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		boolean keepGoing = true;

		System.out.println("Welcome to the Math Program!");
		while (keepGoing) {
			System.out.println("Enter \"1\" to add.");
			System.out.println("Enter \"2\" to subtract.");
			System.out.println("Enter \"3\" to multiply.");
			System.out.println("Enter \"4\" to divide.");
			System.out.println("Enter \"5\" to square.");
			System.out.println("Enter \"6\" to find the square root.");
			System.out.println("Enter \"7\" to quit.");

			int userChoice = scan.nextInt();

			double result = 0;

			if (userChoice == 1 || userChoice == 2 || userChoice == 3
					|| userChoice == 4) {
				int leftOperand, rightOperand;
				System.out.println("Enter the first operand:");
				leftOperand = scan.nextInt();
				System.out.println("Enter the second operand:");
				rightOperand = scan.nextInt();

				if (userChoice == 1) {
					result = leftOperand + rightOperand;
				} else if (userChoice == 2) {
					result = leftOperand - rightOperand;
				} else if (userChoice == 3) {
					result = leftOperand * rightOperand;
				} else { // userChoice==4

					System.out.println("Enter \"1\" for integer division.");
					System.out
							.println("Enter a different number for full division.");
					int userDivisionChoice = scan.nextInt();

					if (userDivisionChoice == 1) {
						result = leftOperand / rightOperand;
					} else { // userDivisionChoice != 1
						result = (1.0 * leftOperand) / (1.0 * rightOperand);
					}
				}

				System.out.println("The result is " + result);

			} else if (userChoice == 5 || userChoice == 6) {
				System.out.println("Enter the value:");
				int operand = scan.nextInt();

				if (userChoice == 5) {
					result = Math.pow(operand, 2);
				} else { // userChoice==6
					result = Math.sqrt(operand);
				}

				System.out.println("The result is " + result);

			} else if (userChoice==7) {
				keepGoing = false;
				System.out.println("Thanks for doing math! Goodbye.");
			} else { // userChoice is not equal to 1, 2, 3, 4, 5, or 6
				System.out.println("That is not a valid option.");
			}

		}

	}

}
