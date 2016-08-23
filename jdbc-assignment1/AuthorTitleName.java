/**
 * Assignment 1
 * Main class to get the all the titles for a given author
 * @author Arpit Pittie
 */
package session1;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AuthorTitleName {

	private Scanner scan;	//To get the input
	
	/**
	 * Method to get the input from user for the author name
	 * @return String - The author name
	 */
	public String getAuthorName() {
		scan = new Scanner(System.in);
		String author = "";
		System.out.println("Enter author name");
		
		//Getting input for the author name
		try {
			author = scan.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
		
		return author;
	} 
	
	/**
	 * Method to display the the title name written by the author
	 * @param author - The author name
	 */
	@SuppressWarnings("unchecked")
	public void displayResult(String author) {
		//Creating query to fetch the titles for the particular author
		String query = "SELECT * FROM titles t INNER JOIN title_author ta ON t.title_id = ta.title_id "
				+ "INNER JOIN authors a ON ta.author_id = a.author_id WHERE a.author_name = '"+author+"'";
		
		//Getting the result of the query
		List<Titles> result = HelperClassAuthorTitleName.executeSelectQuery(query);
		
		System.out.println("The books name for the author "+author+" are :");
		//Iterating and printing the title name for the given author name
		for(Titles title : result) {
			System.out.println(title.getTitleName());
		}
	}
	
	public static void main(String[] args) {
		try {
			//Opening the connection
			ConnectDatabase.getConnection();
			
			AuthorTitleName title = new AuthorTitleName();
			//Get the author name
			String author = title.getAuthorName();
			//Displaying the result
			title.displayResult(author);
			
			//Closing the connection
			ConnectDatabase.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
