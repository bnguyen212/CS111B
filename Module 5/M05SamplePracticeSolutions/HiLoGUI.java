import java.util.*;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;

public class HiLoGUI extends Application {

	private TextField guessField;
	private Button playAgainButton;
	private Text resultText;

	private int secretNumber;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 100;

	public void start(Stage primaryStage) {
		secretNumber = chooseNumber();
		//gridPane.setStyle();
		//gridPane.setVgap(20);
		//gridPane.setAlignment(Pos.CENTER);

		
		Text guessLabel = new Text("Guess a number between \n\t" + MIN_NUMBER + " and " + MAX_NUMBER + ":");
		guessLabel.setFont(Font.font("Helvetica", 16));
		guessLabel.setFill(Color.DARKBLUE);
		VBox guessLabelBox = new VBox(guessLabel);
		guessLabelBox.setAlignment(Pos.TOP_CENTER);

		guessField = new TextField("     ");
		guessField.setOnAction(this::processGuessField);
		
		resultText = new Text("");
		resultText.setFont(Font.font("Helvetica", 24));
		resultText.setFill(Color.MAROON);
		playAgainButton = new Button("Play Again");
		playAgainButton.setOnAction(this::handlePlayAgainButton);
		playAgainButton.setVisible(false);

		VBox mainBox = new VBox(guessLabelBox, guessField, resultText,playAgainButton);
		mainBox.setSpacing(20);
		mainBox.setAlignment(Pos.CENTER);
		mainBox.setStyle("-fx-background-color: lightgreen");
		
		Scene scene = new Scene(mainBox, 200, 200);
		primaryStage.setTitle("HiLo Game");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	private static int chooseNumber() {
		Random generator = new Random();
		return generator.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
	}

	private void handlePlayAgainButton(ActionEvent event) {
		resultText.setText("");
		guessField.clear();
		guessField.setDisable(false);
		playAgainButton.setVisible(false);
		secretNumber = chooseNumber();
		
	}

	private void processGuessField(ActionEvent event) {
		try {
			int userNumber = Integer.parseInt(guessField.getText());
			if(userNumber > secretNumber) {
				resultText.setText(userNumber + " is too high!");
				guessField.clear();
			} else if(userNumber < secretNumber) {
				resultText.setText(userNumber + " is too low!");
				guessField.clear();
			} else {
				resultText.setText("You got it!");
				guessField.setDisable(true);
				playAgainButton.setVisible(true);
			}
			
		} catch (NumberFormatException ex) {
			resultText.setText("Invalid Guess.");
			resultText.setFill(Color.RED);
		} finally {
			guessField.clear();
		}
	}

	public static void main(String[] args) {
		launch(args);

	}

}
