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
	
	// If you ever need a yes/no confirmation, use this
	public boolean confirmAction(String message) {
		System.out.println(message);
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
	
	// Implemented so far: Login, Logout
	public Transaction parseInput() {
		String in = stdin.next();
		switch(in) {
		case "login":
			return parseLogin();
		case "logout":
			return new LogoutTransaction();
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
}
