package model.entities;

import model.exceptions.WithdrawException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	
	public Account() {
	}
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		WithdrawException(amount);
		balance -= amount;
	}
	
	private void WithdrawException(double amount) {
		if (amount > getWithdrawLimit()) {
			throw new WithdrawException ("The amount exceeds withdraw limit");
		}
		else if(amount > getBalance()) {
			throw new WithdrawException ("Not enough balance");
		}
	}
	
	@Override
	public String toString() {
		return "New balance: " + String.format("%.2f", balance);
	}

}
