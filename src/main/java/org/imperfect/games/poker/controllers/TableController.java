package org.imperfect.games.poker.controllers;

import javafx.scene.layout.BorderPane;
import org.imperfect.games.poker.controllers.events.ComparisonEvent;
import org.imperfect.games.poker.controllers.events.DealEvent;
import org.imperfect.games.poker.model.DetailedOutcome;
import org.imperfect.games.poker.model.Player;
import org.imperfect.games.poker.services.GameService;

public class TableController extends BorderPane {
	
	private final GameService gameService;
	private final Player opponent;
	private final Player player;
	
	private final PlayerController playerController = new PlayerController();
	private final CardSetController opponentCardSet = new CardSetController();
	private final CardSetController playerCardSet = new CardSetController();
	private final DeckController deckController = new DeckController();
	private final Object actionLock = new Object();
	
	public TableController(GameService gameService) {
		this.gameService = gameService;
		opponent = gameService.getOpponent();
		player = gameService.getPlayer();
		
		getStyleClass().add("table");
		
		setupPlayground();
		setupPlayerController();
	}
	
	private void setupPlayground() {
		BorderPane innerPane = new BorderPane();
		opponentCardSet.setDisable(true);
		innerPane.setTop(opponentCardSet);
		
		deckController.addEventHandler(DealEvent.DEAL, this::onNewDeal);
		innerPane.setCenter(deckController);
		
		innerPane.setBottom(playerCardSet);
		setCenter(innerPane);
	}
	
	private void setupPlayerController() {
		playerController.nameProperty().bind(player.nameProperty());
		playerController.enableCompareButtonProperty()
				.bind(gameService.notComparableProperty());
		playerController.addEventHandler(ComparisonEvent.COMPARSION, this::onComparison);
		setBottom(playerController);
	}
	
	private void onNewDeal(DealEvent evt) {
		synchronized(actionLock) {
			playerController.clearOutcome();
			gameService.deal();
			playerCardSet.setCards(player.getCards());
			opponentCardSet.setCards(opponent.getCards());
			playerCardSet.exposeAll();
		}
	}
	
	private void onComparison(ComparisonEvent evt) {
		synchronized(actionLock) {
			DetailedOutcome outcome = gameService.compare();
			opponentCardSet.exposeAll();
			playerCardSet.exposeAll();
			playerController.setOutcome(outcome);
		}
	}
	
}
