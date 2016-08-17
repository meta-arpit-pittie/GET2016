/**
 * Assignment 2
 * Class to store the information about colleges
 */
package session2;

public class College implements Comparable<College>{

	private String name;	//Name of the college
	private String place;	//Place of the college
	private int rank;	//Rank of the college
	private int noOfSeats;	//Number of seats available in the college
	
	public College(String name, String place, int noOfSeats, int rank) {
		this.name = name;
		this.place = place;
		this.noOfSeats = noOfSeats;
		this.rank = rank;
	}
	
	public boolean setName(String name) {
		this.name = name;
		return true;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean setSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
		return true;
	}
	
	public int getSeats() {
		return noOfSeats;
	}
	
	public boolean setPlace(String place) {
		this.place = place;
		return true;
	}
	
	public String getPlace() {
		return place;
	}
	
	public boolean setRank(int rank) {
		this.rank = rank;
		return true;
	}
	
	public int getRank() {
		return rank;
	}
	
	@Override
	public int compareTo(College o) {
		//Comparing based on the rank of the college
		if(rank < o.getRank()) {
			return -1;
		}
		return 1;
	}
}
