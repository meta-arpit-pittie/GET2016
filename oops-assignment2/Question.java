/**
 * Assignment 1
 * Class to store the different attributes of a single line in the input file
 * @author Arpit Pittie
 */
package session2;

public class Question implements Comparable<Question>{

	String question;	//String to store the question
	String type;	//String to store the question type
	String choices;		//String to store the choices of question
	
	public Question() {
		question = null;
		type = null;
		choices = null;
	}
	
	public void setQuestion(String ques) {
		this.question = ques;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void setChoices(String choice) {
		this.choices = choice;
	}

	public String getQuestion() {
		return question;
	}

	public String getType() {
		return type;
	}

	public String getChoices() {
		return choices;
	}

	@Override
	public int compareTo(Question o) {
		String arg1 = "";
		String arg2 = "";
		String[] temp;
		
		//Getting the text of question excluding the question number
		temp = question.split(" ");
		for(int i=1; i < temp.length; i++) {
			arg1 = arg1 + temp[i];
		}
		
		//Getting the text of question excluding the question number
		temp = o.getQuestion().split(" ");
		for(int i=1; i < temp.length; i++) {
			arg2 = arg2 + temp[i];
		}
		return arg1.compareTo(arg2);
	}
}
