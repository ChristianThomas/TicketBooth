package frontend;

public class LogoutTransaction extends Transaction {
	LogoutTransaction(String user) {
		super(user);
		// TODO Auto-generated constructor stub
	}

	@Override
	String getTransactionCode() {
		return "logout";
	}

	@Override
	PrivilegeLevel getPrivilege() {
		return PrivilegeLevel.LOGGEDIN;
	}
}
