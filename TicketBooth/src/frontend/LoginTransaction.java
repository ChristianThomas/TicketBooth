package frontend;

public class LoginTransaction extends Transaction {
	LoginTransaction(String user) {
		super(user);
		// TODO Auto-generated constructor stub
	}

	@Override
	String getTransactionCode() {
		return "login";
	}

	@Override
	PrivilegeLevel getPrivilege() {
		return PrivilegeLevel.NOTLOGGEDIN;
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
