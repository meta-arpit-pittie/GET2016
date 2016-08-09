/**
 * Assignment 2
 * Main class to take number input from user
 * And perform the sorting on them based on the user's choice
 * @author Arpit Pittie
 */
package session8;

import java.util.Scanner;

public class SortingSystem {

	private int[] numbers;	//The numbers array on which sorting to be performed
	private int size;		//The size of the number array
	private Scanner scan;	//To take input from the user
	
	public SortingSystem() {
		scan = new Scanner(System.in);
	}
	
	/**
	 * Method to take input from the user
	 */
	public void takeInput() {
		//loop to get the correct size of the array 
		do {
			size = -1;
			System.out.println("Enter size of array");
			//exception handling for the numerals
			try {
				size = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				System.out.println("Enter numerals only");
			}
		} while(size < 1);
		
		//initializing the roll number array
		numbers = new int[size];
		
		System.out.println("Enter "+size+" numbers");
		//loop to take roll numbers of students
		for (int i = 0; i < size;) {
			//exception handling for the numerals
			try {
				numbers[i] = Integer.parseInt(scan.nextLine());
				//check if the numbers are positive
				//As the radix and counting sort cannot handle negative number
				if(numbers[i] < 0) {
					System.out.println("Enter positive numbers only");
				} else {
					i++;
				}
			} catch (Exception e) {
				System.out.println("Enter numerals only");
			}
		}
	}
	
	/**
	 * Method to provide the menu to the user for the type of sorting to be applied to the array
	 */
	public void openMenu() {
		int choice;
		//loop to take input from user continuously
		do {
			//exception handling for the numeric input
			try {
				System.out.println("\nMain menu\n");
				System.out.println("1. Comparision Sort");
				System.out.println("2. Linear Sort");
				System.out.println("3. Exit");
				//Getting the user choice
				choice = Integer.parseInt(scan.nextLine());
				
				//Choosing the appropriate sorting based on the user's choice
				switch (choice) {
				case 1:
					//chosen option is for comparison sort
					new ComparisonSort(numbers).performSorting();
					break;
				case 2:
					//chosen option is for linear sort
					new LinearSort(numbers).performSorting();
					break;
				case 3:
					//chosen option is for exiting from the system
					break;
				default:
					//Wrong option selected from the menu
					System.out.println("Enter correct choice");
				}
				
			} catch (Exception e) {
				System.out.println("\nEnter numerals only\n");
				choice = 0;
			}
		} while (choice != 3);
		
		scan.close();
	}
	
	public static void main(String[] args) {
		SortingSystem sorting = new SortingSystem();
		sorting.takeInput();
		sorting.openMenu();
	}
}
