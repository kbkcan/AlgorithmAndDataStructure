package graph;

import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch {

	int N; //그래프의 정점의 수
	List<IntegerEdge>[] graph;
	private boolean[] visited; //DFS 수행중 방문한 정점을 true로 만든다
	private LinkedList pathList = new LinkedList<Integer>();

	public DepthFirstSearch(List<IntegerEdge>[] adjList) {
		N = adjList.length;
		graph = adjList;
		visited = new boolean[N];
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
		pathList.add(i);
		for (IntegerEdge e : graph[i]) {
			if (!visited[e.adjvertex]) {
				dfs(e.adjvertex);
			}
		}
	}

	public LinkedList getPathList() {
		return pathList;
	}
	
	
}
