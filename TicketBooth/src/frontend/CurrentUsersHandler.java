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
		append(tr.getTransactionString());
	}
}
