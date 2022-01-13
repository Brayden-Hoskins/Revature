package com.revature;

import java.util.Scanner;

public class Employee extends Customer{
	String fName,lName,username,password;
	int employeeID;
	
	public void registerEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your first name:");
		fName = sc.nextLine();
		System.out.println("Enter your last name:");
		lName = sc.nextLine();
		System.out.println("Enter your username:");
		username = sc.nextLine();
		UserDao ud = new UserDao();
		if(ud.isUsernameTaken(username)) {
			System.out.println("That username is already taken!");
			registerEmployee();
		}
		System.out.println("Enter your password:");
		password = sc.nextLine();
		ud.signUp(username, password);
	}
	public void employeeMenu() {
		System.out.println("Select one of the following:");
		System.out.println("\t1) View Account balance");
		System.out.println("\t2) Make a deposit");
		System.out.println("\t3) Make a withdrawal");
		System.out.println("\t4) Transfer funds");
		System.out.println("\t5) Approve/Decline Applications");
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
