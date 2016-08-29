/**
 * Assignment 1
 * Helper class to fire the queries to the database
 * And returning the result to the program
 * @author Arpit Pittie
 */
package session1;

import java.sql.SQLException;
import java.sql.Statement;

public class HelperDeleteBooks {

	/**
	 * Method to execute the query for deleting the books not issued in the past one year
	 * @param query - The query to be executed
	 * @return The number of rows deleted
	 */
	public static int executeDeleteQuery(String query) {
		int rs = 0;
		try {
			//Creating a statement object
			Statement stmt = ConnectDatabase.getConnection().createStatement();
			//Storing the result of the query
			rs = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
