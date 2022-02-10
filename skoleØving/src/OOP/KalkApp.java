package OOP;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KalkApp extends Application {
	
	private static final int BREDDE = 50;
	private static final int HOYDE = 50;
	private static final int ANT_KOLONNER = 4;
	private static final int ANT_RADER = 4;
	
	private String[][] knappTekst = {
			{"7", "8", "9", "+"},
			{"4", "5", "6", "-"},
			{"1", "2", "3", "*"},
			{"0", "+/-", "C", "/"}
	};
		
	private GridPane knappPanel = new GridPane();
	// private TextField display = new TextField();
	private Button erLik = new Button("=");
	
	private Knappelytter lytter = new Knappelytter();
	
	
	@Override
	public void start(Stage vindu) {
		BorderPane rot = new BorderPane();
		
		for(int rad = 0; rad < ANT_RADER; rad++) {
			
			for(int kol = 0; kol < ANT_KOLONNER; kol++) {
				
				final Button knapp = new Button(knappTekst[rad][kol]);
				knappPanel.add(knapp, kol, rad);
				knapp.prefHeightProperty().bind(knappPanel.heightProperty().divide(ANT_KOLONNER));
				knapp.prefWidthProperty().bind(knappPanel.widthProperty().divide(ANT_RADER));
				knapp.setOnAction(lytter);
			}
		}
		
		erLik.prefWidthProperty().bind(rot.widthProperty());
		erLik.setOnAction(lytter);
		
		knappPanel.setPrefSize(BREDDE, HOYDE);
		rot.setTop(lytter.getDisplay());
		rot.setCenter(knappPanel);
		rot.setBottom(erLik);
		
		vindu.setScene(new Scene(rot));
		vindu.setTitle("Kalkulator");
		vindu.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}
