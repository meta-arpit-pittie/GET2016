package session4;

public class KnightTourProblem {
	
	private int index = 0;	//move number
	private int[][] board;	//board size
	public boolean knightProblem(int count, int row, int col, int n) {
		if(board[row][col] != 0) {	//Termination condition, already visited node
			return false;
		}
		
		board[row][col] = index++;	//adding the move number to the solution board
		
		if(count == (n*n)-1) {		//All nodes are visited
			return true;
		}
		//All the 8 possible variations to place the knight
		//If any condition satisfies the feasible solution it returns true else tries other condition
		if((row+1 < n) && (col+2 < n) && (knightProblem(count+1, row+1, col+2, n))) {
			 return true;
		}
		if((row+1 < n) && (col-2 >= 0) && (knightProblem(count+1, row+1, col-2, n))) {
			return true;
		}
		if((row+2 < n) && (col-1 >= 0) && (knightProblem(count+1, row+2, col-1, n))) {
			return true;
		}
		if((row+2 < n) && (col+1 < n) && (knightProblem(count+1, row+2, col+1, n))) {
			return true;
		}
		if((row-1 >= 0) && (col+2 < n) && (knightProblem(count+1, row-1, col+2, n))) {
			return true;
		}
		if((row-1 >= 0) && (col-2 >= 0) && (knightProblem(count+1, row-1, col-2, n))) {
			return true;
		}
		if((row-2 >= 0) && (col-1 >= 0) && (knightProblem(count+1, row-2, col-1, n))) {
			return true;
		}
		if((row-2 >= 0) && (col+1 < n) && (knightProblem(count+1, row-2, col+1, n))) {
			return true;
		}
		
		//no conditions satisfies
		//backtrack to the previous move
		board[row][col]=0;	//move not possible resetting the move number
		index--;
		return false;
	}
	
	public int[][] print(int row, int col) {
		int n=8;	//initialisation of the board
		board= new int[n][n];
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j]=0;	//default value of the board
			}
		}
		System.out.println((knightProblem(row,col), 0, n)));	//calling the solution function
		for(int i=0;i<board.length;i++) {	//printing the solution
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j]+"\t");
			}
			System.out.println();
		}
		return board;
	}
	
	public static void main(String[] args) {
		KnightTourProblem k=new KnightTourProblem();
		k.print(0,0);	//starting row and column call
	}
}
