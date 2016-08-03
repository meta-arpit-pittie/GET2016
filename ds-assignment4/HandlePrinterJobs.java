/**
 * Assignment 1
 * Class to realize the printer job scheduling based on their priorities
 * @author Arpit Pittie
 */
package session4;

import java.util.Scanner;

public class HandlePrinterJobs {

	private CompositeMenuItem mainMenu;		//To provide the operations in the handling of printer
	private Menu[] menuItems;	//The operations for printer handling
	private static final int MENU_ITEMS = 2;	//The number of menu items
	
	/**
	 * Method to create the menu for the printer
	 */
	public void createMenu() {
		//Adding items to the print menu
		menuItems = new Menu[MENU_ITEMS];
		menuItems[0] = new Jobs("Add a new job");
		menuItems[1] = new Printer("Print the job");
		
		mainMenu = new CompositeMenuItem("Print Menu", menuItems);
		//Open the print menu
		mainMenu.actionTaken(new Scanner(System.in));
	}
	
	public static void main(String[] args) {
		HandlePrinterJobs hpj = new HandlePrinterJobs();
		hpj.createMenu();
	}
}
