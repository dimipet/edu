package com.dimipet.blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackJackGame {

	private Deck deck;
	private Dealer dealer;

	private List<Human> humen;

	private Human currentPlayer;
	boolean removedPlayer;
	int removedPlayerIdx;

	public BlackJackGame() {
		deck = Deck.getInstance();
		dealer = new Dealer();
		humen = new ArrayList<Human>();

		int players = howManyPlayers();
		for (int i = 0; i < players; i++) {
			humen.add(new Human("Human" + i));
			humen.get(i).initTotal();
		}

		currentPlayer = null;
		removedPlayer = false;
		removedPlayerIdx = -1;

	}

	public void playGame() {

		// main game loop
		while (true) {

			// if no players left exit
			if (humen.size() == 0)
				break;

			switchPlayer();

			PlayCode hret = currentPlayer.play();
			PlayCode cret = null;

			if (hret == PlayCode.EXT) {
				removeCurrentPlayer();
				continue;
			} else if (hret == PlayCode.LRN) { //loose round
				continue;
			} else if (hret == PlayCode.LTA) { //low total amount
				// break;
				continue;
			} else if (hret == PlayCode.BLJ) { //blackjack
				// do sth
			} else if (hret == PlayCode.BST) { //busted
				System.out.println("[" + currentPlayer.name + "]" + " you loose, computer wins");
			} else if (hret == PlayCode.STA) { // stay
				
				cret = dealer.play();
				
				if (cret == PlayCode.BST) {
					System.out.println("[" + currentPlayer.name + "]" + " you win, computer looses");
					currentPlayer.win();
				
				} else if (currentPlayer.getHandSum() <= dealer.getHandSum()) {
					System.out.println("[" + currentPlayer.name + "]" + " you loose, computer wins");
				
				} else if (currentPlayer.getHandSum() > dealer.getHandSum()) {
					System.out.println("[" + currentPlayer.name + "]" + " you win, computer looses");
					currentPlayer.win();
				}
			}

		}

	}

	private int howManyPlayers() {
		int ret = 0;
		do {
			System.out.print("how many players : ");
			ret = Utils.readInteger();

			if (ret < 1) {
				System.out.println("bad number of players, should be >=1");
			}

		} while (ret < 1);

		return ret;
	}

	/**
	 * Switches player from list of players and preservers/honours the players queue
	 * even in cases where some player exited and the list changed. Honouring the
	 * queue means that the next player of the one removed, should play next.
	 * 
	 * e.g. humen = [H0, H1, H2, H3, H4] Suppose we remove H1 (that is idx 1) :
	 * 
	 * humen = [H0, H2, H3, H4] * notice there are other elements and after it.
	 * 
	 * Next one playing should be H2.
	 */
	private void switchPlayer() {
		// switching players in queue
		if (currentPlayer == null) {
			currentPlayer = humen.get(0);
		} else if (removedPlayer) {
			// get humen last index
			int lastIdx = humen.size() - 1;
			// System.out.println("lastIdx : " + lastIdx);
			// System.out.println("removedPlayerIdx : " + removedPlayerIdx);

			// if the last player was removed
			if (lastIdx < removedPlayerIdx) {
				currentPlayer = humen.get(removedPlayerIdx - 1);
			} else {
				currentPlayer = humen.get(removedPlayerIdx);
			}
			removedPlayer = false;
		} else {
			currentPlayer = humen.get((humen.indexOf(currentPlayer) + 1) % humen.size());
		}
	}

	private void removeCurrentPlayer() {
		/**
		 * CAUTION When removing an element (player) from the list, the
		 * humen.indexOf(currentPlayer) will point to -1. boolean removedPlayer and int
		 * removedPlayerIdx are used to hanlde this.
		 */
		removedPlayer = true;
		removedPlayerIdx = humen.indexOf(currentPlayer);
		humen.remove(removedPlayerIdx);
		// System.out.println("--- removed idx " + removedPlayerIdx);
	}

}
