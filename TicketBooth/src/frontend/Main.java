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
		Logic logic = new Logic(new CurrentUsersHandler(currentUsersFile));
		
		// Program loop
		while(inputParser.hasNext()) {
			Transaction transaction = inputParser.parseInput();
			if(transaction == null) continue;

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
