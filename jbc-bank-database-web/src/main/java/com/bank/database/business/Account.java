package com.bank.database.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String birthdate;
	private String accountHolder;
	private double balance;
	private double fees;
	
	public Account() {
		
	}

	public Account(int id, String birthdate, String accountHolder, double balance, double fees) {
		super();
		this.id = id;
		this.birthdate = birthdate;
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.fees = fees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", birthdate=" + birthdate + ", accountHolder=" + accountHolder + ", balance="
				+ balance + ", fees=" + fees + ", getId()=" + getId() + ", getBirthdate()=" + getBirthdate()
				+ ", getAccountHolder()=" + getAccountHolder() + ", getBalance()=" + getBalance() + ", getFees()="
				+ getFees() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
