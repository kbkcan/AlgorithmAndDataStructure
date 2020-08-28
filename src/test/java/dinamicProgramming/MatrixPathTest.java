package dinamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixPathTest {

	@Test
	public void test() {
		int matrix[][] = {
				{6,7,12,5},
				{5,3,11,18},
				{7,17,3,3},
				{8,10,14,9}
		};
		MatrixPath mp = new MatrixPath(matrix);
		System.out.println("matrix");
		printPath(matrix);
		
		mp.getLargestPath();
		System.out.println("maxScore");
		printPath(mp.getMaxScore());
		
		System.out.println("directions");
		printPath(mp.getDirections());
		
	}
	
	public void printPath(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.printf("%4d", array[i][j]);
			}
			System.out.println();
		}
	}
	public void printPath(String[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.printf("  "+array[i][j]+" ");
			}
			System.out.println();
		}
	}
}
