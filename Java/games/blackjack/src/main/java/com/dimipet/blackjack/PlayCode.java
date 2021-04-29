package com.dimipet.blackjack;

/**
 * Enum holding all possible exit play codes along with their info
 *
 */
public enum PlayCode {
	EXT("Exit"),
	LRN("Loose round"),
	LTA("Low total amount"),
	STA("Stay"),
	BLJ("Blackjack"),
	BST("Busted over 21");

    public final String information;

    private PlayCode(String code) {
        this.information = code;
    }

    public String getInformation() {
		return information;
	}

	public static PlayCode valueOfCode(String information) {
        for (PlayCode c : values()) {
            if (c.information.equals(information)) {
                return c;
            }
        }
        return null;
    }

}
