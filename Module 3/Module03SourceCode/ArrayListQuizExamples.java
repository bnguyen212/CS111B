import java.util.*;


public class ArrayListQuizExamples {

	public static void main(String[] args) {
		
		
		ArrayList<Double> scoreList = new ArrayList<Double>();
		fillUpScoreList(scoreList);
		System.out.println("Your list of scores:");
		System.out.println(scoreList);
		
		findAndRemoveMinimumScore(scoreList);
		System.out.println("Your list after removing the min:");
		System.out.println(scoreList);
		
		System.out.println("Your average is: " + calculateAverage(scoreList));
		
		System.out.println("Your grades are:");
		System.out.println(getGradeList(scoreList));

	}
	
	public static ArrayList<Character> getGradeList(ArrayList<Double> scoreList) {
		ArrayList<Character> gradeList = new ArrayList<Character>();
		
		for(double score : scoreList) {
			if(score >= 90) {
				gradeList.add('A');
			} else if(score >= 80) {
				gradeList.add('B');
			} else if(score >= 70) {
				gradeList.add('C');
			} else if(score >= 60) {
				gradeList.add('D');
			} else {
				gradeList.add('F');
			}
		}
		
		return gradeList;
	}
	
	public static double calculateAverage(ArrayList<Double> scoreList) {
		// assume the list is not empty
		double total = 0;
		for(double score : scoreList) {
			total += score;
		}
		return total / scoreList.size();
	}
	
	public static void findAndRemoveMinimumScore(ArrayList<Double> scoreList) {
		if(!scoreList.isEmpty()) {
			int minIndex = 0;
			double min = scoreList.get(minIndex);
			
			for(int i=0; i<scoreList.size(); i++) {
				double currentScore = scoreList.get(i);
				if(currentScore < min) {
					min = currentScore;
					minIndex = i;
				}
			}
			
			scoreList.remove(minIndex);
		}
	}
	
	public static void fillUpScoreList(ArrayList<Double> scoreList) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("How many scores to enter?");
		int numScores = Integer.parseInt(scan.nextLine());
		
		for(int i=0; i<numScores; i++) {
			System.out.println("Enter the score:");
			double score = Double.parseDouble(scan.nextLine());
			scoreList.add(score);
		}
	}

}
