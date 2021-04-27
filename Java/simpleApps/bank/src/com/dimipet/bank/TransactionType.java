package com.dimipet.bank;

public enum TransactionType {
	
	AD("Account Deposit"),
    AC("Account Charge"),
    CD("Card Deposit"),
    CC("Card Charge");

    public final String label;

    private TransactionType(String label) {
        this.label = label;
    }

	public String getLabel() {
		return label;
	}

}
