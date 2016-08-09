/**
 * Assignment 2
 * Class to perform the comparison sort on the array
 * @author Arpit Pittie
 */
package session8;

public class ComparisonSort implements Sorting {

	private int[] data;		//The array to perform the sorting
	//The length of array to decide for the sorting algorithm
	private static final int SORT_SEPARATION_SIZE = 10;
	
	public ComparisonSort(int[] data) {
		this.data = data;
	}
	
	/**
	 * Method to define the which sorting to perform based on input
	 */
	@Override
	public void performSorting() {
		//checking for the number of elements in the array
		if (data.length > SORT_SEPARATION_SIZE) {
			//Performing quick sort if the array is large
			new QuickSort(data).quickSorting(0, data.length-1);
		} else {
			//Performing bubble sort if the array is small
			new BubbleSort(data).bubbleSorting();
		}
		
		display();
	}

	/**
	 * Method to show the sorted array
	 */
	@Override
	public void display() {
		System.out.println("The sorted array is");
		//Printing the sorted array
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
