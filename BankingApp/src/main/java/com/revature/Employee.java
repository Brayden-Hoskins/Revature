package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Employee extends Customer{
	private static final Logger logger = LogManager.getLogger(Employee.class);
	String fName,lName,username,password;
	int employeeID;
	static Scanner sc = new Scanner(System.in);
	public void registerEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your first name:");
		this.fName = sc.nextLine();
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
		ud.signUp(username, password,2);
		EmployeeDao ed = new EmployeeDao();
		int accID = ed.getAccountID(username);
		ed.createEmployee(accID,fName, lName);
		logger.debug(fName + " " + lName + " registered an Employee account");
	}
	public void employeeMenu() {
		System.out.println("Select one of the following:");
		System.out.println("\t1) View Account balances");
		System.out.println("\t2) Approve Account");
		System.out.println("\t3) View Account Information");
		int ans = sc.nextInt();
		EmployeeDao ed = new EmployeeDao();
		switch (ans) {
		case 1:
			System.out.println(ed.getAllAccounts());
			logger.debug(fName + " " + lName + " viewed all accounts");
			employeeMenu();
			break;
		case 2:
			approveAccount();
			employeeMenu();
			break;
		case 3:
			System.out.println(ed.getAccountInformation(ed.getAccountID(username)));
			employeeMenu();
			break;
		}
	}
	public void approveAccount() {
		ArrayList<Account> accounts = new ArrayList<Account>();
		EmployeeDao ed = new EmployeeDao();
		accounts = ed.getAllAccounts();
		System.out.println(accounts);
		System.out.println("Enter account number to approve:");
		int accNum = sc.nextInt();
		ed.setApproved(accNum);
		logger.debug(this.fName + " " + this.lName + " approved account " + accNum);
		employeeMenu();	
	}

}
