/**
 * Assignment 2
 * JUnit Test Case for checking the working of queue
 * @author Arpit Pittie
 */
package session5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestQueueImplementation {

	private static QueueImplementation<String> queue;
	
	@Before
	public void setUp() throws Exception {
		queue = new QueueImplementation<String>();
		queue.enqueue("First");
		queue.enqueue("Second");
		queue.enqueue("Third");
	}

	@Test
	public void testEnqueue() {
		assertTrue(queue.enqueue("New element"));
		assertTrue(queue.enqueue("Latest element"));
	}
	
	@Test
	public void testDequeue() {
		assertEquals("First", queue.dequeue());
		assertEquals("Second", queue.dequeue());
		assertEquals("Third", queue.dequeue());
	}
	
	@Test
	public void testFront() {
		assertEquals(0, queue.front());
	}
	
	@Test
	public void testRear() {
		assertEquals(3, queue.rear());
	}
	
	@Test
	public void testGetFront() {
		assertEquals("First", queue.getFront());
	}
	
	@Test
	public void testSize() {
		assertEquals(3, queue.size());
	}

}
