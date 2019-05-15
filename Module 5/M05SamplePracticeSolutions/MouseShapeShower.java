import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;


public class MouseShapeShower extends Application {

	private Rectangle rectangle;
	private Pane pane;
	
	public void start(Stage primaryStage) {
		pane = new Pane();
		pane.setOnMouseMoved(this::handleMouseMotion);
		pane.setOnMouseDragged(this::handleMouseDrag);
		
		rectangle = new Rectangle(200,200,50,50);
		rectangle.setStroke(Color.BLACK);
		rectangle.setVisible(false);
		
		pane.getChildren().add(rectangle);
		
		Scene scene = new Scene(pane, 500, 500, Color.LEMONCHIFFON);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private void handleMouseDrag(MouseEvent event) {
		rectangle.setVisible(false);
	}
	
	private void handleMouseMotion(MouseEvent event) {
		rectangle.setVisible(true);
		double x = event.getX();
		double y = event.getY();
		
		if(rectangle.contains(x, y)) {
			rectangle.setFill(Color.BLACK);
		} else {
			rectangle.setFill(Color.TRANSPARENT);
		}

	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
