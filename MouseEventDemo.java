package sunshine;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.geometry.*;
public class MouseEventDemo extends Application {
	@Override
	public void start(Stage primaryStage) {
		Pane p = new Pane();
		p.setPrefSize(300, 300);
		p.setPadding(new Insets(5,5,5,5));
		Font font = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 29);
		Text t = new Text(20,20,"Programing is fun");
		t.setX(20);
		t.setY(20);
		 t.setFill(Color.color(Math.random(), Math.random(), Math.random()));
         t.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
		t.setFont(font);
         t.setFont(font);
         t.setRotate(0.01); //important
		p.getChildren().addAll(t); // important
		t.setOnMouseDragged(e-> {
			t.setX(e.getX());
			t.setY(e.getY());
			System.out.println(e.getX() +" "+ e.getY());
		});
		
		Scene scene = new Scene(p, 300, 300);
		primaryStage.setTitle("MouseEventDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
