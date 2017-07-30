package org.imperfect.games.poker.controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import org.imperfect.games.poker.controllers.events.DealEvent;

public final class DeckController extends StackPane {
	
	private static final Image BACK_IMAGE = new Image(
			CardController.class.getResource("/images/back.png").toString());
	
	private final ImageView imageView = new ImageView(BACK_IMAGE);
	
	public DeckController() {
		setAlignment(Pos.CENTER_LEFT);
		setPadding(new Insets(24));
		imageView.getStyleClass().add("deck");
		
		imageView.setPreserveRatio(true);
		imageView.setSmooth(true);
		imageView.setFitHeight(185.5621);
		imageView.setFitWidth(128.0);
		
		getChildren().add(imageView);
		imageView.setOnMouseClicked((evt) -> {
			this.fireEvent(new DealEvent());
		});
	}
	
}
