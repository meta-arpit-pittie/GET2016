/**
 * Assignment 1
 * Class for mapping the jobs on the printer
 * @author Arpit Pittie
 */
package session4;

import java.util.Scanner;

public class Jobs extends LeafMenuItem implements Comparable<Jobs>{

	private int priority;	//Priority of the job
	private String document;	//The document to be printed
	public static HeapTree heap = new HeapTree();	//Heap tree to store the jobs
	//Priorities for different levels
	private static final int DEPARTMENT_CHAIR = 4;
	private static final int PROFESSORS = 3;
	private static final int GRADUATES = 2;
	private static final int UNDERGRADUATES = 1;
		
	//constructor for creating the menu
	public Jobs(String name) {
		super(name);
	}
	
	private Jobs(int prioirity, String document) {
		this.priority = prioirity;
		this.document = document;
	}
	
	public void setPrioirity(int priority) {
		this.priority = priority;
	}
	
	public int getPrioirity() {
		return priority;
	}
	
	public void setDocument(String document) {
		this.document = document;
	}
	
	public String getDocument() {
		return document;
	}

	@Override
	public int compareTo(Jobs o) {
		if(priority > o.getPrioirity()) {
			return 1;
		} else {
			return -1;
		}
	}
	
	@Override
	public void actionTaken(Scanner scan) {
		int prior = 0;
		do {
			//Exception handling for errorneous input
			try {
				//Giving priority options
				System.out.println("\n1. Undergraduate students");
				System.out.println("2. Graduate students");
				System.out.println("3. Professors");
				System.out.println("4. Department Head");
				System.out.println("Enter prioirity");
				//Getting input from user
				prior = Integer.parseInt(scan.nextLine());
				
				//Checking if the input priority is from the available options only
				if((prior != DEPARTMENT_CHAIR) && (prior != PROFESSORS) && 
						(prior != GRADUATES) && (prior != UNDERGRADUATES)) {
					System.out.println("Enter the correct priority");
				}
				
			} catch (Exception e) {
				System.out.println("Enter numbers only");
			}
			//continue getting the priority input while we do not get our desired input
		} while ((prior != DEPARTMENT_CHAIR) && (prior != PROFESSORS) && 
				(prior != GRADUATES) && (prior != UNDERGRADUATES));
		priority = prior;
		
		//Getting input the document to be printed
		System.out.println("Enter document to be printed");
		document = scan.nextLine();
		//Adding the new job with the priority and document to the heap
		heap.insert(new Jobs(priority, document));
	}
}
