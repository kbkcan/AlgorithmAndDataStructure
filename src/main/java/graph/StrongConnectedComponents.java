package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StrongConnectedComponents {

	int N;
	private List<IntegerEdge>[] graph;
	private List<IntegerEdge>[] reverseGraph;
	LinkedList<Integer> topologicalPath;
	ArrayList<Integer> scc;
	private boolean[] visited;

	public StrongConnectedComponents(List<IntegerEdge>[] graph) {
		N = graph.length;
		this.graph = graph;
		reverseGraph = new LinkedList[N];
		topologicalPath = new LinkedList<Integer>();
		scc = new ArrayList<Integer>();
		visitedInitFalse();

		for (int i = 0; i < N; i++) {
			reverseGraph[i] = new LinkedList<IntegerEdge>();
		}
		for (int i = 0; i < graph.length; i++) {
			for (IntegerEdge e : graph[i]) {
				reverseGraph[e.adjvertex].add(new IntegerEdge(i));
			}
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}

	private void visitedInitFalse() {
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			visited[i] = false;
		}
	}

	private void dfs(int i) {
		visited[i] = true;
		for (IntegerEdge e : graph[i]) {
			if (!visited[e.adjvertex]) {
				dfs(e.adjvertex);
			}
		}
		topologicalPath.addFirst(i);
	}

	public ArrayList<ArrayList<Integer>> findStrongConnectedComponents() {
		ArrayList<ArrayList<Integer>> sccArray = new ArrayList<ArrayList<Integer>>();
		visitedInitFalse();
		for (int i = 0; i < topologicalPath.size(); i++) {
			reverseGraphDfs(topologicalPath.get(i));
			if (!scc.isEmpty()) {
				scc.add(topologicalPath.get(i));
				ArrayList tmp = new ArrayList();
				for (int j = 0; j < scc.size(); j++) {
					tmp.add(scc.get(j));
				}
				sccArray.add(tmp);
				scc.clear();
			}
		}
		return sccArray;
	}

	private void reverseGraphDfs(int j) {
		visited[j] = true;
		for (IntegerEdge e : reverseGraph[j]) {
			if (!visited[e.adjvertex]) {
				reverseGraphDfs(e.adjvertex);
				scc.add(e.adjvertex);
			}
		}
	}

	public LinkedList<Integer> getTopologicalPath() {
		return topologicalPath;
	}

}
