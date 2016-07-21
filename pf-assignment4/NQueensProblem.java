/*
 * To implement the solution for the N-Queens Problem
 * @Assumption: Solution exist for the given input
 * @author: Arpit Pittie
 */
package session4;

public class NQueensProblem {
	
	/*
	 * Method to find the solution to the n Queens Problem
	 * @param: 2D array to implement the board for the queens,
	 * 		   stores 1 where queen can be placed else 0
	 * @param: The first row of the board
	 * @param: Total dimension of the n queens board
	 * @return: boolean true if the solution can be implemented else false
	 */
	private boolean nQueen(int[][] board, int startRow, int dimensionOfMatrix) {
		//For giving result for the current row based on combination of upper rows
		boolean result=false;
		//Checking result for current placement of queen in the row
		boolean imposs=false;
		
		for(int i=0; i < dimensionOfMatrix; i++) {		//loop for solving problem
			board[startRow][i] = 1;		//assigning a queen temporary to a block
			imposs=false;
			
			//check that the queen placement is feasible based on queen placement of upper rows
			for(int j=0;j < startRow; j++) {
				for(int k=0;k < dimensionOfMatrix; k++) {
					//check the feasible condition only if the queen is placed in the upper rows
					if(board[j][k] == 1) {
						//feasibility condition for the queen placement
						if((Math.abs(startRow - j) == Math.abs(i - k)) || (i == k)) {
							imposs = true;
							break;
						}
					}
				}
				if(imposs){		//assumption of position is not feasible
					board[startRow][i] = 0;
					break;
				}
			}
			if(imposs){		//try for next position
				continue;
			} else {
				if(startRow+1 != dimensionOfMatrix) {		//check for last row of the board
					result = nQueen(board, startRow+1, dimensionOfMatrix);
				} else {
					return true;
				}
			}
			//not feasible due to no suitable position for queens in the following rows
			if(!result) {
				board[startRow][i] = 0;
			} else {
				break;
			}
		}
		
		if(!result) {	//solution is feasible or not for the arrangement
			return false;
		} else {
			return true;
		}
	}
	
	public int[][] solutionNQueen(int[][] board, int startRow, int dimensionOfMatrix) {
		nQueen(board, startRow, dimensionOfMatrix);
		return board;
	}
}
