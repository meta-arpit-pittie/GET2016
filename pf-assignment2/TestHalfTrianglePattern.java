/*
 * JUnit Test Case for Testing the half triangle pattern
 * Author: Arpit Pittie
 */
package session2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestHalfTrianglePattern {

	HalfTrianglePattern pattern = new HalfTrianglePattern();
	String[] expected = {"12345", " 1234", "  123", "   12", "    1"};
	
	/*
	 * Method to test the spaces created in the pattern
	 */
	@Test
	public void testSpaces() {
		assertEquals("",pattern.spaces(5, 5));
		assertEquals(" ",pattern.spaces(4, 5));
		assertEquals("  ",pattern.spaces(3, 5));
		assertEquals("   ",pattern.spaces(2, 5));
		assertEquals("    ",pattern.spaces(1, 5));
	}
	
	/*
	 * Method to test the number sequence in the pattern 
	 */
	@Test
	public void testNumbers() {
		assertEquals("12345",pattern.numbers(5));
		assertEquals("1234",pattern.numbers(4));
		assertEquals("123",pattern.numbers(3));
		assertEquals("12",pattern.numbers(2));
		assertEquals("1",pattern.numbers(1));
	}
	
	/*
	 * Method to test the full half triangle pattern
	 */
	@Test
	public void testPrint() {
		assertArrayEquals(expected,pattern.print(5));
	}
}
