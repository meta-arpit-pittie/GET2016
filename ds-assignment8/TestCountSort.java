/**
 * Assignment 1
 * JUnit Test Case for the implementation of the Count Sort
 * @author Arpit Pittie
 */
package session8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCountSort {

	private static CountSort sorting;
	private int[] data;
	private int[] expected;
	
	@Before
	public void setUp() {
		data = new int[] {15,89,36,12,7,55,3,65,23};
		sorting = new CountSort(data);
	}
	
	@Test
	public void testSort() {
		expected = new int[] {3,7,12,15,23,36,55,65,89};
		sorting.countingSorting();
		assertArrayEquals(expected, sorting.getSortedArray());
	}

}
