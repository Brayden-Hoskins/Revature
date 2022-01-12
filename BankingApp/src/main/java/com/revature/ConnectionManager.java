package com.revature;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionManager {
private static Connection connection;
	
	private static String connectionString = "jdbc:postgresql://kashin.db.elephantsql.com:5432/zhcrbmdu",
			username = "zhcrbmdu",
			password = "Pl4NjHckUsXMWNdCqHbOC9a_gfrZrLWW";
	
	public static Connection getConnection() {
		try {
			if (connection == null) {
			
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(connectionString, username, password);
			}
			
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
