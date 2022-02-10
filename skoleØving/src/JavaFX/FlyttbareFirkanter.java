package JavaFX;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;


public class FlyttbareFirkanter extends Application {
	
	private Pane panel;
	private Canvas canvas;
	private GraphicsContext gc;
	private double x1 = 0;
	private double y1 = 0;
	private boolean pennNede = false;
	private int pennTykkelse = 1;
	
	
	public void start(Stage vindu) {
		panel = new Pane();
		canvas = new Canvas(600, 600);
		panel.getChildren().add(canvas);
		gc = canvas.getGraphicsContext2D();
		
		Scene scene = new Scene(panel, 600, 600);
		
		scene.setOnMousePressed(e -> startStrek(e));		 // Starter å tegne når bruker trykker ned
		scene.setOnMouseDragged(e -> tegnStrek(e));			 // Tegner streken enn så lenge musen er trykket ned
		scene.setOnMouseReleased(e -> sluttStrek());		 // Slutter å trgne, når mus slippes
		scene.setOnKeyPressed(e -> endrePenn(e));			 // Endrer penn strl ved ett tastetrykk
		
		vindu.setScene(scene);
		vindu.setTitle("Tegnekødd");
		vindu.show();
	}
	
	public void startStrek(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		pennNede = true;
		
	}
	
	public void sluttStrek() {
		pennNede = false;
		
	}
	
	public void tegnStrek(MouseEvent e) {
		double x2 = e.getX();					// Henter possisjonen hvor musen har blitt dratt
		double y2 = e.getY();					
		if (pennNede) {
			gc.setLineWidth(pennTykkelse);		// setter penn tykkelse ut ifra hva brukeren tidligere har valgt
			gc.strokeLine(x1, y1, x2, y2);		// Tegner en linje fra tidligere possisjon til der musen er nå
		}
		x1 = x2;								// Setter nåværende posisjon til den nye possisjonen
		y1 = y2;
	}
	
	public void endrePenn(KeyEvent e) {
		if (e.getCode() == KeyCode.DOWN && pennTykkelse > 1)
			pennTykkelse--;
		else if(e.getCode() == KeyCode.UP && pennTykkelse < 9)
			pennTykkelse++;
		else
			if(e.getCode() == KeyCode.N)
				gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
