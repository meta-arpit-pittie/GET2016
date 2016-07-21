/**
 * Assignment 1
 * Class to generate the report for each single select type question
 * @author Arpit Pittie
 */
package session2;

public class SingleSelectReport {
	
	private String[] options;	//options for the particular question
	private String question;	//question for the type single select
	private int[] answerMarked;		//number of answers marked against each options
	
	/**
	 * Constructor to store the question, type and choices
	 * @param question - question string
	 * @param type - type of question
	 * @param options - choices against the questions
	 */
	public SingleSelectReport(String question, String type, String options) {
		this.question = question+","+type+","+options;		//Store the question
		this.options = options.split("/");		//Store all the options
		answerMarked = new int[this.options.length];	
		
		//initialize the number marked for options with 0
		for(int i=0; i<answerMarked.length; i++) {
			answerMarked[i] = 0;
		}
	}
	
	/**
	 * Method to increment the count for the chosen option
	 * @param answer - the answer given by the user
	 */
	public void storeAnswer(String answer) {
		//loop to check which answer is chosen
		for(int i=0; i<options.length; i++) {
			if(answer.equalsIgnoreCase(options[i])) {
				this.answerMarked[i]++;		//to increment the count for the option chosen
			}
		}
	}
	
	/**
	 * Method to generate the final report for the single select question
	 * @param participantNo - total number of participants filling the form
	 * @return - StringBuffer containing the full report for the particular single select question
	 */
	public StringBuffer generateReport(int participantNo) {
		StringBuffer report = new StringBuffer(question+"\n");
		double percent;
		for(int i=0; i<options.length; i++) {
			//Determining the percentage selected for each option
			percent = (answerMarked[i] * 100) / participantNo;
			//adding the option with its percentage to the final result
			report.append(options[i]+" - "+percent+"%\n");
		}
		return report;
	}
}
