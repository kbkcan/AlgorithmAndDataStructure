package stateSpaceTree.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;

import graph.Edge;

public class Maze {
	LinkedList<Edge<Integer>>[] graph;
	Edge start;
	Edge end;
	boolean[] visited;
	ArrayList<Edge<Integer>> previous;
	ArrayList<Edge<Integer>> path;

	Maze(LinkedList<Edge<Integer>>[] graph, Edge<Integer> start, Edge<Integer> end) {
		this.graph = graph;
		this.start = start;
		this.end = end;
		int vertexSize = graph.length;
		visited = new boolean[vertexSize];
		previous = new ArrayList<Edge<Integer>>();
		path = new ArrayList<Edge<Integer>>();
	}

	public void hunt(Edge<Integer> e) {
		int vertex = e.getAdjvertex();
		visited[vertex] = true;
		if (e.equals(end)) {
			for (Edge edge : previous) {
				path.add(edge);
			}
		}
		for (Edge<Integer> edge : graph[vertex]) {
			if (visited[edge.getAdjvertex()] == false) {
				previous.add(edge);
				hunt(edge);
			}
		}

	}

	public LinkedList<Edge<Integer>>[] getGraph() {
		return graph;
	}

	public Edge getStart() {
		return start;
	}

	public Edge getEnd() {
		return end;
	}

	public void setGraph(LinkedList<Edge<Integer>>[] graph) {
		this.graph = graph;
	}

	public void setStart(Edge start) {
		this.start = start;
	}

	public void setEnd(Edge end) {
		this.end = end;
	}

	public ArrayList<Edge<Integer>> getPath() {
		return path;
	}

	public void setPath(ArrayList<Edge<Integer>> path) {
		this.path = path;
	}

}
