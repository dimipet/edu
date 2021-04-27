package com.dimipet.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

	private String name;
	private List<Account> accounts;

	public Bank(String name) {
		this.name = name;
		accounts = new ArrayList<Account>();
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * Αίτηση δημιουργίας νέου λογαριασμού
	 * @param name
	 * @param annualIncome
	 */
	public Account applyForAccount(String name, int annualIncome) {
		Account a = null;
		if(annualIncome>10000) {
			System.out.println("Η αίτηση σας εγκρίθηκε");
			a = createAccount(name);
		} else {
			System.out.println("Η αίτηση σας απορρίφθηκε, το ετήσιο εισόδημα σας είναι πολύ χαμηλό");
		}
		return a;
	}

	/**
	 * Δημιουργια νεου πελατη και λογαριασμου
	 * 
	 * @param customerName
	 * @return
	 */
	private Account createAccount(String customerName) {
		Customer newCustomer = new Customer(customerName);
		Account newAccount = new Account(Utils.getRandomAccountId(), newCustomer);
		accounts.add(newAccount);
		System.out.println("Η τράπεζα " + this.name + " δημιουργησε τον λογαριασμό " + newAccount.getId()
				+ " για τον πελάτη " + newCustomer.getName());
		return newAccount;
	}

	/**
	 * Δημιουργία κάρτας και ανάθεσης της σε πελάτη
	 * @param customer
	 * @param cardType
	 * @return
	 */
	public Card createAndAssignCard(Customer customer, CardType cardType) {
		//new Card(String type, int number, String holder, int ccv, int pin, String expiration);
		Card newCard = new Card(cardType, Utils.getCardRandomNumber(), customer.getName(), Utils.getCardRandomCcv(),
				Utils.getCardRandomPin(), Utils.getCardRandomExpirationDate());
		customer.setCard(newCard);
		System.out.println("Created " + newCard.toString() + " and assigned to " + customer.toString());
		return newCard;
	}

	/**
	 * εμφανιση ολων των λογαριασμων
	 */
	public void printAllAccounts() {
		System.out.println("----------------------------------------");
		System.out.println("Εμφανιση ολων των λογαριασμων");
		for(Account a : accounts) {
			System.out.println(a.toString());
		}
	}

} 
