package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

	int N; //그래프의 정점수
	List<IntegerEdge>[] graph;
	private boolean[] visited;
	private LinkedList pathList = new LinkedList<Integer>();

	public BreadthFirstSearch(List<IntegerEdge>[] adjList) {
		N = adjList.length;
		graph = adjList;
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i])
				bfs(i);
		}
	}

	private void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[i] = true;
		q.add(i); //큐에 시작정점 삽입
		while (!q.isEmpty()) {
			int j = q.remove(); //큐에서 정점 j를 가져옴
			pathList.add(j);
			for (IntegerEdge e : graph[j]) {
				if (!visited[e.adjvertex]) {
					visited[e.adjvertex] = true;
					q.add(e.adjvertex);
				}
			}
		}
	}

	public LinkedList getPathList() {
		return pathList;
	}

}
