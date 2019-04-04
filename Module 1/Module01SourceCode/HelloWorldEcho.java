import java.util.Scanner;

// public and class are keywords/reserved words
public class HelloWorldEcho { // class header

	// special method- header must be this exactly!
	// this will run when we run the program
	public static void main(String[] args) { // method header
		System.out.print("Hello "); // one program statement
		System.out.println("World!");
		
		System.out.println("What is your name?");
		
		Scanner scan = new Scanner(System.in); // creates a Scanner object to use for user input
		String name = scan.nextLine();
		
		System.out.println("Hello " + name);
		
		printGoodbye();
	}
	
	public static void printGoodbye() { // method header
		System.out.println("Goodbye!");
	}

}
