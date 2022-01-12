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
		System.out.println("Enter your password:");
		password = sc.nextLine();
	}
	public void approveAccount() {
		
	}
	public void declineAccount() {
		
	}
}
