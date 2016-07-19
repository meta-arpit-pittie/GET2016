/*
 * To find GCD of a two numbers x and y
 * Assumption: x and y are positive and x>y
 * @Author: Arpit Pittie
 */
package session3;

public class GreatestCommonDivisor {
	
	/*
	 * Method to calculate GCD
	 * @param: greater number
	 * @param: smaller number
	 * @return: int the gcd of two numbers
	 */
	int gcd(int x, int y) {
		if(x % y == 0) {	//Termination condition
			return y;
		} else {
			return gcd(y, x%y);		//Using Euclid's formula
		}
	}
}
