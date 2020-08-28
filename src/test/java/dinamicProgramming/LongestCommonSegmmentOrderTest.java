package dinamicProgramming;

import org.junit.Test;

public class LongestCommonSegmmentOrderTest {

	@Test
	public void test() {
		LongestCommonSegmmentOrder lcs = new LongestCommonSegmmentOrder("abcdab", "bcdb");
		//LongestCommonSegmmentOrder lcs = new LongestCommonSegmmentOrder("10111010100", "00111010110");
		lcs.getLongestcommonsegementorder();
		System.out.println("matrix");
		printPath(lcs.getMatrix());
		System.out.println("arrow");
		printPath(lcs.getArrowMatrix());
	}

	void printPath(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%3d", matrix[i][j]);
			}
			System.out.println();
		}
	}

	void printPath(String[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print("  " + matrix[i][j]);
			}
			System.out.println();
		}
	}

}
