/**
 * Assignment 2
 * Class to read the students and college list
 * @author Arpit Pittie
 */
package session2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import session1.MyArrayList;

public class ReadFiles {

	/**
	 * Method to read the students detail from the file
	 * @param student - The student list to add the candidate object
	 * @param path - The path of file of the candidate information
	 */
	public void readStudents(MyQueue<Candidates> student, String path) {
		String[] temp;
		Candidates candidate;
		FileReader file;	//To open the file
		BufferedReader reader;	//To read the file
		
		try {
			//Opening the file for reading
			file = new FileReader(path);
			reader = new BufferedReader(file);
			
			//Reading the file
			while((path = reader.readLine()) != null) {
				//Splitting the information in the file
				temp = path.split(" ");
				candidate = new Candidates(temp[0], Integer.parseInt(temp[1]));
				//Adding the candidate object to the list
				student.enqueue(candidate);
			}
			
			reader.close();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/**
	 * Method to read the colleges detail from the file
	 * @param clg - The student list to add the college object
	 * @param path - The path of file of the college information
	 */
	public void readColleges(MyArrayList<College> clg, String path) {
		String[] temp;
		College colg;
		FileReader file;	//To open the file
		BufferedReader reader;	//To read the file
		
		try {
			//Opening the file for reading
			file = new FileReader(path);
			reader = new BufferedReader(file);
			
			//Reading the file
			while((path = reader.readLine()) != null) {
				//Splitting the information in the file
				temp = path.split(" ");
				//System.out.println(temp.length);
				colg = new College(temp[1], temp[2], Integer.parseInt(temp[3]), 
						Integer.parseInt(temp[0]));
				//Adding the candidate object to the list
				clg.add(colg);
			}
			
			reader.close();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
