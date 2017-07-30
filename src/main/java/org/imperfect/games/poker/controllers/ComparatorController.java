package org.imperfect.games.poker.controllers;

import javafx.beans.property.BooleanProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import org.imperfect.games.poker.controllers.events.ComparisonEvent;

public final class ComparatorController extends StackPane {
	
	private static final Image COIN_IMAGE = new Image(
			CardController.class.getResource("/images/euro.png").toString());
	
	private final ImageView imageView = new ImageView(COIN_IMAGE);
	
	public ComparatorController() {
		imageView.setPreserveRatio(true);
		imageView.setSmooth(true);
		imageView.setFitHeight(64.0);
		imageView.setFitWidth(64.0);
		imageView.addEventHandler(
				MouseEvent.MOUSE_CLICKED, this::onComparatorClicked);
		imageView.getStyleClass().add("compare-button");
		getChildren().add(imageView);
	}
	
	public boolean setEnableCompareButton() {
		return imageView.disableProperty().get();
	}
	
	public void setEnableCompareButton(boolean value) {
		imageView.disableProperty().set(value);
	}
	
	public BooleanProperty enableCompareButtonProperty() {
		return imageView.disableProperty();
	}
	
	private void onComparatorClicked(MouseEvent evt) {
		fireEvent(new ComparisonEvent());
	}
	
}
