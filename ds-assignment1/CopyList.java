/**
 * Assignment 2
 * Class to add the elements of first list to the second list
 * @author Arpit Pittie
 */
package session1;

import java.util.Scanner;

public class CopyList {

	private MyArrayList<String> list1 = new MyArrayList<String>();
	private MyArrayList<String> list2 = new MyArrayList<String>();
	private Scanner scan;
	
	/**
	 * Method to take input from user
	 */
	public void takeInput() {
		scan = new Scanner(System.in);
		int sizeFirst;	//Size of first list
		int sizeSecond;		//Size of second list
		
		System.out.println("Enter size of first list");
		sizeFirst = Integer.parseInt(scan.nextLine());
		System.out.println("Enter elements");
		//Input elements for first list
		for(int i=0; i < sizeFirst; i++) {
			list1.add(scan.nextLine());
		}
		
		System.out.println("Enter size of second list");
		sizeSecond = Integer.parseInt(scan.nextLine());
		System.out.println("Enter elements");
		//Input elements for second list
		for(int i=0; i < sizeSecond; i++) {
			list2.add(scan.nextLine());
		}
		//Adding all elements of second list to first list
		list1.addAll(list2);
	}
	
	/**
	 * Method to display the elements in the list
	 */
	public void display() {
		for(int i=0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
	}
	public static void main(String[] args) {
		CopyList cl = new CopyList();
		cl.takeInput();
		cl.display();
	}
}
