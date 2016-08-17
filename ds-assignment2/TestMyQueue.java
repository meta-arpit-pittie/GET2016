/**
 * Assignment 2
 * JUnit Test Case for checking the working of queue
 * @author Arpit Pittie
 */
package session2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMyQueue {

	private static MyQueue<String> queue;
	
	@Before
	public void setUp() throws Exception {
		queue = new MyQueue<String>();
		queue.enqueue("Last");
		queue.enqueue("Before Last");
	}

	@Test
	public void testEnqueue() {
		assertTrue(queue.enqueue("New element"));
		assertTrue(queue.enqueue("Latest element"));
	}
	
	@Test
	public void testDequeue() {
		assertEquals("Last", queue.dequeue());
		assertEquals("Before Last", queue.dequeue());
	}
	
	@Test
	public void testFront() {
		assertEquals(0, queue.front());
	}
	
	@Test
	public void testRear() {
		assertEquals(2, queue.rear());
	}
	
	@Test
	public void testGetFront() {
		assertEquals("Last", queue.getFront());
	}
	
	@Test
	public void testSize() {
		assertEquals(2, queue.size());
	}

}
