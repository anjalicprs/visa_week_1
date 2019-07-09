package com.visa.prj.entity;
/**
 * This is an entity class which is used to represent
 * account business data
 * @author root
 * @version 1.0
 *
 */
public class Account {
	private double balance; //state of object [ instance variable ]
	private String accNo;
	private static int count; //One copy per class as static is added to it
	public Account(String no) {
		count = getCount() + 1;
		this.accNo = no;
	}
	
	/**
	 * method for amount to be credited
	 * @param amt amount to be credited
	 */
	public void deposit(double amt) {
		setBalance(getBalance() + amt);  //this.balance+= amt;
	}
	/**
	 * gives status of current balance
	 * 
	 * 
	 * @return current balance
	 */
	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccNo() {
		return accNo;
	}

	@Override
	public boolean equals(Object obj) {
		
		Account other = (Account) obj;
		return this.accNo.equals(other.accNo);
	}

	public static int getCount() { //This is a class call can not be called by object
		return count;
	}
	
	
}
