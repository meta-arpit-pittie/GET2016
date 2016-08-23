/**
 * Assignment 2
 * Main class to delete the books which were not issued in the past one year
 * @author Arpit Pittie
 */
package session1;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DeleteBooks {

	/**
	 * Method to delete the books from the database
	 * which were not issued in the last one year
	 */
	public void deleteRecords() {
		//Getting the system date
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		//Saving the current date
		String currentDate = dateFormat.format(cal.getTime());
		
		//Generating the query
		String query = "DELETE FROM books "
				+ "WHERE accession_number NOT IN ("
				+ "SELECT DISTINCT bi.accession_number FROM book_issue bi "
				+ "WHERE TIMESTAMPDIFF(YEAR, bi.issue_dt, '"+currentDate+"') = 0)";
		//System.out.println(query);
		System.out.println("The books deleted "+HelperDeleteBooks.executeDeleteQuery(query));
	}
	
	public static void main(String[] args) {
		try {
			//Opening the connection
			ConnectDatabase.getConnection();
			
			DeleteBooks deleteBook = new DeleteBooks();
			deleteBook.deleteRecords();
			
			//Closing the connection
			ConnectDatabase.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
