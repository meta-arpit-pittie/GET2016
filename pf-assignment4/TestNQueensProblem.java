/*
 * JUnit Test Case for solving the N Queens Problem
 * @author: Arpit Pittie
 */
package session4;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestNQueensProblem {

	private static NQueensProblem nQueens = new NQueensProblem();
		
	@Test
	public void test() {
		assertArrayEquals(new int[][] {{0,1,0,0},{0,0,0,1},{1,0,0,0},{0,0,1,0}}, 
				nQueens.solutionNQueen(new int[4][4], 0, 4));
	}

}
