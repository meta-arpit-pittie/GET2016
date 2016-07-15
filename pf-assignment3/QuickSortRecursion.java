/*
 * To perform Quick Sort on the given array
 * @author: Arpit Pittie
 */
package session3;

public class QuickSortRecursion {

	/*
	 * Method to perform the quick sort
	 * @param: the array to be sorted
	 * @param: the lower index of array/sub-array
	 * @param: the higher index of array/sub-array
	 * @return: the sorted array of numbers
	 */
	public int[] quickSort(int[] numbers, int low, int high) {
		int p;
		if(low < high) {	//Terminating Condition
			p = partition(numbers, low, high);
			quickSort(numbers, low, p-1);		//Sorting of lower sub array
			quickSort(numbers, p+1, high);		//Sorting of upper sub array
		}
		return numbers;
	}
	
	/*
	 * Method to perform the partition of the array
	 * @param: the array of numbers
	 * @param: the lower index of array/sub-array
	 * @param: the higher index of array/sub-array
	 * @return: the index of pivot element
	 */
	public int partition(int[] numbers, int low, int high) {
		int pivot = numbers[low];		//Assuming the default pivot number
		while(true) {
			while(numbers[low] < pivot) {
				low++;
			}
			
			while(numbers[high] > pivot) {
				high--;
			}
			
			if(low < high) {	//Swapping the numbers
				numbers[low] += numbers[high];
				numbers[high] = numbers[low] - numbers[high];
				numbers[low] -= numbers[high];
			} else {		//end of loop condition
				return high;	//pivot element index
			}	
		}
	}
}
