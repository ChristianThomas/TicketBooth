package frontend;

public abstract class Transaction {
	private String transactionCode;
	private String user;
	private final PrivilegeLevel privilege = PrivilegeLevel.ADMIN;
}
