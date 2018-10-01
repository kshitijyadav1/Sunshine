package sunshine;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
public class MultiStageDemo extends Application {
	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(new Button("OK"),200,200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("MyjAVAfX");
		primaryStage.show();
		Stage secondaryStage = new Stage();
		secondaryStage.setScene(new Scene(new Button("Java FX"),200,200));
		secondaryStage.show();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
