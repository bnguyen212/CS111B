import java.util.*;


public class Deck {
	
	private List<Card> deck;
	
	public Deck(boolean shuffle) {
		deck = new ArrayList<Card>();
		fillDeck();
		if(shuffle) {
			shuffle();
		}
	}
	
	private void fillDeck() {
		deck.clear();
		for(Card.Suit suit : Card.Suit.values()) { // values will return Suit[] containing all possible value
			for(Card.Value value : Card.Value.values()) {
				Card card = new Card(suit, value);
				deck.add(card);
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Card card : deck) {
			sb.append(card.toString() + "\n");
		}
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Deck) {
			Deck otherDeck = (Deck) obj;
			return deck.equals(otherDeck.deck);
		} else {
			return false;
		}
	}
	
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public void sort() {
		Collections.sort(deck);
	}
	
	public Card deal() {
		if(deck.size() > 0) {
			Card card = deck.remove(0);
			System.out.println(card);
			return card;
		} else {
			System.out.println("Cannot deal from an empty deck.");
			return null;
		}
	}
	
}
