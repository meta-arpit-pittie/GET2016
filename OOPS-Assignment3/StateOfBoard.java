/**
 * Assignment 1
 * Class to record the state of the board for the game
 * @author Arpit Pittie
 */
package session3;

public class StateOfBoard {
	
	private char[][] board;		//2D array to represent the game board
	private static StateOfBoard stateOfBoard;		//Object for using Singleton design pattern
	
	private StateOfBoard() {
		board = new char[3][3];
		//initializing the board cells with a default space
		for(int i=0; i < 3; i++) {
			for(int j=0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	/**
	 * Static method to get the instance of this class
	 * @return the object for this class
	 */
	public static StateOfBoard getInstance() {
		if(stateOfBoard == null) {
			stateOfBoard = new StateOfBoard();
		}
		return stateOfBoard;
	}
	
	/**
	 * Method to set the symbol of the player at the particular cell
	 * @param row - Row number where the symbol is to set
	 * @param col - Column number where the symbol is to set
	 * @param player - The reference of the player whose symbol needs to be set on the particular cell
	 * @return true if the cell is empty and the symbol can be placed at the row and column else false
	 */
	public boolean setCell(int row, int col, Player player) {
		
		if(board[row][col] != ' ') {
			return false;
		}
		
		board[row][col] = player.getSymbol();
		return true;
	}
	
	/**
	 * Method to print the board on the console
	 */
	public void printBoard() {
		System.out.println();
		for(int i=0; i < 7; i++) {
			//To print the symbol rows
			if(i%2 == 1) {
				for(int j=0;j < 3; j++) {
					System.out.print("| "+board[i/2][j]+" ");
				}
				System.out.println("|");
			} else {
				//To print the board borders
				for(int j=0; j < 3; j++) {
					System.out.print("----");
				}
				System.out.println("-");
			}
		}
		System.out.println();
	}
	
	/**
	 * Method to get the current state of board
	 * @return - the state of board
	 */
	public char[][] getBoard() {
		return board;
	}
	
	/**
	 * Method to close the state of board
	 */
	public void close() {
		stateOfBoard = null;
	}
}
