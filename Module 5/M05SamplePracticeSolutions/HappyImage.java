import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class HappyImage extends Application {
	
	public void start(Stage primaryStage) {
		
		VBox primaryBox = new VBox();
		primaryBox.setAlignment(Pos.CENTER);
		primaryBox.setSpacing(70);
		
		Image marbleImage = new Image("marblerun.jpg", 300, 300, true, true);
		ImageView marbleImageView = new ImageView(marbleImage);
		primaryBox.getChildren().add(marbleImageView);
		
		Text imageDescription = new Text("Building marble run towers with my kids makes me happy!");
		imageDescription.setFont(Font.font(20));
		imageDescription.setFill(Color.RED);
		primaryBox.getChildren().add(imageDescription);
	
		
		Scene scene = new Scene(primaryBox, 550, 450, Color.BLACK);
		primaryStage.setTitle("Happiness rolls on!");
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}

	public static void main(String[] args) {
		launch(args);

	}

}
