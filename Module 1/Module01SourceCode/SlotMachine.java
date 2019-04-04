import java.util.*;

public class SlotMachine {

	public static void main(String[] args) {
		Random generator = new Random();
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("Welcome to the slot machine!");
		
		boolean keepPlaying = true;
		do {
			int num1 = generator.nextInt(10);
			int num2 = generator.nextInt(10);
			int num3 = generator.nextInt(10);
			System.out.println("*" + num1 + "*" + num2 + "*" + num3);
			
			if(num1==num2 && num2==num3) {
				System.out.println("You're a big winner!");
			} else if(num1==num2 || num1==num3 || num2==num3) {
				System.out.println("You're a partial winner!");	
			} else {
				System.out.println("Loser! Try again.");
			}
			
			System.out.println("Play again? Enter \"y\" or \"n\"");
			String userChoice = scan.nextLine();
			if(!userChoice.equalsIgnoreCase("y")) {
				keepPlaying = false;
			}
			
		} while(keepPlaying);
	}

}
