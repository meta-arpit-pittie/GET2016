/**
 * Assignment 1
 * Class to represent the operators used in the class
 * @author Arpit Pittie
 */
package session1;

import javax.swing.JButton;


public class Operator extends JButton{

	private String operator;	//Operator name
	private String id;	//the button id
	
	public Operator() {
		//Do nothing
	}
	public Operator(String text) {
		//Set Button name
	}
	public int getID() {
		//Returns the ID of the button
		return 1;
	}
	public void setText(String name) {
		//Set name for the button
	}
	public String getText() {
		//returns the text related to the button
		return null;
	}
	public double getResult(double value1, double value2) {
		//Perform the desired operation on the values passed as arguments
		return 0.0;
	}
	private double add(double value1, double value2) {
		//Perform addition
		return 0.0;
	}
	private double subtract(double value1, double value2) {
		//Perform subtraction
		return 0.0;
	}
	private double multiply(double value1, double value2) {
		//Perform multiplication
		return 0.0;
	}
	private double divide(double value1, double value2) {
		//Perform division
		return 0.0;
	}
}
