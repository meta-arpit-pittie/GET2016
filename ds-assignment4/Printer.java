/**
 * Assignment 1
 * Class to implement the printing of a document on the printer
 * @author Arpit Pittie
 */
package session4;

import java.util.Scanner;

public class Printer extends LeafMenuItem{

	public Printer(String name) {
		super(name);
	}
	
	@Override
	public void actionTaken(Scanner scan) {
		//Exception handling for printer if there are no documents in the queue
		try {
			//Getting the highest priority job from the heap
			Jobs perform = (Jobs) Jobs.heap.delete();
			//Printing the document
			System.out.println("The document is\n");
			System.out.println(perform.getDocument());
		} catch (IllegalAccessError iae) {
			System.out.println("\nNo jobs are pending");
		}
	}
}
