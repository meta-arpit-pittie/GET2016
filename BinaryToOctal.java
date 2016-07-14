/*
 * Program to convert Binary to Octal
 * Assumption: Work for Integer type only
 * Author: Arpit Pittie
 */
package Session1;

public class BinaryToOctal {
	
	private int octal=0;
	
	/*
	 * Method to convert binary number to octal number
	 * @param: binary number
	 * @return: octal number if valid input else 0
	 */
	public int convertBinaryToOctal(int number) {
		int decimal=0;
		int power=0;
		boolean result=true;
		String temp="";
		
		result = checkBinaryNumber(number);
		if(result) {	/*Input is valid binary number*/
			//Logic to convert binary to decimal
			while(number != 0) {
				decimal += (number%10) * Math.pow(2, power);
				power ++;
				number /= 10;
			}
			
			//Logic to convert Decimal to Octal
			while(decimal != 0) {
				temp = (decimal % 8) + temp;
				decimal /= 8;
			}
			octal=Integer.parseInt(temp);
		} else {	/*Input is invalid*/
			System.out.print("Not a binary number");
		}
		return octal;
	}
	
	/*
	 * To check number is a valid binary number
	 * @param: binary number to check
	 * @return: whether the number is a valid binary number or not
	 */
	private boolean checkBinaryNumber(int number) {
		
		
		int temp;
		while(number != 0) {
			temp = number % 10;
			if((temp != 0) && (temp != 1))	//condition for a binary number
				return false;
			number /= 10;
		}
		return true;
	}

}
