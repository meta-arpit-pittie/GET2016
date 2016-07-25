/**
 * Assignment 1
 * Class to represent the Human  as a user
 * @author Arpit Pittie
 */
package session3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserHuman extends Player{

	private char symbol;	//the symbol selected by the user
	
	public UserHuman(char symbol) {
		this.symbol = Character.toLowerCase(symbol);
	}
	
	@Override
	public void setSymbol(char symbol) {
		this.symbol = Character.toLowerCase(symbol);
	}
	
	@Override
	public char getSymbol() {
		return symbol;
	}

	/**
	 * Method to set a move input for the user
	 * @return The cell number where the player wishes to play his next move
	 */
	@Override
	public int move(Scanner scanner) {
		// TODO Auto-generated method stub
		int cell = 0;
		
		do {
			System.out.println("Enter cell number from 1 to 9");
			try {
				cell = scanner.nextInt();
			}
			catch(InputMismatchException ime) {
				continue;	//If the input is not a number
			}
			finally {
				scanner.nextLine();
			}
		} while (!validateMove(cell));
		return cell;
	}
}
