import java.util.*;

public class CardTester {

	public static void main(String[] args) {

		Deck deck = new Deck(true);
		System.out.println(deck);
		
		deck.sort();
		System.out.println("After sorting:");
		System.out.println(deck);
		
		List<Card> hand = new ArrayList<Card>();
		int handSize = 5;
		
		deck.shuffle();
		for(int i=0; i<handSize; i++) {
			hand.add(deck.deal());
		}
		
		System.out.println(hand);
		Collections.sort(hand);
		System.out.println(hand);
		
	}

}
