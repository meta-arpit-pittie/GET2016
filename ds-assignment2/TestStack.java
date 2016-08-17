/**
 * Assignment 1
 * JUnit Test Case for checking the working of stack
 * @author Arpit Pittie
 */
package session2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestStack {

	private static MyStack<String> stack;
	
	@Before
	public void setUp() throws Exception {
		stack = new MyStack<String>();
		stack.push("First");
		stack.push("Second");
	}

	@Test
	public void testPush() {
		assertTrue(stack.push("First"));
		assertTrue(stack.push("Second"));
	}
	
	@Test
	public void testPeek() {
		assertEquals("Second", stack.peek());
	}
	
	@Test
	public void testPop() {
		assertEquals("Second", stack.pop());
		assertEquals("First", stack.pop());
	}
	
	@Test
	public void testGetTop() {
		assertEquals(2, stack.getTop());
	}

}
