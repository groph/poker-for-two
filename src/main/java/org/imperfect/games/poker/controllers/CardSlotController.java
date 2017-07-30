package org.imperfect.games.poker.controllers;

import javafx.scene.layout.AnchorPane;

public class CardSlotController extends AnchorPane {
	
	public CardSlotController() {
		getStyleClass().add("card-slot");
	}
	
	public CardController getCardController() {
		return (CardController) getChildren().get(0);
	}
	
	public void setCardController(CardController value) {
		getChildren().clear();
		getChildren().add(value);
	}
	
}
