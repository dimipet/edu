package com.dimipet.bank;

import java.util.Random;

public class Utils {

	public static int getRandomAccountId() {
		int min = 100000000;
		int max = 999999999;
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}

	public static int getCardRandomNumber() {
		int min = 100000000;
		int max = 999999999;
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}

	public static String getCardRandomExpirationDate() {
		int minMonth = 1;  //January
		int maxMonth = 12; //December
		int minYear = 11;  //2011
		int maxYear = 20;  //2020
		Random r = new Random();
		int month = r.nextInt(maxMonth - minMonth + 1) + minMonth;
		int year = r.nextInt(maxYear - minYear + 1) + minYear;
		 //pad zero
		return month < 10 ? "0" + String.valueOf(month) : String.valueOf(month) + String.valueOf(year);
	}
	
	public static int getCardRandomCcv() {
		int min = 100;
		int max = 999;
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}

	public static int getCardRandomPin() {
		int min = 100;
		int max = 9999;
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}
	
}
