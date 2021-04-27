package com.dimipet.bank;

public enum CardType {
	
	MASTER("MasterCard"),
    MAESTRO("Maestro"),
    VISA("Visa"),
    PaySafe("PaySafe"),
    AMEX("American Express");

    public final String label;

    private CardType(String label) {
        this.label = label;
    }

}
