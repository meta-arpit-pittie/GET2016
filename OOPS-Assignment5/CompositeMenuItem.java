/**
 * Assignment 1
 * Class to hold the composite menu items which has menu items having further sub menu
 * @author Arpit Pittie
 */
package session4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompositeMenuItem extends Menu{

	private String menuName;	//Menu name
	private CompositeMenuItem parent;	//Parent menu
	private List<Menu> menu;	//To store all the menu items for a composite menu
	
	public CompositeMenuItem() {
		menu = new ArrayList<Menu>();
	}
	
	public CompositeMenuItem(String name) {
		this.menuName = name;
		menu = new ArrayList<Menu>();
	}
	
	public CompositeMenuItem(String name, Menu[] menuItems) {
		this.menuName = name;
		menu = new ArrayList<Menu>();
		for(int i=0; i < menuItems.length; i++) {
			menu.add(menuItems[i]);
		}
	}
	
	@Override
	public void setMenuItems(Scanner scan, String menuName) {
		int items;		//to store the number of sub menu items in this menu
		String type;	//To get the type of the sub menu item
		String name;	//To get the name of the sub menu item
		Menu menuItem;	//To create the new sub menu
		
		System.out.println("Enter number of menu items in menu "+menuName);
		
		//Getting the number of sub menu
		try {
			items = scan.nextInt();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return;
		} finally {
			scan.nextLine();
		}
		
		//loop to get sub menu items from the user
		for(int i=0; i < items ; i++) {
			System.out.println("Enter menu item name for menu "+menuName);
			name = scan.nextLine();
			System.out.println("Is it a composite menu");
			type = scan.nextLine();
			
			//check if the sub menu item is a composite menu or leaf menu item
			if(type.equalsIgnoreCase("y")) {
				//Composite menu item
				menuItem = new CompositeMenuItem();
				menuItem.setName(name);
				menuItem.setParent(this);
				menuItem.setMenuItems(scan,menuItem.getName());
			} else {
				//Leaf menu item
				menuItem = new LeafMenuItem();
				menuItem.setName(name);
				menuItem.setParent(this);
			}
			
			//Add the sub menu item to the list
			menu.add(menuItem);
		}
		
		//Adding the back option for each composite menu
		menuItem = new LeafMenuItem();
		menuItem.setName("Back");
		menuItem.setParent(this);
		menu.add(menuItem);
		
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
	public void setParent(CompositeMenuItem parent) {
		// TODO Auto-generated method stub
		this.parent = parent;
	}

	@Override
	public CompositeMenuItem getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	@Override
	public void actionTaken(Scanner scan) {
		// TODO Auto-generated method stub
		int choice = 0;		//to get the menu choice from the user
		
		do {
			System.out.println("\n\n"+menuName+"\n");
			//loop to print the menu item list
			for(int i=1; i <= menu.size(); i++) {
				System.out.println(i+". "+menu.get(i-1).getName());
			}
			
			//Getting the menu choice from user
			System.out.println("Enter choice :");
			try {
				choice = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			//check if the menu number input is correct or not
			if((choice < 1) || (choice > menu.size())) {
				continue;
			} else {
				menu.get(choice-1).actionTaken(scan);
			}
			
			//checking for the back condition
			if(choice == menu.size()) {
				return;
			}
		} while(true);
	}

}
