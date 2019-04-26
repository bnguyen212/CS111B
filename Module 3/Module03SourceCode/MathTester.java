import java.text.NumberFormat;

public class MathTester {

	public static void main(String[] args) {
		double d1 = 4.0, d2 = 4.1, d3 = 4.5, d4 = 4.9;
		
		int roundD1 = (int) Math.round(d1); // returns a long- must be cast to an int!
		int floorD1 = (int) Math.round(Math.floor(d1)); // returns as a double- must be cast to an int! but, i should always round first!
		int ceilD1 = (int) Math.round(Math.ceil(d1)); // same as above
		System.out.println(d1 + " rounds to " + roundD1 + " and floor is " + floorD1 + " and ceiling is " + ceilD1);
		
		int roundD2 = (int) Math.round(d2);
		int floorD2 = (int) Math.round(Math.floor(d2)); 
		int ceilD2 = (int) Math.round(Math.ceil(d2));
		System.out.println(d2 + " rounds to " + roundD2 + " and floor is " + floorD2 + " and ceiling is " + ceilD2);
		
		int roundD3 = (int) Math.round(d3);
		int floorD3 = (int) Math.round(Math.floor(d3)); 
		int ceilD3 = (int) Math.round(Math.ceil(d3));
		System.out.println(d3 + " rounds to " + roundD3 + " and floor is " + floorD3 + " and ceiling is " + ceilD3);
		
		int roundD4 = (int) Math.round(d4);
		int floorD4 = (int) Math.round(Math.floor(d4)); 
		int ceilD4 = (int) Math.round(Math.ceil(d4));
		System.out.println(d4 + " rounds to " + roundD4 + " and floor is " + floorD4 + " and ceiling is " + ceilD4);
		
		System.out.println(Math.sqrt(100));
		System.out.println(Math.sqrt(37));
		System.out.println(Math.pow(2, 16)); //2^16
		

		NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
		String moneyOutput = moneyFormatter.format(99.99999);
		System.out.println(moneyOutput);
		
		NumberFormat percentFormatter = NumberFormat.getPercentInstance();
		String percentOutput = percentFormatter.format(0.5);
		System.out.println(percentOutput);
		

	}

}
