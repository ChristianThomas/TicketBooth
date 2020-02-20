package frontend;

import java.io.IOException;
import java.util.ArrayList;

/*
 * Class Logic
 * This is where the business logic of the system is kept. Privilege levels are checked here and
 * 	  state is maintained through the use of a reference to a User object, and a reference to an
 * 	  ArrayList of TransactionResults to be written to the DTF. Also holds a reference to the
 *    InputParser to ask the user for confirmation (yes/no).
 * Transactions are processed using the processTransaction() method, which leverages the Visitor
 * 	  pattern to dynamically call the correct method to handle a concrete subclass of 'Transaction'.
 */
public class Logic {
	private User currentUser;
	private ArrayList<TransactionResult> sessionTransactions;
	
	private InputParser inputParser;	// Use this to ask the user for yes/no
	
	private CurrentUsersHandler currentUsersHandler;
	//private AvailableTicketsHandler availableTicketsHandler;
	//private DailyTransactionHandler dailyTransactionFile;
	
	/*
	 * Constructor for Logic object.
	 * Takes in three file handlers.
	 */
	Logic(InputParser inputParser, CurrentUsersHandler currentUsersHandler) {
		this.currentUser = User.getLoggedOutUser();
		this.sessionTransactions = new ArrayList<TransactionResult>();
		this.inputParser = inputParser;
		this.currentUsersHandler = currentUsersHandler;
		//this.availableTicketsHandler = availableTicketsHandler;
		//this.dailyTransactionFileHandler = dailyTransactionFileHandler;
	}
	
	/*
	 * This method takes is called from Main, and is where privilege levels are enforced before
	 *   the transaction is processed using the Transaction.accept() method.
	 * The visitor pattern is implemented to dynamically use the correct method to handle that transaction.
	 * 
	 * @return the result of the transaction
	 */
	public TransactionResult processTransaction(Transaction transaction) throws IOException {
		// Enforce privilege levels
		if(!transaction.getPrivilege().getAllowedUserType().contains(this.currentUser.getUserType())) {
			return new TransactionResult(transaction, false, "You do not have permission to issue this transaction.");
		}
		TransactionResult res = transaction.accept(this);

		return res;
	}

	/*
	 * Writes the Daily Transaction File for this session.
	 * Writes everything in sessionTransactions, followed by an EndOfSession line.
	 */
	private void writeDailyTransactionFile() throws IOException {
		for(TransactionResult tr : sessionTransactions) {
			if(tr.status)
				currentUsersHandler.writeTransaction(tr.transaction);
		}
		currentUsersHandler.writeEndOfSession();
	}
	
	/*
	 * visitTransaction implementation for a LoginTransaction parameter.
	 * Takes a LoginTransaction then logs in if and only if a user is found.
	 * Pertains to Transaction Code: "login"
	 * 
	 * @return The result of the transaction
	 */
	public TransactionResult visitTransaction(LoginTransaction transaction) {		
		// Login logic
		User user = currentUsersHandler.getUser(transaction.user);
		TransactionResult res;
		if(user == null) {
			res = new TransactionResult(transaction, false, "User not found.");
		}
		else {
			this.currentUser = user;
			res = new TransactionResult(transaction, true, "Logged in as " + this.currentUser.getUsername());
		}
		return res;
	}
	
	/*
	 * visitTransaction implementation for a LogoutTransaction parameter.
	 * Takes a LogoutTransaction then logs out and writes the DTF.
	 * Pertains to Transaction Code: "logout"
	 * 
	 * @return The result of the transaction
	 */
	public TransactionResult visitTransaction(LogoutTransaction transaction) {		
		// Logout logic
		try {
			writeDailyTransactionFile();
		} catch (IOException e) {
			e.printStackTrace();
			return new TransactionResult(transaction, false, "DTF Write Failed: " + e.getMessage());
		}
		// Clear the current transactions
		sessionTransactions.clear();
		// Clear currentUser
		this.currentUser = User.getLoggedOutUser();
		return new TransactionResult(transaction, true, "Successfully logged out Daily Transaction File written");
	}
	
	/*
	 * visitTransaction for any unimplemented Transaction parameter.
	 * Returns a failed TransactionResult with information about the transaction to be implemented.
	 * Pertains to any unimplemented transactions.
	 * 
	 * @return A failed transaction result
	 */
	public TransactionResult visitTransaction(Transaction tr) {
		return new TransactionResult(tr, false, "Transaction '" + tr.transactionCode + "' not yet implemented.");
	}
}