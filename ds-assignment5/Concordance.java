/**
 * Assignment 1
 * Class to perform the concordance on the string
 * passed by command line argument
 * @author Arpit Pittie
 */
package session5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Concordance {

	private HashMap<Character, List<Integer>> mapping;	//To store the mapping of characters with index
	private List<Integer> index;	//The indices for a character in a string
	
	/**
	 * Method to get the concordance of the string
	 * @param concat - StringBuffer on which to perform the concordance
	 */
	public void getConcordance(StringBuffer concat) {
		char data;
		mapping = new HashMap<Character, List<Integer>>();
		
		for(int i=0; i < concat.length(); i++) {
			//Getting the character
			data = concat.charAt(i);
			
			//Checking if the character key is already present in the map
			if(!mapping.containsKey(data)) {
				index = new ArrayList<Integer>();
			} else {
				index = mapping.get(data);
			}
			
			//Adding the index position to the corresponding list
			index.add(i);
			//Adding the index list with character as key to hash map
			mapping.put(data, index);
		}
	}
	
	/**
	 * Method to print the concordance of the string
	 */
	public void display() {
		Object[] keys;
		
		//Getting the array of the keys in the map
		keys = mapping.keySet().toArray();
		
		//loop to traverse through all the keys
		for(int i=0; i < keys.length; i++) {
			//Getting the index list corresponding to the character key
			index = mapping.get(keys[i]);
			System.out.print(keys[i]+" - ");
			
			//loop to print the indices of the character
			for(int j=0 ; j < index.size(); j++) {
				System.out.print(index.get(j)+"\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Concordance cordanceString = new Concordance();
		StringBuffer concatenate = new StringBuffer();
	
		//Concatenating the command line argument array 
		for(int i=0; i < args.length; i++) {
			concatenate.append(args[i]);
		}
		
		cordanceString.getConcordance(concatenate);
		cordanceString.display();
	}
}
