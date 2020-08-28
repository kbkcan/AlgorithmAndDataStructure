package dinamicProgramming;

public class LongestCommonSegmmentOrder {

	int[][] matrix = null;
	private String str1;
	private String str2;
	private String[][] arrowMatrix;

	public LongestCommonSegmmentOrder(String str1, String str2) {
		this.str1 = " " + str1;
		this.str2 = " " + str2;
		matrix = new int[this.str1.length()][this.str2.length()];
		arrowMatrix = new String[this.str1.length()][this.str2.length()];

	}

	public void getLongestcommonsegementorder() {
		for (int i = 0; i < this.str1.length(); i++) {
			matrix[i][0] = 0;
			arrowMatrix[i][0] = "0";
		}
		for (int j = 0; j < this.str2.length(); j++) {
			matrix[0][j] = 0;
			arrowMatrix[0][j] = "0";
		}
		for (int i = 1; i < this.str1.length(); i++) {
			for (int j = 1; j < this.str2.length(); j++) {
				if (this.str1.charAt(i) == this.str2.charAt(j)) {
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
					arrowMatrix[i][j] = "↖";
				} else {
					if (matrix[i - 1][j] >= matrix[i][j - 1]) {
						matrix[i][j] = matrix[i - 1][j];
						arrowMatrix[i][j] = "↑";
					} else {
						matrix[i][j] = matrix[i][j - 1];
						arrowMatrix[i][j] = "←";
					}
				}
			}
		}
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public String[][] getArrowMatrix() {
		return arrowMatrix;
	}

}
