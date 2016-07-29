/**
 * Assignment 1
 * Class to represent the Edit Profile menu
 * @author Arpit Pittie
 */
package session5.menu;

import java.util.Scanner;
import session5.*;
import session4.LeafMenuItem;

public class MenuEditProfile extends LeafMenuItem {

	private Graph graph;	//The social network on which the operation is to be performed
	
	public MenuEditProfile(String name, Graph graph) {
		super(name);
		this.graph = graph;
	}
	
	@Override
	public void actionTaken(Scanner scan) {
		String name;
		Node node;
		
		//Getting the name of the node to edit
		System.out.println("\nEnter the profile name");
		name = scan.nextLine();
		//Getting the node reference based on its name
		node = graph.getNode(name);
		
		//Editing the name attribute for the node
		System.out.println("Enter new name");
		name = scan.nextLine();
		//Updating the profile for node
		node.setName(name);
		
		//Editing the place attribute for the node
		System.out.println("Enter new place");
		name = scan.nextLine();
		//Updating the profile for node
		node.setPlace(name);
		
		System.out.println("Updation successfull");
	}
}
