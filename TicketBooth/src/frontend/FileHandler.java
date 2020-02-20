package frontend;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandler {
	 private static String fileName;

	public FileHandler(String fileName) {
		 this.fileName = fileName;
	}
	
	public static void append(String input)throws IOException{
		FileOutputStream outputStream = new FileOutputStream(fileName,true);
		byte[] strToBytes = input.getBytes();
		outputStream.write(strToBytes);
		outputStream.close();
	}
}
