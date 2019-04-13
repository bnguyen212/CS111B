
public class FractionTester {

	public static void main(String[] args) {
		Fraction frac1 = new Fraction(1, 2);
		Fraction frac2 = new Fraction(2, 3);
		Fraction frac3 = new Fraction(2, 5);
		
		/*
		System.out.println("numerator of frac1 is " + frac1.getNumerator());
		System.out.println("denominoator of frac1 is " + frac1.getDenominator());
		
		frac3.setDenominoator(10);
		System.out.println("denominoator of frac3 is " + frac3.getDenominator());
		frac3.setDenominoator(0);
		System.out.println("denominoator of frac3 is " + frac3.getDenominator());
		
		System.out.println(frac3);
		System.out.println(frac2);
		System.out.println(frac2.getValue());
		*/
		Fraction frac4 = new Fraction(2, 9);
		Fraction frac5 = new Fraction(3, 15);
		Fraction frac6 = new Fraction(1, 2);
		Fraction frac7 = new Fraction(2, 8);
		Fraction frac8 = new Fraction(4, 2);
		Fraction frac9 = new Fraction(5, 3);
		Fraction frac10 = new Fraction(4, 3);
		System.out.println(frac9.isReduced());
		
		Fraction reducedFrac7 = frac7.createNewReducedFraction();
		System.out.println(frac7);
		System.out.println(reducedFrac7);
		System.out.println( frac8.createNewReducedFraction().getValue());
		
		System.out.println("Lowest common denominator of " + frac5 + " and " + frac8 + " is " + frac5.lowestCommonDenominator(frac8));
		System.out.println("Lowest common denominator of " + frac6 + " and " + frac7 + " is " + frac6.lowestCommonDenominator(frac7));
		System.out.println("Lowest common denominator of " + frac9 + " and " + frac10 + " is " + frac9.lowestCommonDenominator(frac10));
		
		/*
		System.out.println(frac4);
		frac5.demonstrationMethod(frac4);
		System.out.println(frac4);
		*/
	}

}
