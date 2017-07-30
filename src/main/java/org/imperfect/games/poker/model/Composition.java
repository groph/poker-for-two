package org.imperfect.games.poker.model;

public enum Composition {
	ROYAL_FLUSH(10, "rolyal flush"),
	STRAIGHT_FLUSH(9, "straight flush"),
	FOUR_OF_A_KIND(8, "four of a kind"),
	FULL_HOUSE(7, "full house"),
	FLUSH(6, "flush"),
	STRAIGHT(5, "straight"),
	THREE_OF_A_KIND(4, "three of a kind"),
	TWO_PAIRS(3, "two pairs"),
	ONE_PAIR(2, "one pair"),
	HIGHEST_CARD(1, "highest card");
	
	private final String name;
	private final int strength;
	
	Composition(int strength, String name) {
		this.strength = strength;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getStrength() {
		return strength;
	}
	
}
