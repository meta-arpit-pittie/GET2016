/**
 * Assignment 2
 * Class to implement the queue created
 * @author Arpit Pittie
 */
package session5;

import java.util.Scanner;

public class MainQueueClass {

	private QueueImplementation<Integer> queue;	//Queue data structure
	private Scanner scan;	//to take input from user
	
	public MainQueueClass() {
		queue = new QueueImplementation<Integer>();
		scan = new Scanner(System.in);
	}
	
	public void operation() {
		int choice;		//The operation to be performed
		int value;		//The value to be inserted
		do {
			choice = 0;
			//Options for the user
			System.out.println("\n1. Insert into queue");
			System.out.println("2. Delete from queue");
			System.out.println("3. Get front element from queue");
			System.out.println("4. Exit");
			System.out.println("Enter choice:");
			
			//Exception handling for the choice
			try {
				choice = Integer.parseInt(scan.nextLine());
				
				//Based on choice implementing the feature
				switch (choice) {
				case 1:
					//Adding element to the queue
					System.out.println("\nEnter number to add");
					//exception handling for the numericals
					try {
						value = Integer.parseInt(scan.nextLine());
						queue.enqueue(value);
					} catch (Exception e) {
						System.out.println("\nEnter numbers only");
					}
					break;
				case 2:
					//Removing the element from the queue
					//Exception handling for the queue underflow condition
					try {
						System.out.println("\nDeleted value is: "+queue.dequeue());
					} catch (Exception e) {
						System.out.println("\nQueue underflow");
					}
					break;
				case 3:
					//Getting the front element from the queue
					//Exception handling for the queue underflow condition
					try {
						System.out.println("\nThe value at the front is: "+queue.getFront());
					} catch (Exception e) {
						System.out.println("\nQueue underflow condition");
					}
					break;
				case 4:
					//Exiting the program
					break;
				default:
					System.out.println("Enter correct choice");
				}
				
			} catch (Exception e) {
				System.out.println("Enter numerals only");
			}
		} while (choice != 4);
	}
	
	public static void main(String[] args) {
		MainQueueClass queueClass = new MainQueueClass();
		queueClass.operation();
	}
}
