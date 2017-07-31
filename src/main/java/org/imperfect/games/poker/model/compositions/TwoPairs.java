package org.imperfect.games.poker.model.compositions;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import org.imperfect.games.poker.model.Card;

public class TwoPairs {
	
	public static int strength(Collection<Card> cards) {
		Map<Integer, Long> occurances = cards.stream().collect(
				Collectors.groupingBy(
						c -> c.getStrength(), Collectors.counting()));
		occurances.entrySet().removeIf(e -> e.getValue() != 2);
		if(occurances.size() != 2) {
			return 0;
		}
		int[] values = occurances.entrySet().stream()
				.mapToInt(e -> e.getKey()).toArray();
		
		return (values[0] * 200)  + (values[1] * 20)
				+ HighestCard.strength(cards);
	}
	
}
