/**
 * Assignment 1
 * Main application for the survey
 * It prints the questions and takes the input from the user
 * @author Arpit Pittie
 */
package session2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SurveyApplication {

	private ReadQuestions readQuestions;	//Object to read the questions from the file
	private CreateAnswerReport createReport;	//Object to create the report of the answers
	private String[] lines;		//Array to store the questions
	private Question[] question;	//Array to store the various parts of a question
	private String[] answers;	//Array to store the answers for the participants
	private Scanner scan;		//Object to get the input from the user
	private int numberOfParticipants;		//To store the total number of participants
	private List<SingleSelectReport> report;	//List to store the objects of single select questions
	private SingleSelectReport reportObject;	//Object for generating the single select question
	
	/**
	 * Constructor initializing the array list and the input and output files
	 * @param inputFileName
	 * @param outputFileName
	 */
	public SurveyApplication(String inputFileName, String outputFileName) {
		readQuestions = new ReadQuestions(inputFileName);
		createReport = new CreateAnswerReport(outputFileName);
		report = new ArrayList<SingleSelectReport>();
	}
	
	/**
	 * Separate the lines from the input files into
	 * constituent questions, question type and their options if any
	 * @return Array of class Question having all the values for the lines
	 */
	private Question[] separateLines() {
		String[] temp;
		for(int i=0; i < lines.length; i++) {
			temp = lines[i].split(",");
			question[i] = new Question();		
			question[i].setQuestion(temp[0]);		//First part refers to questions
			question[i].setType(temp[1]);		//Second part refers to type of question
			
			//Third part refers to options if question is multiple or single select type
			if(temp.length == 3 ) {
				question[i].setChoices(temp[2]);	//Third part refers to the choices available
			}
		}
		return question;
	}
	
	/**
	 * To get the answer from the particular user one question by one
	 * @param participantNo - the participant number filling the form
	 * @return
	 */
	private String getAnswers(int participantNo) {
		String ans = "Participant "+(participantNo+1);	//The final answer for the participant
		String[] temp;
		String ansSet;		//To store the partial answer
		int singleSelectQuesNo = 0;	//index to traverse only the single select type question
		System.out.println("Participant "+(participantNo+1)+":");
		for(int i=0; i < question.length; i++) {		//loop to print all the questions
			System.out.println(question[i].getQuestion());	//Printing the question
			
			while(true) {	//loop to ensure that the input entered is correct
				
				//For printing the options for multiple and single select type question
				if((question[i].getType().equalsIgnoreCase("Multi Select")) ||
						(question[i].getType().equalsIgnoreCase("Single Select"))) {
					
					temp = question[i].getChoices().split("/");
					for(int j=0; j < temp.length; j++) {
						System.out.println(temp[j]);	//printing the options
					}
					System.out.print("Enter Choice: ");
					ansSet=scan.nextLine();		//wait for the answer to question
					
					if(question[i].getType().equalsIgnoreCase("Multi Select")) {
						//validate the answer given for multiple select type question
						ansSet = ValidateAnswer.validateAnswerMulti(ansSet, temp);	
					} else {
						//validate the answer given for single select type question
						ansSet = ValidateAnswer.validateAnswerSingle(ansSet, temp);
					}
					
					//action to perform based on validation of answer
					if(ansSet == null) {
						//Answer is not correct and continue to take input for user for the same question
						System.out.println("Select choice from options only");
						continue;
					} else {
						
						//Answer is correct
						//for single select question type generate the report
						if(question[i].getType().equalsIgnoreCase("Single Select")) {
							report.get(singleSelectQuesNo).storeAnswer(ansSet);
							singleSelectQuesNo++;
						}
						
						ans = ans+","+ansSet;		//appending the sub answer to main answer string
						break;		//Answer is correct move to next question
					}
				} else {
					
					//For text type question
					if(question[i].getType().equalsIgnoreCase("Text")) {
						System.out.println("Enter the answer:");
						ans = ans+","+scan.nextLine();	//appending the sub answer to main answer string
						break;		//Answer is correct move to next question
					} else {
						
						//For numeric type question
						System.out.println("Enter the answer:");
						ansSet = scan.nextLine();
						//validate the answer given for numeric type question
						ansSet = ValidateAnswer.validateAnswerNumber(ansSet);
						
						//action to perform based on validation of answer for numeric type
						if(ansSet == null) {
							System.out.println("Enter numerals only");
							continue;
						} else {
							ans = ans+","+ansSet;	//appending the sub answer to main answer string
							break;		//Answer is correct move to next question
						}
					}
				}
			}
		}
		return ans;		//return the final answer string for the given participant
	}
	
	/**
	 * Method to fill the whole survey form for each user
	 */
	public void fillSurveyForm() {
		scan = new Scanner(System.in);		//initialize the object to take input from console
		lines = readQuestions.readLines();	//to store the questions fetched from input file
		question = new Question[lines.length];
		
		//call to separate the questions, type and options from the lines in input files
		separateLines();
		
		System.out.print("Enter number of participants in the survey ");
		numberOfParticipants = scan.nextInt();		//Get the number of participant from user
		scan.nextLine();	//to consume extra \n in the buffer
		answers = new String[numberOfParticipants];		//initialize the toatl number of answers
		
		//Loop to declare objects for each single select type question
		for(int i=0; i < question.length; i++) {
			if(question[i].getType().equalsIgnoreCase("Single Select")) {
				//To initialize the object for a single select question
				reportObject = new SingleSelectReport(question[i].getQuestion(),
						question[i].getType(), question[i].getChoices());
				report.add(reportObject);	//Adding the single select object to list
			}
		}
		
		//loop to get form filled from each user
		for(int i=0; i < numberOfParticipants; i++) {
			answers[i] = getAnswers(i);
		}
		
		//To store the result for every participant in external file
		createReport.saveResult(answers);
		System.out.println("\nReport\n");
		
		//loop to display the report for the single select type question
		for(int i=0; i < report.size(); i++) {
			System.out.println(report.get(i).generateReport(numberOfParticipants));
		}
		
		scan.close();		//close the scanner object
	}
	
	public static void main(String[] args) {
		//Creating the object for the survey application
		SurveyApplication survey = new SurveyApplication
				("C:/Users/admin/workspace/OOPS/bin/session2/questions.txt",
						"C:/Users/admin/workspace/OOPS/bin/session2/report.txt");
		survey.fillSurveyForm();
	}
}
