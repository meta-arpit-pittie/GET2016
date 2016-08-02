/**
 * Assignment 3
 * Class to check the post-order traversal for the binary search tree
 * @author Arpit Pittie
 */
package session3;

import java.util.Scanner;

import session1.MyArrayList;

public class TraversalPostOrder {

	private BinarySearchTree<Integer> bst;	//The BST to hold the tree
	private Scanner scan;	//To take input from the user
	private MyArrayList<Integer> traverse;	//To store the traversing of the tree
	
	public TraversalPostOrder() {
		bst = new BinarySearchTree<Integer>();
		scan = new Scanner(System.in);
	}
	
	/**
	 * Method to take input from the user and create a binary tree of integer values
	 */
	public void createTree() {
		String choice;	//For check of adding more element to the tree
		int number;
		do {
			System.out.println("Enter number to add to tree");
			try {
				//Getting input from the user
				number = Integer.parseInt(scan.nextLine());
				//Adding the number to the tree
				bst.insert(number);
			} catch (Exception e) {
				System.out.println("Enter numbers only");
			}
			//Checking if user want to add more element to the tree
			System.out.println("Do you want to add more elements");
			choice = scan.nextLine();
		} while (choice.equalsIgnoreCase("y"));
	}
	
	/**
	 * Method to do the postorder traversal and print the result
	 */
	public void postorderTraversal() {
		//Performing the postorder traversal
		traverse = bst.traverse(BinarySearchTree.POSTORDER);
		
		//Printing the postorder traversal of the tree
		System.out.println("Postorder traversal is");
		for(int i=0; i < traverse.size(); i++) {
			System.out.println(traverse.get(i));
		}
	}
	
	public static void main(String[] args) {
		TraversalPostOrder preorder = new TraversalPostOrder();
		preorder.createTree();
		preorder.postorderTraversal();
	}

}
