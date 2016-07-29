/**
 * Assignment 1
 * Class to represent the delete profile menu
 * @author Arpit Pittie
 */
package session5.menu;

import java.util.Scanner;
import session5.*;
import session4.LeafMenuItem;

public class MenuDeleteProfile extends LeafMenuItem {

	private Graph graph;	//The social network on which the operation is to be performed
	
	public MenuDeleteProfile(String name, Graph graph) {
		super(name);
		this.graph = graph;
	}
	
	@Override
	public void actionTaken(Scanner scan) {
		String name;
		System.out.println("\nEnter the profile name");
		name = scan.nextLine();
		
		//Deleting the profile and node if the node exist
		if(graph.deleteNode(graph.getNode(name))) {
			System.out.println("Entity deleted successfully");
		} else {
			System.out.println("Node does not exist");
		}
	}
}
