/*
 * JUnit Test Case for checking the remainder through recursion
 * Author: Arpit Pittie
 */
package session3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRemainderRecursion {

	private static RemainderRecursion findRemainder = new RemainderRecursion();
	
	@Test(expected=IllegalArgumentException.class)
	public void testRemNegativeInput() {	//Test case for handling negative inputs
		assertEquals(0, findRemainder.rem(2,0));
	}
	
	@Test
	public void testRemRegular() {		//Test case for positive inputs
		assertEquals(0, findRemainder.rem(2,1));
		assertEquals(1, findRemainder.rem(100,3));
	}

}
