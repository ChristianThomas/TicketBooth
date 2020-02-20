package frontend;

public class CreateTransaction extends Transaction{
	CreateTransaction(String eventName, Float price, int tickets){
		super(ticket);
	}

	@Override
	String getTransactionCode() {
		return "create";
	}

	@Override
	PrivilegeLevel getPrivilege() {
		return PrivilegeLevel.SELL; //min needed?
	}
}