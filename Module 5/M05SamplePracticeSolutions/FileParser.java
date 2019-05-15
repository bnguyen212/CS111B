import java.util.*;
import java.io.*;

public class FileParser {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		
		System.out.println("What is the name of the file?");
		String fileName = scan.nextLine();
		int invalidCount = 0;
		try {
			Scanner fileScan = new Scanner(new File(fileName));
			while(fileScan.hasNext()) {

				String fileLine = fileScan.next();
				
				Scanner lineScan = new Scanner(fileLine);
				lineScan.useDelimiter(",");
				while(lineScan.hasNext()) {
					String word = lineScan.next();
					try {
						int number = Integer.parseInt(word);
						numberList.add(number);
					} catch(NumberFormatException ex) {
						System.out.println("Non-number found: " + word);
						invalidCount++;
					}
				}
			}

			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		
		System.out.println(invalidCount + " non-integer values found.");
		System.out.println("Integer values found: " + numberList);
		int total = 0;
		for(int n : numberList) {
			total += n;
		}
		double average = (total * 1.0) / numberList.size();
		System.out.println("Average: " + average);

	}

}
