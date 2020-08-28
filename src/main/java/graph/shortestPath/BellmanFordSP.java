package graph.shortestPath;

import java.util.Arrays;

public class BellmanFordSP {

	private int distance[];
	private int previous[];
	private int N;

	public BellmanFordSP(int numOfVertics) {
		N = numOfVertics;
		distance = new int[N];
		previous = new int[N];
	}

	public void shortestPath(int start, int graphMatrix[][]) {
		for (int i = 0; i < N; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[start] = 0;
		previous[start] = 0;

		for (int k = 0; k < N - 1; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (graphMatrix[i][j] != Integer.MAX_VALUE) {
						if (distance[j] > distance[i] + graphMatrix[i][j]) {
							distance[j] = distance[i] + graphMatrix[i][j]; //간선완화
							previous[j] = i;
						}
					}
				}
			}
		}
	
		//System.out.println("distance:" + Arrays.toString(distance));
		//System.out.println("previous" + Arrays.toString(previous));
	}

	public void printPaths(int start) {

	}
}
