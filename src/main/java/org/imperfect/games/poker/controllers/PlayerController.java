package org.imperfect.games.poker.controllers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.BorderPane;
import org.imperfect.games.poker.model.DetailedOutcome;

public final class PlayerController extends BorderPane {
	
	private final NameController nameController = new NameController();
	private final ComparatorController comparatorController = new ComparatorController();
	private final OutcomeController outcomeController = new OutcomeController();
	
	public PlayerController() {
		getStyleClass().add("player-controller");
		
		setLeft(nameController);
		setCenter(outcomeController);
		setRight(comparatorController);
	}
	
	public final String getName() {
		return nameController.getText();
	}
	
    public final void setName(String value) {
		nameController.setText(value);
	}
	
    public StringProperty nameProperty() {
		return nameController.textProperty();
	}
	
	public boolean setEnableCompareButton() {
		return comparatorController.disableProperty().get();
	}
	
	public void setEnableCompareButton(boolean value) {
		comparatorController.disableProperty().set(value);
	}
	
	public BooleanProperty enableCompareButtonProperty() {
		return comparatorController.disableProperty();
	}
	
	public void setOutcome(DetailedOutcome outcome) {
		outcomeController.setOutcome(outcome);
	}
	
	public void clearOutcome() {
		outcomeController.clear();
	}
	
}
