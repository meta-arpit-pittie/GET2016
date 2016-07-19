/*
 * JUnit Test Case for searching element using linear search through recursion
 * @author: Arpit Pittie
 */
package session3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestLinearSearchRecursion {

	private static LinearSearchRecursion linearSearch = new LinearSearchRecursion();
	
	@Test
	public void test() {
		int[] input = {2,5,8,9,10,77,55,11};
		assertEquals(-1, linearSearch.linSearch(input, 0, 88));		//Negative Output
		assertEquals(5, linearSearch.linSearch(input, 0, 77));		//Positive Output
	}

}
