/**
 * Assignment 3
 * Class to realize the sorted linked list
 * @author Arpit Pittie
 */
package session5;

import java.util.LinkedList;

public class SortedLinkedList<E> {

	private LinkedList<E> linkedListSorted;	//The linked list to store the elements
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SortedLinkedList() {
		linkedListSorted = new LinkedList();
	}
	
	/**
	 * Method to insert the new element to the list
	 * @param data - The data to be inserted into the list
	 * @return True if the data is inserted to the linked list
	 */
	public boolean insert(E data) {
		int i = 0;
		//Check if the list is empty
		if(linkedListSorted.size() == 0) {
			linkedListSorted.add(data);
		} else {
			//Finding the position of the data in the list and inserting
			insertInternal(data, i);
		}
		return true;
	}
	
	/**
	 * Method to find the correct place for data and inserting it
	 * @param data - The data to be inserted
	 * @param i - The index position with which the data is to be compared 
	 * @return True if the data can be inserted at the particular position
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean insertInternal(E data, int i) {
		E value;
		//Checking if the end of list has arrived
		if(i >= linkedListSorted.size()) {
			//Adding element to the last position
			linkedListSorted.addLast(data);
			return false;
		}
		
		value = linkedListSorted.get(i);
		//Comparing the value at the index position with the data
		if(((Comparable)value).compareTo(data) > 0) {
			//Check for the starting position of the list
			if(i == 0) {
				linkedListSorted.addFirst(data);
			}
			return true;
		} else {
			//using recursion to traverse for the next index position
			if(insertInternal(data, i+1)) {
				//Adding the element to the list
				linkedListSorted.add(i+1, data);
			}
		}
		return false;
	}
	
	/**
	 * Method to retrieve the element at the specified index position
	 * @param index - The index position at which the object is to be fetched
	 * @return The object at the given index position if there else null
	 */
	public E get(int index) {
		//Checking for the correctness of the index
		if(index < 0 || index >= linkedListSorted.size()) {
			throw new IllegalArgumentException("Wrong index value");
		}
		return linkedListSorted.get(index);
	}
	
	/**
	 * Method to get the size of the list
	 * @return - The size of the linked list
	 */
	public int size() {
		return linkedListSorted.size();
	}
}
