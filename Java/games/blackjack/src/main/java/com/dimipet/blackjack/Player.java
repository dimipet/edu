package com.dimipet.blackjack;

import java.util.Vector;

public abstract class Player {
	
	protected String name;
	private Vector<Card> hand;
	protected Deck deck;
	
	public Player(String name) {
		super();
		deck = Deck.getInstance();
		this.name = name;
	}

	public boolean isBusted() {
		boolean ret = false;
		int sum = getHandSum();
		if (sum > 21) {
			ret = true;
		}
		return ret;
	}
	
	public Vector<Card> getHand() {
		return hand;
	}

	public void setHand(Vector<Card> hand) {
		this.hand = hand;
	}

	protected void initHand() {
		setHand(new Vector<Card>());
	}
	
	public void addToHand(Card card) {
		hand.add(card);
	}

	public String printHand() {
		String ret = "";
		for (Card element : this.hand) {
			ret = ret + element.getFace() + " ";
		}
		return ret;
	}

	public int getHandSum() {
		int sum = 0;
		for (Card c : hand) {
			sum = sum + c.getValue();
		}
		return sum;
	}
	
	//force implementation
	public abstract PlayCode play();
}
