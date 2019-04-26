import java.time.*;
import java.util.*;

public class BirthdayMatches {

	public static void main(String[] args) {

		Random generator = new Random();

		int numberTrials = 5000;
		int numberTrialsWithADuplicate = 0;
		int numberPeopleRoom = 23;
		
		for (int j = 0; j < numberTrials; j++) {

			HashSet<MonthDay> birthdaySet = new HashSet<MonthDay>();
			
			boolean foundDupInThisTrial = false;
			for (int i = 0; i < numberPeopleRoom && !foundDupInThisTrial; i++) {
				int randomMonth = generator.nextInt(12) + 1;
				int randomDay;
				if (randomMonth == 2) { // february
					randomDay = generator.nextInt(28) + 1;
				} else if (randomMonth == 1 || randomMonth == 3 || randomMonth == 5 || randomMonth == 7
						|| randomMonth == 8 || randomMonth == 10 || randomMonth == 12) {
					randomDay = generator.nextInt(31) + 1;
				} else {
					randomDay = generator.nextInt(30) + 1;
				}
				MonthDay birthday = MonthDay.of(randomMonth, randomDay);
				boolean added = birthdaySet.add(birthday);
				if (!added) { // birthday is a duplicate!
					// System.out.println("duplicate found! " + birthday);
					foundDupInThisTrial = true;
					numberTrialsWithADuplicate++;
				}
			}
		}
		double probability = (numberTrialsWithADuplicate*1.0) / numberTrials;
		System.out.println("Probability of having matching birthdays in a group of size " + numberPeopleRoom + " is " + probability);
		
		setVsListDemonstration();
	}

	public static void setVsListDemonstration() {
		int trials = 100;
		int timesToTryToFindAMatch = 100000;

		HashSet<Integer> set = new HashSet<Integer>();
		//ArrayList<Integer> set = new ArrayList<Integer>();

		Random generator = new Random();
		for (int i = 0; i < trials; i++) {
			if (i % 10 == 0) {
				System.out.println("Trial " + i);
			}
			set.clear();
			boolean matchFound = false;
			for (int j = 0; j < timesToTryToFindAMatch && !matchFound; j++) {
				int number = generator.nextInt();
				if (set.contains(number)) {
					matchFound = true;
				} else {
					set.add(number);
				}
			}
		}
		System.out.println("Done!");
	}

}
