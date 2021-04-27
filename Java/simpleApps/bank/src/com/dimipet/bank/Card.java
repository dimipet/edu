package com.dimipet.bank;

public class Card {

	private CardType type;
	private int number;
	private String holder;
	private int ccv;
	private int pin;
	private String expiration;

	public Card(CardType type, int number, String holder, int ccv, int pin, String expiration) {
		this.type = type;
		this.number = number;
		this.holder = holder;
		this.ccv = ccv;
		this.pin = pin;
		this.expiration = expiration;
	}

	public CardType getType() {
		return type;
	}

	public int getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public int getCcv() {
		return ccv;
	}

	public int getPin() {
		return pin;
	}
	
	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getExpiration() {
		return expiration;
	}

	@Override
	public String toString() {
		return "Card [type=" + type + ", number=" + number + ", holder=" + holder + ", expiration=" + expiration + "]";
	}

	
	

}
