package homework5;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class ShippingSpeed extends Application {

	private CheckBox item1CheckBox, item2CheckBox, item3CheckBox;
	private RadioButton regularShipSpeedRadioButton, fastShipSpeedRadioButton;
	private Text summaryText;
	private Button purchaseButton;
	
	public void start(Stage primaryStage) {
		VBox mainVBox = new VBox();
		mainVBox.setStyle("-fx-background-color: cyan");
		mainVBox.setAlignment(Pos.CENTER);
		mainVBox.setSpacing(10);
		
		Text itemText = new Text("Select your items:");
		item1CheckBox = new CheckBox("Item 1");
		item2CheckBox = new CheckBox("Item 2");
		item3CheckBox = new CheckBox("Item 3");
		VBox itemBox = new VBox(itemText, item1CheckBox, item2CheckBox, item3CheckBox);
		itemBox.setAlignment(Pos.CENTER);
		itemBox.setSpacing(10);
		mainVBox.getChildren().add(itemBox);

		Text speedText = new Text("Select your shipping speed:");
		regularShipSpeedRadioButton = new RadioButton("Regular Shipping");
		regularShipSpeedRadioButton.setSelected(true);
		fastShipSpeedRadioButton = new RadioButton("Fast Shipping");
		ToggleGroup group = new ToggleGroup();
		regularShipSpeedRadioButton.setToggleGroup(group);
		fastShipSpeedRadioButton.setToggleGroup(group);
		VBox shippingBox = new VBox(speedText, regularShipSpeedRadioButton, fastShipSpeedRadioButton);
		shippingBox.setAlignment(Pos.CENTER);
		shippingBox.setSpacing(10);
		mainVBox.getChildren().add(shippingBox);

		purchaseButton = new Button("Purchase");
		purchaseButton.setOnAction(this::handleButton);
		HBox buttonBox = new HBox(purchaseButton);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(10);
		mainVBox.getChildren().add(buttonBox);

		summaryText = new Text();
		HBox resultBox = new HBox(summaryText);
		resultBox.setAlignment(Pos.CENTER);
		resultBox.setSpacing(10);
		mainVBox.getChildren().add(resultBox);

		Scene scene = new Scene(mainVBox, 350, 350);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private void handleButton(ActionEvent event) {
		try {
			if (!item1CheckBox.isSelected() && !item2CheckBox.isSelected() && !item3CheckBox.isSelected()) {
				throw new Exception("Invalid input: select at least one item.");
			}
			String output = "You purchased:\n";
			if (item1CheckBox.isSelected()) {
				output += item1CheckBox.getText() + "\n";
			}
			if (item2CheckBox.isSelected()) {
				output += item2CheckBox.getText() + "\n";
			}
			if (item3CheckBox.isSelected()) {
				output += item3CheckBox.getText() + "\n";
			}
			output += regularShipSpeedRadioButton.isSelected() ? regularShipSpeedRadioButton.getText() : fastShipSpeedRadioButton.getText();
			summaryText.setText(output);
			item1CheckBox.setDisable(true);
			item2CheckBox.setDisable(true);
			item3CheckBox.setDisable(true);
			regularShipSpeedRadioButton.setDisable(true);
			fastShipSpeedRadioButton.setDisable(true);
			purchaseButton.setDisable(true);
		} catch (Exception ex) {
			summaryText.setText(ex.getMessage());
		}
	}
	public static void main(String[] args) {
		launch(args);

	}

}
