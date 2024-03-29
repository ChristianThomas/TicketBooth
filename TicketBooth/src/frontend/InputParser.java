package frontend;

import java.util.Scanner;

public class InputParser {
	Scanner stdin;
	
	InputParser() {
		this.stdin = new Scanner(System.in);
	}
	
	// For the while loop in main
	public boolean hasNext() {
		return stdin.hasNext();
	}
	
	/*
	 * Displays a message to the user and parses a response in the form of "yes" or "no".
	 * 
	 * @return True for yes, False for no
	 */
	public boolean confirmAction(String message) {
		System.out.println(message + "('yes'/'no')");
		String in = stdin.next();
		while(true) {
			if(in.startsWith("y")) {
				return true;
			} else if (in.startsWith("n")) {
				return false;
			} else {
				System.out.println("Input not recognized, try again.");
			}
		}
	}
	
	/*
	 * Reads in the transaction code and returns an object instantiated from a concrete subclass of 'Transaction'.
	 * If more information is required, the method will call a helper method.
	 * 
	 * @return a Transaction, null if the transaction is not recognized.
	 */
	public Transaction parseTransactionCode() {
		String in = stdin.next();
		switch(in) {
		case "login":
			return parseLogin();
		case "logout":
			return new LogoutTransaction();
		case "create":
			return parseCreate();
		case "delete":
			return parseDelete();
		default:
			return null;
		}
	}
	
	// Returns a login transaction
	private LoginTransaction parseLogin() {
		System.out.print("Enter username: ");
		String in = stdin.next();
		// TODO: Error checking
		return new LoginTransaction(in);
	}
	
	private CreateTransaction parseCreate() {
		System.out.print("Enter desired username: ");
		String user = stdin.next();
		System.out.print("Enter desired balance: ");
		float balance = (float) stdin.nextDouble();
		System.out.println("Enter desired UserType: 1) Admin, 2) Full-Standard, 3) Buy-Standard, 4) Sell-Standard");
		int usertype_choice = stdin.nextInt();
		UserType usertype;
		switch(usertype_choice) {
		case 1:
			usertype = UserType.ADMIN;
			break;
		case 2:
			usertype = UserType.FULLSTANDARD;
			break;
		case 3:
			usertype = UserType.BUYSTANDARD;
			break;
		case 4:
			usertype = UserType.SELLSTANDARD;
			break;
		default:
			usertype = UserType.FULLSTANDARD;
			break;
		}
		return new CreateTransaction(user, balance, usertype);
	}
	
	private DeleteTransaction parseDelete() {
		System.out.print("Enter username to delete: ");
		String user = stdin.next();
		return new DeleteTransaction(user);
	}
}
