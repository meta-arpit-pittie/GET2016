/**
 * Assignment 1
 * Helper class to fire the queries to the database
 * And returning the result as a list to the program
 * @author Arpit Pittie
 */
package session1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class HelperClassAuthorTitleName {
	
	/**
	 * Method to execute the select query
	 * @param query - The select query to be executed
	 * @return The list of Titles object containing the result set of the query
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List executeSelectQuery(String query) {
		List<Titles> result = new LinkedList();
		
		try {
			//Creating a statement object
			Statement stmt = ConnectDatabase.getConnection().createStatement();
			//Storing the result of the query
			ResultSet rs = stmt.executeQuery(query);
			
			//Iterating over the result set
			while(rs.next()) {
				//Adding the row of the result as POJO
				Titles title = new Titles();
				title.setTitleId(rs.getInt(1));
				title.setTitleName(rs.getString(2));
				title.setSubjectId(rs.getString(3));
				title.setPublisherId(rs.getString(4));
				
				//Adding the object to the result set
				result.add(title);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
