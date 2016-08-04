/**
 * Assignment 3
 * Class to implement the created sorted linked list
 * @author Arpit Pittie
 */
package session5;

import java.util.Scanner;

public class MainLinkedListSort {

	private SortedLinkedList<Integer> list;	//The sorted linked list
	private Scanner scan;	//To take input from the user
	
	public MainLinkedListSort() {
		list = new SortedLinkedList<Integer>();
		scan = new Scanner(System.in);
	}
	
	/**
	 * Method to insert the element to the sorted linked list
	 */
	public void insertList() {
		String choice;	//The choice for entering more number to list
		int number;		//The number to be added to the linked list
		
		do {
			//Exception handling for the number
			try {
				System.out.println("Enter number");
				number = Integer.parseInt(scan.nextLine());
				//inserting number to the sorted linked list
				list.insert(number);
			} catch (Exception e) {
				System.out.println("Enter numbers only");
			}
			
			System.out.println("Do you want to add more [y/n] :");
			choice = scan.nextLine();
			//Displaying the contents of the list
			display();
		} while (choice.equalsIgnoreCase("y"));
	}
	
	/**
	 * Method to display the contents of the list
	 */
	public void display() {
		System.out.println("The sorted linked list is");
		//loop to print the elements in the linked list
		for(int i=0; i < list.size(); i++) {
			System.out.print(list.get(i)+"\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MainLinkedListSort sorted = new MainLinkedListSort();
		sorted.insertList();
	}
}
