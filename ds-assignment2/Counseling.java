/**
 * Assignment 2
 * Main class for the counseling  of the students for the college allocation
 * @author Arpit Pittie
 */
package session2;

import java.util.Scanner;

import session1.MyArrayList;

public class Counseling {

	private MyQueue<Candidates> students;	//The queue to store the candidate  objects
	private MyArrayList<College> clg;	//The list to store the college objects
	private Scanner scan;	//The object to get the input from the user 
	private ReadFiles files;	//The object of the class to read the information from the files
	
	public Counseling() {
		students = new MyQueue<Candidates>();
		clg = new MyArrayList<College>();
		scan = new Scanner(System.in);
		files = new ReadFiles();
	}
	
	/**
	 * Method to read the information from the file
	 */
	public void read() {
		String path;
		
		//Getting input of file path for college information
		System.out.println("Enter path for college list");
		path = scan.nextLine();
		files.readColleges(clg, path);
		//sorting the college information based on its rank
		clg.sort();
		
		//Getting input of file path for student information
		System.out.println("Enter path for students list");
		path = scan.nextLine();
		files.readStudents(students, path);
		//sorting the student information based on its rank
		students.sort();
	}
	
	/**
	 * Method to start the counseling for the students
	 */
	public void startCounselling() {
		//The temporary queue to keep the students object
		MyQueue<Candidates> temp = new MyQueue<Candidates>();
		int size = students.size();
		boolean result;		//to store that all the students have filled for counseling
		boolean full;		//to store the information if the seats in the colleges are full
		
		do {
			result = false;
			//loop to get the choices filled by every candidate
			for(int i=0; i < size; i++) {
				//check if the candidate has already allocated a college
				if(students.getFront().getCollege() == null) {
					display();
					students.getFront().fillChoices(scan, clg);
				}
				/*dequeue the original queue and adding to the temporary queue
				 *  for traversing the candidates */
				temp.enqueue(students.dequeue());
			}
			students = temp;
			
			temp = new MyQueue<Candidates>();
			//loop to allocate the college to the candidates
			for(int i=0; i < size; i++) {
				/*to check if the candidate has chosen the college for counseling or not
				 *if yes then the counseling shoul continue to the next round also*/
				if(students.getFront().getChoices().size() > 0) {
					result = true;
				}
				//to allocate the college to the college based on its choices
				students.getFront().allocateCollege(clg);
				/*dequeue the original queue and adding to the temporary queue
				 *  for traversing the candidates */
				temp.enqueue(students.dequeue());
			}
			students = temp;
			
			full = true;
			//loop to check if the seats in all the colleges are full or not
			for(int i=0; i < clg.size(); i++) {
				if(clg.get(i).getSeats() > 0) {
					full = false;
				}
			}
		} while(result && !full);
	}
	
	/**
	 * Method to display the college information to the candidates
	 */
	public void display() {
		System.out.println("S.No.\tName\tPlace\tSeats");
		for (int i=0; i < clg.size(); i++) {
			//display the information only for the colleges having seats available
			if(clg.get(i).getSeats() > 0) {
				System.out.println(clg.get(i).getRank()+"\t"+clg.get(i).getName()+"\t"+
						clg.get(i).getPlace()+"\t"+clg.get(i).getSeats());
			}
		}
	}
	
	/**
	 * Method to display the college allocated to the candidates
	 */
	public void result() {
		MyQueue<Candidates> temp = new MyQueue<Candidates>();
		System.out.println("Rank\tName\tCollege");
		int size = students.size();
		//loop to print the candidate information with the college name
		for(int i=0; i < size; i++) {
			System.out.print(students.getFront().getRank()+"\t"+students.getFront().getName());
			//checking if the college is allocated to a candidate or not
			if(students.getFront().getCollege() != null) {
					System.out.println("\t"+students.getFront().getCollege().getName());
			} else {
				System.out.println("\t-");
			}
			temp.enqueue(students.dequeue());
		}
		students = temp;
	}
	
	public static void main(String[] args) {
		Counseling counsel = new Counseling();
		counsel.read();
		counsel.startCounselling();
		counsel.result();
	}
}
