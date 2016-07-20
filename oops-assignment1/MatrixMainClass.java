/**
 * Assignment 2
 * Main class to execute and print the result for the Matrix class
 * @author Arpit Pittie
 */
package session1;

import java.util.Scanner;

public class MatrixMainClass {
	
	public static void main(String[] args) {
		int rows = 4;
		int cols = 3;
		int[][] data;
		Matrix first = new Matrix(cols, rows);
		Matrix second = new Matrix(rows, cols);
		Matrix result;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 12 values for matrix 1");
		
		for(int i=0; i < cols; i++) {
			for(int j=0; j < rows; j++) {
				first.addElement(i, j, scan.nextInt());
			}
		}
		
		System.out.println("The first matrix is");
		data = first.show();
		for(int i=0; i < first.getRow(); i++) {
			for(int j=0; j < first.getColumns(); j++) {
				System.out.print(data[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("The transpose of first matrix is");
		result = first.transpose();
		data = result.show();
		for(int i=0; i < result.getRow(); i++) {
			for(int j=0; j < result.getColumns(); j++) {
				System.out.print(data[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("Enter 12 values for matrix 2");
		for(int i=0; i < rows; i++) {
			for(int j=0; j < cols; j++) {
				second.addElement(i, j, scan.nextInt());
			}
		}
		
		System.out.println("The matrix mutiplication is");
		result = first.matrixMultiplication(second);
		data = result.show();
		for(int i=0; i < result.getRow(); i++) {
			for(int j=0; j < result.getColumns(); j++) {
				System.out.print(data[i][j]+"\t");
			}
			System.out.println();
		}
		scan.close();
	}
}
