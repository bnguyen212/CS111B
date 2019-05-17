package application;

import javafx.application.*;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class JavaPaint extends Application {
	
	private final static int WIDTH = 700, HEIGHT = 700;
	private RadioButton red, green, blue, borderThin, borderThick, filled, notFilled, rectangle, ellipse;
	private ToggleGroup shapeChoices, colorChoices, strokeChoices, styleChoices;
	private boolean drawing, dragging;
	private Color colorSelected;
	private MouseEvent startLocation;
	private Button clear, undo;
	private Bounds bounds;
	ObservableList<Node> innerElements, whiteBoardElements;
	
	public void start(Stage primaryStage) {
		drawing = false;
		dragging = false;
		colorSelected = Color.RED;
		BorderPane pane = new BorderPane();

		Text appName = new Text("Welcome to JavaPaint!");
		appName.getStyleClass().add("appName");
		VBox header = new VBox(appName);
		header.getStyleClass().add("header");
		pane.setTop(header);
		
		BorderPane whiteBoard = setUpWhiteBoard();
		pane.setCenter(whiteBoard);
		
		HBox controlBox = setUpControlBox();
		pane.setBottom(controlBox);
		
		Scene scene = new Scene(pane, WIDTH, HEIGHT, Color.TRANSPARENT);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
        bounds = whiteBoard.getBoundsInLocal();
	}
	
	private BorderPane setUpWhiteBoard() {
		BorderPane whiteBoard = new BorderPane();
		Pane innerBoard = new Pane();
		innerBoard.getStyleClass().add("inner");
		whiteBoard.setCenter(innerBoard);
		whiteBoard.getStyleClass().add("whiteboard");
		whiteBoard.setOnMousePressed(this::handleMousePressed);
		whiteBoard.setOnMouseDragged(this::handleMouseDragged);
		whiteBoard.setOnMouseReleased(this::handleMouseReleased);
		whiteBoard.setOnMouseClicked(this::handleMouseClicked);
		whiteBoard.setOnMouseMoved(this::handleMouseMoved);
		whiteBoard.setOnMouseExited(this::handleMouseExited);
		whiteBoardElements = whiteBoard.getChildren();
		innerElements = innerBoard.getChildren();
		return whiteBoard;
	}
	
	
	private void handleMousePressed(MouseEvent e) {
		if (!drawing) {
			startLocation = e;
		}
		drawing = !drawing;
	}

	
	private void handleMouseDragged(MouseEvent e) {
		if (dragging == false) {
			startLocation = e;
			dragging = true;
		}
		drawShape(false, e);
	}
	
	private void handleMouseReleased(MouseEvent e) {
		if (dragging) {
			drawShape(true, e);
			dragging = false;
		}
	}
			
	private void handleMouseExited(MouseEvent e) {
		if (!drawing && whiteBoardElements.size() > 1) {
			whiteBoardElements.remove(whiteBoardElements.size()-1);
		}
	}
	
	
	private void handleMouseClicked(MouseEvent e) {
		if (!drawing) {
			drawShape(true, e);
		}
	}
	
	private void handleMouseMoved(MouseEvent e) {
        if (!drawing) {
        	drawPointer(e);
        } else {
        	drawShape(false, e);
		}
	}
	
	private void drawPointer(MouseEvent e) {
		if(whiteBoardElements.size() > 1) {
    		whiteBoardElements.remove(whiteBoardElements.size()-1);
    	}
    	double x = e.getX()-10;
    	double y = e.getY()-10;
    	if (x < 10) {
    		x = 10;
    	} else if (x > bounds.getMaxX() - 30) {
    		x = bounds.getMaxX() - 30;
    	}
    	if (y < 10) {
    		y = 10;
    	} else if (y > bounds.getMaxY() - 30) {
    		y = bounds.getMaxY() - 30;
    	}
    	Shape pointer;
    	if (shapeChoices.getSelectedToggle() == rectangle) {
    		
    		pointer = new Rectangle(x,y,20,20);
    	} else {
    		x += 10;
    		y += 10;
    		pointer = new Circle(x,y,10);
    	}
    	decorateShape(pointer);
    	whiteBoardElements.add(pointer);
	}
	
	private void drawShape(boolean inner, MouseEvent e) {
		Shape shape;
		double startX = startLocation.getX();
		double startY = startLocation.getY();
		double finalX = e.getX();
		double finalY = e.getY();
		double x = Math.min(startX, finalX);
		double y = Math.min(startY, finalY);
		if (x < 10) {
			x = 10;
		}
		double width = Math.max(startX, finalX) - x;
		if (y < 10) {
			y = 10;
		}
		double height = Math.max(startY, finalY) - y;
		if (x+width >= bounds.getMaxX() - 10) {
			width = bounds.getMaxX() - 10 - x;
		}
		if (y+height >= bounds.getMaxY() - 10) {
			height = bounds.getMaxY() - 10 - y;
		}
		if (inner) {
			x -= 10;
			y -= 10;
		}
		if (shapeChoices.getSelectedToggle() == rectangle) {
			shape = new Rectangle(x, y, width, height);
		} else {
			shape = new Ellipse(x + width/2, y + height/2, width/2, height/2);
		}
		decorateShape(shape);
		if (inner) {
			innerElements.add(shape);
			undo.setDisable(false);
			clear.setDisable(false);
			drawing = false;
		} else {
			if(whiteBoardElements.size() > 1) {
	    		whiteBoardElements.remove(whiteBoardElements.size()-1);
	    	}
			whiteBoardElements.add(shape);
		}
	}
	
	private void decorateShape(Shape shape) {
		if (styleChoices.getSelectedToggle() == filled) {
			shape.setFill(colorSelected);
		} else {
			shape.setStroke(colorSelected);
			shape.setStrokeType(StrokeType.INSIDE);
			shape.setFill(Color.TRANSPARENT);
		}
		if (strokeChoices.getSelectedToggle() == borderThin) {
			shape.setStrokeWidth(1);
		} else {
			shape.setStrokeWidth(5);
		}
	}
	
	private HBox setUpControlBox() {
		
		Separator s1 = new Separator(Orientation.HORIZONTAL);
		Separator s2 = new Separator(Orientation.VERTICAL);
		Separator s3 = new Separator(Orientation.HORIZONTAL);
		Separator s4 = new Separator(Orientation.VERTICAL);
		Separator s5 = new Separator(Orientation.VERTICAL);
		
		
		Text shapeLabel = new Text("SHAPE");
		shapeChoices = new ToggleGroup();
		rectangle = new RadioButton("Rectangle");
		rectangle.setSelected(true);
		rectangle.setToggleGroup(shapeChoices);
		ellipse = new RadioButton("Ellipse");
		ellipse.setToggleGroup(shapeChoices);
		HBox shapes = new HBox(shapeLabel, rectangle, ellipse);
		
		Text colorLabel = new Text("COLOR");
		colorChoices = new ToggleGroup();
		red = new RadioButton("RED");
		red.setSelected(true);
		red.setToggleGroup(colorChoices);
		red.getStyleClass().add("color1");
		red.setOnAction(this::selectColor);
		green = new RadioButton("GREEN");
		green.setToggleGroup(colorChoices);
		green.getStyleClass().add("color2");
		green.setOnAction(this::selectColor);
		blue = new RadioButton("BLUE");
		blue.setToggleGroup(colorChoices);
		blue.getStyleClass().add("color3");
		blue.setOnAction(this::selectColor);
		HBox colors = new HBox(colorLabel, red, green, blue);
		
		VBox column1 = new VBox(shapes, s1, colors);
		
		Text strokeLabel = new Text("STROKE");
		strokeChoices = new ToggleGroup();
		borderThin = new RadioButton("Thin");
		borderThin.setSelected(true);
		borderThin.setToggleGroup(strokeChoices);
		borderThick = new RadioButton("Thick");
		borderThick.setToggleGroup(strokeChoices);
		HBox strokes = new HBox(strokeLabel, borderThin, borderThick);
				
		Text styleLabel = new Text("STYLE");
		styleChoices = new ToggleGroup();
		notFilled = new RadioButton("Border");
		notFilled.setSelected(true);
		notFilled.setToggleGroup(styleChoices);
		notFilled.setOnAction(this::selectStyle);
		filled = new RadioButton("Filled");
		filled.setToggleGroup(styleChoices);
		filled.setOnAction(this::selectStyle);
		HBox styles = new HBox(styleLabel, notFilled, filled);
		
		VBox column2 = new VBox(strokes, s3, styles);
		
		clear = new Button("CLEAR");
		clear.setOnAction(this::clear);
		clear.setDisable(true);
		undo = new Button("UNDO");
		undo.setOnAction(this::undo);
		undo.setDisable(true);
		
		VBox column3 = new VBox(clear, undo);
		column3.setAlignment(Pos.CENTER);
		column3.setSpacing(10);
		column3.setPadding(new Insets(0,0,0,10));
		
		HBox controlBox = new HBox(s5, column1, s2, column2, s4, column3);
		controlBox.getStyleClass().add("controlBox");
		
		return controlBox;
	}
	
	
	private void selectColor(ActionEvent e) {
		if (e.getSource() == red) {
			colorSelected = Color.RED;
		} else if (e.getSource() == green) {
			colorSelected = Color.GREEN;
		} else {
			colorSelected = Color.BLUE;
		}
	}
	
	
	private void selectStyle(ActionEvent e) {
		if (e.getSource() == filled) {
			borderThin.setDisable(true);
			borderThick.setDisable(true);
		} else {
			borderThin.setDisable(false);
			borderThick.setDisable(false);
		}
	}
	
	
	private void clear(ActionEvent e) {
		innerElements.clear();
		clear.setDisable(true);
		undo.setDisable(true);
	}
	
	
	private void undo(ActionEvent e) {
		if (innerElements.size() > 0) {
			innerElements.remove(innerElements.size()-1);
			if (innerElements.size() == 0) {
				undo.setDisable(true);
				clear.setDisable(true);
			}
		}
	}
	
    
	public static void main(String[] args) {
        launch(args);
    }
}