/**
 * Assignment 1
 * Abstract class to represent the methods for all types of nodes
 * @author Arpit Pittie
 */
package session5;

import java.util.List;

public abstract class Node {

	public abstract String getName();
	public abstract void setName(String name);
	public abstract String getPlace();
	public abstract void setPlace(String place);
	public abstract String getType();
	public abstract void setType(String type);
	
	/**
	 * To add a connection between two nodes
	 * @param conn - the node reference to which the edge is to be created
	 */
	public abstract void addNeighbour(Node conn);
	
	/**
	 * To remove a edge from a node
	 * @param remove - The node reference whose linking edge to the current node is to be removed
	 * @return True if the edge is deleted else false
	 */
	public abstract boolean removeNeighbour(Node remove);
	
	/**
	 * To display the edges from the given node
	 */
	public abstract void displayNeighbour();
	
	/**
	 * To remove the attributes associated with the node
	 * @return True if the attributes are removed successfully else false
	 */
	public abstract boolean removeProfile();
	
	/**
	 * To check if an edge exist between the nodes
	 * @param query - The node reference by which edge existence is to be checked
	 * @return True if the edge exist else false
	 */
	public abstract boolean isFriend(Node query);
	
	/**
	 * To get the list of immediate neighbours of the node
	 * @return The list of the neighbours of the node
	 */
	public abstract List<Node> getNeighbours();
	
	/**
	 * To block the creation of an edge between two nodes
	 * @param node - The node reference with which edge creation is to be blocked
	 * @return - True if the edge creation is blocked else false
	 */
	public abstract boolean blockNode(Node node);
	
	/**
	 * To check if the edge creation to a node is previously blocked or not
	 * @param node - The reference of the node which is to be checked against the edge block condition
	 * @return - True if previously the edge creation is blocked for the node
	 */
	public abstract boolean isBlockedNode(Node node);
}
