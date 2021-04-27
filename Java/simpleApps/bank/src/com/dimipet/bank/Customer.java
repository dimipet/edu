package com.dimipet.bank;

public class Customer {

	private String name;
	private Card card;

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name +  "]";
	}

	
}
