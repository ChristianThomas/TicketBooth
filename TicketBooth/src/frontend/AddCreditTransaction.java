package frontend;

public class AddCreditTransaction extends Transaction {
	private float amount;
	
	AddCreditTransaction(String user, float amount){
		super(user);
		this.amount = amount;
	}
	@Override
	String getTransactionCode() {
		return "addCredit";
	}
	@Override
	PrivilegeLevel getPrivilege() {
		return PrivilegeLevel.ADMIN;
	}
	@Override
	public TransactionResult accept(Logic l) {
		return l.visitTransaction(this);
	}
	@Override
	String getTransactionString() {
		// TODO Auto-generated method stub
		return null;
	}
}
