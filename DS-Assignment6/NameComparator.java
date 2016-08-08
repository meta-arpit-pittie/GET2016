/**
 * Assignment 1
 * Class to perform the sorting based on the name of the employee
 * @author Arpit Pittie
 */
package session6;

import java.util.Comparator;

public class NameComparator implements Comparator<Employee> {

	/**
	 * Method to perform the sorting based on the employee name
	 */
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}
