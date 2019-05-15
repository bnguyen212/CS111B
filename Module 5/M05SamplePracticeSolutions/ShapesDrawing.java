import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class ShapesDrawing extends Application {
	
	private RadioButton sameColorRadioButton, differentColorRadioButton;
	private boolean sameColor, filled;
	private CheckBox filledBox;
	private Circle circle;
	private Rectangle rectangle;
	private Polygon triangle;
	private static final Color CIRCLE_COLOR = Color.RED, RECTANGLE_COLOR = Color.YELLOW, TRIANGLE_COLOR = Color.BLUE;
	private static final Color SAME_COLOR = Color.GREEN, NO_FILL_COLOR = Color.TRANSPARENT, BORDER_COLOR = Color.BLACK;
	private static final int BORDER_WIDTH = 2;
	
	public void start(Stage primaryStage) {


		int circX = 75, circY = 75, circRadius = 50;
		circle = new Circle(circX, circY, circRadius);
		
		int recX = 200, recY = 25, recWidth = 200, recHeight = 100;
		rectangle = new Rectangle(recX, recY, recWidth, recHeight);
		
		triangle = new Polygon();
		double triTopX = 525, triTopY = 25, triLeftX = 475, triLeftRightY = 125, triRightX = 575;
		triangle.getPoints().addAll(new Double[] {triTopX, triTopY, triLeftX, triLeftRightY, triRightX, triLeftRightY});

		Group shapesGroup = new Group(circle, rectangle, triangle);
		
		Text message = new Text(250, 200, "Shapes!");
		message.setFont(Font.font("Helvetica", 28));
		message.setFill(Color.PURPLE);
		
		Pane shapesPane = new Pane(shapesGroup, message);
		
		filledBox = new CheckBox("Filled");
		filledBox.setSelected(true);
		filledBox.setOnAction(this::handleEvents);
		filled = true;

		sameColorRadioButton = new RadioButton("Same Color");
		sameColorRadioButton.setSelected(true);
		sameColor = true;
		differentColorRadioButton = new RadioButton("Different Colors");
		ToggleGroup buttonGroup = new ToggleGroup();
		sameColorRadioButton.setToggleGroup(buttonGroup);
		differentColorRadioButton.setToggleGroup(buttonGroup);
		sameColorRadioButton.setOnAction(this::handleEvents);
		differentColorRadioButton.setOnAction(this::handleEvents);
		
		HBox buttonBox = new HBox(filledBox, sameColorRadioButton, differentColorRadioButton);
		buttonBox.setSpacing(20);
		buttonBox.setAlignment(Pos.CENTER);
		
		setColors();
		
		VBox primaryBox = new VBox();
		primaryBox.setStyle("-fx-background-color: mistyrose");
		primaryBox.setAlignment(Pos.CENTER);
		primaryBox.setSpacing(30);
		primaryBox.getChildren().add(shapesPane);
		primaryBox.getChildren().add(buttonBox);
		
		Scene scene = new Scene(primaryBox, 600, 300);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	private void setColors() {
		Shape[] shapes = {circle, rectangle, triangle};
		Color[] colors = {CIRCLE_COLOR, RECTANGLE_COLOR, TRIANGLE_COLOR};
		for(int i=0; i<shapes.length; i++) {
			Shape shape = shapes[i];
			shape.setStrokeWidth(BORDER_WIDTH);
			Color fillColor;
			if(sameColor) {
				fillColor = SAME_COLOR;
			} else {
				fillColor = colors[i];
			}
	
			if(filled) {
				shape.setFill(fillColor);
				shape.setStroke(BORDER_COLOR);
			} else {
				shape.setFill(NO_FILL_COLOR);
				shape.setStroke(fillColor);
			}
		}

	}

	private void handleEvents(ActionEvent event) {
		filled = filledBox.isSelected();
		
		// this setup used because radio buttons could be extended to have more than two choices
		if(sameColorRadioButton.isSelected()) {
			sameColor = true;
		} else if(differentColorRadioButton.isSelected()) {
			sameColor = false;
		}
		setColors();

	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
