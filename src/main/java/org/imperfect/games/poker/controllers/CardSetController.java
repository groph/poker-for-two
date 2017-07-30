package org.imperfect.games.poker.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import org.imperfect.games.poker.model.Card;
import org.imperfect.games.poker.model.Player;

public final class CardSetController extends HBox {
	
	public CardSetController() {
		setAlignment(Pos.CENTER);
		setPadding(new Insets(15, 12, 15, 12));
		setSpacing(8.0);
		getChildren().addAll(createSlots());
	}
	
	private List<CardSlotController> createSlots() {
		List<CardSlotController> slots = new ArrayList<>();
		for(int i = 0; i < Player.MAX_CARD_COUNT; i++) {
			slots.add(new CardSlotController());
		}
		return slots;
	}
	
	public void setCards(Iterable<Card> cards) {
		Iterator<Card> cardIterator = cards.iterator();
		for(int i = 0; i < Player.MAX_CARD_COUNT; i++) {
			Node node = getChildren().get(i);
			if(CardSlotController.class.isAssignableFrom(node.getClass())) {
				CardSlotController slotController = (CardSlotController) node;
				Card card = cardIterator.next();
				slotController.setCardController(new CardController(card));
			}
		}
	}
	
	public void exposeAll() {
		for(int i = 0; i < Player.MAX_CARD_COUNT; i++) {
			Node node = getChildren().get(i);
			if(CardSlotController.class.isAssignableFrom(node.getClass())) {
				CardSlotController slotController = (CardSlotController) node;
				slotController.getCardController().expose();
			}
		}
	}
	
}
