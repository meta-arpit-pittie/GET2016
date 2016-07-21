/**
 * Assignment 1
 * Class to read the questions from the given input file
 * @author Arpit Pittie
 */
package session2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadQuestions {
	
	private String path;	//path for the file to read
	private FileReader fileReader;
	private BufferedReader reader;
	
	public ReadQuestions(String path) {
		this.path = path;
	}
	
	/**
	 * Method to open the file for reading
	 * @throws FileNotFoundException
	 */
	private void openFile() throws FileNotFoundException {
		fileReader = new FileReader(path);
		reader = new BufferedReader(fileReader);
	}
	
	/**
	 * Method to read all the lines present in the file
	 * @return String array of all the lines present in the file
	 */
	public String[] readLines() {
		String[] lines=null;
		try {
			//initialize the lines object according to number of lines present in the file
			lines = new String[numberOfLines()];
			openFile();
			
			for(int i=0; i < lines.length; i++) {	//loop to read lines from the file
				lines[i] = reader.readLine();
			}
			reader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lines;
	}
	
	/**
	 * Method to count the number of lines present in the file
	 * @return Number of lines in the file
	 * @throws IOException
	 */
	private int numberOfLines() throws IOException {
		int numberLines = 0;
		openFile();
		
		while(reader.readLine() != null) {	//loop to traverse through the files line by line
			numberLines++;
		}
		reader.close();
		return numberLines;
	}
}
