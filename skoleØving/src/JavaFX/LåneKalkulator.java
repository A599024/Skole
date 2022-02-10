package JavaFX;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import javafx.geometry.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Scanner;
import java.text.ParseException;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.text.*;

public class LåneKalkulator extends Application {
	
	private TextField lånebeløp, årligRente, terminbeløp;
	private Label årInfo;
	private Slider antallÅr;
	
	private double rente = 2.5;
	private double beløp = 2_500_000;
	private double år = 20;
	
	private double mnd = år * 12;
	private double mdnRente = Math.pow((1 + rente / 100), (1.0/12) - 1);
	
	public void start(Stage vindu) {
		GridPane panel = new GridPane();
		final int LUFT = 10;
		
		panel.setPadding(new Insets(LUFT, LUFT, LUFT, LUFT));
		panel.setHgap(LUFT);
		panel.setVgap(LUFT);
		
		Font font = new Font("Harward", 18);
		
		
		Label lånEtikett = new Label("Lånebeløp:");
		lånEtikett.setFont(font);
		lånebeløp = new TextField();
		lånebeløp.setPrefColumnCount(LUFT);
		lånebeløp.setOnAction(e -> regnUt());
		lånebeløp.setText(visBeløp(beløp));
		
		Label renteEtikett = new Label("Rente:");
		renteEtikett.setFont(font);
		årligRente = new TextField();
		årligRente.setPrefColumnCount(LUFT);
		årligRente.setOnAction(e -> regnUt());
		årligRente.setText(Double.toString(rente));
		
		Label terminEtikett = new Label("Terminbeløp:");
		terminEtikett.setFont(font);
		terminbeløp = new TextField();
		terminbeløp.setPrefColumnCount(LUFT);
		terminbeløp.setOnAction(e -> regnUt());
		terminbeløp.setText(visBeløp(annuitetTermin(beløp, mdnRente, mnd)));
		
		
		årInfo = new Label("Antall år: " + (int)år);
		
		antallÅr = new Slider(0, 40, år);
		antallÅr.setOrientation(Orientation.HORIZONTAL);
		antallÅr.setShowTickLabels(true);
		antallÅr.setShowTickMarks(true);
		antallÅr.setBlockIncrement(LUFT);
		antallÅr.setMajorTickUnit(5);
		antallÅr.setMinorTickCount(1);
		antallÅr.setSnapToTicks(true);
		
		antallÅr.valueProperty().addListener(e -> regnUt());
		
		panel.add(lånEtikett, 0, 0);
		panel.add(lånebeløp, 1, 0);
		panel.add(renteEtikett, 0, 1);
		panel.add(årligRente, 1, 1);
		panel.add(årInfo, 0, 2);
		panel.add(antallÅr, 0, 3, 2, 1);
		panel.add(terminEtikett, 0, 4);
		panel.add(terminbeløp, 1, 4);

		Scene scene = new Scene(panel);
		vindu.setScene(scene);
		vindu.setTitle("Lånekalkulator");
		vindu.show();
	}
	
	public void regnUt() {
		double renteNy = Double.parseDouble(årligRente.getText());
		double beløpNy = hentBeløp(lånebeløp.getText());
		double årNy = antallÅr.getValue();
				
		if (renteNy != rente || beløp != beløpNy || Math.abs(år - årNy) > 1) {
		      rente = renteNy/100.0;
		      beløp = beløpNy;
		      år = Math.round(årNy);
		      mnd = år * 12;
		      mdnRente = Math.pow((1+rente), (1.0/12)) - 1;
		      double prMnd = annuitetTermin(beløp, mdnRente, mnd);

		      årInfo.setText("Antall år: " + (int) år);
		      terminbeløp.setText(visBeløp(prMnd));
		    }	
	}
	
	private String visBeløp(double beløp) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return nf.format(beløp);
	}
	
	private double hentBeløp(String str) {
		double beløp = 0.0;
		try {
			NumberFormat nf = NumberFormat.getCurrencyInstance();
			return nf.parse(str).doubleValue();
		} catch (ParseException e) {
			System.out.println("Ugyldig beløp");
		}
		return beløp;
	}
	
	private double annuitetTermin(double beløp, 
						          double rente, 
						          double antall) {
		
		return beløp*rente/(1 - Math.pow(1+rente,-antall));
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
