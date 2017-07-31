package org.imperfect.games.poker;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.imperfect.games.poker.controllers.TableController;
import org.imperfect.games.poker.services.GameService;

public class MainApp extends Application {
	
	private static final Image APP_ICON = new Image(
			MainApp.class.getResource("/images/app-icon.png").toString());
	
	private final GameService gameService = new GameService(
			System.getProperty("user.name"));
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = new TableController(gameService);
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(Configuration.STYLESHEET_LOCATION);
		
		stage.setTitle(Configuration.DICTIONARY.getString("poker_for_two"));
		stage.getIcons().add(APP_ICON);
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * The main() method is ignored in correctly deployed JavaFX application.
	 * main() serves only as fallback in case the application can not be
	 * launched through deployment artifacts, e.g., in IDEs with limited FX
	 * support. NetBeans ignores main().
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}
