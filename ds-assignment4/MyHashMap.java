/**
 * Assignment 2
 * Class to realize a Hash Map
 * @author Arpit Pittie
 */
package session4;

public class MyHashMap<K, V> {

	private Node<K, V>[] bucket;	//The bucket array for the mapping
	private static final int DEFAULT_CAPACITY = 7;	//The default capacity of bucket
	private int capacity;	//Capacity of the bucket defined
	private int[] roomNo;
	
	/**
	 * Class to create a key value pair for the mapping
	 * @author Arpit Pittie
	 *
	 * @param <K> - Key
	 * @param <V> - Value
	 */
	@SuppressWarnings("unused")
	private static class Node<K, V> {	
		K key;
		V value;
		Node<K, V> next;
		
		Node(K key, V value, Node<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	@SuppressWarnings("unchecked")
	public MyHashMap() {
		bucket = new Node[DEFAULT_CAPACITY];
		capacity = DEFAULT_CAPACITY;
		
		//Generating room numbers
		roomNo = new int[DEFAULT_CAPACITY];
		for(int i=0; i < DEFAULT_CAPACITY; i++) {
			roomNo[i] = 101 + i;
		}
	}
	
	@SuppressWarnings("unchecked")
	public MyHashMap(int capacity) {
		bucket = new Node[capacity];
		this.capacity = capacity;
		
		//Generating room numbers
		roomNo = new int[capacity];
		for(int i=0; i < capacity; i++) {
			roomNo[i] = 101 + i;
		}
	}
	
	/**
	 * Method to insert a key-value pair into the hash map
	 * @param key - The key for the value
	 * @param value - The value to be stored in the map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void insert(K key, V value) {
		int index;
		Node<K, V> mapping;
		//Null key is not valid
		if(key == null) {
			throw new IllegalArgumentException("key cannot be null");
		}
		//Getting index value for the bucket
		index = hash(key);
		
		//Checking if the bucket at index value is already filled
		if(bucket[index] != null) {
			//Checking if the out of bounds condition for next index value
			if((AllocateRoom.totalCustomer + 1) == capacity) {
				index = 0;
			} else {
				index = AllocateRoom.totalCustomer + 1;
			}
			
			//Performing linear probing on the index value for the map
			while(bucket[index] != null) {
				if((index + 1) == capacity) {
					index = 0;
				} else {
					index++;
				}
			}
		}
		value = (V) new Integer(roomNo[index]);
		mapping = new Node(key, value, null);
		//Adding the node at the calculated index position in the bucket
		bucket[index] = mapping;
	}
	
	/**
	 * Method to get the value stored using its corresponding key
	 * @param key - The key at which we want to retrieve the value
	 * @return The value stored at the particular key
	 */
	public V get(K key) {
		//Getting the index value for the key
		int index = hash(key);
		V value = null;
		
		//checking for the key matching at the index position
		if(bucket[index].key.hashCode() != key.hashCode()) {
			//Checking if the out of bounds condition for next index value
			if((AllocateRoom.totalCustomer + 1) == capacity) {
				index = 0;
			} else {
				index = AllocateRoom.totalCustomer + 1;
			}
			
			//loop to traverse through the bucket using linear probing
			while(bucket[index].key.hashCode() != key.hashCode()) {
				if((index + 1) == capacity) {
					index = 0;
				} else {
					index++;
				}
			}
		} else {
			value = bucket[index].value;
		}
		return value;
	}
	
	/**
	 * Method to get the hash value for the given key value
	 * @param key - The key for which to generate the hash
	 * @return - The index position corresponding to the key hash
	 */
	private int hash(K key) {
		return (key.hashCode() % capacity);
	}
}
