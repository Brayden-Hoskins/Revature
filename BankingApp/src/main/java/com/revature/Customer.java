package com.revature;
import java.util.Scanner;
public class Customer{
	String fName, lName, username,password;
	Account acc;
	public void registerCustomer() {
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
			registerCustomer();
		}
		System.out.println("Enter your password:");
		password = sc.nextLine();
		ud.signUp(username, password);
		
	}
	public void customerMenu() {
		System.out.println("Select one of the following:");
		System.out.println("\t1) View Account balance");
		System.out.println("\t2) Make a deposit");
		System.out.println("\t3) Make a withdrawal");
		System.out.println("\t4) Transfer funds");
		
	}
	
}
