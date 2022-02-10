package JavaFX;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;


public class KlikkApp extends Application {
	
	private int antAv1 = 0, antAv2 = 0;
	private Button knapp1, knapp2, nullstill;
	private TextField tekst1, tekst2;
	
	
	public void start(Stage vindu) {
		FlowPane panel = new FlowPane();
		
		// Deklarerer teksten
		tekst1 = new TextField();
		tekst2 = new TextField();
		tekst1.setPrefColumnCount(15);
		tekst2.setPrefColumnCount(15);
		
		// Deklarerer knappene
		knapp1 = new Button("Knapp 1");
		knapp2 = new Button("Knapp 2");
		nullstill = new Button("Nullstill");
		
		// Hendelsestyring
		knapp1.setOnAction(e -> klikk(e));
		knapp2.setOnAction(e -> klikk(e));
		nullstill.setOnAction(e -> klikk(e));
		
		// Legger til i panelet
		panel.getChildren().addAll(knapp1, tekst1, knapp2, tekst2, nullstill);
		
		// Setter Scenen alt skal vises på
		Scene scene = new Scene(panel);
		vindu.setTitle("KnappeKødd");
		vindu.setScene(scene);
		vindu.show();
		vindu.setResizable(false);
		
		
	}
	
	
	public void klikk(ActionEvent e) {
		if(e.getSource() == knapp1) {
			antAv1++;
			tekst1.setText("Antall klikk = " + antAv1);
		}
		else if (e.getSource() == knapp2) {
			antAv2++;
			tekst2.setText("Antall klikk = " + antAv2);
		}
		else if (e.getSource() == nullstill) {
			antAv1 = 0;
			antAv2 = 0;
			tekst1.setText("");
			tekst2.setText("");
		}
	}
	

	public static void main(String[] args) {
		launch(args);
	}

}
