/*
 * To search for an element using linear search
 * @author: Arpit Pittie
 */
package session3;

public class LinearSearchRecursion {
	
	/*
	 * Method to perform linear search
	 * @param: array of numbers
	 * @param: index of element to match
	 * @param: the number to be searched
	 * @return: location of the element if found else -1
	 */
	public int linSearch(int[] numbers, int index, int element) {
		if(index == numbers.length) {	//Termination condition
			return -1;
		}
		if(numbers[index] == element) {		//Element found
			return index;		//Element location
		} else {
			return linSearch(numbers, index+1, element);	//Searching the element
		}
	}
}
