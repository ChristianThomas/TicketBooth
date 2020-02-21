package frontend;

import java.io.IOException;

public class CurrentUsersHandler extends FileHandler {
	CurrentUsersHandler(String filepath) {
		super(filepath);
		// STUB
	}
	
	public User getUser(String username) {
		// STUB
		return new User(username, UserType.ADMIN, 0.0f);
	}
	
	public void writeTransaction(Transaction tr) throws IOException {
		// STUB
		System.out.println("CurrentUsersFile < " + tr.getTransactionString());
	}
	
	public void writeEndOfSession() throws IOException {
		System.out.println("CurrentUsersFile < " + "00                        ");
	}
}
