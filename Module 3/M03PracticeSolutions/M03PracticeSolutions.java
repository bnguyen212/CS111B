import java.util.*;

public class M03PracticeSolutions {

	public static void main(String[] args) {
		// write code here to invoke and test the methods!
		Scanner scan = new Scanner(System.in);
		
		// ODD NUMBER ARRAY CODE
		int[] odds = new int[100];
		for(int i=0; i<odds.length; i++) {
			odds[i] = (i*2)+1;
		}
		for(int i=0; i<odds.length; i++) {
			if(odds[i]%5==0) {
				System.out.print(odds[i] + "\t");
				odds[i] *= 2;
			}
		}
		System.out.println();
		System.out.println(Arrays.toString(odds));
	
		// READING USER INTEGERS
		int[] countOfUserNumberEntered = new int[51];
		for(int i=0; i<countOfUserNumberEntered.length; i++) {
			countOfUserNumberEntered[i] = 0;
		}
		boolean validNumber = true;
		do {
			System.out.println("Enter a number between 0 and 50 (inclusive) or a number outside the range to quit.");
			int userNumber = Integer.parseInt(scan.nextLine());
			if(userNumber >= 0 && userNumber < countOfUserNumberEntered.length) {
				countOfUserNumberEntered[userNumber]++;
			} else {
				validNumber = false;
			}
		} while(validNumber);
		for(int i=0; i<countOfUserNumberEntered.length; i++) {
			if(countOfUserNumberEntered[i]>0) {
				String times = countOfUserNumberEntered[i]==1 ? " time." : " times.";
				System.out.println(i + " was entered " + countOfUserNumberEntered[i] + times);
			}
		}
		
		// ARRAY OF DIE OBJECTS
		System.out.println("How many dice to create?");
		int numberDice = Integer.parseInt(scan.nextLine());
		Die[] dice = new Die[numberDice];
		for(int i=0; i<dice.length; i++) {
			dice[i] = new Die();
		}
		int sixes = 0;
		for(Die die : dice) {
			int roll = die.roll();
			if(roll==6) {
				sixes++;
			}
		}
		System.out.println("You rolled " + sixes + " sixes.");
		
		// ARRAYLIST STRING READ-IN
		System.out.println("What is your code word?");
		String codeWord = scan.nextLine();
		ArrayList<String> codeFreeList = new ArrayList<String>();
		boolean keepEntering = true;
		do {
			System.out.println("Enter a word or \"quit\" to quit.");
			String word = scan.nextLine();
			if(word.equalsIgnoreCase("quit")) {
				keepEntering = false;
			} else if(word.indexOf(codeWord)<0) {
				codeFreeList.add(word);
			}
		} while(keepEntering);
		System.out.println(codeFreeList);
		
		// VERSION 1: ARRAYLIST UNIQUE WORD READ IN
		ArrayList<String> uniqueWordList = new ArrayList<String>();
		boolean keepGoing = true;
		do {
			System.out.println("Enter a word or \"quit\" to quit.");
			String word = scan.nextLine();
			if(word.equalsIgnoreCase("quit")) {
				keepGoing = false;
			} else if(!uniqueWordList.contains(word)) {
				uniqueWordList.add(word);
			}
		} while(keepGoing);
		System.out.println(uniqueWordList);
		
		// VERSION 2: ARRAYLIST UNIQUE WORD READ IN USING SET!
		keepGoing = true;
		HashSet<String> uniqueWordSet = new HashSet<String>();
		do {
			System.out.println("Enter a word or \"quit\" to quit.");
			String word = scan.nextLine();
			if(word.equalsIgnoreCase("quit")) {
				keepGoing = false;
			} else {
				uniqueWordSet.add(word);
			}
		} while(keepGoing);
		ArrayList<String> uniqueListFromSet = new ArrayList<String>(uniqueWordSet);
		System.out.println(uniqueListFromSet);
	}
	
