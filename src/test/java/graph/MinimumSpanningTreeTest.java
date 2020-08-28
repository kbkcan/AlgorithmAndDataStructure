package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import graph.minimumSpanningTree.KruskalMST;
import graph.minimumSpanningTree.PrimMST;
import org.junit.BeforeClass;
import org.junit.Test;

import graph.Edge;

public class MinimumSpanningTreeTest {

	@Test
	public void KruskalMSTtest() {
		ArrayList<Edge<Integer>> graphEdges = new ArrayList<Edge<Integer>>(); //edge list, not adjacency list
		graphEdges.add(new Edge(4, 6, 1));
		graphEdges.add(new Edge(2, 5, 2));
		graphEdges.add(new Edge(1, 6, 3));
		graphEdges.add(new Edge(3, 5, 4));
		graphEdges.add(new Edge(1, 4, 5));
		graphEdges.add(new Edge(5, 6, 6));
		graphEdges.add(new Edge(3, 6, 8));
		graphEdges.add(new Edge(0, 1, 9));
		graphEdges.add(new Edge(2, 3, 9));
		graphEdges.add(new Edge(0, 2, 10));
		graphEdges.add(new Edge(1, 3, 10));
		int nodeCount = 7;

		KruskalMST kruskal = new KruskalMST();
		ArrayList<Edge<Integer>> mstEdge = kruskal.getMinmumSpanningTree(graphEdges, nodeCount);
		for (Edge e : mstEdge) {
			System.out.println(e);
		}
	}

	@Test
	public void PrimTest() {
		int VERTEX_NUM = 7;
		List<Edge<Integer>>[] adjList = new LinkedList[VERTEX_NUM];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new LinkedList<Edge<Integer>>();
		}
		adjList[0].add(new Edge(0, 2, 10));
		adjList[0].add(new Edge(0, 1, 9));
		adjList[1].add(new Edge(1, 0, 9));
		adjList[1].add(new Edge(1, 4, 5));
		adjList[1].add(new Edge(1, 6, 3));
		adjList[1].add(new Edge(1, 3, 10));
		adjList[2].add(new Edge(2, 0, 10));
		adjList[2].add(new Edge(2, 4, 7));
		adjList[2].add(new Edge(2, 5, 2));
		adjList[2].add(new Edge(2, 3, 9));
		adjList[3].add(new Edge(3, 1, 10));
		adjList[3].add(new Edge(3, 6, 8));
		adjList[3].add(new Edge(3, 5, 4));
		adjList[3].add(new Edge(3, 2, 9));
		adjList[4].add(new Edge(4, 1, 5));
		adjList[4].add(new Edge(4, 6, 1));
		adjList[4].add(new Edge(4, 2, 7));
		adjList[5].add(new Edge(5, 2, 2));
		adjList[5].add(new Edge(5, 3, 4));
		adjList[5].add(new Edge(5, 6, 6));
		adjList[6].add(new Edge(6, 5, 6));
		adjList[6].add(new Edge(6, 3, 8));
		adjList[6].add(new Edge(6, 1, 3));
		adjList[6].add(new Edge(6, 4, 1));

		PrimMST prim = new PrimMST(adjList);
		List<Edge> list = prim.mst(0);
	}

}
