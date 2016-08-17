/**
 * Assignment 1,3 and 4
 * Interface to define the methods used by the list classes
 */
package session1;

public interface MyList<E> {

	/**
	 * Method to get the number of elements in the list
	 * @return The number of elements in the list
	 */
	public int size();
	
	/**
	 * Method to check if the list has any element or not
	 * @return True if the list has atleast one element else false
	 */
	public boolean isEmpty();
	
	/**
	 * Method to check that the given object is a part of the list or not
	 * @param o - The object to check the presence in the list
	 * @return True if the object is present in the list else false
	 */
	public boolean contains(Object o);
	
	/**
	 * Method to add the element to the list
	 * @param e - Element to be added to the list
	 * @return True if the element is added to the list
	 */
	public boolean add(E e);
	
	/**
	 * Method to remove the first instance of particular object from the list
	 * @param o - The to be removed from the list
	 * @return True if the object is in the list and is successfully removed else false
	 */
	public boolean remove(Object o);
	
	/**
	 * Method to remove all the elements from the list
	 * @return True if the list is cleared out
	 */
	public boolean clear();
	
	/**
	 * Method which returns the element stored at the given index
	 * @param index - The index on which the element is to retrieve
	 * @return The element at the given index
	 */
	public E get(int index);
	
	/**
	 * Method which returns the first instance of the object in the list
	 * starting from the given index
	 * @param o - The object desired
	 * @param index - The starting index to get the object
	 * @return The element if it matched with the object else null
	 */
	public E get(Object o, int index);
	
	/**
	 * Method to replace the element at the given index position with the element given 
	 * @param index - The index position of the element
	 * @param element - The element which is to be set at the given index
	 * @return The old value stored at the given index position
	 */
	public E set(int index, E element);
	
	/**
	 * Method to add the given element at the particular index
	 * @param index - The index position where the element is to be added
	 * @param element - The element which needs to be added to the list
	 * @return True if the element is added at the index position else false
	 */
	public boolean add(int index, E element);
	
	/**
	 * Method to remove the element from the given index position
	 * @param index - The index position at which the element is to be removed
	 * @return The element value at the index position
	 */
	public E remove(int index);
	
	/**
	 * Method to get the index position of the given object in the list
	 * @param o - The object whose index is to be searched
	 * @return The index position of the object in the list if found else -1
	 */
	public int indexOf(Object o);
	
	/**
	 * Method to get the sublist of the list
	 * @param start - The starting index in the list for sub list
	 * @param end - The end index in the list for sub list
	 * @return The n list containing the sub list between the given index positions
	 */
	public MyList<E> subList(int start, int end);
	
	/**
	 * Method to reverse the elements contained in the list
	 * @return The list with the reversed elements
	 */
	public MyList<E> reverse();
	
	/**
	 * Method to add all the items contained in the other list
	 * @param list - The list whose items need to be added to the current list
	 */
	public void addAll(MyList<E> list);
}
