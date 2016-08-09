/**
 * Assignment 2
 * Class to perform the linear sort on the array
 * @author Arpit Pittie
 */
package session8;

public class LinearSort implements Sorting {

	private int[] data;		//The array to perform the sorting
	
	public LinearSort(int[] data) {
		this.data = data;
	}
	
	/**
	 * Method to define the which sorting to perform based on input
	 */
	@Override
	public void performSorting() {
		boolean sortType = false;
		//loop to find if there is any large number in the array or not
		for (int i = 0; i < data.length; i++) {
			if(data[i] > 99) {
				//There is at least one large number
				sortType = true;
				break;
			}
		}
		
		//Selecting the sorting algorithm based on the numbers in the array
		if(sortType) {
			//Performing radix sort if he array contains at least one 3 digit number
			new RadixSort(data).radixSorting();
		} else {
			//Performing count sort if the array has small numbers
			new CountSort(data).countingSorting();
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
