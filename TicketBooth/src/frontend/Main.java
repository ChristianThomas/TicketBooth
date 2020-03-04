package frontend;

import java.io.IOException;

/*
 * This is the main class, which contains the entry point to our program.
 * 
 * To implement a new transaction:
 * 1. Create a subclass of abstract class Transaction and implement all the required methods.
 * 2. Edit InputParser.parseTransactionCode(); to return the new transaction object.
 * 3. Add method visitTransaction(<Your Type>) to class Logic, and implement the business logic.
 */

public class Main {
	// Specifying file paths
	static public String currentUsersFile = "Files/CurrentUserAccounts";
	static public String dailyTransactionFile = "Files/DailyTransactionFile";
	static public String availableTicketsFile = "Files/AvailableTicketsFile";
	
	public static void main(String args[]) {
		InputParser inputParser = new InputParser();

		if(args.length == 2) {
			currentUsersFile = args[1];
			availableTicketsFile = args[2];
		}

		// Instantiating our state-keeping objects
		Logic logic = null;
		try {
			logic = new Logic(inputParser,
							  new CurrentUsersHandler(currentUsersFile),
							  new AvailableTicketsHandler(availableTicketsFile),
							  new DailyTransactionFileHandler(dailyTransactionFile)
							  );
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		
		
		// Program loop
		while(inputParser.hasNext()) {
			// Read in a transaction
			Transaction transaction = inputParser.parseTransactionCode();
			if(transaction == null) {
				System.out.println("Transaction code not recognized.");
				continue;
			}
			// Perform the transaction
			TransactionResult result;
			try {
				result = logic.processTransaction(transaction);
				System.out.println(result.message);
			} catch (IOException e) {
				System.out.println("IOException Caught");
				e.printStackTrace();
			}
		}
		
		// Done
	}
}
