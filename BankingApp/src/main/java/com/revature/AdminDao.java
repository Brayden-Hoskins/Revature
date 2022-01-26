package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminDao {

	public void createAdmin(int accountid,String firstName, String lastName) {
		try {
			Connection c = ConnectionManager.getConnection();
			Statement statement = c.createStatement();
			
			int rowsAffected = statement.executeUpdate("INSERT INTO admintable(accountid,firstName,lastName) VALUES (\'" + accountid 
					+ "\', \'" + firstName + "\', \'" + lastName + "\')" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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
}
