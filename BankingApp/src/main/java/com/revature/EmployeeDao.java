package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDao {
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
	public void createEmployee(int accountid,String firstName, String lastName) {
		try {
			Connection c = ConnectionManager.getConnection();
			Statement statement = c.createStatement();
			
			int rowsAffected = statement.executeUpdate("INSERT INTO employeetable(accountid,firstName,lastName) VALUES (\'" + accountid 
					+ "\', \'" + firstName + "\', \'" + lastName + "\')" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Account> getAllAccounts(){
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
	}
	public String getAccountInformation(int accountid) {
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM customertable WHERE accountid = ?");
			preparedStatement.setInt(1, accountid);
			ResultSet results = preparedStatement.executeQuery();
			results.next();
			String result = results.getString("firstname");
			results.next();
			String result2 = results.getString("lastname");
			String resultString = "First name: "+ result + "\nLast name: " + result2;
			return resultString;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	public void setApproved(int accountNum) {
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = c.prepareStatement("UPDATE accounttable SET isapproved = True WHERE accountnumber = ?");
			preparedStatement.setInt(1, accountNum);
			int results = preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
