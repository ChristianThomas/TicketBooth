package frontend;

public class AddCreditTransaction extends Transaction {
	AddCreditTransaction(String user, float amount){
		super(user);
		this.user.balance+=amount;
	}
	@Override
	String getTransactionCode() {
		return "addCredit";
	}
	@Override
	PrivilegeLevel getPrivilege() {
		return PrivilegeLevel.ADMIN;
	}
}
