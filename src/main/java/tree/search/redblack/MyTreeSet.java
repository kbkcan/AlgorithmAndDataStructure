package tree.search.redblack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import tree.search.binarySearch.TreeMapNode;

public class MyTreeSet<Key extends Comparable<Key>, Value> {

	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private RedBlackTreeNode root;

	private boolean isEmpty() {
		return root == null;
	}

	private boolean isRed(RedBlackTreeNode node) {
		if (node == null)
			return false;
		return node.isRedColor();
	}

	public Value get(Key key) {
		return get(root, key);
	}

	//탐색연산
	public Value get(TreeMapNode node, Key key) {
		if (node == null)
			return null;

		int t = node.getKey().compareTo(key); //키를 비교 
		if (t > 0) {
			return get(node.getLeft(), key);
		} else if (t < 0) {
			return get(node.getRight(), key);
		} else {
			return (Value) node.getValue();
		}
	}

	//노드의 오른쪽 레드 link를 왼쪽으로 옮기는 연산
	private RedBlackTreeNode rotateLeft(RedBlackTreeNode node) {
		RedBlackTreeNode target = (RedBlackTreeNode) node.getRight();
		node.setRight(target.getLeft());
		target.setLeft(node);
		target.setRedColor(node.isRedColor());
		node.setRedColor(RED);
		return target;
	}

	//노드의 왼쪽 레드 link를 오른쪽으로 옮기는 연산
	private RedBlackTreeNode rotateRight(RedBlackTreeNode node) {
		RedBlackTreeNode target = (RedBlackTreeNode) node.getLeft();
		node.setLeft(target.getRight());
		target.setRight(node);
		target.setRedColor(node.isRedColor());
		node.setRedColor(RED);
		return target;
	}

	//노드의 두 link의 색이 같을 때, 둘 다 다른 색으로 바꾸는 연산
	private void flipColor(RedBlackTreeNode node) {
		node.setRedColor(!node.isRedColor());
		RedBlackTreeNode left = (RedBlackTreeNode) node.getLeft();
		RedBlackTreeNode right = (RedBlackTreeNode) node.getRight();
		left.setRedColor(!left.isRedColor());
		right.setRedColor(!right.isRedColor());
	}

	public void put(Key key, Value value) {
		root = put(root, key, value);
		root.setRedColor(BLACK);
	}

	private RedBlackTreeNode put(RedBlackTreeNode node, Key key, Value value) {

		if (node == null)
			return new RedBlackTreeNode(key, value, RED);

		int t = key.compareTo((Key) node.getKey());
		if (t < 0) {
			node.setLeft(put((RedBlackTreeNode) node.getLeft(), key, value));
		} else if (t > 0) {
			node.setRight(put((RedBlackTreeNode) node.getRight(), key, value));
		} else {
			node.setValue(value);
		}

		if (leftBlackRightRed(node))
			node = rotateLeft(node);
		if (doubleLeftRed(node))
			node = rotateRight(node);
		if (leftRightBothRed(node)) {
			flipColor(node);
		}
		return node;
	}

	private boolean leftRightBothRed(RedBlackTreeNode node) {
		return isRed((RedBlackTreeNode) node.getLeft()) && isRed((RedBlackTreeNode) node.getRight());
	}

	private boolean doubleLeftRed(RedBlackTreeNode node) {
		return isRed((RedBlackTreeNode) node.getLeft()) && isRed((RedBlackTreeNode) node.getLeft().getLeft());
	}

	private boolean leftBlackRightRed(RedBlackTreeNode node) {
		return !isRed((RedBlackTreeNode) node.getLeft()) && isRed((RedBlackTreeNode) node.getRight());
	}

	/*
	 *  최솟값 삭제연산
	 *  루트노드로부터 삭제하는 노드 방향으로 레드 link를 옮기어 궁극적으로 삭제되는 노드를 레드로 만든 후 에 삭제한다.
	 */

	private RedBlackTreeNode moveRedLeft(RedBlackTreeNode node) {
		flipColor(node);
		if (isRed((RedBlackTreeNode) node.getRight().getLeft())) {
			RedBlackTreeNode target = rotateRight(node);
			node.setRight(target);
			node = rotateLeft(node);
			flipColor(node);
		}
		return node;
	}

	public void deleteMin() {
		root = deleteMin(root);
		root.setRedColor(BLACK);
	}

	private RedBlackTreeNode deleteMin(RedBlackTreeNode node) {
		if (node.getLeft() == null)
			return null;
		if (!doubleLeftRed(node))
			node = moveRedLeft(node);
		node.setLeft(deleteMin((RedBlackTreeNode) node.getLeft()));
		return fixUp(node);
	}

	private RedBlackTreeNode fixUp(RedBlackTreeNode node) {
		if (isRed((RedBlackTreeNode) node.getRight()))
			node = rotateLeft(node);
		if (doubleLeftRed(node))
			node = rotateRight(node);
		if (leftRightBothRed(node))
			flipColor(node);
		return node;
	}

	public ArrayList<RedBlackTreeNode> levelorder() {

		ArrayList<RedBlackTreeNode> nodeList = new ArrayList();

		Queue<RedBlackTreeNode> q = new LinkedList<RedBlackTreeNode>();
		RedBlackTreeNode target = null;
		q.add(root);
		while (!q.isEmpty()) {
			target = q.remove();
			nodeList.add(target);
			if (target.getLeft() != null)
				q.add((RedBlackTreeNode) target.getLeft());
			if (target.getRight() != null)
				q.add((RedBlackTreeNode) target.getRight());
		}
		return nodeList;
	}
}
