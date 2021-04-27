package com.dimipet.bank;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private int id;
	private Customer customer;
	private double total;
	private List<Transaction> transactions;


	public Account(int id, Customer customer) {
		this.id = id;
		this.customer = customer;
		this.total = 0;
		transactions = new ArrayList<Transaction>();
	}

	public int getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void deposit(double amount) {
		double temp = this.total + amount;
		transactions.add(new Transaction(TransactionType.AD, this.total, temp));
		this.total = temp;
		System.out.println("Πίστωση λογαριασμού : " + amount);
		printTotal();
	}

	public void deposit(Card card, double amount) {
		double temp = this.total + amount;
		transactions.add(new Transaction(TransactionType.CD, this.total, temp));
		this.total = temp;
		System.out.println("Πίστωση λογαριασμού (κάρτα) : " + amount);
		printTotal();
	}

	public void charge(double amount) {
		double temp = this.total - amount;
		transactions.add(new Transaction(TransactionType.AC, this.total, temp));
		this.total = temp;
		System.out.println("Χρέωση λογαριασμού με " + amount);
		printTotal();
	}

	public void charge(Card card, double amount) {
		double temp = this.total - amount;
		transactions.add(new Transaction(TransactionType.CC, this.total, temp));
		this.total = temp;
		System.out.println("Χρέωση λογαριασμού (κάρτα) με " + amount);
		printTotal();
	}

	public void printTotal() {
		System.out.println("Νέο υπόλοιπο λογαριασμού : " + total);
	}

	public void printTransactions() {
		System.out.println("----------------------------------------");
		System.out.println("Printing transactions for account " + id + " (" + this.customer.getName() + ")");
		for (Transaction t : transactions) {
			System.out.println(t.toString());
		}
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", customer=" + customer + ", total=" + total + "]";
	}

}
