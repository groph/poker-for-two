package org.imperfect.games.poker.model.compositions;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import org.imperfect.games.poker.model.Card;
import org.imperfect.games.poker.model.Card.Suit;
import org.imperfect.games.poker.model.Player;

public class Flush {
	
	public static int strength(Collection<Card> cards) {
		Map<Suit, Long> occurances = cards.stream().collect(
				Collectors.groupingBy(
						c -> c.getSuit(), Collectors.counting()));
		occurances.entrySet().removeIf(e -> e.getValue() < Player.MAX_CARD_COUNT);
		if(occurances.size() < 1) {
			return 0;
		}
		int[] values = cards.stream().mapToInt(c -> c.getStrength())
				.sorted().toArray();
		int strength = 0;
		int multiplier = 1;
		for(int value : values) {
			strength += (multiplier * value);
			multiplier *=10;
		}
		return strength;
	}
	
}
