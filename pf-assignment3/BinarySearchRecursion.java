/*
 * To search a number using Binary Search
 * @author: Arpit Pittie
 */
package session3;

public class BinarySearchRecursion {
	
	/*
	 * Method to perform binary search
	 * @param: array of numbers
	 * @param: begining index of sub-array
	 * @param: last index of sub-array
	 * @param: element to be searched
	 * @return: location of element if found else -1
	 */
	public int binSearch(int[] numbers, int beg, int end, int element) {
		int mid = (beg + end)/ 2;
		if(beg>end) {		//termination condition
			return -1;
		}
		if(numbers[mid] == element) {		//Element found
			return mid;		//element location
		} else {
			if(numbers[mid] < element) {
				return binSearch(numbers, mid+1, end, element);		//element may be in upper half of array
			} else {
				return binSearch(numbers, beg, mid-1, element);		//element may be in lower half of array
			}
		}
	}
}
