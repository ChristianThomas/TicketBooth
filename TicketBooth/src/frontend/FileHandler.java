package frontend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
	 protected File file;

	public FileHandler(String file) throws IOException {
		this.file = new File(file);
		if(!this.file.exists()) {
			this.file.createNewFile();
		}
	}
	
	public ArrayList<String> read() throws FileNotFoundException {
		ArrayList<String> result = new ArrayList<String>();
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()) {
			result.add(sc.nextLine());
		}
		sc.close();
		return result;
	}
	
	public void write(ArrayList<String> lines) throws IOException {
		File tempFile = new File(getTemporaryFilename());
		FileWriter fr = new FileWriter(tempFile,true);
		for(String line : lines) {
			fr.write(line + "\n");
		}
		fr.close();
		this.file.delete();
		tempFile.renameTo(this.file);
		this.file = tempFile;
	}
	
	public String getTemporaryFilename() {
		return this.file.getName() + "_tmp";
	}
}
