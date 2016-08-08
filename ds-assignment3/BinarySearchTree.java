/**
 * Assignment 1, 2 & 3
 * Class to implement the Binary Search Tree
 * @author Arpit Pittie
 */
package session3;

import session1.MyArrayList;
import session1.MyList;

public class BinarySearchTree<E> {

	private Node<E> root;	//The reference to store the root information
	private MyArrayList<E> traversal;	//List to store the traversal of the nodes
	public static final int INORDER = 0;	//identifier for inorder traversal
	public static final int PREORDER = 1;	//identifier for preorder traversal
	public static final int POSTORDER = 2;	//identifier for postorder traversal
	
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
	
	public BinarySearchTree() {
		root = null;
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
	 * Method to implement the traversing of the tree
	 * @param type - The value to indicate the type of traversing 
	 * @return ArrayList containing the nodes in the order they were traversed 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MyArrayList<E> traverse(int type) {
		//initializing the array list
		traversal = new MyArrayList();
		//Checking for the type of traversing to be used
		switch(type) {
		case INORDER:
			//starting the inorder traversal from root node
			inorder(root);
			break;
		case PREORDER:
			//starting the preorder traversal from root node
			preorder(root);
			break;
		case POSTORDER:
			//starting the postorder traversal from root node
			postorder(root);
			break;
		default :
			//Wrong type of traversal input
			throw new IllegalArgumentException("Wrong Traversing");
		}
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
	
	/**
	 * Method to implement preorder traversing
	 * @param start - The node for doing the traversing
	 */
	private void preorder(Node<E> start) {
		//Termination condition
		if(start == null) {
			return;
		}
		traversal.add(start.data);	//Traversing the root node
		preorder(start.left);	//Traversing the left portion
		preorder(start.right);	//Traversing the right portion
	}
	
	/**
	 * Method to implement postorder traversing
	 * @param start - The node for doing the traversing
	 */
	private void postorder(Node<E> start) {
		//Termination condition
		if(start == null) {
			return;
		}
		postorder(start.left);	//Traversing the left portion
		postorder(start.right);	//Traversing the right portion
		traversal.add(start.data);	//Traversing the root node
	}
	
	/**
	 * Method to search for the node having the specific data element
	 * @param data - The data element to be searched in the tree
	 * @return The reference for the node with the given data value if found else null
	 */
	public Node<E> search(E data) {
		return searchInternal(data, root);
	}
	
	/**
	 * Method to perform the searching
	 * @param data - the data element to be searched
	 * @param start - The starting node to start search from
	 * @return - The reference for the node with the given data value if found else null
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Node<E> searchInternal(E data, Node<E> start) {
		//element found or the end has reached
		if(start == null || start.data.equals(data)) {
			return start;
		}
		//Comparing on which side the element could be
		if(((Comparable) start.data).compareTo(data) > 0) {
			return insertInternal(data, start.left);
		} else {
			return insertInternal(data, start.right);
		}
	}
	
	/**
	 * Method to mirror the tree
	 */
	public void makeMirror() {
		makeMirrorInternal(root);
	}
	
	/**
	 * Method to help in mirroring the tree
	 * @param start - The root node at which the mirroring is to be performed
	 */
	private void makeMirrorInternal(Node<E> start) {
		if(start == null) {
			return;
		}
		//Swapping the left and right elements
		Node<E> temp = start.left;
		start.left = start.right;
		start.right = temp;
		
		//recursively mirroring the left and right subtrees
		makeMirrorInternal(start.left);
		makeMirrorInternal(start.right);
	}
	
	/**
	 * Method to check if the two trees are mirror similar
	 * @param otherTree - The reference for the other tree
	 * @return True if the trees are mirror similar else false
	 */
	public boolean checkMirror(BinarySearchTree<E> otherTree) {
		return checkMirrorInternal(root, otherTree.root);
	}
	
	/**
	 * Method to perform the mirror similar condition
	 * @param start - The root node of first tree
	 * @param otherStart - The root node of second tree
	 * @return True if both trees are mirror similar with the root provided else false 
	 */
	private boolean checkMirrorInternal(Node<E> start, Node<E> otherStart) {
		//Checking if both the trees are empty
		if(start == null && otherStart == null) {
			return true;
		}
		//Checking if one tree is empty and other is not
		if(start == null || otherStart == null) {
			return false;
		} else {
			//Checking if the data at the node is similar in the tree
			if(start.data.equals(otherStart.data)) {
				//Recursively check the mirror similar condition for the left and right subtrees
				return (checkMirrorInternal(start.left, otherStart.right) &&
						checkMirrorInternal(start.right, otherStart.left));
			}
		}
		return false;
	}
	
	/**
	 * Method to clear all the elements in the tree
	 */
	public void makeEmpty() {
		root = null;
	}
}
