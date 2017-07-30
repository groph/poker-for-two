package org.imperfect.games.poker.controllers;

import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public final class NameController extends StackPane {
	
	private final Label nameLabel = new Label();
	
	public NameController() {
		nameLabel.getStyleClass().add("player-name");
		setAlignment(Pos.CENTER);
		getChildren().add(nameLabel);
	}
	
	public final String getText() {
		return nameLabel.getText();
	}
	
    public final void setText(String value) {
		nameLabel.setText(value);
	}
	
    public StringProperty textProperty() {
		return nameLabel.textProperty();
	}
	
}
