package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 핵심 아이디어
 * dfs를 수행하면서 사용하는 간선을 스택에 저장하고 뒷 간선의 적절한 활용을 통해 
 * 단절정점을 찾으며 단절 정점을 찾은 직후에 
 * 스택에서 이중연결성분에 속한 간선들을 모두 꺼내어출력한다.
 */
public class BiconnectedComponent {

	/* 
	 * dfs를 수행하면서 각 정점에 방문번호(dfsNum)를 부여한다. 
	 * dfs 수행과정에서 만들어지는 신장트리에서 뒷 간선을 활용하여 가장 작은 dfsNum을 가진 정점에
	 * 도달 여부를 표시하기 위해 lowNum 배열을 사용한다.
	 * */
	int sequence = 1;
	int[] dfsNum;
	int[] lowNum;
	List<Integer>[] graph;
	Stack<String> s;
	ArrayList separatedVertexList;

	public BiconnectedComponent(List<Integer>[] adjList) {
		int N = adjList.length;
		dfsNum = new int[N];
		lowNum = new int[N];
		graph = adjList;
		s = new Stack<String>();
		separatedVertexList = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			dfsNum[i] = 0;
			lowNum[i] = 0;
		}
		biconnected(0, -1); //루트노드와 부모노드
	}

	private void biconnected(int target, int parent) {
		dfsNum[target] = lowNum[target] = sequence++;

		for (int adj : graph[target]) {
			if (adj != parent && dfsNum[adj] < dfsNum[target]) {
				s.push(pair(target, adj));
			}
			if (dfsNum[adj] == 0) {
				biconnected(adj, target);
				lowNum[target] = Math.min(lowNum[target], lowNum[adj]);
				if (lowNum[adj] >= dfsNum[target] && parent != -1) {
					separatedVertexList.add(target);
					while (!s.empty()) {
						s.pop();
						//System.out.print(s.pop() + " ");
					}
					//System.out.println();
				}
			} else if (adj != parent) {
				lowNum[target] = Math.min(lowNum[target], dfsNum[adj]);
			}
		}
	}

	private String pair(int target, int adj) {
		return "( " + target + ", " + adj + " )";
	}

	public ArrayList getSeparatedVertexList() {
		return separatedVertexList;
	}

}
