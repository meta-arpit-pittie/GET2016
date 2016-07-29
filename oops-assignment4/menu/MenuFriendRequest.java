/**
 * Assignment 1
 * Class to represent the Sending Friend Request menu
 * @author Arpit Pittie
 */
package session5.menu;

import java.util.Scanner;
import session5.*;
import session4.LeafMenuItem;

public class MenuFriendRequest extends LeafMenuItem {

	private Graph graph;	//The social network on which the operation is to be performed
	
	public MenuFriendRequest(String name, Graph graph) {
		super(name);
		this.graph = graph;
	}
	
	@Override
	public void actionTaken(Scanner scan) {
		Node requester;
		Node query;
		int choice = 0;
		
		System.out.println("Enter profile name of requester");
		//Checking if the requesting node exist
		if((requester = graph.getNode(scan.nextLine())) == null) {
			System.out.println("No such entity is present");
			return;
		}
		
		System.out.println("Enter the profile name to send a friend request");
		//Checking if the node queried for exist
		if((query = graph.getNode(scan.nextLine())) == null) {
			System.out.println("No such entity is present");
			return;
		}
		
		//Checking if the queried node has already blocked the requester node or not
		if(query.isBlockedNode(requester)) {
			System.out.println(requester.getName()+" is blocked by "+query.getName());
			return;
		}
		
		//Setting up the options to respond to the friend request
		System.out.println("1. Accept");
		System.out.println("2. Reject");
		System.out.println("3. Block");
		
		//Check for a valid input from user
		do {
			try {
				choice = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} while ((choice != 1) && (choice != 2) && (choice !=3));
		
		//Action taken based on user choice
		switch (choice) {
		case 1: 
			//Updating the neighbour list for both the nodes upon accepting
			requester.addNeighbour(query);
			query.addNeighbour(requester);
			System.out.println("Friend request of "+requester.getName()+" is accepted by "+query.getName());
			break;
		case 2:
			//Decline message for the friend request
			System.out.println("Friend request of "+requester.getName()+" is declined by "+query.getName());
			break;
		case 3:
			//Updating the block request by the queried user
			query.blockNode(requester);
			System.out.println(requester.getName()+" is blocked by "+query.getName());
			break;
		default:
			break;
		}
	}
}
