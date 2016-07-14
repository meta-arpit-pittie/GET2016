/*
 * Program to find the longest increasing sequence of integers
 * Author: Arpit Pittie
 */
package Session1;

public class LongestIncreasingSequence {

	private int[] output;	//Longest Increasing Sequence
	private int sizeLongestSequence = 0;	//Size of the output
	private int startIndex=0;	//Starting index of the sequence
	private int lastIndex=0;	//Last index of the sequence
	
	/*
	 * Method to find the longest increasing sequence of numbers
	 * @param: integer array
	 * @return: sub array containing the longest increasing sequence
	 */
	public int[] longestSequence(int input[]) {
		
		int temp=1;
		
		//Check longest sequence
		for(int i=0; i<input.length-1; i++) {
			if(input[i] < input[i + 1]) {
				temp++;
			} else {
				if(sizeLongestSequence < temp) {	/*check whether the sequence formed is largest*/
					sizeLongestSequence = temp;
					lastIndex = i;
					startIndex = (lastIndex - temp)+1;
				}
				temp=1;
			}
		}
		
		//Special Case for the last sequence
		if(sizeLongestSequence < temp) {
			sizeLongestSequence = temp;
			lastIndex = input.length - 1;
			startIndex = (lastIndex - temp)+1;
		}
		
		//Storing the resultant sub array
		output = new int[(lastIndex - startIndex) + 1];
		for(int i=startIndex, j=0; i<=lastIndex; i++,j++) {
			output[j] = input[i];
		}
		return output;
	}
}
