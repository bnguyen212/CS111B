package homework5;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class Input extends Application {
	TextField inputField;
	Text outputText;
	
	public void start(Stage primaryStage) {
		Pane pane = new FlowPane();
		
		outputText = new Text("waiting");
		pane.getChildren().add(outputText);
		
		inputField = new TextField("type here");
		inputField.setOnAction(this::handleTextField);
		pane.getChildren().add(inputField);
				
		Scene scene = new Scene(pane, 200, 300, Color.SKYBLUE);
		
		primaryStage.setTitle("Hello User!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void handleTextField(ActionEvent e) {
        String inputText = inputField.getText();
        boolean correct = inputText.equals("here") ? true : false;
        outputText.setText(correct ?  "you got it" : "not quite");
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}