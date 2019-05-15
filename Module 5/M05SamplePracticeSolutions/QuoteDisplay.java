import java.util.*;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class QuoteDisplay extends Application {

	private Text quoteText;
	private Button quoteButton;

	private ArrayList<String> quoteList;

	public void start(Stage primaryStage) {
		quoteList = new ArrayList<String>();
		fillList();

		GridPane gridPane = new GridPane();
		gridPane.setStyle("-fx-background-color: pink");
		gridPane.setVgap(20);
		gridPane.setAlignment(Pos.CENTER);

		quoteText = new Text("Click the button to see a quote!");
		quoteText.setFont(Font.font("Helvetica", 18));
		quoteText.setFill(Color.color(.15, .15, .55));
		gridPane.add(quoteText, 0, 0);

		quoteButton = new Button("Show Quote");
		HBox buttonBox = new HBox(quoteButton);
		buttonBox.setAlignment(Pos.CENTER);
		quoteButton.setOnAction(this::handleQuoteButton);
		gridPane.add(buttonBox, 0, 1);

		Scene scene = new Scene(gridPane, 500, 200);
		primaryStage.setTitle("Quotes!");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	private void fillList() {
		// pun cred to: https://thoughtcatalog.com/january-nelson/2018/03/50-short-funny-puns-that-will-crack-you-up-in-five-seconds-flat/
		quoteList.add("I'm super friendly with 25 letters of the alphabet.\nI just don't know why.");
		quoteList.add("How do turtles communicate with each other?\nWith shell phones.");
		quoteList.add("I'm positive I just lost an electron.\nBetter keep an ion that.");
		quoteList.add("What's so great about whiteboards?\nIf you think about it, they're pretty re-markable!");
		quoteList.add("How do you invite a dinosaur for lunch?\nTea, Rex?");
		quoteList.add("I've got a phobia of over-engineered buildings.\nIt's a complex complex complex.");
		quoteList.add("I tried to sue the airline for losing my luggage.\nI lost my case.");
		quoteList.add("I knew a mathematician who couldn't afford lunch.\nHe could binomial.");
		quoteList.add("Who invented King Arthur's round table?\nSir Cumference");
		quoteList.add("I wanted to learn to drive a stick shift.\nBut I couldn't find a manual.");
		quoteList.add("You know what really bugs me?\nInsect puns");
		
	
	}

	private void handleQuoteButton(ActionEvent event) {
		Random generator = new Random();
		int quoteToShow = generator.nextInt(quoteList.size());
		quoteText.setText(quoteList.get(quoteToShow));		
	}


	public static void main(String[] args) {
		launch(args);

	}

}
