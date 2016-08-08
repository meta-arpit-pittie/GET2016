/**
 * Assignment 1
 * JUnit Test Case for checking the working of Heap Tree
 * @author Arpit Pittie
 */
package session4;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestHeapTree {

	private static HeapTree heap;
	
	@Before
	public void setUp() throws Exception {
		heap = new HeapTree();
		heap.insert(8);
		heap.insert(5);
		heap.insert(0);
		heap.insert(15);
		heap.insert(10);
	}

	@Test
	public void testDelete() {
		assertEquals(15, heap.delete());
		assertEquals(10, heap.delete());
		assertEquals(8, heap.delete());
		assertEquals(5, heap.delete());
		assertEquals(0, heap.delete());
	}

}
