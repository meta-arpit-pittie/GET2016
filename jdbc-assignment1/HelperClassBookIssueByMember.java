/**
 * Assignment 2
 * Helper class to fire the queries to the database
 * And returning the result to the program
 * @author Arpit Pittie
 */
package session1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class HelperClassBookIssueByMember {

	/**
	 * Method to execute the query for checking the book can be issued or not
	 * @param query - The select query to be executed
	 * @return True if book can be issued else false
	 */
	public static boolean executeCheckQuery(String query) {
		boolean result = true;
		try {
			//Creating a statement object
			Statement stmt = ConnectDatabase.getConnection().createStatement();
			//Storing the result of the query
			ResultSet rs = stmt.executeQuery(query);
			
			//Iterating over the result set
			while(rs.next()) {
				//Checking if the issued book has been returned or not
				if(rs.getString("return_dt").equalsIgnoreCase("null")) {
					result = false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * Method to execute the query for inserting the row for issuing the book
	 * @param query - The select query to be executed
	 * @return True if book is issued else false
	 */
	public static boolean executeIssueBookQuery(String query) {
		boolean result = false;
		try {
			//Creating a statement object
			Statement stmt = ConnectDatabase.getConnection().createStatement();
			//Storing the result of the query
			int rs = stmt.executeUpdate(query);
			
			if(rs > 0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * Method to execute the select query for getting the book id
	 * @param query - The select query to be executed
	 * @return The list of Books object containing the result set of the query
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List executeGetAccessionIdQuery(String query) {
		List<Books> result = new LinkedList();
		
		try {
			//Creating a statement object
			Statement stmt = ConnectDatabase.getConnection().createStatement();
			//Storing the result of the query
			ResultSet rs = stmt.executeQuery(query);
			
			//Iterating over the result set
			while(rs.next()) {
				//Adding the row of the result as POJO
				Books book = new Books();
				book.setAccessionNumber(rs.getInt(1));
				book.setTitleId(rs.getInt(2));
				book.setPurchaseDate(rs.getString(3));
				book.setPrice(rs.getFloat(4));
				book.setStatus(rs.getString(5));
				
				//Adding the object to the result set
				result.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
