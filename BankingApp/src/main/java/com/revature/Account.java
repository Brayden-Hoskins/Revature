package com.revature;
import java.util.Scanner;

public class Account {
	String accountType, fName, lName;
	int accountNum;
	double accountBalance;
	boolean isJointAccount;
	static Scanner sc = new Scanner(System.in);
	public Account(int i, String str1, double x, String str2, String str3) {
		this.accountNum = i;
		this.accountType = str1;
		this.accountBalance = x;
		this.fName = str2;
		this.lName = str3;
	}
	public double withdraw(double x) {
		System.out.println("Enter amount to be withdrawn:");
		x = sc.nextDouble();
		accountBalance = accountBalance - x;
		return accountBalance;
	}
	public double deposit(double x) {
		System.out.println("Enter amount to be deposited:");
		x = sc.nextDouble();
		accountBalance = accountBalance + x;
		return accountBalance;
	}
	public double trasnfer(String acc, double d) {
		return 0;
	}
	public int setAccountNum(int x) {
		this.accountNum = x;
		return accountNum ;
	}
	public boolean setJointAccount(boolean b) {
		this.isJointAccount = b;
		return isJointAccount;
	}
	
}
