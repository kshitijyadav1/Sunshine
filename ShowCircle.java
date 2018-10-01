package sunshine;
import javax.script.ScriptEngine;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class ShowCircle extends Application {
	@Override
	public void start(Stage primaryStage) {
		Circle c = new Circle();
		c.setRadius(50);
		c.setCenterX(100);
		c.setCenterY(100);
		c.setStroke(Color.BLACK);
		c.setFill(Color.BLANCHEDALMOND);
		Pane pane = new Pane();
		pane.getChildren().add(c);
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setTitle("Circle");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
