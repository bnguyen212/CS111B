
public class Card  implements Comparable<Card> {
	
	public static enum Suit { SPADES, CLUBS, HEARTS, DIAMONDS }
	
	public static enum Value {
		ACE (1, false),
		ONE (1, false), TWO (2, false), THREE (3, false), FOUR (4, false), FIVE (5, false), SIX (6, false), SEVEN (7, false), EIGHT (8, false), NINE (9, false), TEN (10, false),
		JACK (10, true), QUEEN (10, true), KING (10, true)	;
		
		private int value;
		private boolean faceCard;
		
		private Value(int value, boolean faceCard) {
			this.value = value;
			this.faceCard = faceCard;
		}
		
		public int getValue() {
			return value;
		}
		
		public boolean isFaceCard() {
			return faceCard;
		}
		
	}
	
	
	private Suit suit;
	private Value value;
	
	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public int getValue() {
		return value.getValue();
	}
	
	public boolean isFaceCard() {
		return value.isFaceCard();
	}
	
	@Override
	public String toString() {
		return value + " of " + suit;
	}
	
	@Override
	public boolean equals(Object object) {
		if(object instanceof Card) {
			Card otherCard = (Card) object;
			
			return this.suit.equals(otherCard.suit) && this.value.equals(otherCard.value);
		} else {
			return false;
		}
	}
	
	
	@Override
	public int compareTo(Card otherCard) {
		/* one possibility- order by suit, then number
		if(this.suit.equals(otherCard.suit)) {
			return this.value.compareTo(otherCard.value);
		} else { // suits are different
			return this.suit.compareTo(otherCard.suit);
		}
		*/
		// a second possibility- order by number, then suit
		if(! (this.value.compareTo(otherCard.value)==0) ) {
			return this.value.compareTo(otherCard.value);
		} else { // values are the same
			return this.suit.compareTo(otherCard.suit);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
