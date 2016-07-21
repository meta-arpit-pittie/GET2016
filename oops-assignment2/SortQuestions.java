/**
 * Assignment 2
 * Class to sort the questions stored as string
 * @author Arpit Pittie 
 */
package session2;

import java.util.Arrays;

public class SortQuestions{

	private Question[] ques;
	private ReadQuestions read = new ReadQuestions("C:/Users/admin/workspace/OOPS/bin/session2/questions.txt");
	
	/**
	 * Method to sort the questions based on the question text
	 */
	public void sortQuestions() {
		String[] lines = read.readLines();
		ques = new Question[lines.length];	
		ques = separateLines(lines);		//creating the question objects
		
		Arrays.sort(ques);
		//printing the sorted array
		for(int i=0;i<ques.length;i++) {
			System.out.println(ques[i].getQuestion());
		}
	}
	
	/**
	 * Separate the lines from the input files into
	 * constituent questions, question type and their options if any
	 * @return Array of class Question having all the values for the lines
	 */
	private Question[] separateLines(String[] lines) {
		String[] temp;
		for(int i=0; i < lines.length; i++) {
			temp = lines[i].split(",");
			ques[i] = new Question();		
			ques[i].setQuestion(temp[0]);		//First part refers to questions
			ques[i].setType(temp[1]);		//Second part refers to type of question
			
			//Third part refers to options if question is multiple or single select type
			if(temp.length == 3 ) {
				ques[i].setChoices(temp[2]);	//Third part refers to the choices available
			}
		}
		return ques;
	}
	
	public static void main(String[] args) {
		SortQuestions sortQues = new SortQuestions();
		sortQues.sortQuestions();
	}
}
