/*
 * To find all the permutations of a String
 * @author: Arpit Pittie
 */
package session4;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsOfString {

	/*
	 * Method to find the permutations of the string
	 * @param: input string of which combination to be find
	 * @return: List of the different permutations of the input string
	 */
	public List<String> getCombinations(String input) {
		char firstCharacter;
		int size;
		String remainingInput;
		List<String> words = new ArrayList<String>();
		
		if(input.length() == 1) {	//Termination condition
			words.add(input);	//Adding last character as a string
			return words;
		}
		
		firstCharacter = input.charAt(0);	//separating the first character
		remainingInput = input.substring(1);	//storing the remaining string
		words = getCombinations(remainingInput);	//getting the permutations by recursion
		
		size=words.size();	//getting the size for the partial permutations
		for (int i=0;i<size;i++) {
			remainingInput=words.get(0);	//getting the partial permutation
			words.remove(0);	//removing the partial permutation
			
			//Adding the first character to the partial permutation at every possible place
			for (int j = 0; j <= remainingInput.length(); j++) {
				words.add(addCharacterPossibility(remainingInput, j, firstCharacter));
			}
		}
		return words;
	}
	
	/*
	 * Method to add the character to the substring
	 * @param: substring in which character is to be add
	 * @param: index where the character needs to be add
	 * @param: character which is to be concatenated with substring
	 * @return: string with the character concatenated 
	 */
	private String addCharacterPossibility(String subInput, int index, char first) {
		//Adding the character to different positions
		return subInput.substring(0,index)+first+subInput.substring(index);
	}
}
