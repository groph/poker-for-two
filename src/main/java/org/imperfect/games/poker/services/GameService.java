package org.imperfect.games.poker.services;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import org.imperfect.games.poker.model.Deck;
import org.imperfect.games.poker.model.DetailedOutcome;
import org.imperfect.games.poker.model.DetailedOutcome.Outcome;
import org.imperfect.games.poker.model.Player;
import org.imperfect.games.poker.model.PlayerComparator;

public class GameService {
	
	private final Player player;
	private final Player opponent;
	private final Deck deck = new Deck();
	private final BooleanProperty notComparable = new SimpleBooleanProperty(true);
	
	public GameService(String playerName) {
		player = new Player(playerName);
		opponent = new Player();
	}
	
	public Player getOpponent() {
		return opponent;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Deck getDeck() {
		return deck;
	}
	
	public boolean isNotComparable() {
		return notComparable.get();
	}
	
	public BooleanProperty notComparableProperty() {
		return notComparable;
	}
	
	private void setIsNotComparable(boolean value) {
		notComparable.set(value);
	}
	
	public void deal() {
		deck.reset();
		player.clearHand();
		opponent.clearHand();
		for(int i = 0; i < Player.MAX_CARD_COUNT; i++) {
			player.pickUp(deck.pickRandomCard());
			opponent.pickUp(deck.pickRandomCard());
		}
		setIsNotComparable(false);
	}
	
	public DetailedOutcome compare() {
		PlayerComparator comparator = new PlayerComparator();
		Outcome outcome = compareWithOutcome(comparator);
		setIsNotComparable(true);
		return new DetailedOutcome(outcome, comparator.getWinningComposition());
	}
	
	private Outcome compareWithOutcome(PlayerComparator comparator) {
		int comparatorOutcome = comparator.compare(player, opponent);
		Outcome outcome;
		if(comparatorOutcome < 0) {
			outcome = DetailedOutcome.Outcome.PLAYER_LOST;
		} else if(comparatorOutcome > 0) {
			outcome = DetailedOutcome.Outcome.PLAYER_WON;
		} else {
			outcome = DetailedOutcome.Outcome.DRAW;
		}
		return outcome;
	}
	
	public void reset() {
		player.clearHand();
		opponent.clearHand();
		deck.reset();
		setIsNotComparable(false);
	}
	
}
