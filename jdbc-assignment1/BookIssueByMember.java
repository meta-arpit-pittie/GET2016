/**
 * Assignment 2
 * Main class to Issue a book to the member if available
 * @author Arpit Pittie
 */
package session1;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class BookIssueByMember {

	private Scanner scan;	//To get the input from user
	
	/**
	 * Method to get the input from user for the book name
	 * @return String - The book name
	 */
	public String getBookName() {
		scan = new Scanner(System.in);
		String bookName = "";
		System.out.println("Enter book name");
		
		//Getting input for the book name
		try {
			bookName = scan.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bookName;
	}
	
	/**
	 * Method to get the input from user for the member id
	 * @return String - The member id
	 */
	public String getMemberId() {
		String memberId = "";
		System.out.println("Enter Member Id");
		
		//Getting input for the member id
		try {
			memberId = scan.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		scan.close();
		return memberId;
	}
	
	/**
	 * Method to check if the book can be issued or not
	 * If can be issued then add a record for the same
	 * @param bookName - The book name
	 * @param memberId - The member id
	 */
	@SuppressWarnings("unchecked")
	public void issueBook(String bookName, String memberId) {
		//Creating query to fetch book id from the book name
		String query = "SELECT * FROM books b "
				+ "INNER JOIN titles t ON b.title_id = t.title_id "
				+ "WHERE t.title_name = '"+bookName+"'";
		int accessionNumber = 0;
		boolean bookIssued;
		
		//Getting the result of the query
		List<Books> result = HelperClassBookIssueByMember.executeGetAccessionIdQuery(query);
		//Iterating over the list to get the book id
		for (Books b : result) {
			accessionNumber = b.getAccessionNumber();
		}
		
		//Creating query to check if the book can be issued or not
		query = "SELECT bi.issue_dt, bi.accession_number, bi.member_id, br.return_dt FROM book_issue bi "
				+ "LEFT JOIN book_return br ON bi.accession_number = br.accession_number AND "
				+ "bi.member_id = br.member_id AND bi.issue_dt = br.issue_dt "
				+ "WHERE bi.accession_number = "+accessionNumber;
		//Getting the result of the query
		bookIssued = HelperClassBookIssueByMember.executeCheckQuery(query);
		
		//Checking if the book is available for issuing
		if(bookIssued) {
			//Getting the system date
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Calendar cal = Calendar.getInstance();
			//Saving the current date
			String issueDate = dateFormat.format(cal.getTime());
			//Adding 15 days to current date for due date
			cal.add(Calendar.DATE, 15);
			//Saving the due date
			String dueDate = dateFormat.format(cal.getTime());
			
			//Creating query to insert the record for issuing the book
			query = "INSERT INTO book_issue VALUES "
					+ "('"+issueDate+"', "+accessionNumber+", '"+memberId+"', '"+dueDate+"')";
			//Getting the result of the query
			HelperClassBookIssueByMember.executeIssueBookQuery(query);
			System.out.println("The book has been issued");
		} else {
			System.out.println("The book is already issued so can't be re-isssued");
		}
	}
	
	public static void main(String[] args) {
		try {
			//Opening the connection
			ConnectDatabase.getConnection();
			
			BookIssueByMember issueByMember = new BookIssueByMember();
			//Getting the book name
			String bookName = issueByMember.getBookName();
			//Getting the member id
			String memberId = issueByMember.getMemberId();
			
			issueByMember.issueBook(bookName, memberId);
			
			//Closing the connection
			ConnectDatabase.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
