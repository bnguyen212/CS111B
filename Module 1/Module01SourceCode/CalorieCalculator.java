import java.util.Scanner;

public class CalorieCalculator {
	
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
		double weightInKG = weightInPounds * POUND_TO_KG_CONVERSION_FACTOR; 
		double caloriesPerMinute = CALORIE_FORMULA_CONSTANT * met * weightInKG;
		double totalCaloriesBurned = caloriesPerMinute * minutes;
		
		// output the answer
		System.out.println("You burned " + totalCaloriesBurned + " calories! Nice work.");
		
	}

}
