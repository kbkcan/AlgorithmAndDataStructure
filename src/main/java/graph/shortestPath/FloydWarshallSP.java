package graph.shortestPath;

public class FloydWarshallSP {

	private int[][] distanceMatrix;
	private int[][] graphMatrix;
	private int N;

	public FloydWarshallSP(int[][] graphMatrix, int numOfVertics) {
		N = numOfVertics;
		this.distanceMatrix = new int[N][N];
		this.graphMatrix = graphMatrix;
	}

	public int[][] shortestPath() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				distanceMatrix[i][j] = graphMatrix[i][j];
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (distanceMatrix[i][j] > distanceMatrix[i][k] + distanceMatrix[k][j]) {
						distanceMatrix[i][j] = distanceMatrix[i][k] + distanceMatrix[k][j];
					}
				}
			}
		}

		return distanceMatrix;
	}

	public void printDistanceMatrix() {
		for (int i = 0; i < distanceMatrix.length; i++) {
			for (int j = 0; j < distanceMatrix[i].length; j++) {
				System.out.printf("%3d", distanceMatrix[i][j]);
			}
			System.out.println();
		}
	}
}
