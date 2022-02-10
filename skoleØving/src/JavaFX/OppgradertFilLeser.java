package JavaFX;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.text.*;
import javafx.stage.FileChooser;




public class OppgradertFilLeser extends Application {
	
	private TextArea skrivefelt;
	private Button åpne, lagre, nullstill;
	private Label melding;
	private String filnavn = "null";
	private String path;
	private Label filHåndteres;
	
	
	public void start(Stage vindu) {
		
		BorderPane panel = new BorderPane();
		FlowPane topp = new FlowPane();
		topp.setStyle("-fx-padding: 10 10 10 10;");
		topp.setStyle("-fx-background-color: lightBlue;");
		FlowPane bunn = new FlowPane();
		bunn.setStyle("-fx-padding: 10 10 10 10;");
		bunn.setStyle("-fx-background-color: lightBlue;");
	
		
		// starter med toppen av GUI-en
		Label filEtikett = new Label("Fil:");
		åpne = new Button("Åpne");
		lagre = new Button("Lagre");
		filHåndteres = new Label("");
		åpne.setOnAction(e -> lesFraFil());
		lagre.setOnAction(e -> skrivTilFil());
		
		topp.getChildren().addAll(filEtikett, åpne, lagre, filHåndteres);
		panel.setTop(topp);
		topp.setHgap(10);
		
		// lager midten
		Font font = new Font("Courier New", 12);
		skrivefelt = new TextArea();
		skrivefelt.setPrefColumnCount(10);
		skrivefelt.setPrefRowCount(10);
		skrivefelt.setFont(font);
		skrivefelt.setStyle("-fx-background-color: darkBlue;");
		panel.setCenter(skrivefelt);
		
		// lager bunn
		melding = new Label("");
		Label status = new Label("Status  :   ");
		nullstill = new Button("Blanke ark");
		nullstill.setOnAction(e -> nullstill());
		bunn.getChildren().addAll(status, melding, nullstill);
		bunn.setHgap(10);
		panel.setBottom(bunn);
	
		vindu.setResizable(false);
		vindu.setTitle("Supertekster");
		vindu.setScene(new Scene(panel, 400, 400));
		vindu.show();
	}
	
	public void skrivTilFil() {
		String statusmelding = "";
		try {
			String tekst = skrivefelt.getText();
			
			if(filnavn.equals("null")) {
				FileChooser filvelger = new FileChooser();
				PrintWriter skriver = new PrintWriter(filvelger.showSaveDialog(null));
				skriver.println(tekst);
				skriver.close();
				
				statusmelding = "Filen er lagret ok";
			} else {
				PrintWriter skriver = new PrintWriter(path);
				skriver.println(tekst);
				skriver.close();
				statusmelding = "Fil lagret";
			}
		
		} catch (Exception e) {
			statusmelding = "Problem med filen";
		} finally {
			melding.setText(statusmelding);
		}
	}
	
	public void lesFraFil() {
		String statusmelding = "";
		try {
			FileChooser filvelger = new FileChooser();
			File file = filvelger.showOpenDialog(null);
			filnavn = (String)file.getName();
			path = file.getAbsolutePath();
			filHåndteres.setText("Fil som håndteres: " + filnavn);
			
			if(file != null)
				System.out.println("Valgt fil: " + file.getAbsolutePath());
			else
				System.out.println("Ingen fil valgt");
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String inntxt = "";
			String linje = reader.readLine();
			while(linje != null) {
				inntxt += linje + "\n";
				linje = reader.readLine();
			}
			reader.close();
			statusmelding = "Filen ble lagret ok";
			skrivefelt.setText(inntxt);
			
		} catch (Exception e) {
			statusmelding = "Problem med filen";
		} finally {
			melding.setText(statusmelding);
		}
	}
	
	public void nullstill() {
		skrivefelt.setText("");
		filnavn = "null";
		filHåndteres.setText("Fil som håndteres: ");
	}

	public static void main(String[] args) {
		launch(args);
	}
}