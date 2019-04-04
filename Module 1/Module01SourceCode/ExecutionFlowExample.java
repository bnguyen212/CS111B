
public class ExecutionFlowExample {
	
 	
	public static double findMX(double slope, double x) {
		System.out.println("\t\tIn findMX");
		return slope * x;
	}

	public static double findY(double slope, double x, double yIntercept) {
		System.out.println("\tIn findY, about to invoke findMX");
		double mx = findMX(slope, x);
		System.out.println("\tAfter invoking findMX");
		return mx + yIntercept;
	}
	
	public static void main(String[] args) {	
		System.out.println("Starting main!");
		double slope = 0.5;
		double x = 3;
		double yIntercept = 4;
		System.out.println("About to invoke findY");
		double y = findY(slope, x, yIntercept);
		System.out.println("After invoking findY");
		System.out.println("y is " + y);
		System.out.println("Leaving main goodbye!");	
	}
	


	

}
