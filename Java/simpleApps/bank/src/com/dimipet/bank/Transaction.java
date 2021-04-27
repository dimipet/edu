package com.dimipet.bank;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
	
	private String date;
	private TransactionType transactionType;
	private double totalBeforeTranscation;
	private double totalAfterTranscation;
	
	private final static String pattern = " yyyy-MM-dd HH:mm:ss.SSSZ";
	private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	
	public Transaction(TransactionType transactionType, double totalBeforeTranscation, double totalAfterTranscation) {
		
		this.date = simpleDateFormat.format(new Date());
		this.transactionType = transactionType;
		this.totalBeforeTranscation = totalBeforeTranscation;
		this.totalAfterTranscation = totalAfterTranscation;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public double getTotalBeforeTranscation() {
		return totalBeforeTranscation;
	}

	public void setTotalBeforeTranscation(double totalBeforeTranscation) {
		this.totalBeforeTranscation = totalBeforeTranscation;
	}

	public double getTotalAfterTranscation() {
		return totalAfterTranscation;
	}

	public void setTotalAfterTranscation(double totalAfterTranscation) {
		this.totalAfterTranscation = totalAfterTranscation;
	}

	@Override
	public String toString() {
		return "Transaction " + date.toString() +" [" + transactionType.getLabel() + ", Total(before)=" + totalBeforeTranscation
				+ ", Total(after)=" + totalAfterTranscation + "]";
	}

	
	
}
