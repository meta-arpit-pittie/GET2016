/*
 * JUnit Test Case for checking the type of array sorting
 * Author: Arpit Pittie
 */
package Session1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCheckArraySort {

	private CheckArraySort arraySort = new CheckArraySort();
	
	@Test
	public void test() {
		
		assertEquals(1,arraySort.checkArray(new int[] {1,2,3,4,5,6,7,8}));
		assertEquals(2,arraySort.checkArray(new int[] {8,7,6,5,4,3,1}));
		assertEquals(0,arraySort.checkArray(new int[] {1,2,4,2,9}));
	}

}
