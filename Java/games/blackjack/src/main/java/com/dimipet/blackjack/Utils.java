package com.dimipet.blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {

	// Διάβασμα συμβολοσειράς απο το πληκτρολόγιο.
	public static String readString() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			return in.readLine();
		} catch (IOException ioe) {
			return null;
		}
	}

	// Διάβασμα χαρακτήρα απο το πληκτρολόγιο
	public static char readChar() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			return in.readLine().charAt(0);
		} catch (IOException ioe) {
			return '0';
		}
	}

	// Διάβασμα ακεραίου απο το πληκτρολόγιο
	public static int readInteger() {
		String s = Utils.readString();
		while (s != null) {
			try {
				int i = Integer.valueOf(s).intValue();
				return i;
			} catch (NumberFormatException nfe) {
				System.err.println("ILLEGAL NUMBER: TRY AGAIN");
				s = Utils.readString();
			}
		}
		return 0;
	}

}
