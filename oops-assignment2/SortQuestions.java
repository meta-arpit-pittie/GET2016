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
		ques = new SurveyApplication().separateLines(lines);		//creating the question objects
		
		Arrays.sort(ques);
		//printing the sorted array
		for(int i=0;i<ques.length;i++) {
			System.out.println(ques[i].getQuestion());
		}
	}
	
	public static void main(String[] args) {
		SortQuestions sortQues = new SortQuestions();
		sortQues.sortQuestions();
	}
}
