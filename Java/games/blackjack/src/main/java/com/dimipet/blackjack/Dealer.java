package com.dimipet.blackjack;

public class Dealer extends Player {

	private static final int HIT_THRESHOLD = 15;

	public Dealer() {
		super("Dealer");
	}

	@Override
	public PlayCode play() {
		PlayCode ret = null;
		initHand();

		do {
			addToHand(deck.getCard());
			state();

			if (isBusted()) {
				System.out.println("[" + name + "]" + " busted over 21.");
				ret = PlayCode.BST;
				break;
			}
			if (getHandSum() == 21) {
				ret = PlayCode.BLJ;
				break;
			}
			if (getHandSum() > HIT_THRESHOLD && getHandSum() <= 21) {
				ret = PlayCode.STA;
				break;
			}
		} while (getHandSum() < HIT_THRESHOLD);
		state();
		return ret;
	}

	private void state() {
		System.out.println("[" + name + "]"  + " HAND: " + printHand() + "(" + getHandSum() + ")" + "\t");
	}
}
