/*
 * Program to join two sorted array to generate a third sorted array
 * Assumption: Work for array sorted in ascending order
 * Author: Arpit Pittie
 */
package Session1;

public class MergeSortedArray {

	/*
	 * Method to check that merging was correct
	 * @param: first sorted integer array
	 * @param: second sorted integer array
	 * @return: result if merging is correct or not
	 */
	public boolean checkArrayMerge(int a[], int b[]) {
		int[] c = new int[a.length + b.length];
		boolean check = true;
		c=join(a, a.length, b, b.length, c);
		
		for(int i=0; i<c.length-1; i++) {	/*checking that merging was correct*/
			if(c[i] > c[i+1]) {
				check = false;
			}
		}
		return check;
	}
	
	/*
	 * Method to perform merge sort
	 * @param: first sorted integer array
	 * @param: size of first array
	 * @param: second sorted integer array
	 * @param: size of second array
	 * @param: array to store the resultant array
	 * @return: the merged sorted array
	 */
	public int[] join(int a[], int asize, int b[], int bsize, int c[]) {
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		//Performing Merge Sort
		while((i < asize) && (j < bsize)) {
			if(a[i] < b[j]) {
				c[k++] = a[i++];
			} else {
				c[k++] = b[j++];
			}
		}
		
		//Loops to add the remaining elements
		while (i < asize) { 
			c[k++] = a[i++];
		}
	    while (j < bsize) {
	    	c[k++] = b[j++];
	    }
	    
		return c;
	}
}
