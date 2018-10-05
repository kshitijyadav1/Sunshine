package sunshine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
public class TestClockPane extends Application {
	@Override
	public void start(Stage stg) {
		ClockPane clk = new ClockPane();
		String timeString = clk.getHour() + " : " + clk.getMinute() + " : " + clk.getSecond();
		Label l = new Label(timeString);
		
		BorderPane br = new BorderPane();
		br.setCenter(clk);
		br.setBottom(l);
		BorderPane.setAlignment(l, Pos.TOP_CENTER);
		Scene scene = new Scene(br,250,250);
		stg.setTitle("ShowClock");
		stg.setScene(scene);
		stg.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
