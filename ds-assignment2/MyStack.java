/**
 * Assignment 1
 * Class to implement the stacks
 * @author Arpit Pittie
 */
package session2;

import session1.MyDoubleLinkedList;

public class MyStack<E> {

	private MyDoubleLinkedList<E> stack;	//Linked list to implement stack
	private int top;	//The top of the stack
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MyStack() {
		top = 0;
		stack = new MyDoubleLinkedList();
	}
	
	/**
	 * Method to add/push to the stack
	 * @param e - The object to be added to the stack
	 * @return True if the object can be added to the stack else false
	 */
	public boolean push(E e) {
		stack.add(e);
		top++;
		return true;
	}
	
	/**
	 * Method to remove/pop object from the stack
	 * @return The object removed from the stack 
	 */
	public E pop() {
		//Check if the stack is empty
		if(top == 0) {
			throw new IllegalAccessError("Stack underflow condition");
		}
		E old = stack.remove(top-1);
		top--;
		return old;
	}
	
	/**
	 * Method to retrieve the top object without removing it from the stack
	 * @return The object at the top of stack
	 */
	public E peek() {
		//Check if the stack is empty
		if(top == 0) {
			throw new IllegalAccessError("Stack underflow condition");
		}
		return stack.get(top-1);
	}
	
	/**
	 * Method to get the value of the top pointer
	 * @return The value of the top
	 */
	public int getTop() {
		return top;
	}
}
