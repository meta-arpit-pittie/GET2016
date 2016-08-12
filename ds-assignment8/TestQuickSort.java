/**
 * Assignment 1
 * JUnit Test Case for the implementation of the Quick Sort
 * @author Arpit Pittie
 */
package session8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestQuickSort {

	private static QuickSort sorting;
	private int[] data;
	private int[] expected;
	
	@Before
	public void setUp() {
		data = new int[] {15,98,741,236,45,1,35,0,74,123};
		sorting = new QuickSort(data);
	}
	
	@Test
	public void testSort() {
		expected = new int[] {0,1,15,35,45,74,98,123,236,741};
		sorting.quickSorting(0, data.length - 1);
		assertArrayEquals(expected, sorting.getSortedArray());
	}

}
