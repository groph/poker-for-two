package org.imperfect.games.poker.model;

public class DetailedOutcome {
	
	private final Outcome outcome;
	private final Composition winningComposition;
	
	public DetailedOutcome(Outcome outcome, Composition winningComposition) {
		this.outcome = outcome;
		this.winningComposition = winningComposition;
	}
	
	public Outcome getOutcome() {
		return outcome;
	}
	
	public Composition getWinningComposition() {
		return winningComposition;
	}
	
	public static enum Outcome {
		
		PLAYER_WON("outcome_player_won"),
		PLAYER_LOST("outcome_player_lost"),
		DRAW("outcome_draw");
		
		private final String name;
		
		Outcome(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
	}
	
}
