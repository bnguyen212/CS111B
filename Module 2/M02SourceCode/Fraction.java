public class Fraction {
	
	private int numerator, denominator;
	
	public Fraction(int initialNumerator, int initialDenominator) {
		numerator = initialNumerator;
		denominator = initialDenominator;
	}	
	public int getNumerator() {
		return numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	public void setNumerator(int newNumerator) {
		numerator = newNumerator;
	}
	public void setDenominoator(int newDenominator) {
		if(newDenominator != 0) {
			denominator = newDenominator;
		} 
	}
	public String toString() {
		return numerator + "/" + denominator;
	}
	public double getValue() {
		return (1.0 * numerator) / ( (double) denominator);
	}
	public boolean isReduced() {
		return greatestCommonFactor(numerator, denominator) == 1;
	}
	private int findSmaller(int number1, int number2) {
		if(number1 < number2) {
			return number1;
		} else { // number1 >= number2
			return number2;
		}
	}
	private int greatestCommonFactor(int number1, int number2) {
		int greatestCommonFactor = 1;
		int maxFactorToCheck = findSmaller(number1, number1);
		for(int possibleFactor = 1; possibleFactor <= maxFactorToCheck; possibleFactor++) {
			if(number1 % possibleFactor == 0  && number2 % possibleFactor == 0) {
				greatestCommonFactor = possibleFactor;
			}
		}
		return greatestCommonFactor;
	}
	public void reduce() {
		// reduces the current fraction
	}
	public Fraction createNewReducedFraction() {
		if(isReduced()) {
			return new Fraction(numerator, denominator);
		} else { // not reduced
			int greatestCommonFactor = greatestCommonFactor(numerator, denominator);
			int reducedNumerator = numerator / greatestCommonFactor;
			int reducedDenominator = denominator / greatestCommonFactor;
			return new Fraction(reducedNumerator, reducedDenominator);
		}
	}
	
	public int lowestCommonDenominator(Fraction otherFraction) {
		// lowest common multiple = (a*b) / gcd(a,b)
		int lcmNum = denominator * otherFraction.denominator; // a*b
		int lcmDen = greatestCommonFactor(denominator, otherFraction.denominator); // gcd(a, b)
		return lcmNum / lcmDen;
	}
	
	/*
	public void demonstrationMethod(Fraction otherFraction) {
		// otherFraction.denominator = otherFraction.denominator * 2;
		otherFraction = new Fraction(otherFraction.numerator, otherFraction.denominator * 2); 
		System.out.println(otherFraction);
	}
	*/
	
	
	
	
	
}
