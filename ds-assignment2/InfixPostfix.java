/**
 * Assignment 1
 * Class to convert the infix notation to the postfix notation
 * @author Arpit Pittie
 */
package session2;

import java.util.Scanner;

public class InfixPostfix {

	private Scanner scan;	//To read input from the console
	private String infix;	//The infix notation string
	private String postfix;	//The resultant postfix notation string
	private MyStack<Character> stack;	//The stack to aid in converting infix to postfix
	
	public InfixPostfix() {
		scan = new Scanner(System.in);
		infix = "";
		postfix = "";
		stack = new MyStack<Character>();
	}
	
	/**
	 * Method to get the input from the user
	 */
	public void getInput() {
		String temp;
		//Getting input infix notation
		System.out.println("Enter infix notation");
		infix = scan.nextLine();
		//loop for removing all the special characters from the input string if entered by mistake
		for(int i=0;i<infix.length();i++) {
			//removing the special characters
			if((!Character.isAlphabetic(infix.charAt(i))) && 
					(!Character.isDigit(infix.charAt(i))) &&
					(!isOperator(infix.charAt(i)))) {
				temp="";
				if(i!=0){
					temp = infix.substring(0, i);
				}
				temp = temp + infix.substring(i+1);
				i--;
				infix=temp;
			}
		}
	}
	
	/**
	 * Method to convert the infix string
	 */
	public void convert() {
		char value;
		int preTop;
		int pre;
		stack.push('(');
		//traversing through each variable in the infix notation
		for (int i = 0; i < infix.length(); i++) {
			value = infix.charAt(i);
			switch(value) {
			case '(' :	
			case '^' :
					//They have highest precedence in operators
					stack.push(value);
					break;
			case '*' :
			case '/' :
			case '+' :
			case '-' :
				//Check for the precedence of the stack elements and the character
				pre = precedence(value);
				if(stack.getTop() != 1) {
					preTop = precedence(stack.peek());
					//removing element from stack according to the precedence
					while((pre <= preTop) && (stack.getTop() != 0)) {
						postfix = postfix + stack.pop();
						preTop = precedence(stack.peek());
					}
				}
				stack.push(value);
				break;
			case ')' :
				//removing the element from top for the closing bracket
				value = stack.pop();
				 do{
					postfix = postfix + value;
					value = stack.pop();
					//continue the loop till opening bracket is found
				}while(value != '(');
				 break;
			default :
				//Adding operands to the postfix string
				postfix = postfix + value;
			}
		}
		//Adding all the remaining operators to the postfix result
		value = stack.pop();
		while(value != '(') {
			postfix = postfix + value;
			value = stack.pop();
		}
		System.out.println(postfix);
	}
	
	/**
	 * Method to get the precedence value of the operators
	 * @param c - The operator for which the precedence is to get
	 * @return The precedence value for the operator
	 */
	private int precedence(char c) {
		switch(c) {
		case '^': return 3;
		case '*':
		case '/': return 2;
		case '+':
		case '-': return 1;
		default : return 0;
		}
	}
	
	/**
	 * Method to define the valid operators
	 * @param operator - The operator to be checked if it is a valid operator or not
	 * @return True if the operator is  a valid one else false
	 */
	private boolean isOperator(char operator) {
		if((operator == '+') || (operator == '-') || (operator == '*') ||
				(operator == '/') || (operator == '^') ||
				(operator == '(') || (operator == ')')) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		InfixPostfix inToPost = new InfixPostfix();
		inToPost.getInput();
		inToPost.convert();
	}
}
