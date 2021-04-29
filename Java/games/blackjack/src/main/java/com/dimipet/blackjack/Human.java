package com.dimipet.blackjack;

public class Human extends Player {

	private boolean initializedTotal;
	private int total;
	private int roundBet;

	public Human(String name) {
		super(name);
		initializedTotal = false;
		total = 0;
		roundBet = 0;
	}

	private boolean isInitializedTotal() {
		return initializedTotal;
	}

	private int getTotal() {
		return total;
	}

	private int getRoundBet() {
		return roundBet;
	}

	private void charge(int amount, String reason) {
		total = total - amount;
		System.out.println("[" + name + "]" + " charged " + amount + " for " + reason);
	}

	/**
	 * 
	 * @return
	 * 			Y for yes
	 * 			N for no
	 * 			E to exit
	 */
	private String playRound() {
		//boolean ret = false;
		String ans = null;

		do {
			System.out.print("[" + name + "]"  + " play round (Y/N/E) ? : ");
			ans = Utils.readString().substring(0).toUpperCase();
			if (!ans.equalsIgnoreCase("Y") && !ans.equalsIgnoreCase("N") && !ans.equalsIgnoreCase("E")) {
				System.out.println("use only Y (yes) or N (no) or E (exit).");
			}
		} while (!ans.equalsIgnoreCase("Y") && !ans.equalsIgnoreCase("N") && !ans.equalsIgnoreCase("E"));

//		if (ans.equalsIgnoreCase("Y")) {
//			ret = true;
//		} else if (ans.equalsIgnoreCase("N")) {
//			ret = false;
//		}
		return ans;
	}

	/**
	 * ζηταμε από τον παίκτη να δώσει ένα αρχικό ποσό μέχρι να δώσει κάποιο
	 * μεγαλυτερο του 5
	 */
	public void initTotal() {
		do {
			System.out.print("[" + name + "]"  + " please provide initial total : ");
			total = Utils.readInteger();
			if (total < App.ROUND_CHARGE + App.ROUND_LEAST_BID) {
				System.out.println("Initial total low");
				System.out.println("Must be at least " + (App.ROUND_CHARGE + App.ROUND_LEAST_BID));
			}
		} while (total < App.ROUND_CHARGE + App.ROUND_LEAST_BID);
		initializedTotal = true;
	}

	private boolean isTotalLow() {
		boolean ret = false;
		if (total < (App.ROUND_CHARGE + App.ROUND_LEAST_BID)) {
			System.out.println("[" + name + "]" + "your total does not allow you to place a normal bet i.e. :");
			System.out.println(" at least " + App.ROUND_CHARGE + " for round charge");
			System.out.println(" at least " + App.ROUND_LEAST_BID + " for round least bid");
			System.out.println("Finish Forced. Exiting. Low total.");
			ret = true;
		}
		return ret;
	}

	private void placeRoundBet() {
		int rbet = 0;
		do {
			System.out.print("[" + name + "]"  + " place bet : ");
			rbet = Utils.readInteger();

			if (rbet < App.ROUND_LEAST_BID || rbet + App.ROUND_CHARGE > getTotal()) {
				System.out.println("Bad bet, least round bid " + App.ROUND_LEAST_BID);
			}

		} while (rbet < App.ROUND_LEAST_BID);

		roundBet = rbet;
	}

	public boolean hit() {
		String ans = null;
		boolean ret = false;
		do {
			System.out.print("[" + name + "]"  +  " hit or stay (H/S) ? : ");
			ans = Utils.readString();
			ans = ans.substring(0);
			ans = ans.toUpperCase();
			if (!ans.equalsIgnoreCase("H") && !ans.equalsIgnoreCase("S")) {
				System.out.println("use only H or S.");
			}
		} while (!ans.equalsIgnoreCase("H") && !ans.equalsIgnoreCase("S"));

		if (ans.equalsIgnoreCase("H")) {
			ret = true;
		} else if (ans.equalsIgnoreCase("S")) {
			ret = false;
		}
		return ret;

	}

	/**
	 * returns PlayCode enum information
	 */
	@Override
	public PlayCode play() {

		initHand();
		
		boolean hit = false;
		PlayCode ret = null;
		
		String playRound = playRound();
		if (playRound.equalsIgnoreCase("E")) {
			ret = PlayCode.EXT; //exit
			return ret;
		} else if (playRound.equalsIgnoreCase("N")) {
			ret = PlayCode.LRN; //loose round
			return ret;
		} else if (playRound.equalsIgnoreCase("Y")) {
			//playround
		}

		if (isTotalLow()) {
			ret = PlayCode.LTA; //low total
			return ret;
		} else {
			placeRoundBet();
			charge(App.ROUND_CHARGE, "round charge");
			charge(roundBet, "round bet");
			addToHand(deck.getCard());
			addToHand(deck.getCard());
			state();
		}
		// hit or stay loop
		do {

			hit = hit();
			if (hit) {
				addToHand(deck.getCard());
				state();
			} else {
				state();
				ret = PlayCode.STA;
				break;
			}

			if (isBusted()) {
				System.out.println("[" + name + "] " + PlayCode.BST.getInformation());
				state();
				hit = false;
				ret = PlayCode.BST;
				break;
			}
			if (getHandSum() == 21) {
				System.out.println("[" + name + "] " + PlayCode.BLJ.getInformation());
				win();
				state();
				hit = false;
				ret = PlayCode.BLJ;
				break;
			}

			state();

		} while (!isBusted() && hit);
		return ret;
	}

	public void win() {
		total = total + 2 * roundBet;
	}

	private void loose() {
		// nothing already charged
	}

	private void state() {
		System.out.println("[" + name + "]" + " Hand:{ " + printHand() + "}(" + getHandSum() + ")\t" + "Bid:" + getRoundBet()
				+ "\t" + "Total:" + getTotal() + "\tDeck:" + deck.getSize());
	}

}
