package graph;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class GraphTest {

	static List<IntegerEdge>[] adjList;
	static List<IntegerEdge>[] adjList2;
	static LinkedList<Integer> dfsPath = new LinkedList<Integer>();
	static LinkedList<Integer> bfsPath = new LinkedList<Integer>();
	static LinkedList<Integer>[] adjList3;

	@BeforeClass
	public static void before() {
		final int VERTEX_NUM = 10;
		final int VERTEX_NUM2 = 9;
		final int VERTEX_NUM3 = 7;
		adjList = new LinkedList[VERTEX_NUM];
		adjList2 = new LinkedList[VERTEX_NUM2];
		adjList3 = new LinkedList[VERTEX_NUM3];
		for (int i = 0; i < VERTEX_NUM; i++) {
			adjList[i] = new LinkedList();
		}
		for (int j = 0; j < VERTEX_NUM2; j++) {
			adjList2[j] = new LinkedList();
		}

		for (int i = 0; i < VERTEX_NUM3; i++) {
			adjList3[i] = new LinkedList();
		}

		adjList[0].add(new IntegerEdge(2));
		adjList[0].add(new IntegerEdge(1));
		adjList[1].add(new IntegerEdge(0));
		adjList[1].add(new IntegerEdge(3));
		adjList[2].add(new IntegerEdge(0));
		adjList[2].add(new IntegerEdge(3));
		adjList[3].add(new IntegerEdge(9));
		adjList[3].add(new IntegerEdge(8));
		adjList[3].add(new IntegerEdge(1));
		adjList[4].add(new IntegerEdge(5));
		adjList[5].add(new IntegerEdge(4));
		adjList[5].add(new IntegerEdge(7));
		adjList[5].add(new IntegerEdge(6));
		adjList[6].add(new IntegerEdge(5));
		adjList[6].add(new IntegerEdge(7));
		adjList[7].add(new IntegerEdge(5));
		adjList[7].add(new IntegerEdge(6));

		dfsPath.add(0);
		dfsPath.add(2);
		dfsPath.add(3);
		dfsPath.add(9);
		dfsPath.add(8);
		dfsPath.add(1);
		dfsPath.add(4);
		dfsPath.add(5);
		dfsPath.add(7);
		dfsPath.add(6);

		bfsPath.add(0);
		bfsPath.add(2);
		bfsPath.add(1);
		bfsPath.add(3);
		bfsPath.add(9);
		bfsPath.add(8);
		bfsPath.add(4);
		bfsPath.add(5);
		bfsPath.add(7);
		bfsPath.add(6);

		adjList2[2].add(new IntegerEdge(1));
		adjList2[2].add(new IntegerEdge(0));
		adjList2[0].add(new IntegerEdge(1));
		adjList2[1].add(new IntegerEdge(4));
		adjList2[1].add(new IntegerEdge(3));
		adjList2[3].add(new IntegerEdge(6));
		adjList2[4].add(new IntegerEdge(5));
		adjList2[5].add(new IntegerEdge(3));
		adjList2[5].add(new IntegerEdge(7));
		adjList2[6].add(new IntegerEdge(7));
		adjList2[7].add(new IntegerEdge(8));

		adjList3[0].add(3);
		adjList3[0].add(1);
		adjList3[0].add(2);
		adjList3[1].add(2);
		adjList3[1].add(0);
		adjList3[2].add(1);
		adjList3[2].add(3);
		adjList3[2].add(0);
		adjList3[3].add(0);
		adjList3[3].add(2);
		adjList3[3].add(5);
		adjList3[4].add(5);
		adjList3[4].add(6);
		adjList3[5].add(3);
		adjList3[5].add(4);
		adjList3[5].add(6);
		adjList3[6].add(4);
		adjList3[6].add(5);

	}

	@Test
	public void DFStest() {
		DepthFirstSearch dfs = new DepthFirstSearch(adjList);
		LinkedList pathList = dfs.getPathList();
		assertEquals(pathList.toString(), dfsPath.toString());
	}

	@Test
	public void BFStest() {
		BreadthFirstSearch bfs = new BreadthFirstSearch(adjList);
		LinkedList pathList = bfs.getPathList();
		assertEquals(pathList.toString(), bfsPath.toString());
	}

	@Test
	public void TopologicalSort() {
		TopologicalSort tps = new TopologicalSort(adjList2);
		LinkedList pathList = tps.getPath();
		LinkedList pathList2 = new LinkedList<Integer>();
		assertEquals(pathList.toString(), "[2, 0, 1, 4, 5, 3, 6, 7, 8]");

	}

	@Test
	public void BiconnectedComponent() {
		BiconnectedComponent bc = new BiconnectedComponent(adjList3);
		ArrayList separatedVertexList = bc.getSeparatedVertexList();
		assertEquals(separatedVertexList.toString(), "[5, 3]");
	}

	@Test
	public void StrongConnectedComponent() {
		List<IntegerEdge>[] graph = new LinkedList[9];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new LinkedList<IntegerEdge>();
		}
		graph[0].add(new IntegerEdge(7));
		graph[1].add(new IntegerEdge(8));
		graph[2].add(new IntegerEdge(5));
		graph[3].add(new IntegerEdge(4));
		graph[3].add(new IntegerEdge(8));
		graph[3].add(new IntegerEdge(1));
		graph[4].add(new IntegerEdge(2));
		graph[4].add(new IntegerEdge(5));
		graph[5].add(new IntegerEdge(3));
		graph[6].add(new IntegerEdge(0));
		graph[6].add(new IntegerEdge(4));
		graph[7].add(new IntegerEdge(2));
		graph[7].add(new IntegerEdge(6));
		graph[8].add(new IntegerEdge(1));
		StrongConnectedComponents scc =new StrongConnectedComponents(graph);
		//System.out.println(scc.getTopologicalPath().toString());
		ArrayList<ArrayList<Integer>> sccArray =  scc.findStrongConnectedComponents();
		//System.out.println(sccArray.toString());
	}
}
