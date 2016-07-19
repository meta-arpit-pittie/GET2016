/*
 * JUnit Test Case for finding all the permutations of a string
 * @author: Arpit Pittie
 */
package session4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class TestAllPermutationsOfString {

	private static AllPermutationsOfString allString = new AllPermutationsOfString();
	private String input;
	private List<String> expected;
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {{new ArrayList<String>(Arrays.asList("ABC", "BAC",
				"BCA", "ACB", "CAB", "CBA")),"ABC"},
				{new ArrayList<String>(Arrays.asList("ABCD", "BACD", "BCAD", "BCDA", "ACBD",
				"CABD", "CBAD", "CBDA", "ACDB", "CADB", "CDAB", "CDBA", "ABDC", "BADC", "BDAC",
				"BDCA", "ADBC", "DABC", "DBAC", "DBCA", "ADCB", "DACB", "DCAB", "DCBA")),"ABCD"}});
	}
	
	public TestAllPermutationsOfString(ArrayList<String> expected, String input) {
		this.expected = expected;
		this.input = input;
	}
	
	@Test
	public void test() {
		assertEquals(expected, allString.getCombinations(input));
	}

}
