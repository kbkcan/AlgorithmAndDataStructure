package graph;

import java.util.LinkedList;

import graph.shortestPath.BellmanFordSP;
import graph.shortestPath.DijkstraSP;
import graph.shortestPath.FloydWarshallSP;
import org.junit.Test;

import graph.Edge;

public class ShortestPathTest {

	@Test
	public void DijkstraSPtest() {
		final int VERTEX_NUM = 8;
		LinkedList<Edge<Integer>>[] graph = new LinkedList[VERTEX_NUM];
		for (int i = 0; i < VERTEX_NUM; i++) {
			graph[i] = new LinkedList<Edge<Integer>>();
		}
		graph[0].add(new Edge(0, 1, 1));
		graph[0].add(new Edge(0, 3, 2));
		graph[1].add(new Edge(1, 0, 1));
		graph[1].add(new Edge(1, 3, 3));
		graph[1].add(new Edge(1, 4, 1));
		graph[2].add(new Edge(2, 1, 4));
		graph[2].add(new Edge(2, 6, 1));
		graph[2].add(new Edge(2, 7, 2));
		graph[2].add(new Edge(2, 5, 1));
		graph[3].add(new Edge(3, 0, 2));
		graph[3].add(new Edge(3, 1, 3));
		graph[3].add(new Edge(3, 5, 4));
		graph[4].add(new Edge(4, 3, 5));
		graph[4].add(new Edge(4, 6, 2));
		graph[4].add(new Edge(4, 1, 1));
		graph[5].add(new Edge(5, 1, 6));
		graph[5].add(new Edge(5, 2, 1));
		graph[5].add(new Edge(5, 7, 9));
		graph[6].add(new Edge(6, 7, 1));
		graph[6].add(new Edge(6, 2, 1));
		graph[6].add(new Edge(6, 4, 2));
		graph[7].add(new Edge(7, 6, 1));
		graph[7].add(new Edge(7, 5, 9));
		graph[7].add(new Edge(7, 2, 2));
		DijkstraSP dsp = new DijkstraSP(graph);
		int[] path = dsp.shortestPath(0);
		//System.out.println("path : " + Arrays.toString(path));
	}

	@Test
	public void BellmanFordSP() {
		final int INF = Integer.MAX_VALUE;
		int[][] graphMatrix = { 
				{ 0, 1, INF, 2, INF, INF, INF, INF }, 
				{ INF, 0, 4, -2, 1, 6, INF, INF },
				{ INF, INF, 0, INF, INF, INF, INF, 2 }, 
				{ INF, INF, INF, 0, -1, INF, INF, INF },
				{ INF, INF, INF, INF, 0, INF, 4, INF }, 
				{ INF, 1, INF, INF, INF, 0, INF, INF },
				{ INF, INF, -1, INF, INF, INF, 0, 1 },
				{ INF, INF, INF, INF, INF, 3, INF, 0 } };

		BellmanFordSP sp = new BellmanFordSP(8);
		sp.shortestPath(0, graphMatrix);
	}

	@Test
	public void FloydWarshallSP() {
		final int INF = Short.MAX_VALUE;
		int[][] graphMatrix = { 
				{ 0, 4, 2, 5, INF }, 
				{ INF, 0, 1, INF, 4 },
				{ 1, 3, 0, 1, 2 }, 
				{ -2, INF, INF, 0, 2 },
				{ INF, -3, 3, 1, 0 } };
		FloydWarshallSP sp = new FloydWarshallSP(graphMatrix, 5);
		sp.shortestPath();
		//sp.printDistanceMatrix();
	}
}
