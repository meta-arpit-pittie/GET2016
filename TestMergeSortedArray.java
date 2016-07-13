/*
 * JUnit Test Case for check for the merge sorting
 * Author: Arpit Pittie
 */
package Session1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMergeSortedArray {

	private MergeSortedArray mergeArray = new MergeSortedArray();
	private int[] a = {1,2,5,6,8,9,15,19};
	private int[] b = {4,5,8,11,12,14,20,26,50};
	
	@Test
	public void testCheckArrayMerge() {
		
		assertTrue(mergeArray.checkArrayMerge(a, b));
	}

}
