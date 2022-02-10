package JavaFX;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField; 
import javafx.event.ActionEvent;


public class KnappeTest extends Application {
	
	private int antall = 0;
	private Button knapp;
	private TextField tekstfelt;
	
	
	public void start(Stage vindu) {
		BorderPane panel = new BorderPane();
		BorderPane cp = new BorderPane();
		
		knapp = new Button("Klikk her!");
		knapp.setOnAction(e -> behandleKlikk(e));
		panel.setTop(knapp);
		
		panel.setCenter(cp);
		String[] alternativ = {"Moren din", "Faren din", "Onkelen din", "Tanta di"};
		ComboBox<String> liste = new ComboBox<String>();
		liste.getItems().addAll(alternativ);
		cp.setCenter(liste);
		
		tekstfelt = new TextField();
		tekstfelt.setPrefColumnCount(15);
		panel.setBottom(tekstfelt);
		Scene scene = new Scene(panel, 300, 100);
		
		vindu.setTitle("Knappetrykking");
		vindu.setScene(scene);
		vindu.show();
	}
	
	
	public void behandleKlikk(ActionEvent event) {
		if(antall < 5) {
			antall++;
			tekstfelt.setText("Antall klikk = " + antall);
		} else {
			antall++;
			tekstfelt.setText("Faren din = " + antall);
		}
	}
	

	public static void main(String[] args) {
		launch(args);

	}

}
