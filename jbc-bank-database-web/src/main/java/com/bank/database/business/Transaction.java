package com.bank.database.business;

import javax.persistence.*;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double amount;
	private String txnType;
	@ManyToOne
	@JoinColumn(name="AccountId")
	private Account account;
	
	public Transaction() {}

	public Transaction(int id, double amount, String txnType, Account account) {
		super();
		this.id = id;
		this.amount = amount;
		this.txnType = txnType;
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
