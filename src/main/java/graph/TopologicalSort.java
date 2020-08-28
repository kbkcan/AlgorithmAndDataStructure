package graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TopologicalSort {

	int N; //그래프의 정점 수
	boolean[] visited; //DFS 수행중 방문여부 체크용
	List<IntegerEdge>[] noneCycleGraph;
	LinkedList<Integer> path;

	public TopologicalSort(List<IntegerEdge>[] adjList) {
		N = adjList.length;
		visited = new boolean[N];
		noneCycleGraph = adjList;
		path = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i])
				dfs(i);
		}
	}

	private void dfs(int i) {
		visited[i] = true;
		for (IntegerEdge e : noneCycleGraph[i]) {
			if (!visited[e.adjvertex]) {
				dfs(e.adjvertex);
			}
		}
		path.addFirst(i);
	}

	public LinkedList<Integer> getPath() {
		return path;
	}

}
