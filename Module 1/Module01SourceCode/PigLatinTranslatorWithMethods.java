import java.util.*;

public class PigLatinTranslatorWithMethods {
	
	public static final String PIG_LATIN_ENDING = "ay";
	
	public static void main(String[] args) {
		
		System.out.println("Welcome! Let's talk in Pig Latin!");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your first name:");
		String firstName = scan.nextLine();
		System.out.println("Enter your last name:");
		String lastName = scan.nextLine();
		
		String pigLastName = convertToPigLatin(lastName);
		
		System.out.println(firstName + " " + lastName);
		System.out.println(convertToPigLatin(firstName) + "\n" + pigLastName);
		
		System.out.println("Give me one more word:");
		String word = scan.nextLine();
		word = convertToPigLatin(convertToPigLatin(word));
		System.out.println(word);
	}

	public static String convertToPigLatin(String word) {
		String pigWord = word.toLowerCase();
		String formerFirstLetter = pigWord.substring(0,1);
		pigWord += formerFirstLetter;
		pigWord = pigWord.substring(1);
		pigWord += PIG_LATIN_ENDING;
		String newFirstLetter = pigWord.substring(0,1);
		newFirstLetter = newFirstLetter.toUpperCase();
		pigWord = newFirstLetter + pigWord.substring(1);
		return pigWord;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
