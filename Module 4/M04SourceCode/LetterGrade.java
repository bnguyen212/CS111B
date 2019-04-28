
public enum LetterGrade {
	
	A (90, 100, true), B (80, 89, true), C (70, 79, true), D (60, 69, false), F (0, 59, false);
	
	private final int low, high;
	private final boolean passing;
	
	private LetterGrade(int low, int high, boolean passing) {
		this.low = low;
		this.high = high;
		this.passing = passing;
	}
	
	public static LetterGrade getLetterGrade(int numericGrade) {
		// in reality, we SHOULD include validity checking of the parameter
		
		LetterGrade[] possibleLetterGrades = LetterGrade.values();
		for(LetterGrade possibleLetterGrade : possibleLetterGrades) {
			int lowRange = possibleLetterGrade.getLow();
			int highRange = possibleLetterGrade.getHigh();
			if(numericGrade >= lowRange && numericGrade <= highRange) {
				return possibleLetterGrade;
			}
		}
		return null; // more appropriate to throw an exception!		
	}
	
	public int getLow() {
		return low;
	}
	public int getHigh() {
		return high;
	}
	public boolean isPassing() {
		return passing;
	}
	

}
