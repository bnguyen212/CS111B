import java.util.*;

public class HiLoGame {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to HiLo!");

		Random generator = new Random();
	

		boolean keepPlaying = true;

		// outer loop represents one "round" of the game
		while (keepPlaying) {
			
			int randomNumber = generator.nextInt(100) + 1;
			boolean guessCorrect = false;
			
			// inner loop represents one "guess" within each round
			while (!guessCorrect) {
				System.out.println("Enter a guess:");
				int userGuess = scan.nextInt();

				if (userGuess == randomNumber) {
					System.out.println("You've got it!");
					guessCorrect = true;
				} else if (userGuess < randomNumber) {
					System.out.println("Too low!");
				} else { // userGuess > randomNumber
					System.out.println("Too high!");
				}

			}
			System.out.println("Play again? Enter \"1\" to play again.");
			int userChoice = scan.nextInt();
			if(userChoice!=1) {
				keepPlaying = false;
			} 
		}
		System.out.println("Goodbye!");

	}

}
