/**
 * Assignment 2
 * Class to implement the bubble sorting
 * @author Arpit Pittie
 */
package session8;

public class BubbleSort {

	private int[] data;		//The array to perform the sorting
	
	public BubbleSort(int[] data) {
		this.data = data;
	}

	/**
	 * Method to implement the algorithm for bubble sort
	 */
	public void bubbleSorting() {
		int temp;
		//loop for the total number of passes
		for (int i = 0; i < data.length - 1; i++) {
			//inner loop for performing the comparison
			for(int j = 0; j < (data.length-1-i); j++) {
				//checking for the need of swapping the terms
				if(data[j] > data[j+1]) {
					temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * Method to get sorted array
	 * @return sorted integer array 
	 */
	public int[] getSortedArray() {
		return data;
	}
}
