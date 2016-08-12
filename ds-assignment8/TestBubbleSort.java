/**
 * Assignment 1
 * JUnit Test Case for the implementation of the Bubble Sort
 * @author Arpit Pittie
 */
package session8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBubbleSort {

	private static BubbleSort sorting;
	private int[] data;
	private int[] expected;
	
	@Before
	public void setUp() {
		data = new int[] {15,89,36,12,7,55,3};
		sorting = new BubbleSort(data);
	}
	
	@Test
	public void testSort() {
		expected = new int[] {3,7,12,15,36,55,89};
		sorting.bubbleSorting();
		assertArrayEquals(expected, sorting.getSortedArray());
	}

}
