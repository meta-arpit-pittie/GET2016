/**
 * Assignment 1
 * Class to define the win, loss and draw conditions in the Tic-Tac-Toe Game
 * @author Arpit Pittie
 */
package session3;

public class Rules {
	
	/**
	 * Method to check that the particular player has won or not
	 * @param player - The reference for the player who is playing the move
	 * @param board - The board state for the game
	 * @return true if the player has won else false
	 */
	public static boolean conditionWinLoss(Player player, char[][] board) {
		boolean result = false;
		char sym = player.getSymbol();
		
		for(int i=0; i < 3 ;i++) {
			//Check for all horizontal rows for win condition
			if((board[i][0] == sym) && (board[i][1] == sym) && 
					(board[i][2] == sym)) {
				result = true;
				break;
			}
			
			//Check for all vertical columns for win condition
			if((board[0][i] == sym) && (board[1][i] == sym) && 
					(board[2][i] == sym)) {
				result = true;
				break;
			}
		}
		
		//Check for both the diagonal for win condition
		if((board[0][0] == sym) && (board[1][1] == sym) && 
				(board[2][2] == sym)) {
			result = true;
		}
		
		if((board[0][2] == sym) && (board[1][1] == sym) && 
				(board[2][0] == sym)) {
			result = true;
		}
		
		return result;
	}
	
	/**
	 * Method to check that game has ended with a draw or not
	 * @param board - The board state for the game
	 * @return true if the game is ended with a darw else false
	 */
	public static boolean conditionDraw(char[][] board) {
		boolean result = true;
		
		for(int i=0; i < 3; i++) {
			for(int j=0; j < 3; j++) {
				//Check if all the cell in the board is filled
				if(board[i][j] == ' ') {
					result = false;
					break;
				}
			}
			if(!result) {
				break;
			}
		}
		return result;
	}
}
