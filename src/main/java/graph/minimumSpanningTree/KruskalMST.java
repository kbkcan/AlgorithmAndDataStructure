package graph.minimumSpanningTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import graph.Edge;
import unionFind.DisjointSet;

public class KruskalMST {

	private int mstTotalEdgeWeight = 0; //최소신장비용

	public ArrayList<Edge<Integer>> getMinmumSpanningTree(List<Edge<Integer>> graphEdges, int nodeCount) {

		Collections.sort(graphEdges); //오름차순으로 먼저 정렬한다.
		ArrayList<Edge<Integer>> mstEdges = new ArrayList<Edge<Integer>>(); //최소 신장 트리에 포함된 에지 목록(초기적으로 비어 있음)

		DisjointSet nodeSet = new DisjointSet(nodeCount + 1);
		//그래프의 각 노드에 대해 싱글톤 세트를 초기화
		//(nodeCount +1) 0부터의 배열 인덱싱을 고려함

		for (int i = 0; i < graphEdges.size() && mstEdges.size() < (nodeCount - 1); i++) {
			Edge currentEdge = graphEdges.get(i);
			if (!nodeSet.isConnected((int) currentEdge.getVertex(), (int) currentEdge.getAdjvertex())) {
				mstEdges.add(currentEdge); //그래프에 edge를 더하다
				nodeSet.union((int) currentEdge.getVertex(), (int) currentEdge.getAdjvertex()); //Union 한다
			}
		}

		for (Edge edge : mstEdges) {
			mstTotalEdgeWeight += edge.getWeight();
		}
		return mstEdges;
	}

	public int getMstTotalEdgeWeight() {
		return mstTotalEdgeWeight;
	}

}