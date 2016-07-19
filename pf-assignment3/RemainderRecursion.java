/*
 * To find remainder of x divided by y through recursion
 * Assumption: Work for positive values
 * Author: Arpit Pittie
 */
package session3;

public class RemainderRecursion {

	/*
	 * Method to calculate the remainder of x divided by y
	 * @param: int x dividend
	 * @param: int y divisor
	 * @return: int remainder value
	 */
	int rem(int x, int y) {
		if((x < 0) || (y <= 0)) {	//check for illegal arguments
			throw new IllegalArgumentException();
		}
		if(x < y) {		//Termination condition
			return x;
		} else {	//logic for calculating remainder
			return rem((x-y),y);
		}
	}
}
