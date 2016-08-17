/**
 * Assignment 1
 * Class to implement the array list
 * @author Arpit Pittie 
 */
package session1;

public class MyArrayList<E> implements MyList<E>{

	private Object[] array;		//Array of objects to store the list elements
	private static final int DEFAULT_SIZE = 10;		//Default size for the list array
	private int size;	//To store the number of elements in the list

	public MyArrayList() {
		super();
		array = new Object[DEFAULT_SIZE];
		size = 0;
	}

	public MyArrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Wrong Capacity"
					+ initialCapacity);
		}
		this.array = new Object[initialCapacity];
		size = 0;
	}

	/**
	 * Method to increase the size of the array dynamically
	 * @param size - The actual size of the array
	 */
	private void ensureCapacityInternal(int size) {
		int newSize;
		if (size > array.length) {
			if (array.length < 4) {
				//The new array size
				newSize = size * 2;
			} else {
				//The new array size
				newSize = (size * 5) / 4;
			}
			//Copying the elements in the new array
			array = copyOf(newSize);
		}
	}

	/**
	 * Method to copy the elements in the given array to anew array
	 * @param newSize - The size of the new array
	 * @return
	 */
	private Object[] copyOf(int newSize) {
		Object[] temp = new Object[newSize];
		//Copying the elements in the new array
		for (int i = 0; i < size; i++) {
			temp[i] = array[i];
		}
		return temp;
	}

	/**
	 * Method to check the given index value is permissible or not
	 * @param index - The index value to check
	 * @return True if the index value is permissible else false
	 */
	private boolean checkRange(int index) {
		if ((index >= 0) && (index < size)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method to ensure the capacity of the array according to the user provided size
	 * @param size - The needed array size for the array
	 */
	public void ensureCapacity(int size) {
		if (size > 0) {
			ensureCapacityInternal(size);
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0) {	//Check for emptiness of array list
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			//Checking if the object is in the array 
			if (array[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		ensureCapacityInternal(size + 1);
		//Adding the element to the list
		array[size++] = e;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			//checking if the object exist in the list
			if (array[i].equals(o)) {
				remove(i);
				//decreasing the size of list
				size--;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean clear() {
		// TODO Auto-generated method stub
		//loop to clear all the elements from the array
		for (int i = 0; i < size; i++) {
			array[i] = null;
		}
		size = 0;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if (index >= size) {
			throw new IllegalArgumentException("Wrong index number" + index);
		} else {
			return (E) array[index];
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		if (!checkRange(index)) {
			throw new IllegalArgumentException("Wrong index number" + index);
		}
		E old = (E) array[index];
		//To replace the element at the index
		array[index] = element;
		return old;
	}

	@Override
	public boolean add(int index, E element) {
		// TODO Auto-generated method stub
		ensureCapacity(size + 1);
		//loop to move the array values one step ahead for adding the element at the index position
		for (int i = size; i > index; i--) {
			array[i] = array[i - 1];
		}
		//setting the element at the index value
		array[index] = element;
		size++;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		if (!checkRange(index)) {
			throw new IllegalArgumentException("Wrong index number" + index);
		}
		E old = (E) array[index];
		//loop to shift the list values one index before
		for (int i = index; i < size; i++) {
			array[i] = array[i + 1];
		}
		size--;
		return old;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			//checking if the object is in the array list
			if (array[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public MyList<E> subList(int start, int end) {
		// TODO Auto-generated method stub
		if (!checkRange(end)) {
			throw new IllegalArgumentException("Wrong index number" + end);
		}
		if (!checkRange(end)) {
			throw new IllegalArgumentException("Wrong index number" + start);
		}
		MyArrayList<E> temp = new MyArrayList<E>(end - start + 1);
		//loop to add the elements in the new list
		for (int i = start; i <= end; i++) {
			temp.add((E) array[i]);
		}
		return temp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(Object o, int index) {
		// TODO Auto-generated method stub
		for (int i = index; i < size; i++) {
			if (array[i].equals(o)) {
				return (E) array[i];
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public MyList<E> reverse() {
		MyArrayList<E> temp = new MyArrayList<E>(size);
		//loop to reverse the elements and setting it in the new array list
		for (int i = size - 1; i >= 0; i--) {
			temp.add((E) array[i]);
		}
		return temp;
	}
	
	@Override
	public void addAll(MyList<E> list) {
		// TODO Auto-generated method stub
		array = copyOf(size + list.size());
		for (int i = 0; i < list.size(); i++) {
			add(list.get(i));
		}
	}

	/**
	 * Method to implement the sorting
	 */
	public void sort() {
		mergeSort(0, size - 1);
	}

	/**
	 * Method to implement the merge sort n the array list
	 * @param low - The starting index of the array
	 * @param high - The end index of the array
	 */
	private void mergeSort(int low, int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;
			//Dividing the array in two equal parts
			mergeSort(low, middle);
			mergeSort(middle + 1, high);
			//Sorting the one part of the array
			merge(low, middle, high);
		}
	}

	/**
	 * Method to sort the sub array
	 * @param low - The starting index of sub array
	 * @param middle - The middle index at which the array was divided
	 * @param high - The end index of the sub array
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void merge(int low, int middle, int high) {

		Object[] helper = new Object[size];	//Temporary object array
		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		//Copy the smallest values from either the left or the right side back to the original array
		while (i <= middle && j <= high) {
			if (((Comparable) helper[i]).compareTo(helper[j]) < 0) {
				array[k] = helper[i];
				i++;
			} else {
				array[k] = helper[j];
				j++;
			}
			k++;
		}
		//Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			array[k] = helper[i];
			k++;
			i++;
		}
	}
}