	public static void makeElementsPositive(int[] numbers) {
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = Math.abs(numbers[i]);
		}
		// NOTE: invoking numbers = createPositiveArray(numbers) will NOT work!! make sure you know why!
		// (think about pass by value and breaking the alias link of the formal/actual parameter!)
	}

	public static int[] createPositiveArray(int[] numbers) {
		int[] positiveArray = new int[numbers.length];
		for(int i=0; i<numbers.length; i++) {
			positiveArray[i] = Math.abs(numbers[i]);
		}
		return positiveArray;
	}
	
	public static boolean isValidIndex(int[] array, int index) { // could also be a String[] or any other type of array
		return index>=0 && index<array.length;
	}
	public static int[] subArray(int[] numbers, int start, int end) {
		if(start <= end && start >= 0 && end < numbers.length) {
			int size = end - start + 1;
			int[] subArray = new int[size];
			for(int i=start, j=0; i<=end; i++, j++) {
				subArray[j] = numbers[i];
			}
			return subArray;
		} else {
			return null; // or throw an exception! (we'll learn how soon!)
		}
	}

	public static void convertToUpper(String[] words) {
		for(int i=0; i<words.length; i++) {
			words[i] = words[i].toUpperCase();
		}
	}
	
	public static boolean isIncreasing(int[] numbers) {
		boolean allNeighborsIncreasing = true;
		for(int i=0; i<numbers.length-1 && allNeighborsIncreasing; i++) {
			if(numbers[i] > numbers[i+1]) {
				allNeighborsIncreasing = false;
			}
		}
		return allNeighborsIncreasing;
	}

	
	public static int findRange(int[] numbers) {
		int min = numbers[0], max = numbers[0];
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i] < min) {
				min = numbers[i];
			}
			
			if(numbers[i] > max) {
				max = numbers[i];
			}
		}
		return max - min;	
	}
	
	public static String generateUsername(String firstName, String lastName) {
		String username = firstName.substring(0,1); // returns a String
		
		if(lastName.length() >= 5) {
			username = username + lastName.substring(0,5);
		} else {
			username += lastName;
		}
		
		Random generator = new Random();
		int randomNumber = generator.nextInt(90) + 10;
		
		username += randomNumber;
		username = username.toLowerCase();
		return username;
	}
	
	public static boolean hasDuplicates(int[] numbers) {
		for(int i=0; i<numbers.length; i++) {
			for(int j=i+1; j<numbers.length; j++) {
				if(numbers[i]==numbers[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean hasDuplicates(ArrayList<Integer> numberList) {
		for(int number : numberList) {
			if(Collections.frequency(numberList, number)>1) {
				return true;
			}
		}
		return false;
	}
	
	public static int removeStringsWithChar(ArrayList<String> list, char c) { // could also be void!
		int count = 0;
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String word = iterator.next();
			if(word.indexOf(c)>=0) {
				iterator.remove();
				count++;
			}
		}
		return count;
	}
	
	public static HashSet<Integer> createSet(ArrayList<Integer> list) { // could also hold String or other type
		HashSet<Integer> set = new HashSet<Integer>(list);
		/* or this instead: */
		/* 
		HashSet<Integer> set = new HashSet<Integer>();
		for(int number : list) {
			set.add(number);
		}
		*/
		
		int dupsNotAdded = list.size() - set.size();
		System.out.println(dupsNotAdded + " duplicates not added to the set.");
		return set;
		
	}
	
	public static ArrayList<String> createUniqueStringList(ArrayList<String> wordList) {
		// version 1!
		/*
		ArrayList<String> uniqueList = new ArrayList<String>();
		for(String word : wordList) {
			if(!uniqueList.contains(word)) {
				uniqueList.add(word);
			}
		}
		return uniqueList;
		*/
		
		// version 2!
		HashSet<String> set = new HashSet<String>(wordList);
		return new ArrayList<String>(set);
	}
	public static String[] createUniqueStringArray(String[] words) {
		String[] wordsCopy = Arrays.copyOf(words, words.length); // or manually make a copy
	
		// null out any duplicates in the copy; the parameter array will remain unchanged
		for(int i=0; i<wordsCopy.length; i++) {
			String currentWord = wordsCopy[i];
			for(int j=i+1; j<wordsCopy.length; j++) {
				if(wordsCopy[i]!=null && wordsCopy[j]!=null && currentWord.equals(wordsCopy[j])) {
					wordsCopy[j] = null;
				}
			}
		}
		
		// count how many values remain
		int uniqueValues = 0;
		for(int i=0; i<wordsCopy.length; i++) {
			if(wordsCopy[i]!=null) {
				uniqueValues++;
			}
		}
		
		// copy over the unique values
		String[] uniqueArray = new String[uniqueValues];
		for(int i=0, j=0; i<uniqueArray.length && j<wordsCopy.length; j++) {
			if(wordsCopy[j]!=null) {
				uniqueArray[i] = wordsCopy[j];
				i++;
			}
		}
		return uniqueArray;
	}
}
