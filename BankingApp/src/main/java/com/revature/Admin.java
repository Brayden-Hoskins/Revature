package com.revature;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Admin extends Employee{
	static Scanner sc = new Scanner(System.in);
	private static final Logger logger = LogManager.getLogger(Admin.class);
	public void registerAdmin() {
		System.out.println("Enter your first name:");
		fName = sc.nextLine();
		System.out.println("Enter your last name:");
		lName = sc.nextLine();
		System.out.println("Enter your username:");
		username = sc.nextLine();
		UserDao ud = new UserDao();
		if(ud.isUsernameTaken(username)) {
			System.out.println("That username is already taken!");
			registerAdmin();
		}
		System.out.println("Enter your password:");
		password = sc.nextLine();
		ud.signUp(username, password,3);
		AdminDao ad = new AdminDao();
		int accID = ad.getAccountID(username);
		ad.createAdmin(accID,fName, lName);
		logger.debug(fName + " " + lName + " registered an Admin account");
	}
	public void adminMenu() {
		System.out.println("Select one of the following:");
		System.out.println("\t1) View All Accounts");
		System.out.println("\t2) Approve Account");
		System.out.println("\t3) Make a deposit");
		System.out.println("\t4) Make a withdrawal");
		System.out.println("\t5) Transfer funds");
		int ans = sc.nextInt();
		sc.nextLine();
		AccountDao accDao = new AccountDao();
		Account acc;
		switch (ans) {
		case 1:
			AdminDao ad = new AdminDao();
			System.out.println(ad.getAllAccounts());
			adminMenu();
			break;
		case 2:
			approveAccount();
			adminMenu();
			break;
		case 3:
			System.out.println("Enter the username of the Account you want:");
			String username = sc.nextLine();
			acc = AccountDao.accessAccount(username);
			acc.deposit(accDao.getAccountNumber(username));
			adminMenu();
			break;
		case 4:
			System.out.println("Enter the username of the Account you want:");
			username = sc.nextLine();
			acc = AccountDao.accessAccount(username);
			acc.withdraw(accDao.getAccountNumber(username));
			adminMenu();
			break;
		case 5: 
			System.out.println("Enter the username of the Account to transfer from:");
			username = sc.nextLine();
			acc = AccountDao.accessAccount(username);
			acc.transfer(accDao.getAccountNumber(username));
			adminMenu();
			break;
		}
	}
	public void approveAccount() {
		ArrayList<Account> accounts = new ArrayList<Account>();
		AdminDao ad = new AdminDao();
		accounts = ad.getAllAccounts();
		System.out.println(accounts);
		System.out.println("Enter account number to approve:");
		int accNum = sc.nextInt();
		ad.setApproved(accNum);
		logger.debug(fName + " " + lName + " approved account " + accNum);
		adminMenu();	
	}
}
