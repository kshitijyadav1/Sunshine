package sunshine;
import java.util.List;

import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.text.*;

public class NotePad extends Application {
	@Override 
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		TextArea txtarea = new TextArea();
		txtarea.setMinSize(605, 350);
		pane.getChildren().add(txtarea);
		HBox hpane = new HBox(10);
		hpane.setAlignment(Pos.CENTER);
		hpane.setPadding(new Insets(5,5,5,5));
		CheckBox chedit = new CheckBox("Editable");
		CheckBox chwrap = new CheckBox("Wrap");
		CheckBox chbold = new CheckBox("Bold");
		CheckBox chitalic = new CheckBox("Italic");
		hpane.getChildren().addAll(chedit, chwrap,chbold,chitalic);
		BorderPane bpane = new BorderPane();
		
		List<String> fontList = Font.getFamilies();
		Text[] txt = new Text[fontList.size()];
		for(int i=0; i<fontList.size(); i++) {
			txt[i] = new Text(fontList.get(i));
			txt[i].setRotate(0.000001);
			txt[i].setStroke(Color.BLACK);
			txt[i].setFont(Font.font("Arial", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 12));
		}
		HBox hpane1 = new HBox(10);
		ComboBox<Text> cbo = new ComboBox<>();
		ObservableList<Text> items = FXCollections.observableArrayList(txt);
		cbo.setRotate(0.000001);
		cbo.setItems(items);
		Text t = new Text(txtarea.getFont().getFamily());
		cbo.setValue(t);
		cbo.setStyle("-fx-color:white;");
		ComboBox<Text> cbo1 = new ComboBox<>();
		Text[] number = new Text[72];
		for(int i=0; i<number.length; i++) {
			number[i] = new Text(Integer.toString(i));
			number[i].setRotate(0.000001);
			number[i].setStroke(Color.BLACK);
			number[i].setFont(Font.font("Arial", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 12));
		}
		ObservableList<Text> items1 = FXCollections.observableArrayList(number);
		cbo1.setValue(items1.get(17));
		cbo1.setStyle("-fx-background-color:white");
		cbo1.setRotate(0.000001);
		cbo1.setItems(items1);
		cbo1.setMaxWidth(5);
		Text t1 = new Text(Integer.toString((int)txtarea.getFont().getSize()));
		cbo1.setValue(t1);
		cbo1.setStyle("-fx-color:white;");
		TextField color = new TextField();
		color.setRotate(0.000001);
		color.setText("Enter color name and press enter");
		hpane1.getChildren().addAll(new Label("Font\nfamily "),cbo,new Label("Font\nsize "),cbo1,new Label("Text color \nname/value"),color);
		bpane.setTop(hpane1);
		bpane.setCenter(pane);
		bpane.setBottom(hpane);
		txtarea.setEditable(false);
		txtarea.setWrapText(false);
		color.setOnAction(e -> {
			if(color.isHover()) {
				color.setText(" ");
			}
			txtarea.setStyle("-fx-text-fill:"+color.getText()+";");
		});
		txtarea.setRotate(0.000001);
		//
		chedit.setOnAction(e -> {
			if(chedit.isSelected()) {
				txtarea.setEditable(true);
			}
			else 
				txtarea.setEditable(false);
		});
		chwrap.setOnAction(e -> {
			if(chwrap.isSelected()) {
				txtarea.setWrapText(true);
			}
			else 
				txtarea.setWrapText(false);
		});
		chbold.setOnAction(e -> {
			if(chbold.isSelected() && chitalic.isSelected()) {
				txtarea.setFont(Font.font(cbo.getValue().getText(), FontWeight.BOLD, FontPosture.ITALIC, Double.parseDouble(cbo1.getValue().getText())));
			}
			if(chbold.isSelected() && !chitalic.isSelected()) {
				txtarea.setFont(Font.font(cbo.getValue().getText(), FontWeight.BOLD, FontPosture.REGULAR, Double.parseDouble(cbo1.getValue().getText())));
			}
			if(!chbold.isSelected() && chitalic.isSelected()) {
				txtarea.setFont(Font.font(cbo.getValue().getText(), FontWeight.NORMAL, FontPosture.ITALIC, Double.parseDouble(cbo1.getValue().getText())));
			}
			if(!chbold.isSelected() && !chitalic.isSelected()) {
				txtarea.setFont(Font.font(cbo.getValue().getText(), FontWeight.NORMAL, FontPosture.REGULAR, Double.parseDouble(cbo1.getValue().getText())));
			}
 		
		});
		chitalic.setOnAction(e -> {
			if(chbold.isSelected() && chitalic.isSelected()) {
				txtarea.setFont(Font.font(cbo.getValue().getText(), FontWeight.BOLD, FontPosture.ITALIC, Double.parseDouble(cbo1.getValue().getText())));
			}
			if(chbold.isSelected() && !chitalic.isSelected()) {
				txtarea.setFont(Font.font(cbo.getValue().getText(), FontWeight.BOLD, FontPosture.REGULAR, Double.parseDouble(cbo1.getValue().getText())));
			}
			if(!chbold.isSelected() && chitalic.isSelected()) {
				txtarea.setFont(Font.font(cbo.getValue().getText(), FontWeight.NORMAL, FontPosture.ITALIC, Double.parseDouble(cbo1.getValue().getText())));
			}
			if(!chbold.isSelected() && !chitalic.isSelected()) {
				txtarea.setFont(Font.font(cbo.getValue().getText(), FontWeight.NORMAL, FontPosture.REGULAR, Double.parseDouble(cbo1.getValue().getText())));
			}
		});
		cbo1.setOnAction(e -> {
			txtarea.setFont(Font.font(Integer.parseInt(cbo1.getValue().getText())));
		});
		cbo.setOnAction(e -> {
			txtarea.setFont(Font.font(cbo.getValue().getText()));
		});
		//
		Scene scene = new Scene(bpane, 605,410);
		primaryStage.setTitle("TextArea");
		primaryStage.setScene(scene);
		primaryStage.show();
		//primaryStage.setResizable(false);
		txtarea.requestFocus();
		color.requestFocus();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
