/*
 * JUnit Test Case for finding largest digit in a number 
 * @author: Arpit Pittie
 */
package session3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLargestDigitInNumber {

	private static LargestDigitInNumber largeDigit = new LargestDigitInNumber();
	
	@Test
	public void test() {
		assertEquals(2, largeDigit.largestDigit(2));
		assertEquals(9, largeDigit.largestDigit(1257369));
		assertEquals(4, largeDigit.largestDigit(444));
	}

}
