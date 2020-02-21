package frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class CurrentUsersHandler extends FileHandler {
	CurrentUsersHandler(String filepath) throws IOException {
		super(filepath);
	}
	
	public User getUser(String username) throws FileNotFoundException {
		ArrayList<String> tmp = this.read();
		for(String line : tmp) {
			if(line.startsWith(User.getPaddedUsername(username))) {
				return User.getUserFromString(line);
			}
		}
		
		//return null;
		return new User(username, UserType.ADMIN, 0.0f);
	}
	
	public void createUser(User user) throws IOException {
		ArrayList<String> tmp = this.read();
		tmp.add(tmp.size() - 1, user.toString());
		
		write(tmp);
	}
	
	public void deleteUser(String username) throws IOException {
		ArrayList<String> tmp = this.read();
		String rmLine = null;
		for(String line : tmp) {
			if(line.startsWith(User.getPaddedUsername(username))) {
				rmLine = line;
			}
		}
		tmp.remove(rmLine);
		write(tmp);
	}
	
	public void modifyBalance(String username, float balance) {
		
	}
}

