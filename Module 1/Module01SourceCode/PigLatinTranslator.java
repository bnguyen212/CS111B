import java.util.*;

public class PigLatinTranslator {
	
	public static final String PIG_LATIN_ENDING = "ay";
	
	public static void main(String[] args) {
		
		System.out.println("Welcome! Let's talk in Pig Latin!");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your first name:");
		String firstName = scan.nextLine();
		System.out.println("Enter your last name:");
		String lastName = scan.nextLine();
		
		
		String pigFirstName = firstName.toLowerCase();
		char pigFirstNameFirstLetter = pigFirstName.charAt(0);
		pigFirstName = pigFirstName + pigFirstNameFirstLetter;
		pigFirstName = pigFirstName.substring(1);
		pigFirstName = pigFirstName + PIG_LATIN_ENDING;
		String newFirstLetter = pigFirstName.substring(0,1);
		newFirstLetter = newFirstLetter.toUpperCase();
		pigFirstName = newFirstLetter + pigFirstName.substring(1);
		
		String pigLastName = lastName.toLowerCase();
		String pigLastNameFirstLetter = pigLastName.substring(0, 1);
		pigLastName = pigLastName + pigLastNameFirstLetter;
		pigLastName = pigLastName.substring(1);
		pigLastName = pigLastName + PIG_LATIN_ENDING;
		String newLastLetter = pigLastName.substring(0,1);
		newLastLetter = newLastLetter.toUpperCase();
		pigLastName = newLastLetter + pigLastName.substring(1);
		
		System.out.println(firstName + " " + lastName);
		System.out.println(pigFirstName + "\n" + pigLastName);
	}

	
	
	
	
	
	
	
}
