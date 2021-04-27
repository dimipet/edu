package com.dimipet.bank;

public class Main {

	public static void main(String[] args) {

		// Create a bank
		Bank alphaBank = new Bank("SimpleBank");

		// customer applies for new account ..... rejected
		Account a0 = alphaBank.applyForAccount("Πλάτωνας", 10000);
		
		// customer applies for new account .... accepted 
		Account a1 = alphaBank.applyForAccount("Σωκράτης", 11000);

		// if account approved -> simulate some transactions
		if (a1 != null) {
			a1.deposit(123);
			a1.charge(132);
			a1.deposit(567);
			a1.charge(321);
			a1.toString();

			Card c1 = alphaBank.createAndAssignCard(a1.getCustomer(), CardType.MASTER);
			a1.charge(c1, 18);
			a1.deposit(c1, 45);
		}

		a1.printTransactions();

		// print all bank accounts
		alphaBank.printAllAccounts();

	}
}
