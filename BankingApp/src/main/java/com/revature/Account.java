package com.revature;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Account {
	int accountNum, accountID;
	double accountBalance;
	boolean isApproved;
	private static final Logger logger = LogManager.getLogger(Account.class);
	static Scanner sc = new Scanner(System.in);
	public Account(int accountID,double accBalance,boolean isApproved) {
		this.accountID = accountID;
		this.accountBalance = accBalance;
		this.isApproved = isApproved;

	}
	public Account(int accountNum,int accountID,double accBalance,boolean isApproved) {
		this.accountNum = accountNum;
		this.accountID = accountID;
		this.accountBalance = accBalance;
		this.isApproved = isApproved;

	}
	public double withdraw(int accountNum) {
		if(isApproved) {
			System.out.println("Enter amount to be withdrawn:");
			double x = sc.nextDouble();
			if(x <= accountBalance && x>0) {
				accountBalance = accountBalance - x;
				AccountDao ad = new AccountDao();
			ad.accountUpdate(accountNum, accountBalance);
			logger.debug("Account Number " + accountNum + " withdrew $"+x);
			return accountBalance;
			}else {
				System.out.println("Insufficient Funds! Or negative amount entered");	
				return accountBalance;
		}
		}else {
			System.out.println("Account is not approved");
		}
		
		return 0;
	}
	public double deposit(int accountNum) {
		if(isApproved) {
		System.out.println("Enter amount to be deposited:");
		double x = sc.nextDouble();

		accountBalance = accountBalance + x;
		AccountDao ad = new AccountDao();
		ad.accountUpdate(accountNum, accountBalance);
		logger.debug("Account Number " + accountNum + " deposited $"+x);
		return accountBalance;
	}else {
		System.out.println("Account is not approved yet");
	}
		return 0;
	}
	public double transfer(int accountNum) {
		if(isApproved) {
			System.out.println("Enter amount to transfer:");
			double transferAmt = sc.nextDouble();
			System.out.println("Enter Account Number to transfer to:");
			int accNum2 = sc.nextInt();
			AccountDao ad = new AccountDao();
			double totalBalance = this.accountBalance - transferAmt;
			double totalBalance2 = ad.getAccountBalance(accNum2) + transferAmt;
			logger.debug("Account Number " + accountNum + " transferred $"+ transferAmt);
			ad.accountUpdate(accountNum, totalBalance);
			ad.accountUpdate(accNum2, totalBalance2);
		}else {
			System.out.println("Account is not approved yet");
		}

		return 0;
	}
	public String toString() {
		String approvalStatus = "";
		if(isApproved == true) {
			approvalStatus = "Approved";
		}else {
			approvalStatus = "Pending";
		}
		String result = "Account Number: " + accountNum + "\nAccount Balance: " + accountBalance + "\nIs Approved:" + approvalStatus + "\n";
		return result;
	}
}
