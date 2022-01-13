package com.revature;

import java.util.Scanner;

public class Admin extends Employee{
	public void registerAdmin() {
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
			registerAdmin();
		}
		System.out.println("Enter your password:");
		password = sc.nextLine();
		ud.signUp(username, password);
	}
	public void approveAccount() {
		
	}
	public void declineAccount() {
		
	}
}
