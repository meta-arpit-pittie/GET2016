/**
 * Assignment 2
 * Class to represent the customer for a guest house
 * @author Arpit Pittie
 */
package session4;

public class Customer {

	private String name;	//Customer name
	private int age;		//Customer age
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public int hashCode() {
		return age+System.identityHashCode(this);
	}
}
