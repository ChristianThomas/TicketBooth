package frontend;

import java.io.IOException;


public class Main {
	// Specifying file paths
	static public String currentUsersFile = "CUF";
	static public String dailyTransactionFile = "DTF";
	static public String availableTicketsFile = "ATF";
	
	public static void main(String args[]) {
		InputParser inputParser = new InputParser();

		// Instantiating our state-keeping objects
		Logic logic = new Logic(inputParser,
				new CurrentUsersHandler(currentUsersFile));
		// At the end this will look like this:
		/* 
		 * Logic logic = new Logic(inputParser, 
		 * 						   new CurrentUsersHandler(currentUsersFile), 
		 * 						   new DailyTransactionFileHandler(dailyTransactionFile),
		 * 						   new AvailableTicketsHandler(availableTicketsFile));
		 */
		
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
