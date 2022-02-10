package JavaFX;

import javafx.geometry.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;
import javafx.scene.text.*;

public class MatBestilling extends Application {
	
	private RadioButton chopsuey, karri, sursøt;
	private CheckBox ananas, babymais, bambus, brokkoli;
	private Button bestill;
	
	
	public void start(Stage vindu) {
		GridPane panel = new GridPane();
		final int LUFT = 10;
		
		panel.setPadding(new Insets(LUFT, LUFT, LUFT, LUFT));
		panel.setHgap(LUFT);
		panel.setVgap(LUFT);
		
		Font font = new Font("Arial", 24);
		Label overskrift = new Label("Kylling-wok med ris");
		overskrift.setFont(font);
		
		ToggleGroup saus = new ToggleGroup();
		chopsuey = new RadioButton("Chop Suey");
		chopsuey.setToggleGroup(saus);
		chopsuey.setSelected(true);
		karri = new RadioButton("Karri");
		karri.setToggleGroup(saus);
		sursøt = new RadioButton("Sursøt");
		sursøt.setToggleGroup(saus);
		
		ananas = new CheckBox("Ananas");
		babymais = new CheckBox("Babymais");
		bambus = new CheckBox("Bambus");
		brokkoli = new CheckBox("brokkoli");
		
		bestill = new Button("Bestill");
		bestill.setOnAction(e -> bestill());
		
		panel.add(overskrift, 0, 0, 3, 1);
		panel.add(chopsuey, 0, 1);
		panel.add(karri, 1, 1);
		panel.add(sursøt, 2, 1);
		panel.add(ananas, 0, 2);
		panel.add(babymais, 0, 3);
		panel.add(bambus, 0, 4);
		panel.add(brokkoli, 0, 5);
		panel.add(bestill, 0, 6);

		Scene scene = new Scene(panel);
		vindu.setTitle("Wok bestilling");
		vindu.setScene(scene);
		vindu.show();
	
	}
	
	public void bestill() {
		if(karri.isSelected())
			System.out.println("Karrisaus er bestilt!");
		if(ananas.isSelected())
			System.out.println("Ananas valgt");

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
