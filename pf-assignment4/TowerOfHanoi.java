/*
 * To implement the Tower Of Hanoi using recursion
 * Assumption: The number of discs are positive
 * @author: Arpit Pittie
 */
package session4;

import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi {
	
	private List<String> steps = new ArrayList<String>();
	
	/*
	 * Method to find the Tower of Hanoi steps
	 * @param: source rod
	 * @param: destination rod
	 * @param: auxilary rod
	 * @return: List of steps
	 */
	public List<String> tower(String source, String destination,
			String auxiliary, int numOfDisk) {
		
		if(numOfDisk == 1) {	//Termination condition
			steps.add("Move Disk "+numOfDisk+" from "+source+" to "+destination);
			return steps;
		}
		
		tower(source, auxiliary, destination, numOfDisk-1);
		steps.add("Move Disk "+numOfDisk+" from "+source+" to "+destination);
		tower(auxiliary, destination, source, numOfDisk-1);
		return steps;
	}
}
