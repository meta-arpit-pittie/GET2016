/**
 * Assignment 1
 * Class to represent the display menu
 * @author Arpit Pittie
 */
package session5.menu;

import java.util.Scanner;
import session5.*;
import session4.LeafMenuItem;

public class MenuDisplay extends LeafMenuItem{

	private Graph graph;	//The social network on which the operation is to be performed
	
	public MenuDisplay(String name, Graph graph) {
		super(name);
		this.graph = graph;
	}
	
	@Override
	public void actionTaken(Scanner scan) {
		//Displaying the current structure of the social network
		graph.displayGraph();
	}
}
