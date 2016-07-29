/**
 * Assignment 1
 * Abstract class to define methods for each menu
 * @author Arpit Pittie
 */
package session4;

import java.util.Scanner;

public abstract class Menu implements ActionMenu{

	public abstract void setName(String name);
	public abstract String getName();
	public abstract void setParent(CompositeMenuItem parent);
	public abstract CompositeMenuItem getParent();
	/**
	 * Set all the menu items in the given menu
	 * @param scan - Scanner object to take input from user
	 * @param name
	 */
	public abstract void setMenuItems(Scanner scan, String name);
}
