package sunshine;

import java.io.*;
public class TestCountExec {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		CountExec ec = new CountExec(new File("src/sunshine/count.dat"));
		ec.getMessage();

    }
}
