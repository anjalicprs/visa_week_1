package com.visa.prj.client;

import com.visa.prj.entity.Account;

public class AccountClient {

	public static void main(String[] args) {
		Account first = new Account("SBI345");
		Account second = new Account("SBI123");
		
		first.deposit(5000);  //deposit(first, 5000)
		second.deposit(2500); //deposit(second, 2500)
		
		System.out.println("first account "+first.getAccNo());
		System.out.println("balance is "+first.getBalance());
		
		System.out.println("second account "+second.getAccNo());
		System.out.println("balance is "+second.getBalance());
		
		
		System.out.println("******");
		Account rahul = new Account("SBI100");
		Account sweta = new Account("SBI100");
		Account ref = rahul;
		if(ref == rahul ) {
			System.out.println("rahul and ref are same");
		}
		
		if(rahul.equals(sweta)) {
			System.out.println("sweta and rahul are same");
		}
		System.out.println(Account.getCount());
		
	}

}
