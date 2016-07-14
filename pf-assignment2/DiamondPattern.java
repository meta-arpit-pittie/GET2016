/*
 * To Print a Pattern
 *         1
 *       1 2 1
 *     1 2 3 2 1
 *   1 2 3 4 3 2 1
 * 1 2 3 4 5 4 3 2 1
 *   1 2 3 4 3 2 1
 *     1 2 3 2 1
 *       1 2 1
 *         1
 * Assumption: Work only for integer number of rows
 * Author: Arpit Pittie
 */
package session2;

public class DiamondPattern {
		
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
		String no="";	//String to store the numbers
		
		for(int i=1; i<=row; i++) {		//Loop to generate the first half of the numbers
			no = no + i;
		}
		
		for(int i=row-1; i>=1; i--) {	//Loop to generate the other half of the numbers
			no = no + i;
		}
		return no;
	}
	
	/*
	 * Method to generate the diamond
	 * @param: total number of rows
	 * @return: array of all rows of the diamond
	 */
	public String[] print(int n) {
		String[] diamond = new String[(n * 2) - 1];		//Stores all the rows of the diamond
		int index = 0;		//index for the rows of diamond
		
		for(int i=1; i<=n; i++) {		//Loop to generate the first half of the diamond
			diamond[index] = spaces(i,n) + numbers(i);		//concatenating the spaces and numbers
			index++;
		}
		
		for(int i=n-1; i>=1; i--) {		//Loop to generate the other half of the diamond
			diamond[index] = spaces(i,n) + numbers(i);		//concatenating the spaces and numbers
			index++;
		}
		return diamond;
	}
}
