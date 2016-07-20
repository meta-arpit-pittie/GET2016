/**
 * JUnit Test Case for the Knight's Tour Problem
 * @author Arpit Pittie
 */
package session4;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestKTProblem {

	private static KTProblem knightTour = new KTProblem();
	@Test
	public void test() {
		assertArrayEquals(new int[][] {{1,14,19,8,25},
				{6,9,2,13,18},{15,20,7,24,3},{10,5,22,17,12},
				{21,16,11,4,23}}, knightTour.solutionKTProblem(0, 0, 5));
	}

}
