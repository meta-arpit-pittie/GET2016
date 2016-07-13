/*
 * JUnit Test Case for removing the duplicate elements from
 * an integer array
 * Author: Arpit Pittie
 */
package Session1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRemoveDuplicateFromArray {

	private RemoveDuplicateFromArray removeDuplicate = new RemoveDuplicateFromArray();
	
	
	@Test
	public void testRemoveDuplicates() {
		
		assertArrayEquals(new int[] {2,5,4,6,3,8,9,0},
				removeDuplicate.removeDuplicate(new int[] {2,5,4,6,3,8,5,9,3,3,6,3,9,0}));
		//fail("Not yet implemented");
	}

}
