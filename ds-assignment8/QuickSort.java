/**
 * Assignment 2
 * Class to implement the quick sort algorithm
 * @author Arpit Pittie
 */
package session8;

public class QuickSort {

	private int[] data;		//The array to perform the sorting
	
	public QuickSort(int[] data) {
		this.data = data;
	}
	
	/**
	 * Method to perform the quick sort
	 * @param: the lower index of array/sub-array
	 * @param: the higher index of array/sub-array
	 */
	public void quickSorting(int low, int high) {
		int p;
		if(low < high) {	//Terminating Condition
			p = partition(low, high);
			quickSorting(low, p-1);		//Sorting of lower sub array
			quickSorting(p+1, high);		//Sorting of upper sub array
		}
	}
	
	/**
	 * Method to perform the partition of the array
	 * @param: the lower index of array/sub-array
	 * @param: the higher index of array/sub-array
	 * @return: the index of pivot element
	 */
	private int partition(int low, int high) {
		int pivot = data[low];		//Assuming the default pivot number
		int index = low + 1;	//Saving the index position for swapping
		int temp;
		
		//loop to find the position of the pivot element in the array
		for(int i = low+1; i <= high; i++) {
			//Checking if there is need to swap the elements
			if(data[i] < pivot) {
				temp = data[i];
				data[i] = data[index];
				data[index] = temp;
				index++;
			}
		}
		index--;
		
		//Swapping the pivot element with the calculated index position
		temp = data[low];
		data[low] = data[index];
		data[index] = temp;
		
		return index;
	}
	
	/**
	 * Method to get sorted array
	 * @return sorted integer array 
	 */
	public int[] getSortedArray() {
		return data;
	}
}
