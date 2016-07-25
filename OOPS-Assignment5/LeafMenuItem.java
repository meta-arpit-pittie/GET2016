/**
 * Assignment 1
 * Class to hold the leaf menu items having no further menu items
 * @author Arpit Pittie
 */
package session4;

import java.util.Scanner;

public class LeafMenuItem extends Menu{
	
	private String menuName;	//Menu name
	private CompositeMenuItem parent;	//Parent menu
	
	public LeafMenuItem() {
		//Do nothing constructor
	}
	
	public LeafMenuItem(String name) {
		this.menuName = name;
	}

	@Override
	public void setParent(CompositeMenuItem parent) {
		this.parent = parent;
	}
	
	@Override
	public CompositeMenuItem getParent() {
		return parent;
	}
	
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.menuName = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return menuName;
	}

	@Override
	public void setMenuItems(Scanner scan, String name) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionTaken(Scanner scan) {
		// TODO Auto-generated method stub
		if((!menuName.equalsIgnoreCase("back")) && (!menuName.equalsIgnoreCase("exit"))) {
			System.out.println("You have chosen "+parent.getName()+" -> "+menuName);
		}
	}

}
