package frontend;

import java.util.ArrayList;

public class Logic {
	private String username;
	private UserType usertype;
	private ArrayList<TransactionResult> sessionTransactions;
	
	private CurrentUsersHandler currentUsers;
	//private AvailableTicketsHandler availableTickets;
	//private DailyTransactionHandler dailyTransactionFile;
	
	Logic(String currentUsersPath) {
		this.username = null;
		this.usertype = null;
		this.sessionTransactions = new ArrayList<TransactionResult>();
		this.currentUsers = new CurrentUsersHandler(currentUsersPath);
	}
	
	public TransactionResult processTransaction(Transaction transaction) {
		if(transaction instanceof LoginTransaction) {
			return processTransaction((LoginTransaction) transaction);
		}
		else if(transaction instanceof LogoutTransaction) {
			return processTransaction((LogoutTransaction) transaction);
		}
		return null;
	}
	
	// LoginTransaction
	public TransactionResult processTransaction(LoginTransaction transaction) {
		UserType privilege = currentUsers.getUser(transaction.user);
		if(privilege == null) {
			return new TransactionResult(transaction, false, "User not found.");
		}
		else {
			this.username = transaction.user;
			this.usertype = privilege;
			return new TransactionResult(transaction, true, "Logged in as " + this.username);
		}
	}
	
	private boolean isLoggedIn() {
		if(this.username != null && this.username != "") {
			return true;
		} else {
			return false;
		}
	}
	
	public TransactionResult processTransaction(LogoutTransaction transaction) {
		UserType privilege = currentUsers.getUser(transaction.user);
		if(privilege == null) {
			return new TransactionResult(transaction, false, "User not found.");
		}

		if(!isLoggedIn()) {
			return new TransactionResult(transaction, false, "Not Logged In.");
		}
		else {
			for(TransactionResult tr : sessionTransactions) {
				if(tr.status)
					currentUsers.writeTransaction(transaction);
			}
			this.username = null;
			this.usertype = null;
			return new TransactionResult(transaction, true, "Successfully logged out Daily Transaction File written");
		}
	}
}