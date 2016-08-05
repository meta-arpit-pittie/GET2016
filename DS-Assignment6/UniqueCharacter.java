/**
 * Assignment 2
 * Class to calculate the number of unique characters in a string
 * Using hash map to cache the string previously encountered
 * @author Arpit Pittie
 */
package session6;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class UniqueCharacter {

	private HashMap<String, Integer> characterUnique;	//Map to cache the result
	private TreeSet<Character> characters;	//Set to store the unique elements in a string
	private Scanner scan;	//to take input from the user
	
	public UniqueCharacter() {
		characterUnique = new HashMap<String, Integer>();
		scan = new Scanner(System.in);
	}
	
	/**
	 * Method to count the number of unique characters in a string
	 * @param value - The string in which the unique character number is to be found
	 * @return The number of unique characters in the string
	 */
	private int countUniqueCharacter(String value) {
		char ch;
		
		//Checking if the string was previously passed
		if(characterUnique.containsKey(value)) {
			//returning the stored result
			System.out.println("String repeated");
			return characterUnique.get(value);
		}
		
		characters = new TreeSet<Character>();
		
		//loop to find the unique characters
		for(int i=0; i < value.length(); i++) {
			ch = value.charAt(i);
			characters.add(ch);
		}
		
		//Adding the result to map for caching
		characterUnique.put(value, characters.size());
		
		return characters.size();
	}
	
	/**
	 * Method to take input from the user and
	 * displaying the number of unique characters in it 
	 */
	public void takeInput() {
		String choice;
		//loop to take input from the user
		do {
			System.out.println("Enter the string to count the unique character");
			//Displaying the number of unique characters
			System.out.println("Unique characters: "+countUniqueCharacter(scan.nextLine()));
			
			System.out.println("Do you wish to enter more string [y/n] :");
			choice = scan.nextLine();
		} while (choice.equalsIgnoreCase("y"));
		scan.close();
	}
	
	public static void main(String[] args) {
		UniqueCharacter unique = new UniqueCharacter();
		unique.takeInput();
	}
}
