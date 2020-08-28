package tree.search.redblack;

import tree.search.binarySearch.TreeMapNode;

public class RedBlackTreeNode<Key extends Comparable<Key>, Value> extends TreeMapNode {

	private boolean redColor; //부모노드 link의 색

	public RedBlackTreeNode(Key key, Value value, boolean redColor) {
		this.key = key;
		this.value = value;
		this.redColor = redColor;
		left = right = null;
	}

	public boolean isRedColor() {
		return redColor;
	}

	public void setRedColor(boolean redColor) {
		this.redColor = redColor;
	}

	@Override
	public String toString() {
		String redOrBlack = redColor == true ? "RED" : "BLACK";
		return "RedBlackTreeNode [redColor=" + redOrBlack + ", key=" + key + ", value=" + value + "]";
	}

}