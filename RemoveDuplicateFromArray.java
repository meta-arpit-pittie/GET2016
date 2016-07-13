/*
 * Program to remove Duplicates from unsorted array
 * Assumption: Works for integer only
 * Author: Arpit Pittie
 */
package Session1;

public class RemoveDuplicateFromArray {
	
	private int[] withoutDuplicate;	//output array
	private int size=0;	//size of output array
	private boolean isNewElement;	//a flag for the new element in the array
	
	/*
	 * Method to remove the duplicates from the array
	 * @param: integer array
	 * @return: array with no duplicates
	 */
	public int[] removeDuplicate(int input[]) {
		int[] temp = new int[input.length];
		for(int i=0; i<input.length; i++) {
			isNewElement=true;
			//Loop to check duplicate element 
			for(int j=0; j<size; j++) {
				if(input[i] == temp[j]) {
					isNewElement = false;
				}
			}
			if(isNewElement) {	//adding the new element to the resultant array
				temp[size] = input[i];
				size++;
			}
		}
		
		withoutDuplicate = new int[size];
		//Assigning the resultant array to final output
		for(int i=0; i<size; i++) {
			withoutDuplicate[i] = temp[i];
		}
		return withoutDuplicate;
	}

}
