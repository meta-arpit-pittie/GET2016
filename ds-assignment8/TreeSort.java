/**
 * Assignment 1
 * Class to implement the tree sort algorithm
 * @author Arpit Pittie
 */
package session8;

import java.util.ArrayList;

import session1.MyList;

public class TreeSort<E> {

	private Node<E> root;	//The reference to store the root information
	private ArrayList<E> traversal;	//List to store the traversal of the nodes
	
	/**
	 * Node class to implement the binary search tree
	 * @author Arpit Pittie
	 *
	 * @param <E> - Generic Type
	 */
	private static class Node<E> {
		E data;
		Node<E> left;
		Node<E> right;
		
		Node(Node<E> left, E data, Node<E> right) {
			this.left = left;
			this.data = data;
			this.right = right;
		}
	}
	
	public TreeSort() {
		root = null;
	}
	
	/**
	 * Method to add all the elements to the tree
	 * @param data - Array of the element to be added to the tree
	 * @return True if the elements are inserted to the tree
	 */
	public boolean addAll(E[] data) {
		for(int i=0; i < data.length; i++) {
			insert(data[i]);
		}
		return true;
	}
	
	/**
	 * Method to add all the elements to the tree
	 * @param data - List of the element to be added to the tree
	 * @return True if the elements are inserted to the tree
	 */
	public boolean addAll(MyList<E> data) {
		for(int i=0; i < data.size(); i++) {
			insert(data.get(i));
		}
		return true;
	}
	
	/**
	 * Method to insert the element to the BST
	 * @param data - The element to be added to the tree
	 * @return True if the element is added to the tree else false 
	 */
	public boolean insert(E data) {
		//Find the right place in the tree to insert the element in the BST
		root = insertInternal(data, root);
		return true;
	}
	
	/**
	 * Method to find the right node to place the new element
	 * @param data - The new element to be inserted
	 * @param start - The node whose data is to be checked against the new element for inserting
	 * @return The node inserted
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Node<E> insertInternal(E data, Node<E> start) {
		//Check if the leaf node has arrived
		if(start == null) {
			//Creating new node
			start = new Node(null, data, null);
			return start;
		}
		//Comparing the element with the existing data
		if(((Comparable) start.data).compareTo(data) > 0) {
			start.left = insertInternal(data, start.left);
		} else {
			start.right = insertInternal(data, start.right);
		}
		return start;
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList<E> sort() {
		//initializing the array list
		traversal = new ArrayList();
		inorder(root);
		return traversal;
	}
	
	/**
	 * Method to implement inorder traversing
	 * @param start - The node for doing the traversing
	 */
	private void inorder(Node<E> start) {
		//Termination condition
		if(start == null) {
			return;
		}
		inorder(start.left);	//Traversing the left portion
		traversal.add(start.data);	//Traversing the root node
		inorder(start.right);	//Traversing the right portion
	}
}
