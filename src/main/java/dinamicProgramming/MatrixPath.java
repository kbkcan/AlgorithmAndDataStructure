package dinamicProgramming;

public class MatrixPath {
	int maxScore[][];
	int matrix[][];
	String directions[][];

	public MatrixPath(int[][] matrix) {
		this.matrix = matrix;
		for (int i = 0; i < matrix.length; i++) {
			maxScore = new int[matrix.length][matrix[i].length];
			directions = new String[matrix.length][matrix[i].length];
		}
	}

	public void getLargestPath() {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (i == 0 && j == 0) {
					maxScore[i][j] = matrix[i][j];
					directions[i][j] = "-";
				} else if (j == 0) {
					maxScore[i][j] = maxScore[i - 1][j] + matrix[i][j];
					directions[i][j] = "↑";
				} else if (i == 0) {
					maxScore[i][j] = maxScore[i][j - 1] + matrix[i][j];
					directions[i][j] = "←";
				} else {
					if (maxScore[i - 1][j] > maxScore[i][j - 1]) {
						maxScore[i][j] = matrix[i][j] + maxScore[i - 1][j];
						directions[i][j] = "←";
					} else {
						maxScore[i][j] = matrix[i][j] + maxScore[i][j - 1];
						directions[i][j] = "↑";
					}
				}
			}
		}
	}

	public int[][] getMaxScore() {
		return maxScore;
	}

	public String[][] getDirections() {
		return directions;
	}

}
