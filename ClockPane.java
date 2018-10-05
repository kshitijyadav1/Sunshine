package sunshine;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.*;

public class ClockPane extends Pane {
	private int hour;
	private int minute;
	private int second;
	private double w = 250;
	private double h = 250;
	public ClockPane() {
		setCurrentTime();
	}
	public ClockPane(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		paintClock();
	}
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getSecond() {
		return second;
	}
	public void setHour(int hour) {
		this.hour = hour;
		paintClock();
	}
	public void setMinute(int minute) {
		this.minute = minute;
		paintClock();
	}
	public void setSecond(int second) {
		this.second = second;
		paintClock();
	}
	public double getW() {
		return w;
	}
	public void setW() {
		this.w = w;
		paintClock();
	}
	public double getH() {
		return h;
	}
	public void setH() {
		this.h = h;
		paintClock();
	}
	public void setCurrentTime() {
		Calendar calendar = new GregorianCalendar();
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
		paintClock();	
	}
	protected void paintClock() {
		double clockRadius = Math.min(w, h) * 0.8 * 0.5;
		double centerX = w / 2;
		double centerY = h / 2;
		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.WHEAT);
		circle.setStroke(Color.GOLD);
		Label[] lb = new Label[12];
		for(int i = 0; i<12; i++) {
			lb[i] = new Label(Integer.toString(i+1));
			fixNumber(lb, i, centerX, centerY, clockRadius);
			lb[i].setStyle("-fx-font:20px Arial; -fx-stroke:black;");
		}
		//draw second hand
		double sLength = clockRadius * 0.8;
		double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
		double secondY = centerY - sLength * Math.cos(second *(2 * Math.PI / 60));
		Line sline = new Line(centerX, centerY, secondX, secondY);
		sline.setStroke(Color.GREEN);
		//draw minute hand
		double mLength = clockRadius * 0.65;
		double xMinute = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
		double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
		Line mline = new Line(centerX, centerY, xMinute, minuteY);
		mline.setStroke(Color.BLUE);
		//Draw hour hand
		double hLength = clockRadius * 0.5;
		double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		Line hline = new Line(centerX, centerY, hourX, hourY);
		hline.setStroke(Color.RED);
		getChildren().clear();
		getChildren().add(circle);
		getChildren().addAll(lb);
		getChildren().addAll(sline, mline, hline);
	}
	protected void fixNumber(Label[] lb, int i, double centerX, double centerY, double clockRadius) {
		switch(i) {
		case 0: lb[i].setLayoutX(centerX + clockRadius - 50);
		lb[i].setLayoutY(centerY - clockRadius + 15);
			break;
		case 1:
			lb[i].setLayoutX(centerX + clockRadius - 25);
			lb[i].setLayoutY(centerY - clockRadius + 45);
			break;
		case 2: // print 3
			lb[i].setLayoutX(centerX + clockRadius - 12);
			lb[i].setLayoutY(centerY - 10);
			break;
		case 3:
			lb[i].setLayoutX(centerX + clockRadius - 25);
			lb[i].setLayoutY(centerY + clockRadius - 70);
			break;
		case 4:
			lb[i].setLayoutX(centerX + clockRadius - 58);
			lb[i].setLayoutY(centerY + clockRadius - 35);
			break;
		case 5: // print 6
			lb[i].setLayoutX(centerX - 3);
			lb[i].setLayoutY(centerY + clockRadius - 20);
			break;
		case 6:
			lb[i].setLayoutX(centerX - clockRadius + 50);
			lb[i].setLayoutY(centerY + clockRadius - 35);
			break;
		case 7: 
			lb[i].setLayoutX(centerX - clockRadius + 15);
			lb[i].setLayoutY(centerY + clockRadius - 70);
			break;
		case 8: //print 9 
			lb[i].setLayoutX(centerX - clockRadius + 3);
			lb[i].setLayoutY(centerY - 10);
			break;
		case 9:
			lb[i].setLayoutX(lb[8].getLayoutX() + 10);
			lb[i].setLayoutY(lb[8].getLayoutY() - 42);
			break;
		case 10:
			lb[i].setLayoutX(lb[9].getLayoutX() + 31);
			lb[i].setLayoutY(lb[9].getLayoutY() - 30);
			break;
		case 11: // print 12
			lb[i].setLayoutX(centerX - 3);
			lb[i].setLayoutY(centerY - clockRadius);
			break;
		default:System.out.println("Bug invoke in fixNumber");
		break;
		}
	}
}
