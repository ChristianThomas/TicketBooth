package frontend;

public abstract class Transaction {
	protected final String transactionCode;
	protected final String user;
	protected final PrivilegeLevel privilege;
	
	Transaction(String user) {
		this.transactionCode = getTransactionCode();
		this.privilege = getPrivilege();
		this.user = user;
	}
	
	abstract String getTransactionCode();
	abstract PrivilegeLevel getPrivilege();
	abstract String getTransactionString();
	
	abstract public TransactionResult accept(Logic l);
}
