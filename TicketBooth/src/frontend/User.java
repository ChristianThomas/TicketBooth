package frontend;

public class User {
	static final User loggedOutUser = new User("", UserType.NOTLOGGEDIN, 0.0f);
	
	private final String username;
	private final UserType usertype;
	private float balance;
	
	User(String username, UserType usertype, float balance) {
		this.username = username;
		this.usertype = usertype;
		this.balance = balance;
	}
	
	static User getLoggedOutUser() {
		return loggedOutUser;
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
	
	public String toString() {
		// UUUUUUUUUUUUUUU_TT_CCCCCCCCC.CC
		// peter           AA 000001267.40
		// U = username, T = type, C = balance
		int balance_padding = getBalancePadding();
		String result = getPaddedUsername(getUsername());
		result += ' ';
		result += UserType.getShortUserType(getUserType());
		result += ' ';
		result += getPaddedBalance(getBalance());
		
		return result;
	}
	
	private static String getPadding(int n, char c) {
		String result = "";
		for(int i = 0; i < n; i++) {
			result += c;
		}
		return result;
	}
	
	public static String getPaddedUsername(String username) {
		String result = username;
		int username_padding = getUsernamePadding();
		username_padding -= username.length();
		result += getPadding(username_padding, ' ');
		
		return result;
	}
	
	public static String getPaddedBalance(float balance) {
		String result = "";
		String balance_string = String.format("%.2f", balance);
		int balance_padding = getBalancePadding() - balance_string.length();
		result += getPadding(balance_padding, '0');
		result += balance_string;
		return result;
	}
	
	public static int getUsernamePadding() {
		return 15;
	}
	
	public static int getBalancePadding() {
		return 9;
	}
	
	public static User getUserFromString(String line) {
		// peter           AA 000001267.40
		// Padding: 15, space, 2, space, 9
		String delimiter = " +";
		String username = line.split(delimiter)[0];
		
		UserType usertype = UserType.getUserTypeFromString(line.split(delimiter)[1]);
		
		float balance = Float.parseFloat(line.split(delimiter)[2]);
		
		return new User(username, usertype, balance);
	}
}
