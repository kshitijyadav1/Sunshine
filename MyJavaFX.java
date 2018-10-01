package sunshine;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class MyJavaFX extends Application {
	public void start(Stage primaryStage) {
		Button btok = new Button("OK");
		Scene scene = new Scene(btok, 100, 100);
		btok.setMaxSize(100, 20);
		primaryStage.setTitle("MyJavaFx");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
