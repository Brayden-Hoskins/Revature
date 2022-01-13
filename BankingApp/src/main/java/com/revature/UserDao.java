package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {

	public boolean isUsernameTaken(String username) {
		
		try {
			// 1. Create a Statement
			Connection c = ConnectionManager.getConnection();

			
			PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM logininfo WHERE username = ?");
			preparedStatement.setString(1, username);

			ResultSet results = preparedStatement.executeQuery();
			

			if (results.next())
				return true;
			
			return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	public void signUp(String username, String password) {

		try {
			Connection c = ConnectionManager.getConnection();
			Statement statement = c.createStatement();
			
			int rowsAffected = statement.executeUpdate("INSERT INTO logininfo(username,password) VALUES (\'" + username 
					+ "\', \'" + password + "\')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}