package sunshine;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
public class DrawLine extends Application {
	private double x = 200;
	private double y = 200;
	@Override
	public void start(Stage primaryStage) {
		Pane p = new Pane();
		p.setPadding(new Insets(5,5,5,5));
		p.setOnMouseClicked(e -> {
			Line l = new Line();
			l.setStartX(x);
			l.setStartY(y);
			l.setEndX(e.getX());
			l.setEndY(e.getY());
			p.getChildren().add(l);
		});
		p.setOnKeyPressed(e -> {
			if(e.getCode() == KeyCode.LEFT) {
				Line l1 = new Line();
				l1.setStartX(x);
				l1.setStartY(y);
				x -= 10;
				y += 0;
			    l1.setEndX(x);
			    l1.setEndY(y);
			    p.getChildren().add(l1);
			}
			if(e.getCode() == KeyCode.RIGHT) {
				Line l1 = new Line();
				l1.setStartX(x);
				l1.setStartY(y);
				x += 10;
				y += 0;
			    l1.setEndX(x);
			    l1.setEndY(y);
			    p.getChildren().add(l1);
			}
			if(e.getCode() == KeyCode.UP) {
				Line l1 = new Line();
				l1.setStartX(x);
				l1.setStartY(y);
				x += 0;
				y -= 10;
			    l1.setEndX(x);
			    l1.setEndY(y);
			    p.getChildren().add(l1);
			}
			if(e.getCode() == KeyCode.DOWN) {
				Line l1 = new Line();
				l1.setStartX(x);
				l1.setStartY(y);
				x += 0;
				y += 10;
			    l1.setEndX(x);
			    l1.setEndY(y);
			    p.getChildren().add(l1);
			}
		});
		Scene scene = new Scene(p,500,500);
		primaryStage.setTitle("Draw Line");
		primaryStage.setScene(scene);
		primaryStage.show();
		p.requestFocus();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
