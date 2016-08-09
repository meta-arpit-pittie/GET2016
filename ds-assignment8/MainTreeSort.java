/**
 * Assignment 1
 * Class to take input and perform the tree sort on the numbers
 * @author Arpit Pittie
 */
package session8;

import java.util.Scanner;

public class MainTreeSort {

	private Scanner scan;	//to take input from the user
	private int[] rollNo;	//Array of student roll numbers
	private int size;		//Size of the student's roll number array
	
	public MainTreeSort() {
		scan = new Scanner(System.in);
	}
	
	/**
	 * Method to take input from the user
	 */
	public void takeInput() {
		//loop to get the correct size of the array 
		do {
			size = -1;
			System.out.println("Enter number of students");
			//exception handling for the numerals
			try {
				size = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				System.out.println("Enter numerals only");
			}
		} while(size < 1);
		
		//initializing the roll number array
		rollNo = new int[size];
		
		System.out.println("Enter "+size+" numbers");
		//loop to take roll numbers of students
		for (int i = 0; i < size;) {
			//exception handling for the numerals
			try {
				rollNo[i] = Integer.parseInt(scan.nextLine());
				//if the roll number is correct take input for next student
				i++;
			} catch (Exception e) {
				System.out.println("Enter numerals only");
			}
		}
		
		scan.close();
	}
	
	/**
	 * Method to perform the sorting and printing the result
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void display() {
		TreeSort<Integer> treeSort = new TreeSort();
		//inserting the roll numbers to the BST
		for (int i = 0; i < rollNo.length; i++) {
			treeSort.insert(rollNo[i]);
		}
		
		System.out.println("Sorted array is");
		//Printing the sorted roll numbers in ascending order
		System.out.println(treeSort.sort());
	}
	
	public static void main(String[] args) {
		MainTreeSort sorting = new MainTreeSort();
		sorting.takeInput();
		sorting.display();
	}
}
