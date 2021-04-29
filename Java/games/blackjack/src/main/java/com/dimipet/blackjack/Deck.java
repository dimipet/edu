package com.dimipet.blackjack;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

public class Deck {

	private static final int INIT_DECKS = 1;
	private static final int SHUFFLE_TIMES = 7;
	private static final int CARD_REFILL_THRESHOLD = 0;

	private static Deck INSTANCE;
	
	
	private Vector<Card> deck = new Vector<Card>();

	private Deck() {
		refill(INIT_DECKS);
	}
	
	public static Deck getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Deck();
        }
        
        return INSTANCE;
    }

	/*
	 * refills deck with cards
	 * cards are shuffled before refilled
	 */
	private void refill(int numberOfDecks) {
		Vector<Card> ret = new Vector<Card>();
		for (int i = 0; i < numberOfDecks; i++) {
			ret.addAll(getNewDeck());
		}
		shuffle(ret, SHUFFLE_TIMES);
		deck.addAll(ret);
	}

	/**
	 * shuffles collection of cards
	 * 
	 * @param cards - collectionof cards to shuffle
	 * @param times - times to shuffle
	 */
	private void shuffle(Vector<Card> cards, int times) {
		// if shuffle times not provided
		times = times > 0 ? times : SHUFFLE_TIMES;
		for (int i = 0; i <= times; i++) {
			Collections.shuffle(cards);
		}
	}

	/**
	 * creates new deck of 52 cards
	 * A 2 3 4 5 6 7 8 9 10 J Q K for
	 * clubs (♣), diamonds (♦), hearts (♥) and spades (♠)
	 * @return
	 */
	private Vector<Card> getNewDeck() {
		Vector<Card> ret = new Vector<Card>();
		
		ret.add(new Card("A♣", 1));
		ret.add(new Card("2♣", 2));
		ret.add(new Card("3♣", 3));
		ret.add(new Card("4♣", 4));
		ret.add(new Card("5♣", 5));
		ret.add(new Card("6♣", 6));
		ret.add(new Card("7♣", 7));
		ret.add(new Card("8♣", 8));
		ret.add(new Card("9♣", 9));
		ret.add(new Card("10♣", 10));
		ret.add(new Card("J♣", 10));
		ret.add(new Card("D♣", 10));
		ret.add(new Card("K♣", 10));

		ret.add(new Card("A♦", 1));
		ret.add(new Card("2♦", 2));
		ret.add(new Card("3♦", 3));
		ret.add(new Card("4♦", 4));
		ret.add(new Card("5♦", 5));
		ret.add(new Card("6♦", 6));
		ret.add(new Card("7♦", 7));
		ret.add(new Card("8♦", 8));
		ret.add(new Card("9♦", 9));
		ret.add(new Card("10♦", 10));
		ret.add(new Card("J♦", 10));
		ret.add(new Card("D♦", 10));
		ret.add(new Card("K♦", 10));

		ret.add(new Card("A♥", 1));
		ret.add(new Card("2♥", 2));
		ret.add(new Card("3♥", 3));
		ret.add(new Card("4♥", 4));
		ret.add(new Card("5♥", 5));
		ret.add(new Card("6♥", 6));
		ret.add(new Card("7♥", 7));
		ret.add(new Card("8♥", 8));
		ret.add(new Card("9♥", 9));
		ret.add(new Card("10♥", 10));
		ret.add(new Card("J♥", 10));
		ret.add(new Card("D♥", 10));
		ret.add(new Card("K♥", 10));

		ret.add(new Card("A♠", 1));
		ret.add(new Card("2♠", 2));
		ret.add(new Card("3♠", 3));
		ret.add(new Card("4♠", 4));
		ret.add(new Card("5♠", 5));
		ret.add(new Card("6♠", 6));
		ret.add(new Card("7♠", 7));
		ret.add(new Card("8♠", 8));
		ret.add(new Card("9♠", 9));
		ret.add(new Card("10♠", 10));
		ret.add(new Card("J♠", 10));
		ret.add(new Card("D♠", 10));
		ret.add(new Card("K♠", 10));

		return ret;
	}

	/**
	 * print cards for debugging purposes
	 */
	private void enumerate() {
		for (Card c : deck) {
			System.out.println(c.getFace() + "[" + c.getValue() + "]");
		}
	}

	/**
	 * 
	 * @return last card of deck
	 */
	public Card getCard() {
		if (deck.size() <= CARD_REFILL_THRESHOLD) {
			System.out.println("Deck size : " + deck.size() + "refilling");
			refill(INIT_DECKS);
		}
		Card temp = deck.lastElement();
		deck.removeElement(deck.lastElement());
		//System.out.println("[Deck] size : " + deck.size());
		return temp;
	}

	public int getSize() {
		return deck.size();
	}

}
