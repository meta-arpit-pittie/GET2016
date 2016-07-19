package session4;

public class KnightTourProblem {
	
	private int index = 0;
	private int[][] board;
	public boolean knightProblem(int count, int row, int col, int n) {
		if(board[row][col] != 0) {
			return false;
		}
		
		board[row][col] = index++;
		
		if(count == (n*n)-1) {
			return true;
		}
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
		
		board[row][col]=0;
		index--;
		return false;
	}
	
	public int[][] print(int row, int col) {
		int n=8;
		board= new int[n][n];
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j]=0;
			}
		}
		System.out.println((knightProblem(row,col), 0, n)));
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j]+"\t");
			}
			System.out.println();
		}
		return board;
	}
	
	public static void main(String[] args) {
		KnightTourProblem k=new KnightTourProblem();
		k.print(0,0);
	}
}
