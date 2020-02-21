package frontend;

import java.io.IOException;


public class Main {
	// Specifying file paths
	static public String currentUsersFile = "src/CurrentUserAccounts";
	static public String dailyTransactionFile = "src/DailyTransactionFile";
	static public String availableTicketsFile = "src/AvailableTicketsFile";
	
	public static void main(String args[]) {
		InputParser inputParser = new InputParser();

		// Instantiating our state-keeping objects
		Logic logic = null;
		try {
			logic = new Logic(inputParser,
					new CurrentUsersHandler(currentUsersFile),
					new AvailableTicketsHandler(availableTicketsFile),
					new DailyTransactionFileHandler(dailyTransactionFile));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
