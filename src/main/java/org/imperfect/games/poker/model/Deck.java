package org.imperfect.games.poker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private final List<Card> cards = new ArrayList<>();
	private int currentCardIndex = 0;
	
	public Deck() {
		generateDeck();
		reset();
	}
	
	private void generateDeck() {
		for(Card.Suit suit : Card.Suit.values()) {
			for(Card.Value value : Card.Value.values()) {
				cards.add(new Card(value, suit));
			}
		}
	}
	
	public final void reset() {
		Collections.shuffle(cards);
		currentCardIndex = 0;
	}
	
	public Card pickRandomCard() {
		Card card = cards.get(currentCardIndex);
		currentCardIndex++;
		return card;
	}
	
}
