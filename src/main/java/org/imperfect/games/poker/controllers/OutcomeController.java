package org.imperfect.games.poker.controllers;

import java.text.MessageFormat;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.imperfect.games.poker.Configuration;
import org.imperfect.games.poker.model.DetailedOutcome;
import org.imperfect.games.poker.model.DetailedOutcome.Outcome;

public final class OutcomeController extends VBox {
	
	private final Label outcomeLabel = new Label();
	private final Label outcomeDetailsLabel = new Label();
	
	public OutcomeController() {
		getStyleClass().add("outcome-box");
		
		outcomeLabel.getStyleClass().add("outcome");
		outcomeDetailsLabel.getStyleClass().add("outcome-detail");
		
		getChildren().addAll(outcomeLabel, outcomeDetailsLabel);
	}
	
	public void setOutcome(DetailedOutcome outcome) {
		String outcomeName = outcome.getOutcome().getName();
		String outcomeText = Configuration.DICTIONARY.getString(outcomeName);
		outcomeLabel.setText(outcomeText);
		
		String detailText = getDetailedOutcome(outcome);
		outcomeDetailsLabel.setText(detailText);
	}
	
	private String getDetailedOutcome(DetailedOutcome outcome) {
		String compositionName = outcome.getWinningComposition().getName();
		MessageFormat formatter = createMessageFormat(outcome);
		String[] aguments = {
			Configuration.DICTIONARY.getString(compositionName)
		};
		String str = formatter.format(aguments);
		
		return str.isEmpty()? str : String.format("%s%s",
				str.substring(0, 1).toUpperCase(), str.substring(1));
	}
	
	private MessageFormat createMessageFormat(DetailedOutcome outcome) {
		MessageFormat formatter = new MessageFormat("");
		formatter.setLocale(Configuration.DICTIONARY.getLocale());
		if(outcome.getOutcome() == Outcome.PLAYER_WON) {
			formatter.applyPattern(
					Configuration.DICTIONARY.getString("win_detail_template"));
		} else if(outcome.getOutcome() == Outcome.PLAYER_LOST) {
			formatter.applyPattern(
					Configuration.DICTIONARY.getString("lose_detail_template"));
		}
		return formatter;
	}
	
	public void clear() {
		outcomeLabel.setText("");
		outcomeDetailsLabel.setText("");
	}
	
}
