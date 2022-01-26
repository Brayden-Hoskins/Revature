package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountDao {
	public int getAccountID(String username) {
		int result = 1;
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM logininfo WHERE username = ?");
			preparedStatement.setString(1, username);

			ResultSet results = preparedStatement.executeQuery();
			results.next();
			result = results.getInt("accountid");
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int getAccountNumber(String username) {
		int result = 1;
		try {
			Connection c = ConnectionManager.getConnection();
			int accID = getAccountID(username);
			PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM accounttable WHERE accountid = ?");
			preparedStatement.setInt(1, accID);
			ResultSet results = preparedStatement.executeQuery();
			results.next();
			result = results.getInt("accountnumber");
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public void accountUpdate(int accountNum, double accountBalance) {
		try {
			// 1. Create a Statement
			Connection c = ConnectionManager.getConnection();

			
			PreparedStatement preparedStatement = c.prepareStatement("UPDATE accounttable SET accountBalance = ? WHERE accountnumber = ?");
			preparedStatement.setDouble(1, accountBalance);
			preparedStatement.setInt(2, accountNum);
			int results = preparedStatement.executeUpdate();	
	}catch(Exception e) {
		
	}
		}
	public double getAccountBalance(int accountNum) {
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = c.prepareStatement("SELECT * accounttable WHERE accountnumber = ?");
			preparedStatement.setInt(1, accountNum);
			ResultSet results = preparedStatement.executeQuery();
			return results.getDouble("accountbalance");
		}catch(Exception e) {
			
		}
		return 0;
	}
	public void createAccount(Account acc) {
		try {
			Connection c = ConnectionManager.getConnection();
			Statement statement = c.createStatement();
			
			int rowsAffected = statement.executeUpdate("INSERT INTO accounttable(accountbalance,accountid,isapproved) VALUES (\'" + acc.accountBalance 
					+ "\', \'" + acc.accountID + "\', \'" + acc.isApproved + "\')" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*public Account getAccounts(){
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM accounttable");
			ResultSet results = preparedStatement.executeQuery();
			ArrayList<Account> myAccounts = new ArrayList<Account>();
			while(results.next()) {
				Account account = new Account(results.getInt("accountnumber"),
									results.getInt("accountid"),
									results.getDouble("accountbalance"),
									results.getBoolean("isApproved"));
				myAccounts.add(account);
			}
			return myAccounts;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/
	public static Account accessAccount(String username) {
		
		try {
			
			// checks that we're in the db
			Connection connection = ConnectionManager.getConnection();
					
			// asks to select a row based on the username
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM logininfo WHERE username = ?");
			preparedStatement.setString(1, username);
			
			// calls that resultset results
			ResultSet results = preparedStatement.executeQuery();
			
			//always need to tell it to go to the next to get to the first row after the column headers
			results.next();
			
			// calls that int in the db named accountID accountIDDB
			int accountIDDB = results.getInt("accountid");
            
			// asks to select a row in the bankAccounts table based on the accountIDDB pulled above
			PreparedStatement otherPreparedStatement = connection.prepareStatement("SELECT * FROM accounttable WHERE accountid = ?");
			otherPreparedStatement.setInt(1, accountIDDB);
			
			// calls that resultset results2 
			ResultSet results2 = otherPreparedStatement.executeQuery();
			
			//always need to tell it to go to the next to get to the first row after the column headers
			if (results2.next() == false) {
				
				return null;
				
			} else {

				int accountID = results2.getInt("accountid");
				int balance = results2.getInt("accountbalance");
				boolean isApproved = results2.getBoolean("isapproved");
				
				// creates a bank account object that holds that info
				Account myBankAccount = new Account(accountID, balance, isApproved);
				
				// returns that bank account object
				return myBankAccount;
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	
	}
}
	