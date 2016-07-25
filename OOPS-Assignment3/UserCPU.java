/**
 * Assignment 1
 * Class to represent the CPU  as a user
 * @author Arpit Pittie
 */
package session3;

import java.util.Scanner;

public class UserCPU extends Player{

	private char symbol;	//the symbol selected by the user
	
	public UserCPU(char symbol) {
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
		int cell;
		
		do {
			cell = (int)(Math.random()*10);
		} while (!validateMove(cell));
		
		return cell;
	}

}
