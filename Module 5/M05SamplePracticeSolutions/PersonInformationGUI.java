import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class PersonInformationGUI extends Application {
	/*
	 * Write a GUI to allow the user to enter their name, age, gender (using radio buttons), and whether they are a student (using a check box). 
	 * Include a submit button. When the user clicks submit, display a summary of the information.
	 */
	private CheckBox studentCheckBox;
	private TextField nameField, ageField;
	private RadioButton maleRadioButton, femaleRadioButton, otherRadioButton;
	private TextArea output;
	private Button submitButton;
	
	public void start(Stage primaryStage) {
		
		VBox primaryBox = new VBox();
		primaryBox.setAlignment(Pos.CENTER);
		primaryBox.setSpacing(30);
		
		Text nameLabel = new Text("Name: ");
		nameLabel.setFont(Font.font("Dialog", 16));
		nameField = new TextField();
		HBox nameBox = new HBox(nameLabel, nameField);
		nameBox.setAlignment(Pos.CENTER_LEFT);
		nameBox.setSpacing(10);
		primaryBox.getChildren().add(nameBox);
		
		Text ageLabel = new Text("Age: ");
		ageLabel.setFont(Font.font("Dialog", 16));
		ageField = new TextField();
		HBox ageBox = new HBox(ageLabel, ageField);
		ageBox.setAlignment(Pos.CENTER_LEFT);
		ageBox.setSpacing(10);
		primaryBox.getChildren().add(ageBox);
		
		studentCheckBox = new CheckBox("Student?");
		primaryBox.getChildren().add(studentCheckBox);
		
		ToggleGroup genderGroup = new ToggleGroup();
		maleRadioButton = new RadioButton("Male");
		maleRadioButton.setToggleGroup(genderGroup);
		
		femaleRadioButton = new RadioButton("Female");
		femaleRadioButton.setToggleGroup(genderGroup);
		
		otherRadioButton = new RadioButton("Other");
		otherRadioButton.setToggleGroup(genderGroup);

		HBox radioButtonBox = new HBox(maleRadioButton, femaleRadioButton, otherRadioButton);
		radioButtonBox.setAlignment(Pos.CENTER);
		radioButtonBox.setSpacing(10);
		primaryBox.getChildren().add(radioButtonBox);
		
		submitButton = new Button("Submit");
		submitButton.setOnAction(this::handleSubmitButton);
		primaryBox.getChildren().add(submitButton);
		
		output = new TextArea("");
		primaryBox.getChildren().add(output);
		
		primaryBox.setStyle("-fx-background-color: lightYellow");
		
		Scene scene = new Scene(primaryBox, 275, 400);
		primaryStage.setTitle("Information Entry");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		
	}
	
	private void handleSubmitButton(ActionEvent event) {
		output.setText("");
		boolean genderSelected = maleRadioButton.isSelected() || femaleRadioButton.isSelected() || otherRadioButton.isSelected();
		boolean nameEntered = !nameField.getText().isEmpty();
		boolean ageEntered = true;
		if(ageField.getText().isEmpty()) {
			ageEntered = false;
		} else {
			try {
				Integer.parseInt(ageField.getText());
			} catch(NumberFormatException ex) {
				ageEntered = false;
			}
		}
		boolean validInput = true;

		if(!nameEntered) {
			output.appendText("\nName is required.");
			validInput = false;
		}
		if(!ageEntered) {
			output.appendText("\nA numeric age is required.");
			validInput = false;
		}
		if(!genderSelected) {
			output.appendText("\nGender is required.");
			validInput = false;
		}
		if(validInput) {
			output.setText("Information:");
			output.appendText("\nName: " + nameField.getText());
			output.appendText("\nAge: " + ageField.getText());
			String genderString;
			if(maleRadioButton.isSelected()) {
				genderString = "Male";
			} else if(femaleRadioButton.isSelected()) {
				genderString = "Female";
			} else { // otherRadioButton.isSelected()
				genderString = "Other";
			}
			output.appendText("\nGender: " + genderString);
			output.appendText(studentCheckBox.isSelected() ? "\nStudent" : "");
			
		}
	}
	

	public static void main(String[] args) {
		launch(args);

	}

}
