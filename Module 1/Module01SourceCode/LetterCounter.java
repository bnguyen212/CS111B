import java.util.Scanner;

public class LetterCounter {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// note that this program will give invalid data if the user enters something other than letters
		// this should be fixed!! I leave it to you to do so! :)
		System.out.println("Enter a word or phrase with letters only:");
		
		String userText = scan.nextLine();
		
		int numVowels = 0, numConsonants = 0;
		
		for(int i=0; i<userText.length(); i++) {
			char c = userText.charAt(i);
			
			
			switch(c) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				numVowels++;
				break;
			default:
				numConsonants++;
			}
		}
		System.out.println("There are " + numVowels + 
				(numVowels==1 ? " vowel" : " vowels") +
				" and " + numConsonants +
				(numConsonants==1 ? " consonant" : " consonants") );
		
	}

}
