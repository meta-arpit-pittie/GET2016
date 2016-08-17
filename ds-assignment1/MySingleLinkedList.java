/**
 * Assignment 3
 * Class to implement the array list
 * @author Arpit Pittie 
 */
package session1;

public class MySingleLinkedList<E> implements MyList<E>{

	private Node<E> head;	//The starting node
	private int size;	//size of the list
	
	/**
	 * Node class for implementing the singly linked list
	 * @author Arpit Pittie
	 *
	 * @param <E> - Generic Type
	 */
	private static class Node<E> {

		E data;
		Node<E>  link;
		
		Node(Node<E> link, E data) {
			this.data = data;
			this.link = link;
		}
	}
	
	public MySingleLinkedList() {
		//Construct empty list
		size = 0;
		head = null;
	}
	
	/**
	 * Method to add the element at the head of the list
	 * @param element - Element to be added to the list
	 * @return True if the element is added to the list
	 */
	public boolean addFirst(E element) {
		Node<E> node;
		//creating new node
		if(head == null) {
			node = new Node<>(null, element);
		} else {
			node = new Node<>(head, element);
		}
		head = node;
		size++;
		return true;
	}
	
	/**
	 * Method to add the element at the last of the list
	 * @param element - Element to be added to the list
	 * @return True if the element is added to the list
	 */
	public boolean addLast(E element) {
		Node<E> x = head;
		Node<E> node = new Node<>(null, element);
		//Setting the link for the previous last node
		if(head == null) {
			head = node;
		} else {
			while(x.link != null) {
				x = x.link;
			}
			x.link = node;
		}
		size++;
		return true;
	}
	
	/**
	 * Method to add the element before a particular element in the list
	 * @param e - The element to be added to the list
	 * @param element - The element before the object is to be added
	 * @param parent - The element after which the oobject is to be added
	 * @return True if the element is added to the list
	 */
	private boolean addBefore(E e, Node<E> element, Node<E> parent) {
		Node<E> node = new Node<>(element, e);
		parent.link = node;
		size++;
		return true;
	}
	
	/**
	 * Method to check the given index value is permissible or not
	 * @param index - The index value to check
	 * @return True if the index value is permissible else false
	 */
	private void checkIndex(int index) {
		if(!(index >= 0 && index < size)) {
			throw new IllegalArgumentException("Wrong index"+index);
		}
	}
	
	/**
	 * Method to get the node reference based on the index of the object
	 * @param index - The index of the object
	 * @return The reference of the node at the index
	 */
	private Node<E> node(int index) {
		Node<E> x = head;
		//loop to get the node reference
		for(int i=0; i < index; i++) {
			x = x.link;
		}
		return x;
	}
	
	/**
	 * Method to get the reference of the object starting at the particular index
	 * @param o - The object whose node reference need to get
	 * @param index - The starting index of the list to get the node
	 * @return The reference of the node at the index 
	 */
	private Node<E> node(Object o, int index) {
		Node<E> x = head;
		//loop to find the object
		for(int i=index; i < size; i++) {
			if(x.data.equals(o)) {
				return x;
			}
			x = x.link;
		}
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(size == 0) {		//Check for emptiness of list
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		//Checking if the object is in the list
		if(node(o, 0) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return addLast(e);
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		Node<E> frwd = head;
		Node<E> prev = null;
		//loop to find the object
		for(int i=0; i < size; i++) {
			if(frwd.data.equals(o)) {
				//changing the reference of the nodes
				if(prev == null) {
					head = head.link;
					size--;
					return true;
				}
				prev.link = frwd.link;
				size--;
				return true;
			}
			prev = frwd;
			frwd = frwd.link;
		}
		return false;
	}

	@Override
	public boolean clear() {
		// TODO Auto-generated method stub
		Node<E> x = head;
		Node<E> next;
		//loop to unset all th nodes in the list
		for(int i=0; i < size; i++) {
			next = x.link;
			x.data = null;
			x.link = null;
			x = next;
		}
		head = null;
		size = 0;
		return true;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		checkIndex(index);
		return node(index).data;
	}

	@Override
	public E get(Object o, int index) {
		// TODO Auto-generated method stub
		checkIndex(index);
		return node(o, index).data;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		checkIndex(index);
		Node<E> node = node(index);
		//saving the old data
		E old = node.data;
		node.data = element;
		return old;
	}

	@Override
	public boolean add(int index, E element) {
		// TODO Auto-generated method stub
		checkIndex(index);
		return addBefore(element, node(index), node(index-1));
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		checkIndex(index);
		Node<E> frwd = head;
		Node<E> prev = null;
		E old;
		if(index == 0) {	//if removing the first element
			old = head.data;
			head = head.link;
		} else {
			//loop to traverse till the index vlue
			for(int i=0; i < index; i++) {
				prev = frwd;
				frwd = frwd.link;
			}
			prev.link = frwd.link;
			old = frwd.data;
		}
		size--;
		return old;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		Node<E> x = head;
		//loop to search the object
		for(int i=0; i < size; i++) {
			if(x.data.equals(o)) {
				return i;
			}
			x = x.link;
		}
		return -1;
	}

	@Override
	public MyList<E> subList(int start, int end) {
		// TODO Auto-generated method stub
		checkIndex(end);
		checkIndex(start);
		MySingleLinkedList<E> reversed = new MySingleLinkedList<E>();
		Node<E> x = node(start);
		//loop to add the elements in the new list
		for(int i=start; i <= end; i++) {
			reversed.addLast(x.data);
			x = x.link;
		}
		return reversed;
	}

	@Override
	public MyList<E> reverse() {
		// TODO Auto-generated method stub
		MySingleLinkedList<E> reversed = new MySingleLinkedList<E>();
		Node<E> x = head;
		//loop to reverse the elements and setting it in the new array list
		for(int i=0; i < size; i++) {
			reversed.addFirst(x.data);
			x = x.link;
		}
		return reversed;
	}
	
	@Override
	public void addAll(MyList<E> list) {
		// TODO Auto-generated method stub
		for(int i=0; i < list.size(); i++) {
			add(list.get(i));
		}
	}
	
	/**
	 * Method to implement the sorting
	 */
	public void sort() {
		MyArrayList<E> temp = new MyArrayList<E>(size);
		Node<E> x = head;
		//converting the list into array list
		for(int i=0; i < size; i++) {
			temp.add(x.data);
			x = x.link;
		}
		//Performing sorting on the array		
		temp.sort();
		x = head;
		//setting the sorted array value back into the list
		for(int i=0; i < temp.size(); i++) {
			x.data = temp.get(i);
			x = x.link;
		}
	}
}
