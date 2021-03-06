package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserService {

	private int count = 0;
	User[] users;

	public UserService() {

		BufferedReader fileReader = null;

		// read data file, get number of lines, so the array can be initialized in the
		// right size
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));

			String line = "";
			while ((line = fileReader.readLine()) != null) {
				count++;

			}
			// taken & adapted from Trevor's lesson
		} catch (FileNotFoundException e) {
			System.out.println("file not found error");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("there was some kind of I/O Exception");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		users = new User[count];
		int count2 = -1;

		// read data into Array of User objects
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			String line = "";

			while ((line = fileReader.readLine()) != null) {
				count2++;
				String[] tempArray = line.split(",");
				users[count2] = new User(tempArray);

			}
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("I/O Exception");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	boolean checkUserInput() {

		int failedTrial = 0;
		for (int i = 1; i < 6; i++) { // Versuchsschleife, loop for 5 trials
			failedTrial++;
			if (failedTrial > 5) {
				return false;
			}

			String email = UserLoginApplication.inputMail();
			String password = UserLoginApplication.inputPassword();

			for (int k = 0; k < count; k++) { // Schleife zum Prüfen der Eingabe, loop for testing user's input

				if (email.equalsIgnoreCase(users[k].getUsername()) == true && password.equals(users[k].getPassword()) == true) {
					System.out.println("\nWelcome: " + users[k].getName());
					return true;
				}

			}
			if (failedTrial < 5) {
				System.out.println("\nInvalid login, please try again");
			}

		}
		return false;

	}
	
	/*
	 * working, but not conform to requirements: a wrong / unknown email address leads already
	 * to an invalid login
	 */	
//	boolean checkUserInput() {
//
//		int failedTrial = 0;
//		for (int i = 1; i < 6; i++) { // Versuchsschleife, loop for 5 trials
//			failedTrial++;
//			if (failedTrial > 5) {
//				return false;
//			}
//			
//			String email = UserLoginApplication.inputMail();
//
//			for (int k = 0; k < count; k++) { // Schleife zum Prüfen der Eingabe, loop for testing user's input
//
//				if (email.equalsIgnoreCase(users[k].getUsername()) == true) {
//					String password = UserLoginApplication.inputPassword();
//					for (int j = 0; j < count; j++) {
//						if (password.equals(users[k].getPassword()) == true) {
//							System.out.println("\nWelcome: " + users[k].getName());
//							return true;
//						}
//					}
//				}
//
//			}
//			System.out.println("\nInvalid login, please try again");
//
//		}
//		return false;
//
//	}
}
