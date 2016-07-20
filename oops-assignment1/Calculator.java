/**
 * Assignment 1
 * Class to combine the other needed class for implementing the calculator
 * It combines all the necessary objects required to make a calculator
 * @author Arpit Pittie
 */
package session1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener{
	
	private Digits[] digit;		//array to represent the digits in the calculator
	private Operator[] operator;	//array to represent the operators in the calculator
	private Layout layout;		//the user interface to interact with user
	private Display display;	//the display screen of the calculator
	
	public Calculator(){
		//do nothing constructor
	}
	
	public Calculator(int digit, int operator) {
		//initialize all the objects
	}
	
	public Digits[] getDigits() {
		//sending the reference for the digits
		return digit;
	}
	
	public void setDigit(Digits digit) {
		//Method to set the digits for the calculator
	}
	
	public Operator[] getOperators() {
		//sending the reference of all the operators
		return operator;
	}
	
	public void setOperator(Operator operator) {
		//Method to set the operator for the calculator
	}
	
	public Display getDisplay() {
		//sending the reference for the display screen
		return display;
	}
	
	public void setDisplay(String text) {
		//Method to set the string to the display area
	}
	public Layout getLayout() {
		//sending the reference for the layout of calculator
		return layout;
	}
	public void setLayout() {
		//setting the layout for the calculator
	}
	
	public double performOperation(double arg0, double arg1, Operator operator) {
		//to perform the function required based on operator selected
		return 0.0;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//logic for action when the buttons are clicked
	}
}
