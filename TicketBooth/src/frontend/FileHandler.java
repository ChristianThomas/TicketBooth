package frontend;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
	 private static String file;

	public FileHandler(String file) {
		 FileHandler.file = file;
	}
	
	public static void append(String input)throws IOException{
		FileWriter fr = new FileWriter(file,true);
		fr.write(input);
		fr.close();
	}
}
