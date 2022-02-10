package JavaFX;

import java.awt.Label;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class ValutaKalkulator extends Application {
	
	private String[] valutakode = {"EUR", "USD", "GBP"};
	private double[] valutakurs = { 9.70, 7.95, 11.05 };
	private Button beregn;
	private TextField inn, ut;
	private ComboBox<String> liste;
	
	
	public void start(Stage vindu) {
		FlowPane panel = new FlowPane();
		panel.setHgap(10);
		
		Button nullstill = new Button("Nullstill");
				
		inn = new TextField();
		inn.setPrefColumnCount(6);
		
		ut = new TextField();
		ut.setPrefColumnCount(6);
		ut.setEditable(false);
		
		liste = new ComboBox<String>();
		liste.getItems().addAll(valutakode);
		liste.setValue("EUR");
		
		beregn = new Button("=");		
		
		panel.getChildren().add(inn);
		panel.getChildren().add(liste);
		panel.getChildren().add(beregn);
		panel.getChildren().add(ut);
		panel.getChildren().add(nullstill);

		inn.setOnAction(e -> regnOm());
		ut.setOnAction(e -> regnOm());
		beregn.setOnAction(e -> regnOm());
		nullstill.setOnAction(e -> nullstill());
		
		Scene scene = new Scene(panel, 350, 100);
		vindu.setTitle("Valutakalkulator");
		vindu.setScene(scene);
		vindu.show();
		

	}
	
	public void nullstill() {
		Label melding = new Label("Faren din!");
		Stage vindu = new Stage();
		FlowPane panel = new FlowPane();
		panel.getChildren().add(new TextArea("FAREN DIN"));
		
		vindu.setScene(new Scene(panel, 100, 100));
		vindu.show();
		
		inn.setText("");
		ut.setText("");
	}
	
	public void regnOm() {
		try {
			double innbeløp = Double.parseDouble(inn.getText());
			int valutaNr = liste.getSelectionModel().getSelectedIndex();
			double dagskurs = valutakurs[valutaNr];
			double utbeløp = innbeløp * dagskurs;
			ut.setText("" + Math.round(utbeløp) + ".00kr");
			
			
		} catch (Exception e) {
			ut.setText("Feil i beløp!");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
