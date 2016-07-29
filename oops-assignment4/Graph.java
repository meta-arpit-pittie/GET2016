/**
 * Assignment 1
 * Class to implement a graph
 * @author Arpit Pittie
 */
package session5;

import java.util.LinkedList;
import java.util.List;

public class Graph {

	private List<Node> vertices;	//Vertices in the graph
	
	public Graph() {
		vertices = new LinkedList<Node>();
	}
	
	/**
	 * Adding a node or vertex to the graph
	 * @param node - the vertex to be added to the graph
	 * @return True if the node is added to the graph else false
	 */
	public boolean addNode(Node node) {
		//Adding a node
		if(vertices.add(node)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Deleting a node or vertex from the graph
	 * @param node - The node to be deleted from the graph
	 * @return - True if the node exist and is deleted from the graph else false
	 */
	public boolean deleteNode(Node node) {
		//Removing the node from the graph
		if(vertices.remove(node)) {
			//Removing the attributes associated with the nodes
			node.removeProfile();
			//Removing the references of the node from the edges of other nodes
			for(Node n: vertices) {
				n.removeNeighbour(node);
			}
			node = null;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Method to get the reference of the node in the graph with the help of the name of the node
	 * @param name - The name associated with the node
	 * @return Reference of first node having the name associated with it else returns null
	 */
	public Node getNode(String name) {
		for(int i=0; i < vertices.size(); i++) {
			//Checking if the name is associated with the node
			if(vertices.get(i).getName().equalsIgnoreCase(name)) {
				return vertices.get(i);
			}
		}
		
		return null;
	}
	
	/**
	 * Method to display the graph structure
	 */
	public void displayGraph() {
		System.out.println("Entity\tFriends\t\tPlace\tType");
		
		for(int i=0; i < vertices.size(); i++) {
			//Printing each node
			System.out.print(vertices.get(i).getName()+"\t");
			//Printing the neighbour of the vertices
			vertices.get(i).displayNeighbour();
			//Printing the place attribute of the node
			System.out.print("\t"+vertices.get(i).getPlace());
			//Printing the type of the node
			System.out.println("\t"+vertices.get(i).getType());
		}
	}
	
}
