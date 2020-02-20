package frontend;

public class User {
	private final String username;
	private final UserType usertype;
	private float balance;
	
	User(String username, UserType usertype, float balance) {
		this.username = username;
		this.usertype = usertype;
		this.balance = balance;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public UserType getUserType() {
		return this.usertype;
	}
	
	public float getBalance() {
		return this.balance;
	}
}
