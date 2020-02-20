package frontend;

import java.util.Scanner;

public class InputParser {
	Scanner stdin;
	
	InputParser() {
		this.stdin = new Scanner(System.in);
	}
	
	// Implemented so far: Login, Logout
	public Transaction parseInput() {
		String in = stdin.next();
		if(in.equals("login")) {
			return parseLogin();
		} 
		else if (in.equals("logout")) {
			return new LogoutTransaction("");
		}
		return null;
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
			}
		}
	}
	
	// For the while loop in main
	public boolean hasNext() {
		return stdin.hasNext();
	}
	
	// Returns a login transaction
	private LoginTransaction parseLogin() {
		System.out.print("Enter username: ");
		String in = stdin.next();
		// TODO: Error checking
		return new LoginTransaction(in);
	}
}
