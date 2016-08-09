/**
 * Assignment 2
 * Class to implement the count sorting algorithm
 * @author Arpit Pittie
 */
package session8;

public class CountSort {

	private int[] data;		//The array to perform the sorting
	
	public CountSort(int[] data) {
		this.data = data;
	}
	
	/**
	 * Method to perform the counting sort on the given array 
	 */
	public void countingSorting() {
		//Finding the largest value in the array and initializing key array of the same size
		int[] keyArray = new int[data[maxElement()] + 1];
		int index=0;
		//loop to increment the key value based on the data in the array
		for (int i = 0; i < data.length; i++) {
			keyArray[data[i]]++;
		}

		//loop to copy back the elements into the array based on the key values
		for (int i = 0; i < keyArray.length; i++) {
			for(int j=keyArray[i]; j > 0; j--) {
				//adding elements back to the array
				data[index++] = i;
			}
		}
	}
	
	/**
	 * Method to find the index of the largest element in the array
	 * @return
	 */
	private int maxElement() {
		int largestNumberIndex = 0;		//index of largest element
		//loop to find the largest element index
		for(int i=1; i < data.length; i++) {
			//Checking if the element is the largest or not
			if(data[largestNumberIndex] < data[i]) {
				largestNumberIndex = i;
			}
		}
		return largestNumberIndex;
	}
	
	/**
	 * Method to get sorted array
	 * @return sorted integer array 
	 */
	public int[] getSortedArray() {
		return data;
	}
}
