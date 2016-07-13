/*
 * JUnit Test Case for finding the longest increasing sequencee 
 * in the integer array
 * Author: Arpit Pittie
 */
package Session1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLongestIncreasingSequence {

	private LongestIncreasingSequence increasingSequence = new LongestIncreasingSequence();
	
	@Test
	public void test() {
		
		assertArrayEquals(new int[] {1,2,4,5,6,7,8,9}, increasingSequence.longestSequence(new int[] {1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9}));
		//fail("Not yet implemented");
	}

}
