/**
 * Assignment 2
 * Class to store the information regarding the candidates
 * @author Arpit Pittie
 */
package session2;

import java.util.Scanner;

import session1.MyArrayList;
import session1.MySingleLinkedList;

public class Candidates implements Comparable<Candidates>{
	
	private String name;	//Name of the candidate
	private int rank;		//Rank of the candidate
	private College clg;	//College allocated to the  candidate
	private MySingleLinkedList<Integer> choices;	//The choice list of college for the candidate
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Candidates(String name, int rank) {
		this.name = name;
		this.rank = rank;
		clg = null;
		choices = new MySingleLinkedList();
	}
	
	public boolean setName(String name) {
		this.name = name;
		return true;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean setRank(int rank) {
		this.rank = rank;
		return true;
	}
	
	public int getRank() {
		return rank;
	}
	
	public boolean setCollege(College clg) {
		this.clg = clg;
		return true;
	}
	
	public College getCollege() {
		return clg;
	}
	
	/**
	 * Method to fill in the college choices for the candidate
	 * based upon his priorities
	 * @param scan - Scanner object to take input from the user
	 * @param clg - The available college list for the counseling
	 */
	public void fillChoices(Scanner scan, MyArrayList<College> clg) {
		String str;
		String value;
		int size = clg.size();
		
		//Check if college has been previously allocated to the candidate
		if(clg != null) {
			//input to check if the candidate want to participate in this round of counseling
			System.out.println("\n"+name+" - Do you want to fill choices [y/n]");
			str = scan.nextLine();
			//loop to fill in the choices if candidate wishes to participate in the counseling round
			while (str.equalsIgnoreCase("y")) {
				System.out.println("\nEnter college choice");
				value = scan.nextLine();
				try {
					//Checking for the correct college input from the candidate
					if((Integer.parseInt(value) < 1) || (Integer.parseInt(value) > size)) {
						System.out.println("\nEnter the correct choice");
					} else {
						//Checking if the selected college has vacant seats
						if(clg.get(Integer.parseInt(value) - 1).getSeats() > 0) {
							choices.add(Integer.parseInt(value));
						} else {
							System.out.println("\nSeats are full in this college\n");
						}
					}
				} catch(Exception e) {
					//e.printStackTrace();
					System.out.println("\nEnter the numerals only");
				}
				//input if the candidate wishes to add more college for this counseling round
				System.out.println("Do you want to add more [y/n]");
				str = scan.nextLine();
			}
		}
	}
	
	/**
	 * Method to allocate the college to this candidate
	 * based upon the priority list of college filled in by the candidate
	 * @param clg - The colleges list
	 */
	public void allocateCollege(MyArrayList<College> clg) {
		//loop to traverse through the choices of the candidate
		for(int i=0; i < choices.size(); i++) {
			//check if the desired college has the vacant seats
			if(clg.get(choices.get(i) - 1).getSeats() > 0) {
				//Allocating the college to the candidate
				this.clg = clg.get(choices.get(i) - 1);
				//Decreasing the available seats in the college
				clg.get(choices.get(i) - 1).setSeats(
						clg.get(choices.get(i) - 1).getSeats() - 1);
				//Clearing all the choices for the next round of counseling
				choices.clear();
				break;
			}
		}
	}
	
	public MySingleLinkedList<Integer> getChoices() {
		return choices;
	}

	@Override
	public int compareTo(Candidates o) {
		//Comparing based on the rank of the candidates
		if(rank < o.getRank()) {
			return -1;
		}
		return 1;
	}
}
