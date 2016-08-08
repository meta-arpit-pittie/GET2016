/**
 * Assignment 2
 * JUnit Test Case for checking Hash Map
 * @author Arpit Pittie
 */
package session4;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestMyHashMap {

	private static MyHashMap<Integer, String> hashMap;
	private String[] input;
	
	@Before
	public void setUp() throws Exception {
		hashMap = new MyHashMap<Integer, String>();
		input = new String[] {"First", "Second", "Third", "Fourth"};
		hashMap.insert(2, input[0]);
		hashMap.insert(10, input[1]);
		hashMap.insert(11, input[2]);
		hashMap.insert(0, input[3]);
	}

	@Test
	public void testGet() {
		assertTrue(input[0].equals(hashMap.get(2)));
		assertTrue(input[1].equals(hashMap.get(10)));
		assertTrue(input[2].equals(hashMap.get(11)));
		assertTrue(input[3].equals(hashMap.get(0)));
	}

}
