/**
 * To implement the solution to the Knight's Tour Problem
 * @author Arpit Pittie
 */
package session4;

public class KTProblem {
	
	private int[][] moves;	//board for the knight
	private int index=1;	//move number on the board cell
	
	private boolean solution(int row, int col, int n) {
		boolean result=false;
		
		if(moves[row][col]!=-1) {	//non feasible move condition
			return false;
		}
		
		moves[row][col] = index;	//assigning the move number to the cell
		
		if(index==n*n) {	//termination condition
			return true;
		}
		
		index++;
		
		//go right and down
		if((row+1 < n) && (col+2 <n)) {
			result=solution(row+1, col+2, n);
		}
		//go down and right
		if((!result) && (row+2 < n) && (col+1 <n)) {
			result=solution(row+2, col+1, n);
		}
		//go down and left
		if((!result) && (row+2 < n) && (col-1 >=0)) {
			result=solution(row+2, col-1, n);
		}
		//go left and down
		if((!result) && (row+1 < n) && (col-2 >=0)) {
			result=solution(row+1, col-2, n);
		}
		//go left and up
		if((!result) && (row-1 >=0) && (col-2 >=0)) {
			result=solution(row-1, col-2, n);
		}
		//go  up and left
		if((!result) && (row-2 >=0) && (col-1 >=0)) {
			result=solution(row-2, col-1, n);
		}
		//go up and right
		if((!result) && (row-2 >=0) && (col+1 <n)) {
			result=solution(row-2, col+1, n);
		}
		//go right and up
		if((!result) && (row-1 >=0) && (col+2 <n)) {
			result=solution(row-1, col+2, n);
		}
		
		if(!result) {	//solution not feasible
			moves[row][col]=-1;
			index--;
			
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param startRow - starting row position of knight
	 * @param startColumn - starting column position of knight
	 * @param boardSize - chess board size
	 * @return 2D integer array containing the moves
	 */
	public int[][] solutionKTProblem(int startRow, int startColumn, int boardSize) {
		moves=new int[boardSize][boardSize];
		for(int i=0;i<boardSize;i++){ 	//initialization of the chess board
			for(int j=0;j<boardSize;j++)
				moves[i][j]=-1;
		}
		solution(startRow, startColumn, boardSize);
		return moves;
	}
}
