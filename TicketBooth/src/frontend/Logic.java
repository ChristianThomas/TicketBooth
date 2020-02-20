package frontend;

import java.io.IOException;
import java.util.ArrayList;

public class Logic {
	private User currentUser;
	private ArrayList<TransactionResult> sessionTransactions;
	
	private CurrentUsersHandler currentUsersHandler;
	//private AvailableTicketsHandler availableTickets;
	//private DailyTransactionHandler dailyTransactionFile;
	
	Logic(CurrentUsersHandler currentUsersHandler) {
		this.currentUser = null;
		this.sessionTransactions = new ArrayList<TransactionResult>();
		this.currentUsersHandler = currentUsersHandler;
	}
	
	public TransactionResult processTransaction(Transaction transaction) throws IOException {
		if(!transaction.getPrivilege().getAllowedUserType().contains(this.currentUser.getUserType())) {
			return new TransactionResult(transaction, false, "You do not have permission to issue this transaction.");
		}
		if(transaction instanceof LoginTransaction) {
			return login((LoginTransaction) transaction);
		}
		else if(transaction instanceof LogoutTransaction) {
			return logout((LogoutTransaction) transaction);
		}
		return new TransactionResult(transaction, false, "Transaction code '" + transaction.getTransactionCode() + "' not yet implemented.");
	}
	
	private boolean isLoggedIn() {
		if(this.currentUser == null) {
			return false;
		} else {
			return true;
		}
	}

	// LoginTransaction
	public TransactionResult login(LoginTransaction transaction) {
		User user = currentUsersHandler.getUser(transaction.user);
		
		if(isLoggedIn()) {
			return new TransactionResult(transaction, false, "Already logged in as " + this.currentUser.getUsername());
		}
		
		if(user == null) {
			return new TransactionResult(transaction, false, "User not found.");
		}
		else {
			this.currentUser = user;
			return new TransactionResult(transaction, true, "Logged in as " + this.currentUser.getUsername());
		}
	}
	
	// LogoutTransaction
	public TransactionResult logout(LogoutTransaction transaction) throws IOException {
		if(!isLoggedIn()) {
			return new TransactionResult(transaction, false, "Not Logged In.");
		}
		else {
			for(TransactionResult tr : sessionTransactions) {
				if(tr.status)
					currentUsersHandler.writeTransaction(transaction);
			}
			this.currentUser = null;
			return new TransactionResult(transaction, true, "Successfully logged out Daily Transaction File written");
		}
	}
}