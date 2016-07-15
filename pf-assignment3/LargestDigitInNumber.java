/*
 * To find the largest digit in a number
 * @author: Arpit Pittie
 */
package session3;

public class LargestDigitInNumber {
	
	/*
	 * Method to find the largest digit in a number
	 * @param: input number
	 * @return: int, the largest digit in the input number
	 */
	public int largestDigit(int x) {
		if(x == 0) {	//Termination condition
			return x;
		} else {	//Logic to find the largest digit
			int digit = largestDigit(x/10);
			if((x%10) > digit) {	//Checking for largest digit
				return (x % 10);
			} else {
				return digit;
			}
		}
	}
}
