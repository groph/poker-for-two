package org.imperfect.games.poker.model.compositions;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.imperfect.games.poker.model.Card;

public class Straight {
	
	public static int strength(Collection<Card> cards) {
		int[] values = cards.stream()
				.mapToInt(c -> c.getStrength())
				.sorted().toArray();
		
		boolean isStraight = IntStream.range(0, values.length - 1)
				.map(i -> values[i + 1] - values[i]).allMatch(val -> val == 1);
		
		
		if(!isStraight) {
			return 0;
		}
		return values[values.length - 1];
	}
	
}
