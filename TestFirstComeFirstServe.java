/*
 * JUnit Test case for FCFS
 * Author: Arpit Pittie
 */
package Session1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFirstComeFirstServe {

	private FirstComeFirstServe fcfs = new FirstComeFirstServe();
	private int[] arrival={1,5,9,25};
	private int[] execution={12,7,2,5};
	private int[][] expected={{0,12},{8,19},{11,21},{0,29}};
	
	@Test
	public void testFCFS() {
		
		assertArrayEquals(expected, fcfs.FCFS(arrival, execution));
	}

}
