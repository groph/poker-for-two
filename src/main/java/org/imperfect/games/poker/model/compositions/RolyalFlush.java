package org.imperfect.games.poker.model.compositions;

import java.util.Collection;
import org.imperfect.games.poker.model.Card;

public class RolyalFlush {
	
	private static final int ACE_STRENGTH = new Card(
			Card.Value.ACE, Card.Suit.HEART).getStrength();
	
	public static int strength(Collection<Card> cards) {
		int strength = Straight.strength(cards) / 1000;
		if(strength > 0 && Flush.strength(cards) > 0) {
			if(isAceTheMaxCard(cards)) {
				return ACE_STRENGTH * 5;
			}
		}
		return 0;
	}
	
	private static boolean isAceTheMaxCard(Collection<Card> cards) {
		int maxVal = cards.stream()
				.mapToInt(c -> c.getStrength()).max().getAsInt();
		return ACE_STRENGTH == maxVal;
	}
	
}
