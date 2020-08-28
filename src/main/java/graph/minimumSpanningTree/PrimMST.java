package graph.minimumSpanningTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import graph.Edge;

public class PrimMST {
	int N;
	List<Edge<Integer>>[] graph;

	public PrimMST(List<Edge<Integer>>[] graph) {
		this.graph = graph;
		N = graph.length;
	}

	public List mst(int start) {
		boolean[] visited = new boolean[N]; //방문된 정점은 true
		int[] D = new int[N]; //시작 정점의 인접정점중에 가장 작은 가중치를 가진 간선의 끝점을 찾기 위한 배열
		int[] previous = new int[N]; //최소신장트리의 간선으로 확정될 때 간선의 다른 쪽

		for (int i = 0; i < N; i++) { //방문안된 정점들의 D 원소들 중에서 최솟값 가진 정점 찾기
			visited[i] = false;
			previous[i] = -1;
			D[i] = Integer.MAX_VALUE;
		}
		previous[start] = 0;
		D[start] = 0;

		for (int k = 0; k < N; k++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				if (!visited[j] && (D[j] < min)) {
					min = D[j];
					minVertex = j;
				}
			}
			visited[minVertex] = true;
			//			System.out.println("minVertex:" + minVertex);
			//			System.out.println("visited:" + Arrays.toString(visited));
			//			System.out.println("D:" + Arrays.toString(D));
			//			System.out.println("previous :" + Arrays.toString(previous));
			for (Edge i : graph[minVertex]) {
				if (!visited[(int) i.getAdjvertex()]) { //트리에 아직 포함 안 된 정점이면
					int currentDist = D[(int) i.getAdjvertex()];
					int newDist = i.getWeight();
					if (newDist < currentDist) {
						D[(int) i.getAdjvertex()] = newDist;
						previous[(int) i.getAdjvertex()] = minVertex;
					}
				}
			}
		}
		return getEdgeArray(previous, D);
	}

	public List<Edge> getEdgeArray(int[] previous, int[] distance) {
		ArrayList<Edge> primEdgeList = new ArrayList(previous.length);
		for (int i = 0; i < previous.length; i++) {
			if (i == previous[i])
				continue;
			Edge e = new Edge(i, previous[i], distance[i]);
			primEdgeList.add(e);
		}
		return primEdgeList;
	}
}
