import java.util.Scanner;


public class StringReverser {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter some text to be reversed:");
		
		String userWord = scan.nextLine();
		
		int wordLength = userWord.length();
		
		// HELLO (length = 5)
		// 01234
		
		for(int i=wordLength-1; i>=0; i--) {
			System.out.print(userWord.charAt(i));
		}
		
	}

}
