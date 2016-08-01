/**
 * Assignment 2
 * Class tom implement the queue
 * @author Arpit Pittie
 */
package session2;

import session1.MyArrayList;

public class MyQueue<E> {

	private MyArrayList<E> queue;	//The array list to implement the queue
	private int front;	//The pointer to store the index of the least recently added element
	private int rear;	//The pointer to store the index where the new element is to be added
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MyQueue() {
		queue = new MyArrayList();
		front = 0;
		rear = 0;
	}
	
	/**
	 * Method to get the value of the rear
	 * @return The index value for the rear pointer
	 */
	public int rear() {
		return rear;
	}
	
	/**
	 * Method to get the value of the front
	 * @return The index value for the front pointer
	 */
	public int front() {
		return front;
	}
	
	/**
	 * Method to get the value at the front without removing it
	 * @return The value least recently added
	 */
	public E getFront() {
		//Check if the queue is empty
		if(rear <= front) {
			throw new IllegalAccessError("Queue underflow condition");
		}
		return queue.get(front);
	}
	
	/**
	 * Method to make queue empty removing all elements
	 */
	public void makeEmpty() {
		queue.clear();
		front = 0;
		rear = 0;
	}
	
	/**
	 * Method to add the elements to the queue
	 * @param element - The object to be added to the queue
	 * @return True if the value is added to the queue
	 */
	public boolean enqueue(E element) {
		queue.add(element);
		rear++;
		return true;
	}
	
	/**
	 * Method to remove the element from the queue
	 * @return The removed element from the queue
	 */
	public E dequeue() {
		//Check if the queue is empty
		if(rear <= front) {
			throw new IllegalAccessError("Stack underflow condition");
		}
		return queue.get(front++);
	}
	
	/**
	 * Method to get the size of the queue
	 * @return The size of the queue
	 */
	public int size() {
		return rear-front;
	}
	
	/**
	 * Method to sort the elements of the queue
	 */
	public void sort() {
		queue.sort();
	}
}
