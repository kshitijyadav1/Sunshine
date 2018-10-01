package sunshine;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
public class ButtonInPane extends Application {
	 @Override
	 public void start(Stage primaryStage) {
		 StackPane pane = new StackPane();
		 pane.getChildren().add(new Button("Hello"));
		 Scene scene = new Scene(pane, 200, 200);
		 primaryStage.setTitle("Hello");
		 primaryStage.setScene(scene);
		 primaryStage.show();
	 }
	 public static void main(String[] args) {
		 Application.launch(args);
	 }
}
