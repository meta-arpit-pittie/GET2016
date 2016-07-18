/*
 * To Print a Pattern
 * 1 2 3 4 5
 *   1 2 3 4
 *     1 2 3
 *       1 2
 *         1
 * Assumption: Work only for integer number of rows
 * Author: Arpit Pittie
 */
package session2;

public class HalfTrianglePattern {
	
	/*
	 * Method to generate the spaces before the number
	 * @param: row number
	 * @param: total number of rows
	 * @return: String containing the required spaces
	 */
	public String spaces(int row, int n) {
		String space="";	//String to store the spaces
		
		for(int i=1; i<=(n - row); i++) {	//loop to assign the needed spaces
			space = space + " ";
		}
		return space;
	}
	
	/*
	 * Method to generate the number sequence
	 * @param: row number
	 * @return: String containing the required numbers
	 */
	public String numbers(int row) {
		String no="";		//String to store the numbers
		
		for(int i=1; i<=row; i++) {		//Loop to generate the numbers of triangle
			no = no + i;
		}
		return no;
	}
	
	/*
	 * Method to generate the half triangle
	 * @param: total number of rows
	 * @return: array of all rows of the half triangle
	 */
	public String[] print(int n) {
		String[] triangle = new String[n];		//Stores all the rows of the half triangle
		int index = 0;		//index for the rows of half triangle
		
		for(int i=n; i>=1; i--) {		//Loop to generate the half triangle
			triangle[index] = spaces(i,n) + numbers(i);		//concatenating the spaces and numbers
			index++;
		}
		return triangle;
	}
}
