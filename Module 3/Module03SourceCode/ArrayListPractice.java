import java.util.*;

public class ArrayListPractice {

	public static void main(String[] args) {
		//arrayListInts();
		arrayListStrings();
	}
	public static void arrayListStrings() {
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> wordList = new ArrayList<String>();
		
		System.out.println("Enter words. Duplicates will not be stored. Enter \"quit\" to quit.");
		boolean stillEntering = true;
		while(stillEntering) {
			String userWord = scan.nextLine();
			if(userWord.equals("quit")) {
				stillEntering = false;
			} else if(!wordList.contains(userWord)) {
				wordList.add(0, userWord);
			}
		}
		System.out.println(wordList);
	}
	
	public static void arrayListInts() {
		Scanner scan = new Scanner(System.in);

		ArrayList<Integer> numberList = new ArrayList<Integer>();
		
		System.out.println("Begin entering numbers, enter 0 to quit.");
		boolean stillEntering = true;
		while(stillEntering) {
			int userNumber = Integer.parseInt(scan.nextLine());
			if(userNumber!=0) {
				numberList.add(userNumber);
			} else {
				stillEntering = false;
			}
		}
		
		System.out.println(numberList);
		System.out.println("You entered " + numberList.size() + " numbers.");
		
		int total = 0, numberOfEvens = 0;
		for(Integer i : numberList) {
			total += i;
			if(i%2==0) { 
				numberOfEvens++;
			}
		}
		System.out.println("The total is " + total);
		System.out.println("There were " + numberOfEvens + " even numbers entered.");

	}

}
