package org.imperfect.games.poker.controllers;

import java.net.URL;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.imperfect.games.poker.model.Card;

public final class CardController extends AnchorPane {
	
	private static final Image BACK_IMAGE = new Image(
			CardController.class.getResource("/images/back.png").toString());
	
	private final ImageView imageView = new ImageView(BACK_IMAGE);
	private final Image image;
	
	public CardController(Card card) {
		imageView.setPreserveRatio(true);
		imageView.setSmooth(true);
		imageView.setFitHeight(185.5621);
		imageView.setFitWidth(128.0);
		image = createImage(card);
		getChildren().add(imageView);
	}
	
	private Image createImage(Card card) {
		URL frontImgUrl = getClass().getResource(
					String.format("/images/%s.png", card.toString()));
		return new Image(frontImgUrl.toString());
	}
	
	public void expose() {
		imageView.setImage(image);
	}
	
}
