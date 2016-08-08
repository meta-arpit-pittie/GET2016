/**
 * Assignment 1
 * Implement the binary search which returns the left most occurrence of the element
 * @author Arpit Pittie
 */
package session7;

import java.util.Scanner;

public class BinarySearch {

	private int[] array;	//The array of the numbers
	private static final int SIZE = 10;	//default array size
	
	public BinarySearch() {
		array = new int[SIZE];
	}
	
	public BinarySearch(int[] values) {
		array = values;
	}
	
	/**
	 * Method to take number array and the element to search in it from the user
	 * @return - The element to be searched in the given array
	 */
	public int inputNumberArray() {
		int item;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter "+SIZE+" numbers in sorted manner");
		//loop to take number input from the user
		for(int i=0; i < SIZE;) {
			//Exception handling for the numerical input
			try {
				array[i] = Integer.parseInt(scan.nextLine());
				i++;
			} catch (Exception e) {
				System.out.println("Enter number only");
			}
		}
		
		System.out.println("Enter number to be searched");
		do {
			//exception handling for a numerical value
			try {
				item = Integer.parseInt(scan.nextLine());
				break; 
			} catch (Exception e) {
				System.out.println("Enter number only");
			}
		} while(true);
		
		scan.close();
		return item;
	}
	
	/**
	 * Method to perform the binary search returning the left most occurrence
	 * @param item - The element to be searched in the array
	 * @param low - The starting index of the array
	 * @param high - The end index of the array
	 * @return Index position of the element if found int the array else -1
	 */
	public int performBinarySearch(int item, int low, int high) {
		int mid = (low + high)/ 2;
		int temp;
		
		//Termination condition for the element not found in the given sub array/array
		if(low > high) {
			return -1;
		}
		//checking if the element is equals to the mid element
		if(item == array[mid]) {
			//Recursion to find any occurrence of the element in the left side of mid
			temp = performBinarySearch(item, low, mid -1);
			//condition to check if any more occurrence of element is found on the left side
			if(temp == -1) {
				return mid;
			} else {
				return temp;
			}
		} else {
			//Checking if the element lies in the left or right sub array
			if(item < array[mid]) {
				return performBinarySearch(item, low, mid - 1);
			} else {
				return performBinarySearch(item, mid + 1, high);
			}
		}
	}
	
	public static void main(String[] args) {
		int element;
		int location;
		BinarySearch searching = new BinarySearch();
		
		element = searching.inputNumberArray();
		location = searching.performBinarySearch(element, 0, SIZE-1);
		//condition to print the index position of the element in the array
		if(location == -1) {
			System.out.println("Element does not exist in the list");
		} else {
			System.out.println("Left most occurance is at index "+location);
		}
	}
}
