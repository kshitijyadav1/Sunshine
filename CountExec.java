package sunshine;
import java.io.*;
public class CountExec {
	private int l=0;
	private File file;
	CountExec(File filename) throws FileNotFoundException, IOException {
		this.file = filename;
		increment();
	}
	
	public boolean checkFileExist() {
		return file.exists();
	}
	
	public void increment() throws FileNotFoundException, IOException {
		if(!checkFileExist()) {
		try (
				DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			) {
			l++;
			output.writeInt(l);
		} 
		catch(IOException ex) {
			System.out.println("Not increament");
		}
		}
		else if(checkFileExist()) {
			try {
				try (
						DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
						) 
				{
					while(true) {
						l = input.readInt();
					}
				}
				catch(IOException ex) {
					System.out.println("Read : "+l);
				}
				try (
						DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
					) {
					l++;
					output.writeInt(l);
					
				} 
				} 
				catch(IOException ex) {
					System.out.println("Write : " + l);
				}
		}
	}
	
	
	public void getMessage() {
		if(this.l <= 1) {
		System.out.println("Program has been executed "+this.l+ " time."); 
		}
		else {
			System.out.println("Program has been executed "+this.l + " times."); 
		}
	}
}

