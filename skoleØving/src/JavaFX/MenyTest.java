package JavaFX;

import java.awt.Panel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MenyTest extends Application {
	
	private TextArea tekstområde;
	private MenuBar menylinje = new MenuBar();
	private Menu filmeny = new Menu("Fil");
	private Menu hjemmeny = new Menu("Hjem");
	private MenuItem ny = new MenuItem("Ny");
	private MenuItem avslutt = new MenuItem("Avlsutt");
	private MenuItem skrift = new MenuItem("Skrift");
	private MenuItem overskrift = new MenuItem("Overskrift");
	
	
	
	public void start(Stage vindu) {
		
		filmeny.setStyle("-fx-padding: 10 10 10 10;");
		hjemmeny.setStyle("-fx-padding: 10 10 10 10;");
		
		BorderPane panel = new BorderPane();
		tekstområde = new TextArea();
		panel.setCenter(tekstområde);
		filmeny.getItems().addAll(ny, avslutt);
		hjemmeny.getItems().addAll(skrift, overskrift);
		menylinje.getMenus().addAll(filmeny, hjemmeny);
		
		ny.setOnAction(e -> ny());
		avslutt.setOnAction(e -> avslutt());
		
		panel.setTop(menylinje);
		
		Scene scene = new Scene(panel, 300, 300);
		vindu.setTitle("Filmeny Test");
		vindu.setResizable(false);
		vindu.setScene(scene);
		vindu.show();
		 
	}
	
	public void ny() {
		tekstområde.appendText("Ny fil fungerer ikke nå...");
	}
	
	public void avslutt() {
		tekstområde.setText("Avslutt fil fungerer ikke nå...");
	}

	public static void main(String[] args) {
		launch(args);
	}

}
