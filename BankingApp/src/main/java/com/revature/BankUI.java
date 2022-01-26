package com.revature;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class BankUI {
	//public static Map<String,String> loginInfo = new HashMap<String,String>();
	public static String loggedInUsername;
	/*public void populateLogin(String file){
	    try {
	        FileReader filereader = new FileReader(file);
	        CSVReader csvReader = new CSVReader(filereader);
	        String[] nextRecord;

	        while ((nextRecord = csvReader.readNext()) != null) {
	            for (int i =0; i<nextRecord.length;i = i+2) {
	                loginInfo.put(nextRecord[i], nextRecord[i+1]);
	            }
	            System.out.println();
	        }
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}*/
	public void display() {
		//populateLogin("C:\\Users\\brady\\OneDrive\\Desktop\\Revature\\BankingApp\\src\\main\\java\\com\\revature\\loginInfo.txt");
		Scanner sc = new Scanner(System.in);
		System.out.println("Select from one of the following choices:");
		System.out.println("\t1) Register for an account");
		System.out.println("\t2) Login");
		int ans = sc.nextInt();
		switch (ans) {
		case 1:
			register();
			break;
		case 2:
			login();
			break;
		}	
		
	}
/*	public void writeToCSV(String filePath) {
		 File file = new File(filePath);
		    try {
		        // create FileWriter object with file as parameter
		        FileWriter outputfile = new FileWriter(file);
		  
		        // create CSVWriter object filewriter object as parameter
		        CSVWriter writer = new CSVWriter(outputfile);
		  
		  
		        // add data to csv
		        String[] data1 = { "Aman", "10" };
		        writer.writeNext(data1);
		        String[] data2 = { "Suraj", "10" };
		        writer.writeNext(data2);
		  
		        // closing writer connection
		        writer.close();
		    }
		    catch (IOException e) {
		        e.printStackTrace();
		    }*/
	//}
	public void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String username = sc.nextLine();
		System.out.println("Enter Password: ");
		String password = sc.nextLine();
		validateLogin(username,password);
		
	}
	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Are you one of the following:");
		System.out.println("\t1) Customer");
		System.out.println("\t2) Employee");
		System.out.println("\t3) Admin");
		int ans = sc.nextInt();
		switch (ans) {
		case 1:
			Customer c1 = new Customer();
			c1.registerCustomer();
			System.out.println("Please login");
			login();
			//registerCustomer();
			break;
		case 2:
			Employee e1 = new Employee();
			e1.registerEmployee();
			System.out.println("Please login");
			login();
			//registerEmployee();
			break;
		case 3:
			Admin a1 = new Admin();
			a1.registerAdmin();
			System.out.println("Please login");
			login();
			//registerAdmin();
			break;
		}	
		
		
	}
	public boolean validateLogin(String user, String pass) {
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM logininfo WHERE username = ? AND password = ?");
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			loggedInUsername = user;
			ResultSet results = preparedStatement.executeQuery();
			if(results.next()) {
				System.out.println("Login successful!");
				int ans = results.getInt("role");
				switch (ans) {
				case 1:
					Customer c1 = new Customer();
					c1.customerMenu();
					return true;
					//registerCustomer();
					
				case 2:
					Employee e1 = new Employee();
					e1.employeeMenu();
					return true;
					//registerEmployee();
					
				case 3:
					Admin a1 = new Admin();
					a1.adminMenu();
					 return true;
					//registerAdmin();
					
				}		
			}else {
				System.out.println("Invalid username or password");
				login();
				return false;	
				
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
}
}