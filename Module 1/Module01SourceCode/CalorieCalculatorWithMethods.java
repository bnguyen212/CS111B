import java.util.Scanner;

public class CalorieCalculatorWithMethods {
	
	public static final double POUND_TO_KG_CONVERSION_FACTOR = 0.453592;
	public static final double CALORIE_FORMULA_CONSTANT = 0.0175;
	
	public static void main(String[] args) {
		System.out.println("Welcome to the calorie calculator!");

		// read in the user's input
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the MET of your activity:");
		int met = scan.nextInt(); // for now, we'll use nextInt(); in the future, we will learn a better way!
		System.out.println("For how many minutes did you do that activity?");
		int minutes = scan.nextInt();	
		System.out.println("How many pounds do you weigh?");
		double weightInPounds = scan.nextDouble(); 
		
		// calculate the data
		// option one: small methods that calculate each individual part
		/*
		double weightInKG = convertPoundsToKG(weightInPounds); 
		double caloriesPerMinute = calculateCaloriesPerMinute(met, weightInKG);
		double totalCaloriesBurned = calculateCaloriesBurned(caloriesPerMinute, minutes);
		*/
		
		// option two: one method to calculate the whole value
		double totalCaloriesBurned = calculateTotalCaloriesBurned(weightInPounds, met, minutes);
		
		// output the answer
		System.out.println("You burned " + totalCaloriesBurned + " calories! Nice work.");
		
	}
	
	
	public static double calculateTotalCaloriesBurned(double pounds, int met, int minutes) {
		double weightInKG = pounds * POUND_TO_KG_CONVERSION_FACTOR;
		return weightInKG * met * CALORIE_FORMULA_CONSTANT * minutes;
	}
	
	
	public static double convertPoundsToKG(double pounds) {
		return pounds * POUND_TO_KG_CONVERSION_FACTOR;
	}

	public static double calculateCaloriesPerMinute(int met, double weightInKG) {
		return CALORIE_FORMULA_CONSTANT * met * weightInKG;
	}
	
	public static double calculateCaloriesBurned(double caloriesPerMinute, int minutes) {
		return caloriesPerMinute * minutes;
	}
	
	

	
	
	
	
	
	
	
	
	
}
