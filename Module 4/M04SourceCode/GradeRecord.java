
public class GradeRecord {

	private String name;
	private int numericGrade;
	private LetterGrade letterGrade;
	
	public GradeRecord(String name, int numericGrade) {
		this.name = name;
		this.numericGrade = numericGrade;
		this.letterGrade = LetterGrade.getLetterGrade(numericGrade);
	}
	
	public String getName() {
		return name;
	}
	public int getNumericGrade() {
		return numericGrade;
	}
	public LetterGrade getLetterGrade() {
		return letterGrade;
	}
	
	@Override
	public String toString() {
		return name + "\t" + numericGrade + " (" + letterGrade + ")";
	}
	
	
}
