package JavaFX;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class PanelOppdelingDemo extends Application {
	
	private Button k1, k2, k3, k4, k5, k6,
					 k7, k8, k9, k10, k11;
	
	public void start(Stage vindu) {
		BorderPane panel = new BorderPane();
		BorderPane cp = new BorderPane();
		BorderPane rp = new BorderPane();
		
		k1 = new Button("Klikk her!");
		k2 = new Button("Klikk her!");
		k3 = new Button("Klikk her!");
		k4 = new Button("Klikk her!");
		k5 = new Button("Klikk her!");
		k6 = new Button("Klikk her!");
		k7 = new Button("Klikk her!");
		k8 = new Button("Klikk her!");
		k9 = new Button("Klikk her!");
		k10 = new Button("Klikk her!");
		k11 = new Button("Klikk her!");

		panel.setTop(k1);
		panel.setBottom(k2);
		panel.setCenter(cp);
		
		cp.setTop(k3);
		cp.setLeft(k4);
		cp.setCenter(k5);
		cp.setBottom(k6);
		
		cp.setRight(rp);
		
		rp.setTop(k7);
		rp.setLeft(k8);
		rp.setCenter(k9);
		rp.setRight(k10);
		rp.setBottom(k11);
		
		Scene scene = new Scene(panel, 300, 150);
		vindu.setTitle("Knapper");
		vindu.setScene(scene);
		vindu.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
