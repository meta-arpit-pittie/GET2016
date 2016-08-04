/**
 * Assignment 3
 * JUnit Test Case for sorted linked list
 * @author Arpit Pittie
 */
package session5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSortedLinkedList {

	private static SortedLinkedList<Integer> linkedList;
	
	@Before
	public void setUp() {
		linkedList = new SortedLinkedList<Integer>();
		linkedList.insert(5);
		linkedList.insert(2);
		linkedList.insert(7);
		linkedList.insert(9);
	}
	
	@Test
	public void testInsert() {
		assertTrue(linkedList.insert(18));
		assertTrue(linkedList.insert(13));
	}
	
	@Test
	public void testSize() {
		assertEquals(4, linkedList.size());
	}
	
	@Test
	public void testGet() {
		Integer input;
		int[] expected = new int[] {2, 5, 7, 9};
		for(int i=0; i < linkedList.size(); i++) {
			input = linkedList.get(i);
			assertEquals(new Integer (expected[i]), input);
		}
	}
}
