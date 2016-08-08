/**
 * Assignment 1
 * Class for storing the information regarding the employee
 * @author Arpit Pittie
 */
package session6;

public class Employee implements Comparable<Employee>{

	private String empId;		//ID of the employee
	private String empName;		//Name of the employee
	private String empAddress;	//Address of the employee
	
	public Employee(String id, String name, String address) {
		this.empId = id;
		this.empName = name;
		this.empAddress = address;
	}
	
	public void setId(String id) {
		this.empId = id;
	}
	
	public String getId() {
		return empId;
	}
	
	public void setName(String name) {
		this.empName = name;
	}
	
	public String getName() {
		return empName;
	}
	
	public void setAddress(String address) {
		this.empAddress = address;
	}
	
	public String getAddress() {
		return empAddress;
	}
	
	@Override
	public String toString() {
		return "ID: "+empId+"| Name: "+empName+"| Address: "+empAddress;
	}

	/**
	 * Method to perform the natural ordering based on the employee id
	 */
	@Override
	public int compareTo(Employee o) {
		return empId.compareTo(o.getId());
	}
}
