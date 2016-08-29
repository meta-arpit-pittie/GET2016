/**
 * Assignment 1,2,3
 * Connection class to establish the connection with the database
 * @author Arpit Pittie
 */
package session1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDatabase {

	public static Connection connection;	//Creating the connection object
	
	/**
	 * Method to create and opening the connection
	 * @return The Connection object for the session
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		try {
			//Opening the connection
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String host = "jdbc:mysql://localhost:3306/";
		String dbName = "lis";
		
		String userId = "root";
		String password = "arpit";
		
		//Creating the connection url
		String mysqlURL = host+dbName;
		
		//Checking if the connection is already open or not
		if(connection == null) {
			//Creating new connection with the specified url
			connection = DriverManager.getConnection(mysqlURL,userId,password);
		}
		
		return connection;
	}
	
	public static void closeConnection() throws SQLException {
		connection.close();
	}
}
