package org.imperfect.games.poker.model.compositions;

import java.util.Collection;
import org.imperfect.games.poker.model.Card;

public class FullHouse {
	
	public static int strength(Collection<Card> cards) {
		int threeOfAKindStrength = ThreeOfAKind.strength(cards);
		int onePairStrength = OnePair.strength(cards);
		if(threeOfAKindStrength > 0 && onePairStrength > 0) {
			return threeOfAKindStrength * 10 + onePairStrength;
		}
		return 0;
	}
	
}
