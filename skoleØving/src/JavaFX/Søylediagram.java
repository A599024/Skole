package JavaFX;

import javafx.geometry.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.scene.shape.*;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;
import javafx.scene.text.*;

public class Søylediagram extends Application {
	
	
	public void start(Stage vindu) {
		
		int x = 50;
		int y = 400;
		int bredde = 50;
		int luft = bredde / 2;
		int faktor = 30;
		
		
		Pane lerret = new Pane();
		Font font = new Font("Arial", 24);
		
		int[] nedbør = {5, 11, 3, 7, 2};
		String[] dager = {"man", "tir", "ons", "tor", "fre"};
		
		for (int i = 0; i < dager.length; i++) {
			int høyde = nedbør[i] * faktor;
			Rectangle søyle = new Rectangle(x, y-høyde, bredde, høyde);
			
			søyle.setFill(Color.GRAY);
			Text dag = new Text(x+bredde/3, y+luft, dager[i]);
			Text verdi =  new Text(x+bredde/3, y-høyde-luft, ""+nedbør[i]);
			lerret.getChildren().addAll(søyle, dag, verdi);
			x += bredde + luft;
		}
		
		Scene scene = new Scene(lerret, 450, 450);
		vindu.setTitle("Diagram");
		vindu.setScene(scene);
		vindu.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
