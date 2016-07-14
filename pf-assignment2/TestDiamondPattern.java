/*
 * JUnit Test Case for Testing the diamond pattern
 * Author: Arpit Pittie
 */
package session2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDiamondPattern {
	
	DiamondPattern pattern = new DiamondPattern();
	String[] expected = {"    1", "   121", "  12321", " 1234321", "123454321",
						" 1234321", "  12321", "   121", "    1"};
	
	/*
	 * Method to test the spaces created in the pattern
	 */
	@Test
	public void testSpaces() {
		assertEquals("    ",pattern.spaces(1, 5));
		assertEquals("   ",pattern.spaces(2, 5));
		assertEquals("  ",pattern.spaces(3, 5));
		assertEquals(" ",pattern.spaces(4, 5));
		assertEquals("",pattern.spaces(5, 5));
	}
	
	/*
	 * Method to test the number sequence in the pattern 
	 */
	@Test
	public void testNumbers() {
		assertEquals("1",pattern.numbers(1));
		assertEquals("121",pattern.numbers(2));
		assertEquals("12321",pattern.numbers(3));
		assertEquals("1234321",pattern.numbers(4));
		assertEquals("123454321",pattern.numbers(5));
	}
	
	/*
	 * Method to test the full diamond pattern
	 */
	@Test
	public void testPrint() {
		assertArrayEquals(expected,pattern.print(5));
	}


}
