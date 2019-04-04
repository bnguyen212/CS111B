import java.util.Scanner;


public class MinOfThree {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the first value: ");
		int value1 = scan.nextInt();
		
		System.out.println("Enter the second value: ");
		int value2 = scan.nextInt();
		
		System.out.println("Enter the third value: ");
		int value3 = scan.nextInt();
		
		int smallest = findMinOfThree(value1, value2, value3);
		System.out.println("The minimum of these numbers is " + smallest);
	}
	
	public static int findMinOfThree(int n1, int n2, int n3) {
		
		if(n1 <= n2 && n1 <= n3) {
			return n1;
		} else if(n2 <= n1 && n2 <= n3) {
			return n2;
		} else  { // n3 <= n1 && n3 <= n2
			return n3;
		}

		
	}
	

}
