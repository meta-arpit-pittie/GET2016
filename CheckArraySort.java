/*
 * Program to check whether array is ascending, descending or unsorted
 * Assumption: Only for integers
 * Author: Arpit Pittie
 */
package Session1;

public class CheckArraySort {

	/*
	 * Function to give the result about the sorting of the array
	 * @param: input array of integers
	 * @return: The nature of the sort of array
	 */
	public String result(int input[]) {
		int value=checkArray(input);
		
		switch(value) {		/*checking the 3 possible condition for the array sort*/
			case 0:{ return "Unsorted"; }
			case 1:{ return "Ascending"; }
			case 2:{ return "Descending"; }
		}
		return "Invalid";
	}
	
	/*
	 * Method to determine the sorting of the array
	 * @param: input integer array
	 * @return: code for the type of array sort
	 */
	public int checkArray(int input[]) {
		
		boolean ascending=false;
		boolean descending=false;
		
		for(int i=0; i<input.length-1; i++) {
			if(input[i] > input[i +1]) { /*Condition to check array is in ascending order*/
				descending=true;
			}
			
			if(input[i] < input[i +1]) { /*Condition to check array is in descending order*/
				ascending=true;
			}
			
			if(descending && ascending) { /*Condition if array is unsorted*/
				return 0;
			}
		}
		
		if(ascending) {
			return 1;
		} else {
			return 2;
		}
	}

}
