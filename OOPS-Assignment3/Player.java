/**
 * Assignment 1
 * Abstract class to define the methods used by each type of user for the game
 * @author Arpit Pittie
 */
package session3;

import java.util.Scanner;


public abstract class Player {
	
	/**
	 * Method to validate the cell number input by the user
	 * @param cell - the cell number for the next move
	 * @return true if the cell number is correct else false
	 */
	public boolean validateMove(int cell) {
		if((cell < 1) || (cell > 9)) {
			return false;
		}
		return true;
	}
	public abstract void setSymbol(char symbol);
	public abstract char getSymbol();
	public abstract int move(Scanner scanner);
}
