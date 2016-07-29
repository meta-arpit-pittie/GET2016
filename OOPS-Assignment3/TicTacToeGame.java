/**
 * Assignment 1
 * Main class to bind all the objects and start the game
 * @author Arpit Pittie
 */
package session3;

import java.util.Scanner;

public class TicTacToeGame {

	private static Scanner scanner;
	private Player[] players;		//array of the players playing the game
	private int numberPlayers;		//total number of players
	private StateOfBoard board;		//board on which the game will be played
	
	public TicTacToeGame() {
		players = new Player[2];
	}
	
	/**
	 * Method to setup the prerequisite for the game
	 */
	private void setUpGame() {
		int temp;
		String symbol;
		
		board = StateOfBoard.getInstance();
		
		do {
			System.out.println("Enter the number of human user");
			temp = scanner.nextInt();	//getting the number of human user
			scanner.nextLine();
			//checking for the number of human user playing the game
			if((temp <= 2) && (temp >= 0)) {
				numberPlayers = 2;
			}
		} while (numberPlayers != 2);
		
		//Taking input for the symbol of all the human players and creating object for the same
		for(int i=0; i < temp; i++) {
			do {
				System.out.println("Enter symbol for player "+(i+1)+" [x/0] :");
				symbol = scanner.nextLine();
				
				//Checking if the symbol chosen is already taken or not
				for(int j=0; j < i; j++) {
					if(players[j].getSymbol() == symbol.charAt(0)) {
						symbol = "";
					}
				}
			} while ((!symbol.equalsIgnoreCase("x")) && (!symbol.equalsIgnoreCase("0")));
			//creating object for a human user
			players[i] = new UserHuman(symbol.charAt(0));
		}
		
		//Taking input for the symbol of all the CPU players and creating object for the same
		for(int i=temp; i < numberPlayers; i++) {
			do {
				System.out.println("Enter symbol for player "+(i+1)+" [x/0] :");
				symbol = scanner.nextLine();
				
				//Checking if the symbol chosen is already taken or not
				for(int j=0; j < i; j++) {
					if(players[j].getSymbol() == symbol.charAt(0)) {
						symbol = "";
					}
				}
			} while ((!symbol.equalsIgnoreCase("x")) && (!symbol.equalsIgnoreCase("0")));
			//creating object for a CPU user
			players[i] = new UserCPU(symbol.charAt(0));
		}
		
		playGame();		//playing the game
		board.close();		//destroying the game board
	}
	
	/**
	 * Method to simulate the game
	 */
	private void playGame() {
		boolean result = false;		//variable to store the win/loss status
		boolean draw = false;		//variable to store the draw status
		boolean chance = true;		//variable to store the chance of the player
		int move;	//To store the cell number for the move
		int row;	//To store the row for the move
		int col;	//To store the column for the move
		do {
			
			if(chance) {
				//chance for player 1
				move = players[0].move(scanner);
				//converting cell number to row and column id
				row = (move - 1)/ 3;
				col = (move - 1)% 3;
				if(!board.setCell(row, col, players[0])) {
					continue;
				}
				//check for the player's win
				result = Rules.conditionWinLoss(players[0], board.getBoard());
				chance = false;
			} else {
				//chance for player 2
				move = players[1].move(scanner);
				//converting cell number to row and column id
				row = (move - 1)/ 3;
				col = (move - 1)% 3;
				if(!board.setCell(row, col, players[1])) {
					continue;
				}
				//check for the player's win
				result = Rules.conditionWinLoss(players[1], board.getBoard());
				chance = true;
			}
			//check for the draw
			draw = Rules.conditionDraw(board.getBoard());
			board.printBoard();
		} while ((!draw) && (!result));
		
		//Check for the outcome of the game
		if(!result) {
			//The game drew
			System.out.println("Game ended in a draw");
		} else {
			if(chance) {
				//Player 2 has won the game
				System.out.println("Player 2 is the winner");
			} else {
				//Player 1 has won the game
				System.out.println("Player 1 is the winner");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String choice;
		scanner = new Scanner(System.in);
		do {
			TicTacToeGame game = new TicTacToeGame();
			System.out.println("Welcome to the new game of Tic-Tac-Toe\n");
			game.setUpGame();
			//To check for continue playing
			System.out.println("Do you wish to play another game y/n");
			choice = scanner.nextLine();
		} while (choice.equalsIgnoreCase("y"));
	}

}
