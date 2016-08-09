/**
 * Assignment 1
 * JUnit Test Case for the implementation of the Tree Sort
 * @author Arpit Pittie
 */
package session8;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestTreeSort {

	private static TreeSort<Integer> bst;
	private int[] input;
	private int[] expected;
	
	@Before
	public void setUp() {
		bst = new TreeSort<Integer>();
		input = new int[] {10,30,15,8,20,0};

		for(int i=0; i < input.length; i++) {
			bst.insert(input[i]);
		}
	}
	
	@Test
	public void testInsert() {
		assertTrue(bst.insert(1));
	}
	
	@Test
	public void testSort() {
		expected = new int[] {0,8,10,15,20,30};
		ArrayList<Integer> value = bst.sort();
		input = new int[value.size()];
		
		for(int i=0; i < value.size(); i++) {
			input[i] = value.get(i);
		}
		
		assertArrayEquals(expected, input);
	}

}
