/**
 * Assignment 1, 2 & 3
 * JUnit Test Case for testing Binary Search Tree
 */
package session3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import session1.MyArrayList;

public class TestBinarySearchTree {

	private static BinarySearchTree<Integer> bst;
	private int[] input;
	private int[] expected;
	
	@Before
	public void setUp() {
		bst = new BinarySearchTree<Integer>();
		input = new int[] {10,30,45,5,2,25};

		for(int i=0; i < input.length; i++) {
			bst.insert(input[i]);
		}
	}
	
	@Test
	public void testInsert() {
		assertTrue(bst.insert(1));
	}
	
	@Test
	public void testTraverse() {
		expected = new int[] {2,5,10,25,30,45};
		MyArrayList<Integer> value = bst.traverse(BinarySearchTree.INORDER);
		input = new int[value.size()];
		
		for(int i=0; i < value.size(); i++) {
			input[i] = value.get(i);
		}
		
		assertArrayEquals(expected, input);
	}
	
	@Test
	public void testCheckMirror() {
		BinarySearchTree<Integer> second = new BinarySearchTree<Integer>();
		MyArrayList<Integer> value = bst.traverse(BinarySearchTree.PREORDER);
		second.addAll(value);
		second.makeMirror();
		
		assertTrue(bst.checkMirror(second));
	}

}
