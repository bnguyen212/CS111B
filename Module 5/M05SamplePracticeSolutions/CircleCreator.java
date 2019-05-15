import java.util.Random;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.*;

public class CircleCreator extends Application {

	private Pane pane;
	private final static int MAX_CIRCLE_RADIUS = 100;
	private final static Color[] COLOR_CHOICES = {Color.DARKGREEN, Color.HOTPINK, Color.BLUEVIOLET};
	private int colorIndex;
	private boolean filled;
		
	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		
		pane = new Pane();
		pane.setOnMouseClicked(this::handleMouseClicks);
		borderPane.setCenter(pane);
	
		colorIndex = 0;
		filled = true;
		
		Scene scene = new Scene(borderPane, 500, 500, Color.LIGHTCYAN);
		primaryStage.setTitle("Circle Creator");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	private void handleMouseClicks(MouseEvent event) {
		double x = event.getX();
		double y = event.getY();

		Random generator = new Random();
		int radius = generator.nextInt(MAX_CIRCLE_RADIUS);
		Circle circle = new Circle(x, y, radius);
		circle.setStrokeWidth(3);
		circle.setStroke(COLOR_CHOICES[colorIndex]);
		if(filled) {
			circle.setFill(COLOR_CHOICES[colorIndex]);
		} else {
			circle.setFill(Color.TRANSPARENT);
		}
		colorIndex = (colorIndex+1) % COLOR_CHOICES.length;
		filled = !filled;
		pane.getChildren().add(circle);
		
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
