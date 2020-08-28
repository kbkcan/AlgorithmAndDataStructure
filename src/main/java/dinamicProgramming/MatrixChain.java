package dinamicProgramming;

public class MatrixChain {
	int[][] multiplyMinResult;
	int[] matrixRowColumnArray;

	public MatrixChain(int[] matrixRowColumnArray) {
		this.matrixRowColumnArray = matrixRowColumnArray;
		multiplyMinResult = new int[matrixRowColumnArray.length][matrixRowColumnArray.length];
	}

	public int getMinMultiplyCount() {
		int n = matrixRowColumnArray.length - 1;
		for (int i = 0; i < n; i++) {
			multiplyMinResult[i][i] = 0;
		}
		//행렬 대각선행 순서로 진행 
		for (int r = 1; r <= n - 1; r++) {
			for (int i = 1; i <= n - r; i++) { //대각선에 있는 항목수
				int j = i + r; //대각선열 인덱스
				multiplyMinResult[i][j] = multiplyMinResult[i + 1][j] + matrixRowColumnArray[i - 1] * matrixRowColumnArray[i] * matrixRowColumnArray[j];
				for (int k = i + 1; k <= j - 1; k++) {
					if (multiplyMinResult[i][j] > multiplyMinResult[i][k] + multiplyMinResult[k + 1][j] + matrixRowColumnArray[i - 1] * matrixRowColumnArray[k] * matrixRowColumnArray[j]) {
						multiplyMinResult[i][j] = multiplyMinResult[i][k] + multiplyMinResult[k + 1][j] + matrixRowColumnArray[i - 1] * matrixRowColumnArray[k] * matrixRowColumnArray[j];
					}
				}
			}
		}
		return multiplyMinResult[1][n];
	}
}
