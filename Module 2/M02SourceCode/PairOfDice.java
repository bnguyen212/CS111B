
public class PairOfDice {
	
	private Die die1, die2;
	
	public PairOfDice() {
		die1 = new Die(1);
		die1.roll();
		
		die2 = new Die(1);
		die2.roll();
	}
	
	public Die getDie1() {
		return die1;
	}
	public Die getDie2() {
		return die2;
	}
	
	public String toString() {
		String s = "Die 1: " + die1.getFaceValue() + "; Die 2: " + die2.getFaceValue();
		return s;
	}
	
	public int roll() {
		return die1.roll() + die2.roll();
	}
	
	public boolean isDoubles() {
		if(die1.getFaceValue() == die2.getFaceValue()) {
			return true;
		} else {
			return false;
		}
	}
	

}
