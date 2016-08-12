/**
 * Assignment 2
 * Class to implement the radix sorting algorithm
 * @author Arpit Pittie
 */
package session8;

import session5.QueueImplementation;


public class RadixSort {

	private int[] data;		//The array to perform the sorting
	private static final int KEY_ARRAY_SIZE = 10;	//to define the key size
	
	public RadixSort(int[] data) {
		this.data = data;
	}
	
	/**
	 * Method to perform the radix sort
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void radixSorting() {
		//defining the queues as key for the radix sort
		QueueImplementation<Integer>[] keyArray = new QueueImplementation[KEY_ARRAY_SIZE];
		int numberPlace = 1;
		//loop to initialize each queue
		for (int i = 0; i < keyArray.length; i++) {
			keyArray[i] = new QueueImplementation();
		}
		
		//loop to traverse through each places in the highest digit number
		while(stages(keyArray,numberPlace)) {
			//incrementing the digit place for the next pass
			numberPlace++;
		}
	}
	
	/**
	 * Method to realize single pass of the radix sort
	 * @param keyArray - The queue array for using as the key array
	 * @param numberPlace - The number of pass and the digit place to be used for the particular pass
	 * @return True if the sorting was performed on this stage else false
	 */
	private boolean stages(QueueImplementation<Integer>[] keyArray, int numberPlace) {
		int digit;
		boolean result = false;
		//loop to place each element of the data into the correct queue based on the key
		for (int i = 0; i < data.length; i++) {
			digit = data[i];
			//loop to find the key for the element for this pass
			for (int j = 0; j < numberPlace - 1; j++) {
				digit /= 10;
			}
			digit %= 10;
			//Checking if any sorting is performed in this particular iteration
			if(digit != 0) {
				result = true;
			}
			//Adding the element to the queue based on the key calculated
			keyArray[digit].enqueue(data[i]);
		}
		digit = 0;
		
		//loop to write back the elements into the array from all the queue
		for(int i = 0; i < keyArray.length; i++) {
			//loop to traverse through each queue and adding the elements to the array
			while(keyArray[i].size() > 0) {
				data[digit++] = keyArray[i].dequeue();
			}
		}
		return result;
	}
	
	/**
	 * Method to get sorted array
	 * @return sorted integer array 
	 */
	public int[] getSortedArray() {
		return data;
	}
}
