/**
 * Assignment 2
 * JUnit Test Case for testing the methods of Matrix class
 * @author Arpit Pittie
 */
package session1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMatrix {

	private static Matrix matrix;
	private static Matrix second;
	private static Matrix result;
	private static int row;
	private static int column;
	
	@Before
	public void setUp() throws Exception {
		row = 3;
		column = 3;
		
		matrix = new Matrix(row, column);
		for(int i=1; i <= row; i++) {
			for(int j=1; j <= column; j++) {
				matrix.addElement(i-1, j-1, (i+j));
			}
		}
		
		second = new Matrix(row, column);
		for(int i=1; i <= row; i++) {
			for(int j=1; j <= column; j++) {
				second.addElement(i-1, j-1, i*j);
			}
		}
	}

	@Test
	public void testAddElement() {
		for(int i=1; i <= row; i++) {
			for(int j=1; j <= column; j++) {
				assertTrue(matrix.addElement(i-1, j-1, i+j));
			}
		}
	}
	
	@Test
	public void testShow() {
		assertArrayEquals(new int[][] {{2,3,4},{3,4,5},{4,5,6}}, matrix.show());
	}
	
	@Test
	public void testTranspose() {
		assertArrayEquals(new int[][] {{2,3,4},{3,4,5},{4,5,6}}, matrix.transpose().show());
	}
	
	@Test
	public void testMatrixMultiplication() {
		result = matrix.matrixMultiplication(second);
		assertArrayEquals(new int[][] {{20,40,60},{26,52,78},{32,64,96}}, result.show());
	}

}
