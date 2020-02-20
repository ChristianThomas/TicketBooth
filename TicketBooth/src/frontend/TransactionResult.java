package frontend;

public class TransactionResult {
	public final Transaction transaction;
	public final boolean status;
	public final String message;
	
	TransactionResult(Transaction transaction, boolean status, String message){
		this.transaction = transaction;
		this.status = status;
		this.message = message;
	}
}
