package frontend;

import java.io.IOException;

public class LogoutTransaction extends Transaction {
	LogoutTransaction() {
		super("");
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

	@Override
	String getTransactionString() {
		// TODO Auto-generated method stub
		return null;
	}
}
