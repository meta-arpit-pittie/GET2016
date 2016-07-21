/**
 * Assignment 2
 * To implement the methods for the matrix operations
 * @author: Arpit Pittie
 */
package session1;


public class Matrix {
	
	private int[][] data;	//Matrix
	private int noRows;		//Matrix rows number
	private int noCols;		//Matrix columns number
	
	/**
	 * Parameterized Constructor
	 * @param row-Number of rows in the matrix
	 * @param col-Number of columns in the matrix
	 */
	public Matrix(int row, int col) {	//Parameterized Constructor
		this.noRows = row;
		this.noCols = col;
		data = new int[row][col];
	}
	
	public int getRow() {
		return noRows;
	}
	
	public int getColumns() {
		return noCols;
	}
	
	/**
	 * Method to add elements to the matrix
	 * @param row - Row number
	 * @param col - Column number
	 * @param val - Value to add
	 * @return true if value is added to the matrix
	 */
	public boolean addElement(int row, int col, int val) {
		try {		//if the rows and columns are out of the permitted value
			data[row][col] = val;
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public int getElement(int row, int col) {
		return data[row][col];
	}
	
	/**
	 * Method to find the transpose of the matrix
	 * @return Object of matrix class having matrix as transpose of calling object matrix
	 */
	public Matrix transpose() {
		Matrix trans = new Matrix(noCols, noRows);
		for(int i=0; i < noRows; i++) {
			for(int j=0; j < noCols; j++) {
				trans.addElement(j, i, data[i][j]);		//logic for transposing
			}
		}
		return trans;
	}
	
	/**
	 * It performs the matrix multiplication
	 * @param second - the second matrix with which the matrix is to be multiplied
	 * @return null if the matrix multiplication is not satisfied else the resultant object of Matrix class
	 */
	public Matrix matrixMultiplication(Matrix second) {
		
		Matrix result;
		int temp;
		
		if(noCols != second.getRow()) {		//checking matrix multiplication condition
			return null;
		}
		
		result = new Matrix(noRows, second.getColumns());
		
		for(int i=0; i < noRows; i++) {
			for(int j=0; j < noCols; j++) {
				temp = 0;
				for(int k=0; k < second.getColumns(); k++) {
					temp += data[i][k] * second.getElement(k, j);	//Matrix multiplication logic
				}
				result.addElement(i, j, temp);
			}
		}
		return result;
	}
	
	/**
	 * Provides the matrix stored
	 * @return The 2D array of integer containing the matrix
	 */
	public int[][] show() {
		return data;
	}
}
