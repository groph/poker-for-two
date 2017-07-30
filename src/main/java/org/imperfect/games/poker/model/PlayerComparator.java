package org.imperfect.games.poker.model;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {
	
	private Composition winningComposition;
	
	@Override
	public int compare(Player o1, Player o2) {
		//TODO: Compare.
		winningComposition = Composition.ROYAL_FLUSH;
		return 0;
	}
	
	public Composition getWinningComposition() {
		return winningComposition;
	}
	
}
