package com.revature;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
public class Customer{
	String firstName, lastName, username, password;
	int customerID;
	Scanner sc = new Scanner(System.in);
	private static final Logger logger = LogManager.getLogger(Customer.class);
	public void registerCustomer() {
		
		System.out.println("Enter your first name:");
		firstName = sc.nextLine();
		System.out.println("Enter your last name:");
		lastName = sc.nextLine();
		System.out.println("Enter your username:");
		username = sc.nextLine();
		UserDao ud = new UserDao();
		if(ud.isUsernameTaken(username)) {
			System.out.println("That username is already taken!");
			registerCustomer();
		}
		System.out.println("Enter your password:");
		password = sc.nextLine();
		ud.signUp(username, password, 1);
		CustomerDao cd = new CustomerDao();
		int accID = cd.getAccountID(username);
		cd.createCustomer(accID,firstName, lastName);
		logger.debug(firstName + " " + lastName + " registered an Customer account");
	}
	public void customerMenu() {
		System.out.println("Select one of the following:");
		System.out.println("\t1) View Account balance");
		System.out.println("\t2) Apply for Account");
		System.out.println("\t3) Make a deposit");
		System.out.println("\t4) Make a withdrawal");
		System.out.println("\t5) Transfer funds");
		int ans = sc.nextInt();
		sc.nextLine();
		Account acc = AccountDao.accessAccount(BankUI.loggedInUsername);
		AccountDao ad = new AccountDao();
		switch (ans) {
		case 1:
			viewAccountBalance(BankUI.loggedInUsername);
			logger.debug(BankUI.loggedInUsername + " viewed account balances");
			customerMenu();
			break;
		case 2:
			applyForAccount();
			logger.debug(BankUI.loggedInUsername + " applied for an account");
			customerMenu();
			break;
		case 3:
			acc.deposit(ad.getAccountNumber(BankUI.loggedInUsername));
			logger.debug(BankUI.loggedInUsername + " deposited money");
			customerMenu();
			break;
		case 4:
			acc.withdraw(ad.getAccountNumber(BankUI.loggedInUsername));
			logger.debug(BankUI.loggedInUsername + " withdrew money");
			customerMenu();
			break;
		case 5: 
			acc.transfer(ad.getAccountNumber(BankUI.loggedInUsername));
			customerMenu();
			break;
		}	
		
	}
	public void viewAccountBalance(String username) {
		CustomerDao cd = new CustomerDao();
		ArrayList<Account> customerAccounts = cd.getCustomerAccounts(username);
		if(customerAccounts.size() > 0) {
			System.out.println(customerAccounts.toString());
		}else {
			System.out.println("No accounts found, please create one");
		}
			
	}

	public void applyForAccount() {
		CustomerDao cd = new CustomerDao();
		Account acc = new Account(cd.getAccountID(BankUI.loggedInUsername),0,false);
		AccountDao ad = new AccountDao();
		ad.createAccount(acc);
	}

}
