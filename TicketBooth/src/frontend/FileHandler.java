package frontend;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
	 private static String file;

	public FileHandler(String file) {
		 this.file = file;
	}
	
	public static void append(String input)throws IOException{
		FileWriter fr = new FileWriter(file,true);
		fr.write(input);
		fr.close();
	}
}
