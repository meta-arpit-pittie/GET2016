/**
 * Assignment 2
 * Class to simulate the guest house
 * @author Arpit Pittie
 */
package session4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllocateRoom {

	private Scanner scan;	//To take input from user
	private MyHashMap<Customer, Integer> rooms;	//Hash Map to map the customers with rooms
	public static int totalCustomer;	//Total number of customers
	private List<Customer> keyList;		//The customer list
	
	public AllocateRoom() {
		int size;
		boolean result;
		scan = new Scanner(System.in);
		keyList = new ArrayList<Customer>();
		//taking input the total number of customers
		do {
			//Exception handling for the numeric value for total customer
			try {
				System.out.println("Enter total number of customers");
				totalCustomer = Integer.parseInt(scan.nextLine());
				break;
			} catch(Exception e) {
				System.out.println("Enter numerals only");
			}
		} while (true);
		
		size = totalCustomer;
		//Calculating the next prime number for hash map bucket size
		do {
			size++;
			result = false;
			//loop to check for prime number
			for(int i=2; i < size/2; i++) {
				if(size % i == 0) {
					result = true;
					break;
				}
			}
		} while(result);
		rooms = new MyHashMap<Customer, Integer>(size);
	}
	
	/**
	 * Method to take the customer information input
	 */
	public void takeCustomer() {
		String name;
		int age;
		Customer customer;
		
		//loop to take input for every customer
		for(int i=0; i < totalCustomer; i++) {
			System.out.println("Enter name");
			name = "";
			try {
				name = scan.nextLine();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			//loop to get the correct value of customer age
			do {
				age = 0;
				//Exception handling for the numeric value for customer age
				try {
					System.out.println("Enter age");
					age = Integer.parseInt(scan.nextLine());
				} catch(Exception e) {
					System.out.println("Enter numerals only");
				}
			} while (age < 1);
			
			//creating object of customer
			customer = new Customer(name, age);
			
			//Adding the customer object to the list
			keyList.add(customer);
			//Mapping the customer with the room number
			//Room number will be generated automatically
			rooms.insert(customer, null);
		}
	}
	
	/**
	 * Method to print the room allocation for the customers
	 */
	public void printDetails() {
		System.out.println("Name\tAge\tRoom");
		//loop to traverse the customer list and print their details
		for(int i=0; i < keyList.size(); i++) {
			System.out.println(keyList.get(i).getName()+"\t"+keyList.get(i).getAge()+
					"\t"+rooms.get(keyList.get(i)));
		}
	}
	
	public static void main(String[] args) {
		AllocateRoom allocate = new AllocateRoom();
		allocate.takeCustomer();
		allocate.printDetails();
	}
}
