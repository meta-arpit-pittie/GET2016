/*
 * JUnit Test Case for finding an element using binary search 
 * @author: Arpit Pittie
 */
package session3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBinarySearchRecursion {

	private static BinarySearchRecursion binarySearch = new BinarySearchRecursion();
	
	@Test
	public void test() {
		int[] input = {2,5,8,9,10,55,77};
		assertEquals(6, binarySearch.binSearch(input, 0, input.length-1, 77));		//Positive Output
		assertEquals(-1, binarySearch.binSearch(input, 0, input.length-1, 88));		//Negative Output
	}
}
