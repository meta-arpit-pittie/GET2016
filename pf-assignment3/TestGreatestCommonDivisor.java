/*
 * JUnit Test Case for checking the GCD through recursion
 * Author: Arpit Pittie
 */
package session3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGreatestCommonDivisor {
	
	private static GreatestCommonDivisor hcf = new GreatestCommonDivisor();

	@Test
	public void testGCD() {
		assertEquals(1, hcf.gcd(2, 1));
		assertEquals(6, hcf.gcd(12, 18));
		assertEquals(1, hcf.gcd(100, 3));
		assertEquals(21, hcf.gcd(1071, 462));
	}

}
