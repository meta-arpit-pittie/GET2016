/*
 * JUnit Test Case for checking the Quick sort
 * @author: Arpit Pittie
 */
package session3;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class TestQuickSortRecursion {

	private static QuickSortRecursion quick = new QuickSortRecursion();
	private int[] expected;
	private int[] input;
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {{new int[] {},new int[] {}},
				{new int[] {2,5,8,9,11,55,77},new int[] {2,5,8,9,77,55,11}}});
	}
	
	public TestQuickSortRecursion(int[] expected, int[] input) {
		this.expected = expected;
		this.input = input;
	}
	
	@Test
	public void testQuickSort() {
		assertArrayEquals(expected, quick.quickSort(input, 0, input.length-1));
	}

}
