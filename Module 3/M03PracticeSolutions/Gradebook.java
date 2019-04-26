
public class Gradebook {
	
	private double[][] gradebook;
	private int numStudents, numQuizzes;
	
	public Gradebook(int numStudents, int numQuizzes) {
		this.numStudents = numStudents;
		this.numQuizzes = numQuizzes;
		
		gradebook = new double[numStudents][numQuizzes];
	}
	
	public int getNumStudents() {
		return numStudents;
	}
	public int getNumQuizzes() {
		return numQuizzes;
	}
	
	public String toString() {
		String s = "";
		for(int row=0; row<numStudents; row++) { // could use gradebook.length instead of numStudents
			for(int column=0; column<numQuizzes; column++) { // could use gradebook[i].length instead of numQuizzes
				s += gradebook[row][column] + "\t";
			}
			s += "\n";
					
		}
		return s;
	}

	public boolean enterGrade(int student, int quiz, double grade) {
		if( validStudent(student) && validQuiz(quiz)) { // valid indices
			gradebook[student][quiz] = grade;
			return true;
		} else {
			System.out.println("Invalid gradebook index. No changes made");
			return false;
		}
	}
	
	public double calculateStudentAverage(int student) {
		if(validStudent(student)) {
			double[] studentGrades = gradebook[student];
			
			double total = 0;
			for(double grade : studentGrades) {
				total += grade;
			}
			return total / studentGrades.length;
			
		} else {
			return -1; // the really accurate thing to do is throw an exception
		}
	}
	
	public double calculateQuizAverage(int quiz) {
		if(validQuiz(quiz)) {
			double total = 0;
			
			for(int i=0; i<numStudents; i++) {
				total += gradebook[i][quiz];
			}
			
			return total/numStudents;
		} else {
			return -1; // the really accurate thing to do is throw an exception
		}
		
	}
	
	private boolean validStudent(int student) {
		return student < numStudents && student >= 0;
	}
	private boolean validQuiz(int quiz) {
		return quiz < numQuizzes && quiz >= 0;
	}
	
	
	
}
