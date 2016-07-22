/**
 * Assignment 1
 * Class to validate the input for different type of questions
 * @author Arpit Pittie
 */
package session2;

public class ValidateAnswer {
	
	/**
	 * Method to validate the answer given for the multiple select type question
	 * @param answer - the answer given by the user
	 * @param choices - the choices available for the question
	 * @return Answer string if the options chosen are from the choices else null
	 */
	public static String validateAnswerMulti(String answer, String[] choices) {
		String[] temp;
		boolean[] result;
		temp = answer.split("/");		//getting all the answers given by the user
		result = new boolean[temp.length];		//check for each answer given by user
		
		//loop to check each answer is valid or not
		for(int i=0; i<temp.length; i++) {
			for(int j=0; j<choices.length;j++) {
				//if the answer matches with any of the choices stores true against it
				if(temp[i].equalsIgnoreCase(choices[j])) {
					result[i] = true;
				}
			}
		}
		
		//loop to check that all the answers given are valid or not
		for(int i=0; i<result.length; i++) {
			if(!result[i])	//if any answer given is not from the given choices
				return null;
		}
		
		return answer;
	}
	
	/**
	 * Method to validate the answer given for the single select type question
	 * @param answer - the answer given by the user
	 * @param choices - the choices available for the question
	 * @return Answer string if the answer chosen are from the choices else null
	 */
	public static String validateAnswerSingle(String answer, String[] choices) {
		boolean result  = false;
		
		//loop to check the answer against all the options
		for(int i=0; i<choices.length; i++) {
			
			if(answer.equalsIgnoreCase(choices[i])) {
				result = true;		//answer is from the given options only
				break;
			}
		}
		
		//if the answer is from the given option only return the answer else null
		if(result) {
			return answer;
		} else {
			return null;
		}
	}
	
	/**
	 * Method to validate the answer given for the numeric type question
	 * @param answer - the answer given by the user
	 * @return Answer string if the answer is a number else null
	 */
	public static String validateAnswerNumber(String answer) {
		boolean result = true;
		
		//loop to check that the answer contains only numerals
		for(int i=0; i<answer.length(); i++) {
			//condition if any character within answer is not a numeral
			if(!Character.isDigit(answer.charAt(i))) {
				result = false;
			}
		}
		
		//if the answer is a numeric return the answer else null
		if(result) {
			return answer;
		} else {
			return null;
		}
	}
}
