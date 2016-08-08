/**
 * Assignment 1
 * Class to implement the Heap Tree
 * @author Arpit Pittie
 */
package session4;

public class HeapTree {

	private Object[] tree;	//Array to store the elements of the tree
	private int size;	//The no of elements in the heap
	private static final int DEFAULT_CAPACITY = 10;
	private static final int DELETE_INDEX = 1;
	
	public HeapTree() {
		tree = new Object[DEFAULT_CAPACITY];
		size = 0;
	}
	
	public HeapTree(int size) {
		tree = new Object[size];
		size = 0;
	}
	
	/**
	 * Method to increase the size of the array dynamically
	 * @param size - The actual size of the array
	 */
	private void ensureCapacityInternal(int size) {
		int newSize;
		if (size > tree.length) {
			if (tree.length < 4) {
				//The new array size
				newSize = size * 2;
			} else {
				//The new array size
				newSize = (size * 5) / 4;
			}
			//Copying the elements in the new array
			tree = copyOf(newSize);
		}
	}
	
	/**
	 * Method to copy the elements in the given array to anew array
	 * @param newSize - The size of the new array
	 * @return - The array of objects with increased size and the elements of the old array
	 */
	private Object[] copyOf(int newSize) {
		Object[] temp = new Object[newSize];
		//Copying the elements in the new array
		for (int i = 0; i < size; i++) {
			temp[i] = tree[i];
		}
		return temp;
	}
	
	/**
	 * Method to insert the object to the head tree
	 * @param data - The object to be added to the tree
	 */
	public void insert(Object data) {
		//Checking the capacity of the array
		ensureCapacityInternal(size+1);
		//Adding element to the tree
		tree[++size] = data;
		//Performing operations on the tree to build a max heap
		buildHeap();
	}
	
	/**
	 * Method to perform operations for building a max heap
	 */
	private void buildHeap() {
		//loop to heapify each subtree
		for(int i = size/2; i >= 1; i--) {
			heapify(i);
		}
	}
	
	/**
	 * Method for converting tree to heap tree
	 * @param i - The index of the internal node to make it a heap
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void heapify(int i) {
		int left = (2 * i);		//index of left child
		int right = (2 * i)+ 1;	//index of right child
		int largest;
		Object temp;
		
		//Comparing the parent data with the data in left child
		if((left <= size) && (((Comparable) tree[left]).compareTo(tree[i]) > 0)) {
			largest = left;
		} else {
			largest = i;
		}
		
		//Comparing the largest data between parent and left child data with the data in right child
		if((right <= size) && (((Comparable) tree[right]).compareTo(tree[largest]) > 0)) {
			largest = right;
		}
		
		//Check if the parent node data is largest or not
		if(largest != i) {
			//swapping the parent data with the largest data
			temp = tree[i];
			tree[i] = tree[largest];
			tree[largest] = temp;
			//Calling the heapify function to perform heap operation with the largest index as root node
			heapify(largest);
		}
	}
	
	/**
	 * Method to delete the root node from the heap tree
	 * @return The object at the root of the tree
	 */
	public Object delete() {
		Object old;
		//Check if the heap tree is empty
		if(size < 1) {
			throw new IllegalAccessError("No object in heap to delete");
		}
		//Deleting the root node
		old = tree[DELETE_INDEX];
		//adding the last element of the tree as the root node
		tree[DELETE_INDEX] = tree[size];
		tree[size--] = null;
		
		//Make a heap of the tree with the new root
		buildHeap();
		
		return old;
	}
}
