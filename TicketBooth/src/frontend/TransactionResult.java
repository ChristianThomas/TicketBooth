package frontend;

public class TransactionResult {
	private final Transaction transaction;
	private final boolean status;
	private final String message;
	
	TransactionResult(Transaction transaction, boolean status, String message){
		this.transaction = transaction;
		this.status = status;
		this.message = message;
	}
}
