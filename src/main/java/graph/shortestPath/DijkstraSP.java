package graph.shortestPath;

import java.util.Arrays;
import java.util.List;

import graph.Edge;

public class DijkstraSP {
	public int N; // 그래프의 정점의 수
	List<Edge<Integer>>[] graph;
	public int[] previous; //최단경로상 이전 정점을 기록하기 위해

	public DijkstraSP(List<Edge<Integer>>[] graph) {
		this.graph = graph;
		N = graph.length;
		previous = new int[N];
	}

	public int[] shortestPath(int start) {
		boolean[] visited = new boolean[N];
		int[] distance = new int[N];
		for (int i = 0; i < N; i++) {
			visited[i] = false;
			previous[i] = -1;
			distance[i] = Integer.MAX_VALUE;
		}
		previous[start] = 0;
		distance[start] = 0;
		for (int k = 0; k < N; k++) {
			int minVertex = -1; //
			int min = Integer.MAX_VALUE;
			//방문안된 정점들 중에서 D원소 값이 최소인 minVertex 찾기
			for (int j = 0; j < N; j++) {
				if (!visited[j] && (distance[j] < min)) {
					min = distance[j];
					minVertex = j;
				}
			}

			visited[minVertex] = true;
			for (Edge e : graph[minVertex]) { //minVertex에 인접한 각 정점에 대해
				if (!visited[(Integer) e.getAdjvertex()]) { //아직 방문 안된 정점에 대해
					//간선완화를 한다.
					int currentDist = distance[(Integer) e.getAdjvertex()];
					int newDist = distance[minVertex] + e.getWeight();
					if (newDist < currentDist) {
						distance[(Integer) e.getAdjvertex()] = newDist;
						previous[(Integer) e.getAdjvertex()] = minVertex;
					}
				}
			}
		}

		//System.out.println("visited:" + Arrays.toString(visited));
		//System.out.println("D:" + Arrays.toString(distance));
		//System.out.println("previous :" + Arrays.toString(previous));
		return distance;
	}
}
