package JavaFX;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Første extends Application {
	
	public void start(Stage vindu) {
		FlowPane panel = new FlowPane();
		panel.setHgap(10);
		
		Label etikett = new Label("Brukernavn");
		TextField brukernavn = new TextField();
		
		Label etikettPassord = new Label("Passord");
		TextField passord = new TextField();
		
		passord.setPrefColumnCount(25);
		brukernavn.setPrefColumnCount(25);
		
		panel.getChildren().add(etikett);
		panel.getChildren().add(brukernavn);
		panel.getChildren().add(etikettPassord);
		panel.getChildren().add(passord);
		
		Scene scene = new Scene(panel, 400, 250);
		vindu.setScene(scene);
		vindu.setTitle("Innlogging");
		vindu.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
