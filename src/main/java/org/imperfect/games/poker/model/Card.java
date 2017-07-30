package org.imperfect.games.poker.model;

public final class Card {
	
	private final Suit suit;
	private final Value value;
	
	public Card(Value value, Suit suit) {
		this.value = value;
		this.suit = suit;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public Value getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return String.format("%s_%s", suit.name, value.name);
	}
	
	public static enum Value {
		
		NUM_02(2, "02"),
		NUM_03(3, "03"),
		NUM_04(4, "04"),
		NUM_05(5, "05"),
		NUM_06(6, "06"),
		NUM_07(7, "07"),
		NUM_08(8, "08"),
		NUM_09(9, "09"),
		NUM_10(10, "10"),
		JACK(11, "J"),
		QUEEN(12, "Q"),
		KING(13, "K"),
		ACE(14, "A");
		
		public final int strength;
		private final String name;
		
		Value(int strength, String name) {
			this.strength = strength;
			this.name = name;
		}
		
	}
	
	public static enum Suit {
		
		HEART("heart"),
		TILE("tile"),
		CLOVER("clover"),
		PIKE("pike");
		
		private final String name;
		
		Suit(String name) {
			this.name = name;
		}
		
	}
	
}
