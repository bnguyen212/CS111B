import java.util.*;

public class HomeworkM3Driver {

	public static void main(String[] args) {

		// System.out.println("*****TESTING RANDOM NUMBER ARRAY GENERATOR***");
		// System.out.println("Note: run some of these tests multiple times since they involve random numbers.");
		// int[] array = generateRandomArray(10, 1, 100, true);
		// System.out.println("Size 10: " + array.length + "\t" +	"Contents should be between 1 and 100, inclusive.\n\t" + Arrays.toString(array));

		// array = generateRandomArray(5, 1, 10, false);
		// System.out.println("Size 5: " + array.length + "\t" + "Contents should be between 1 and 10, with the upper bound exclusive, meaning between 1 and 9 inclusive.\n\t" + Arrays.toString(array));

		// array = generateRandomArray(15, 1, 5, true);
		// System.out.println("Size 15: " + array.length + "\t" + "Contents should be between 1 and 5, inclusive.\n\t" + Arrays.toString(array));

		// array = generateRandomArray(15, 1, 5, false);
		// System.out.println("Size 15: " + array.length + "\t" + "Contents should be between 1 and 5, with the upper bound exclusive, meaning between 1 and 4, inclusive.\n\t" + Arrays.toString(array));


		// array = generateRandomArray(15, 1, 2, false);
		// System.out.println("Size 15: " + array.length + "\t" +	"Contents should be only the number 1.\n\t" + Arrays.toString(array));

		// array = generateRandomArray(15, 1, 1, true);
		// System.out.println("Size 15: " + array.length + "\t" + 	"Contents should be only the number 1.\n\t" + Arrays.toString(array));

		// array = generateRandomArray(10, 4, 3, true);
		// System.out.println("Should print null (without crashing) lower > upper inclusive: " + array);

		// array = generateRandomArray(10, 4, 3, false);
		// System.out.println("Should print null (without crashing) lower > upper exclusive: " + array);

		// array = generateRandomArray(10, 4, 4, false);
		// System.out.println("Should print null (without crashing) lower == upper exclusive: " + array);

		// array = generateRandomArray(10, 4, 4, true);
		// System.out.println("Should not print null (without crashing) lower == upper inclusive: " + Arrays.toString(array));

		// array = generateRandomArray(-1, 4, 14, true);
		// System.out.println("Should print null (without crashing) negative size: " + array);



		// System.out.println("\n\n*****TESTING ARRAY COPY AND EXPAND***");
		// String[] words1 = {"a", "b", "c"};
		// words1 = copyToEndAndExpand(words1);
		// System.out.println("Array holds \t[null, null, null, a, b, c]");
		// System.out.println("\t\t" + Arrays.toString(words1));

		// String[] words2 = new String[1];
		// words2[0] = "hi";
		// words2 = copyToEndAndExpand(words2);
		// System.out.println("Array holds \t[null, hi]");
		// System.out.println("\t\t" + Arrays.toString(words2));

		// String[] words3 = {"apple", "cat", "dog", "banana"};
		// String[] moreWords = copyToEndAndExpand(words3);
		// System.out.println("Original array holds \t[apple, cat, dog, banana]");
		// System.out.println("\t\t\t" + Arrays.toString(words3));
		// System.out.println("New array holds \t[null, null, null, null, apple, cat, dog, banana]");
		// System.out.println("\t\t\t" + Arrays.toString(moreWords));


		// System.out.println("\n\n*****TESTING THE METHOD TO CREATE A LIST OF WORDS THAT DON'T START WITH A CHARACTER OR DIGIT***");
		// ArrayList<String> wordList = new ArrayList<>(List.of("hello!", "?what", "email@com", "#javarules", "3blindmice", "&more"));
		// ArrayList<String> wordsNotStartingWithCharDigit = createListNonCharacterDigitWords(wordList);
		// System.out.println("List holds \t[?what, #javarules, &more]" + "\n\t\t" + createListNonCharacterDigitWords(wordList));

		// wordList = new ArrayList<>(List.of("no!", "answers?", "found#here", "4sure"));
		// wordsNotStartingWithCharDigit = createListNonCharacterDigitWords(wordList);
		// System.out.println("List holds \t[]" + "\n\t\t" + wordsNotStartingWithCharDigit);

		// wordList = new ArrayList<>(List.of("$money", "^carrot", "(parens", ")parensclose", "\ttab"));
		// wordsNotStartingWithCharDigit = createListNonCharacterDigitWords(wordList);
		// System.out.println("List holds \t[$money, ^carrot, (parens, )parensclose, 	tab]" + "\n\t\t" + wordsNotStartingWithCharDigit);


		// YOUR CODE HERE TO COMMUNICATE WITH THE USER TO CREATE A LIST, SORT AND PRINT, AND INVOKE THE ABOVE METHOD
		Scanner scan = new Scanner(System.in);
		int numberOfEntries;
		do {
			System.out.print("Please enter a positive number: ");
			numberOfEntries = Integer.parseInt(scan.nextLine());
		} while (numberOfEntries < 1);
		int count = 1;
		ArrayList<String> stringList = new ArrayList<>();
		while (count <= numberOfEntries) {
			System.out.printf("Please enter string #%s: ", count);
			String newStr = scan.nextLine();
			stringList.add(newStr);
			count++;
		}
		scan.close();
		Collections.sort(stringList);
		System.out.println(stringList);
		System.out.println(createListNonCharacterDigitWords(stringList));

	}

	public static int[] generateRandomArray(int size, int lower, int upper, boolean inclusive) {
		if (size < 0 || upper < lower || (upper == lower && !inclusive)) {
			return null;
		}
		Random generator = new Random();
		int[] result = new int[size];
		if (inclusive) {
			upper += 1;
		}
		for (int index = 0; index < result.length; index++) {
			result[index] = generator.nextInt(upper - lower) + lower;
		}
		return result;
	}

	public static String[] copyToEndAndExpand(String[] array) {
		String[] newArray = new String[array.length * 2];
		for (int index = array.length; index < newArray.length; index++) {
			newArray[index] = array[index-array.length];
		}
		return newArray;
	}

	public static ArrayList<String> createListNonCharacterDigitWords(ArrayList<String> words) {
		ArrayList<String> newList = new ArrayList<>();
		for (String word : words) {
			char firstChar = word.charAt(0);
			if (!Character.isLetterOrDigit(firstChar)) {
				newList.add(word);
			}
		}
		return newList;
	}


}
