import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class NumberWriter {

	public static void main(String[] args) {
		readNumbersOutputToFile();
	}

	public static void readNumbersOutputToFile() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 10 numbers.");
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			try {
				int value = Integer.parseInt(scan.nextLine());
				numbers[i] = value;
			} catch (NumberFormatException ex) {
				System.out.println("Invalid. Try again.");
				i--;
			}
		}
		System.out.println("Enter the name of the output file: ");
		String file = scan.nextLine();
		try (FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter outputWriter = new PrintWriter(bw);) {
			for (int i = 0; i < numbers.length - 1; i++) {
				outputWriter.print(numbers[i] + ", ");
			}
			outputWriter.print(numbers[numbers.length-1]);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Method complete.");
	}

}
