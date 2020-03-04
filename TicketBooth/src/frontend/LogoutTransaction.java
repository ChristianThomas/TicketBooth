package frontend;


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

	@Override
	public TransactionResult accept(Logic l) {
		return l.visitTransaction(this);
	}
}
