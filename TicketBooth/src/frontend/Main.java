package frontend;

public class Main {
	public static void main(String args[]) {
		// Instantiating our state-keeping objects
		InputParser inputParser = new InputParser();
		Logic logic = new Logic("SAMPLE FILE PATH");
		
		// Program loop
		while(inputParser.hasNext()) {
			Transaction transaction = inputParser.parseInput();
			TransactionResult result = logic.processTransaction(transaction);
			System.out.println(result.message);
		}
		
		// Done
	}
}
