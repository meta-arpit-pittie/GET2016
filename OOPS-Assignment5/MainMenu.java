/**
 * Class to create the initial menu
 * @author Arpit Pittie 
 */
package session4;

import java.util.Scanner;

public class MainMenu {

	CompositeMenuItem menu;		//To hold the main menu
	Scanner scan;
	
	public MainMenu(String name) {
		menu = new CompositeMenuItem(name);
		scan = new Scanner(System.in);
		menu.setParent(null);
	}
	
	/**
	 * Method to setup the menu and display the menu
	 */
	public void setUpMenu() {
		menu.setMenuItems(scan,menu.getName());
		menu.actionTaken(scan);
	}
	
	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu("Main");
		mainMenu.setUpMenu();
	}
}
