package frontend;

public class DeleteTransaction extends Transaction {
	DeleteTransaction(String eventName){
		super(Ticket);
	}
	@Override
	String getTransactionCode() {
		return "delete";
	}

	@Override
	PrivilegeLevel getPrivilege() {
		return PrivilegeLevel.ADMIN;
	}
}


