package com.revature;

import java.util.Scanner;

public class Employee extends Customer{
	String fName,lName,username,password;
	
	public void registerEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your first name:");
		fName = sc.nextLine();
		System.out.println("Enter your last name:");
		lName = sc.nextLine();
		System.out.println("Enter your username:");
		username = sc.nextLine();
		System.out.println("Enter your password:");
		password = sc.nextLine();
	}
	public void viewAccountBalances(Account acc) {
		
	}
	public void viewAccInfo(Customer c) {
		System.out.println(c.username);
		System.out.println(c.password);
	}
	public void viewPersonalInfo(Account acc) {
		System.out.println(acc.fName);
		System.out.println(acc.lName);
	}
	public void approveApplication() {
		
	}
	public void declineApplication() {
		
	}
}
