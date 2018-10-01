package sunshine;
import javafx.application.*;
import javafx.stage.*;
public class Test extends Application{
	public Test() {
		System.out.println("Test constructor invoked");
	}
	@Override
	public void start(Stage pstage) {
		System.out.println("start method invoked");
	}
	public static void main(String[] args) {
		System.out.println("launch application");
		Application.launch(args);
	}

}
