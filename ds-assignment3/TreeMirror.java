/**
 * Assignment 2
 * Class to perform the check for mirror similar trees
 * @author Arpit Pittie
 */
package session3;

import java.util.Scanner;

import session1.MyArrayList;

public class TreeMirror {

	private BinarySearchTree<Integer> bstFirst;		//To store the first BST
	private BinarySearchTree<Integer> bstSecond;	//To store the first BST
	private Scanner scan;	//To get input from the user
	private MyArrayList<Integer> traverse;
	
	public TreeMirror() {
		bstFirst = new BinarySearchTree<Integer>();
		bstSecond = new BinarySearchTree<Integer>();
		traverse = new MyArrayList<Integer>();
		scan = new Scanner(System.in);
	}
	
	/**
	 * Method to perform all the functions for checking the mirror similar trees
	 */
	public void startProcess() {
		//Checking the mirror similar condition when the trees are empty
		System.out.println("Before adding any element to the trees");
		mirrorSimilarTree();
		
		//Taking input for first tree
		System.out.println("\nAdd Elements for first tree");
		createTree(bstFirst);
		//Taking input for second tree
		System.out.println("\nAdd Elements for second tree");
		createTree(bstSecond);
		
		//Checking the mirror similar condition when both the trees have value
		System.out.println("\nAfter adding entries to both trees");
		mirrorSimilarTree();
		
		//Deleting entries in second tree to store the mirror image of first tree
		bstSecond.makeEmpty();
		//Getting values of first tree
		traverse = bstFirst.traverse(BinarySearchTree.PREORDER);
		//inserting the values of first tree into second tree
		bstSecond.addAll(traverse);
		//converting the second tree to its mirror image
		bstSecond.makeMirror();
		
		//Checking the first tree with its mirror image in second tree for mirror similar condition
		System.out.println("\nAfter taking mirror image of first tree");
		mirrorSimilarTree();
		
		scan.close();
	}
	
	/**
	 * Method to take input from the user and create a binary tree of integer values
	 */
	public void createTree(BinarySearchTree<Integer> bst) {
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
	 * Method to check for the mirror similar condition on the trees
	 */
	public void mirrorSimilarTree() {
		//Check if the trees are mirror similar trees
		if(bstFirst.checkMirror(bstSecond)) {
			System.out.println("Both the trees are mirror similar trees");
		} else {
			System.out.println("The trees are not mirror similar");
		}
	}
	
	public static void main(String[] args) {
		TreeMirror mirroring = new TreeMirror();
		mirroring.startProcess();
	}
}
