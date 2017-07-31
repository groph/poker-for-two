package org.imperfect.games.poker.model.compositions;

import java.util.Collection;
import org.imperfect.games.poker.model.Card;

public class StraightFlush {
	
	public static int strength(Collection<Card> cards) {
		int strength = Straight.strength(cards);
		if(strength > 0 && Flush.strength(cards) > 0) {
			return strength;
		}
		return 0;
	}
	
}
