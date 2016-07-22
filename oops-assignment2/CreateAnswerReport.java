/**
 * Assignment 1
 * Class to create a file for the answers given by each participant
 * @author Arpit Pittie
 */
package session2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CreateAnswerReport {

	private String fileName;	//File name to write the answers
	private PrintWriter writer;
	
	public CreateAnswerReport(String file) {
		this.fileName = file;
	}
	
	private void createFile() throws FileNotFoundException {
		writer = new PrintWriter(fileName);		//opening the file for writing
	}
	
	public void saveResult(String[] answer) {
		try {
			createFile();
			//loop to write each answer in the file
			for(int i=0; i<answer.length; i++) {
				writer.println(answer[i]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		writer.close();
	}
}
