package sunshine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.shape.Rectangle;

public class CheckerBoard extends Application{
		@Override
		public void start(Stage primaryStage) {
			GridPane pane = new GridPane();
			pane.setPadding(new Insets(5,5,5,5));
			Rectangle[][] rec = new Rectangle[8][8];
			int serial = 0;
			for(int i=0; i<rec.length; i++) {
				for(int j=0; j<rec[i].length; j++) {
					rec[i][j] = new Rectangle(50,50);
					rec[i][j].setStroke(Color.BLACK);
					
				}
			}
			for(int i=0; i<rec.length; i++) {
				serial = i + 1;
				if(serial % 2 == 0) {
					oddBlack(i,rec);
				}
				else {
					evenBlack(i, rec);
				}
			}
			for(int i=0; i<rec.length; i++) {
				for(int j=0; j<rec[i].length; j++) {
			        pane.add(rec[i][j], i, j);
				}
			}
 		    //Create the scene for the application
		    Scene scene = new Scene(pane, 420, 420);
		    primaryStage.setTitle("CheckerBoard");
		    primaryStage.setScene(scene);
		    //Display
		    primaryStage.show();
		}
		public static void main(String[] args) {
			Application.launch(args);
		}
public static void evenBlack(int i, Rectangle[][] rec) {
	int column = 1;
	for(int j=0; j<rec[i].length; j++) {
		
		if(column % 2 == 0) {
			rec[i][j].setFill(Color.BLACK);
		}
		else {
			rec[i][j].setFill(Color.WHITE);
		}
			column++;
	}
}
public static void oddBlack(int i, Rectangle[][] rec) {
	int column = 1;
	for(int j=0; j<rec[i].length; j++) {
		if(column % 2 != 0) {
			rec[i][j].setFill(Color.BLACK);
		}
		else {
			rec[i][j].setFill(Color.WHITE);
		}
			column++;
	}
}
}
