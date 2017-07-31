package org.imperfect.games.poker.model.compositions;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import org.imperfect.games.poker.model.Card;

public class FourOfAKind {
	
	public static int strength(Collection<Card> cards) {
		Map<Integer, Long> occurances = cards.stream().collect(
				Collectors.groupingBy(
						c -> c.getStrength(), Collectors.counting()));
		occurances.entrySet().removeIf(e -> e.getValue() < 4);
		if(occurances.size() < 1) {
			return 0;
		}
		return occurances.entrySet().stream()
				.mapToInt(e -> e.getKey()).sum() * 4;
	}
	
}
