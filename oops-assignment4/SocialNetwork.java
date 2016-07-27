/**
 * Assignment 1
 * Main class to implement the social network structure
 * @author Arpit Pittie
 */
package session5;

import java.util.Scanner;

import session5.menu.*;
import session4.*;

public class SocialNetwork {

	private Graph graph;	//Graph to store the social network structure
	private Scanner scan;
	private CompositeMenuItem mainMenu;		//To provide the operations in the social network
	private Menu[] menuItems;	//The operations in the social network
	
	public SocialNetwork() {
		graph = new Graph();
		scan = new Scanner(System.in);
		menuItems = new Menu[7];
	}
	
	/**
	 * Method to initialize the social network
	 */
	public void createNetwork() {
		ReadNetwork read = new ReadNetwork();
	
		//Reading the node information
		graph = read.readNodes(graph,scan);
		//Reading the edge information
		graph = read.readConnections(graph, scan);
		//Displaying the initial social network
		graph.displayGraph();
	}
	
	/**
	 * Method to create a menu for the available operations in the social network
	 */
	public void createMenu() {
		//Creating the Menu items
		menuItems[0] = new MenuIsFriend("Is Friend", graph);
		menuItems[1] = new MenuDeleteProfile("Delete Profile", graph);
		menuItems[2] = new MenuEditProfile("Edit Profile", graph);
		menuItems[3] = new MenuFriendRequest("Friend Request", graph);
		menuItems[4] = new MenuMutualFriend("Mutual Friend", graph);
		menuItems[5] = new MenuIsConnection("Is Connection", graph);
		menuItems[6] = new MenuDisplay("Display", graph);
		
		//Adding the menu items
		mainMenu = new CompositeMenuItem("Main Menu", menuItems);
		//Display the main menu
		mainMenu.actionTaken(scan);
		scan.close();
	}
	
	public static void main(String[] args) {
		SocialNetwork network = new SocialNetwork();
		network.createNetwork();
		network.createMenu();
	}
}
