package JavaFX;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.*;
import javafx.util.Duration;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Animajson extends Application {
	
	
	public void start(Stage vindu) {
		Pane root = new Pane();
		Scene scene = new Scene(root, 800, 300);
		vindu.setScene(scene);
		vindu.setTitle("Pacman");
		
		// (x, y, x-radius, y-radius, startåpning, vinkelåpning);
		Arc pacman = new Arc(100, 200, 50, 50, 30, 300);
		pacman.setStroke(Color.BLACK);
		pacman.setFill(Color.YELLOW);
		pacman.setType(ArcType.ROUND);
		Font font = new Font("Arial", 44);
		Text tekst = new Text(300, 80, "PacMan");
		tekst.setStroke(Color.YELLOW);
		tekst.setFill(Color.RED);
		tekst.setFont(font);
		root.getChildren().addAll(pacman, tekst);
		
		// A N I M A S J O N
		
		// Høyreflytting
		Path høyreSti = new Path();
		høyreSti.getElements().add(new MoveTo(100, 200));
		høyreSti.getElements().add(new LineTo(700, 200));
		PathTransition høyreFlytt  = new PathTransition();
		høyreFlytt.setDuration(Duration.millis(2000));
		høyreFlytt.setPath(høyreSti);
		høyreFlytt.setNode(pacman);
		
		// Rotasjon mot venstre
		RotateTransition medKlokken = new RotateTransition(Duration.millis(500), pacman);
		medKlokken.setByAngle(180);
		
		// Venstreflytting
		Path venstreSti = new Path();
		venstreSti.getElements().add(new MoveTo(700, 200));
		venstreSti.getElements().add(new LineTo(100, 200));
		PathTransition venstreFlytt = new PathTransition();
		venstreFlytt.setDuration(Duration.millis(2000));
		venstreFlytt.setPath(venstreSti);
		venstreFlytt.setNode(pacman);
		
		// Rotasjon mot høyre
		RotateTransition motKlokken = new RotateTransition(Duration.millis(500), pacman);
		motKlokken.setByAngle(-180);
		
		// Sekvens
		SequentialTransition flytting = new SequentialTransition();
		flytting.getChildren().addAll(høyreFlytt, medKlokken, venstreFlytt, motKlokken);
		flytting.setCycleCount(Timeline.INDEFINITE);
		
		// Åpne og lukke munnen
		Timeline gaping = new Timeline();
		gaping.setCycleCount(Timeline.INDEFINITE);
		gaping.setAutoReverse(true);
		KeyValue vinkel = new KeyValue(pacman.startAngleProperty(), 0);
		KeyValue bue = new KeyValue(pacman.lengthProperty(), 360);
		
		KeyFrame kf = new KeyFrame(Duration.millis(500), vinkel, bue);
		gaping.getKeyFrames().add(kf);
		
		// Parallell utførelse av bevegelse/rotasjon og åpning/lukking av munn
		ParallelTransition animasjon = new ParallelTransition();
		animasjon.getChildren().addAll(flytting, gaping);
		
		
		vindu.show();
		animasjon.play();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
}
