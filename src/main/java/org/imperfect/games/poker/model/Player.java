package org.imperfect.games.poker.model;

import java.util.Arrays;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Player {
	
	public static final int MAX_CARD_COUNT = 5;
	private final Card[] cardArray = new Card[MAX_CARD_COUNT];
	private final Iterable<Card> cards = Arrays.asList(cardArray);
	private final StringProperty name = new SimpleStringProperty("");
	
	public Player() {
		setName("");
	}
	
	public Player(String name) {
		setName(name);
	}
	
	public final String getName() {
		return name.get();
	}
	
    public final void setName(String value) {
		name.set(value);
	}
	
    public StringProperty nameProperty() {
		return name;
	}
	
	public Iterable<Card> getCards() {
		return cards;
	}
	
	public void exchangeCard(Card from, Card to) {
		for(int i = 0; i < MAX_CARD_COUNT; i++) {
			if(from.equals(cardArray[i])) {
				cardArray[i] = to;
				return;
			}
		}
		throw new IllegalArgumentException("Don't have the selected card!");
	}
	
	public void pickUp(Card card) {
		for(int i = 0; i < MAX_CARD_COUNT; i++) {
			if(cardArray[i] == null) {
				cardArray[i] = card;
				return;
			}
		}
		throw new IllegalArgumentException("Can't hold more cards!");
	}
	
	public void clearHand() {
		for(int i = 0; i < MAX_CARD_COUNT; i++) {
			cardArray[i] = null;
		}
	}
	
}
