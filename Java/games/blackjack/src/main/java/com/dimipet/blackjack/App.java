package com.dimipet.blackjack;

public class App {
	public static final int ROUND_CHARGE = 5;
	public static final int ROUND_LEAST_BID = 5;
	
	public static void main(String[] args) {
		BlackJackGame blackJack = new BlackJackGame();
		blackJack.playGame();
		System.out.println("Exit.Thank You.");
	}
}
