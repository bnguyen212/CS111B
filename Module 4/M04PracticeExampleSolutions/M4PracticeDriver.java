
public class M4PracticeDriver {
	
	public static enum Semester {
		FALL (16, "Fall"), SPRING (16, "Spring"), SUMMER (6, "Summer");
		
		private int weeks;
		private String displayString;
		
		private Semester(int weeks, String displayString) {
			this.weeks = weeks;
			this.displayString = displayString;
		}
		public int getWeeks() {
			return weeks;
		}
		public String toString() {
			return displayString + " Semester (" + weeks + "weeks)";
		}
	}
	
	public static void main(String[] args) {
		// add code here to for testing!
		
		Beverage stella = new Beverage("Stella Artios", Beverage.BeverageType.BEER, 5.50);
		Beverage horizon = new Beverage("Horizon Organic", Beverage.BeverageType.MILK, 2.99);
		System.out.println(stella);
		System.out.println(horizon);
		
		Semester fall = Semester.FALL;
		Semester spring = Semester.SPRING;
		Semester summer = Semester.SUMMER;
		int totalWeeks = fall.getWeeks() + spring.getWeeks() + summer.getWeeks();
		System.out.println(totalWeeks + " weeks");
		
		// or even better:
		Semester[] allSemesters = Semester.values();
		totalWeeks = 0;
		for(Semester semester : allSemesters) {
			totalWeeks += semester.getWeeks();
		}
		System.out.println(totalWeeks + " weeks");
	}
	public static int sumElements(int[] array) {
		return sumElements(array, 0, array.length-1);
	}
	public static int sumElements(int[] array, int start) {
		return sumElements(array, start, array.length-1);
	}
	public static int sumElements(int[] array, int start, int end) {
		if(start >= 0 && end <array.length && start <= end) {
			int total = 0;
			for(int i=start; i<=end; i++) {
				total += array[i];
			}
			return total;
		} else {
			System.exit(0); // IMPORTANT NOTE: the correct action here is to throw an exception, not quit the program
			// since we haven't yet learned about throwing exceptions, I'm leaving this like this for now!
			return 0;
		}
	}
}
