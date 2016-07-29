/**
 * Assignment 1
 * Class to read the initial position of the graph from the file
 * @author Arpit Pittie
 */
package session5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadNetwork {

	private Node node;	//To create the nodes in the graph
	
	/**
	 * Method to read the nodes and the attributes in the graph from the file
	 * @param graph - The graph for which the file contains the node information
	 * @param scan - The scanner class object to read the file location
	 * @return The reference for the Graph class object with the nodes in it
	 */
	public Graph readNodes(Graph graph, Scanner scan) {
		String path;	//To store the path of the file
		String[] temp;
		FileReader file;	//To open the file
		BufferedReader reader;	//To read the file
		
		System.out.println("Enter nodes file location");
		path = scan.nextLine();
		
		try {
			file = new FileReader(path);
			reader = new BufferedReader(file);
			
			//Reading the file
			while((path = reader.readLine()) != null) {
				//Splitting the information in the file
				temp = path.split(" ");
				
				//Setting the information contained in the file according to the type of node
				if(temp[2].equalsIgnoreCase("user")) {
					node = new NodeUser(temp[0], temp[1], temp[2]);
				} else {
					node = new NodeOrganisation(temp[0], temp[1], temp[2]);
				}
				//Adding the node created to the graph
				graph.addNode(node);
			}
			
			reader.close();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		return graph;
	}
	
	/**
	 * Method to read the initial edges created in the graph
	 * @param graph - he graph for which the file contains the edge information
	 * @param scan - The scanner class object to read the file location
	 * @return The reference for the Graph class object with the edges in it
	 */
	public Graph readConnections(Graph graph, Scanner scan) {
		String path;	//To store the file path
		String[] temp;
		Node nodeSource;	//To store the source node of edge
		Node nodeDestination;	//To store the destination node of edge
		FileReader file;	//To open the file
		BufferedReader reader;	//To read the file
		
		System.out.println("Enter connections file location");
		path = scan.nextLine();
		
		try {
			file = new FileReader(path);
			reader = new BufferedReader(file);
			
			//Reading the file
			while((path = reader.readLine()) != null) {
				//Splitting the edge information to get the source and destination node information
				temp = path.split("-");
				//Getting the node reference for the given node name
				nodeSource = graph.getNode(temp[0]);
				nodeDestination = graph.getNode(temp[1]);
				
				//Checking if any of the source or destination node does not exist in the graph
				if((nodeSource == null) || (nodeDestination == null)){
					System.out.println("Node does not exist in the graph");
					continue;
				}
				//Adding an edge from the source to destination
				nodeSource.addNeighbour(nodeDestination);
				//Adding an edge from the destination to source
				nodeDestination.addNeighbour(nodeSource);
			}
			
			reader.close();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		return graph;
	}
}
