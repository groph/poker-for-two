package org.imperfect.games.poker.model;

import java.util.Collection;
import java.util.Comparator;
import org.imperfect.games.poker.model.compositions.Flush;
import org.imperfect.games.poker.model.compositions.FourOfAKind;
import org.imperfect.games.poker.model.compositions.FullHouse;
import org.imperfect.games.poker.model.compositions.HighestCard;
import org.imperfect.games.poker.model.compositions.OnePair;
import org.imperfect.games.poker.model.compositions.RolyalFlush;
import org.imperfect.games.poker.model.compositions.Straight;
import org.imperfect.games.poker.model.compositions.StraightFlush;
import org.imperfect.games.poker.model.compositions.ThreeOfAKind;
import org.imperfect.games.poker.model.compositions.TwoPairs;

public class PlayerComparator implements Comparator<Player> {
	
	private static final int COMPOSITION_MULTIPLIER = 10000000;
	
	private Composition winningComposition;
	
	@Override
	public int compare(Player player1, Player player2) {
		HandContent player1Hand = getHandValue(player1.getCards());
		HandContent player2Hand = getHandValue(player2.getCards());
		winningComposition = (player1Hand.strength > player2Hand.strength)?
				player1Hand.composition : player2Hand.composition;
		return player1Hand.strength - player2Hand.strength;
	}
	
	public Composition getWinningComposition() {
		return winningComposition;
	}
	
	private HandContent getHandValue(Collection<Card> cards) {
		int strength;
		if((strength = RolyalFlush.strength(cards)) > 0) {
			return new HandContent(strength, Composition.ROYAL_FLUSH);
		} else if((strength = StraightFlush.strength(cards)) > 0) {
			return new HandContent(strength, Composition.STRAIGHT_FLUSH);
		} else if((strength = FourOfAKind.strength(cards)) > 0) {
			return new HandContent(strength, Composition.FOUR_OF_A_KIND);
		} else if((strength = FullHouse.strength(cards)) > 0) {
			return new HandContent(strength, Composition.FULL_HOUSE);
		} else if((strength = Flush.strength(cards)) > 0) {
			return new HandContent(strength, Composition.FLUSH);
		} else if((strength = Straight.strength(cards)) > 0) {
			return new HandContent(strength, Composition.STRAIGHT);
		} else if((strength = ThreeOfAKind.strength(cards)) > 0) {
			return new HandContent(strength, Composition.THREE_OF_A_KIND);
		} else if((strength = TwoPairs.strength(cards)) > 0) {
			return new HandContent(strength, Composition.TWO_PAIRS);
		} else if((strength = OnePair.strength(cards)) > 0) {
			return new HandContent(strength, Composition.ONE_PAIR);
		} else {
			strength = HighestCard.strength(cards);
			return new HandContent(strength, Composition.HIGHEST_CARD);
		}
	}
	
	private static class HandContent {
		
		private final int strength;
		private final Composition composition;
		
		HandContent(int strength, Composition composition) {
			this.strength = strength
					+ (composition.getStrength() * COMPOSITION_MULTIPLIER);
			this.composition = composition;
		}
		
	}
	
}
