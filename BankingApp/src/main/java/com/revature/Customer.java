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
		System.out.println("Enter your password:");
		password = sc.nextLine();
		
	} 
	
}
