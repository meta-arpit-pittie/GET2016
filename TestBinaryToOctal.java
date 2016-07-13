/*
 * JUnit Test Case for Binary to Octal Conversion
 * Author: Arpit Pittie
 */
package Session1;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestBinaryToOctal {

	private BinaryToOctal conversion = new BinaryToOctal();
	
	@Test
	public void testConvertBinaryToOctal() {
		
		assertEquals(7, conversion.convertBinaryToOctal(111));
		assertEquals(10, conversion.convertBinaryToOctal(1000));
		assertEquals(65, conversion.convertBinaryToOctal(110101));
		assertEquals(15, conversion.convertBinaryToOctal(1101));
	}

}
