/*
 * JUnit Test Case for solving Tower of Hanoi
 * @author: Arpit Pittie
 */
package session4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class TestTowerOfHanoi {

	private static TowerOfHanoi toh = new TowerOfHanoi();
	private List<String> expected;
	private List<String> value;
	private int actual;
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {{new ArrayList<String>(Arrays.asList("Move Disk 1 from A to C",
				"Move Disk 2 from A to B", "Move Disk 1 from C to B")),2},
				{new ArrayList<String>(Arrays.asList("Move Disk 1 from A to B", "Move Disk 2 from A to C",
						"Move Disk 1 from B to C", "Move Disk 3 from A to B", "Move Disk 1 from C to A",
						"Move Disk 2 from C to B", "Move Disk 1 from A to B")),3}});
	}
	
	public TestTowerOfHanoi(ArrayList<String> expected, int input) {
		this.expected = expected;
		this.actual = input;
	}
	
	@Test
	public void test() {
		value=toh.tower("A", "B", "C", actual);
		assertEquals(expected, value);
		value.clear();		//to clear the list
	}

}
