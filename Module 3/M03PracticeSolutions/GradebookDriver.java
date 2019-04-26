
public class GradebookDriver {

	public static void main(String[] args) {
		
		Gradebook mathGrades = new Gradebook(6, 10);
		mathGrades.enterGrade(0,  0,  99.5);
		mathGrades.enterGrade(0,  1,  93);
		mathGrades.enterGrade(0,  2,  92);
		mathGrades.enterGrade(0,  3,  88);
		mathGrades.enterGrade(0,  4,  78);
		mathGrades.enterGrade(0,  5,  87.3);
		mathGrades.enterGrade(0,  6,  82.5);
		mathGrades.enterGrade(0,  7,  92);
		mathGrades.enterGrade(0,  8,  91);
		mathGrades.enterGrade(0,  9,  90);
		mathGrades.enterGrade(0, 10, 92);
		mathGrades.enterGrade(5, 5, 45.3);
		mathGrades.enterGrade(6, 5, 88);
		
		System.out.println(mathGrades);
		
		System.out.println(mathGrades.calculateStudentAverage(0));
		System.out.println(mathGrades.calculateQuizAverage(9));

	}
}
