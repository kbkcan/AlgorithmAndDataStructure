package stateSpaceTree.branchAndBound;

import java.util.LinkedList;

public class KColoring {

	LinkedList[] graph;
	int[] paintedColors;

	enum ColorKind {
		RED, BLACK, GREEN
	}

	public KColoring(LinkedList[] graph) {
		this.graph = graph;
		paintedColors = new int[graph.length];
	}

	public void getHowManyColors(int i) {



	}

	private boolean valid(int i, ColorKind color) {
		// TODO Auto-generated method stub
		return false;
	}
}
