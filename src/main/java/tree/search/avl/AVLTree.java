package tree.search.avl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import tree.search.binarySearch.TreeMapNode;

public class AVLTree<Key extends Comparable<Key>, Value> {

	private TreeMapNode root;

	public TreeMapNode getRoot() {
		return root;
	}

	public AVLTree(Key newId, Value newName) {
		root = new TreeMapNode(newId, newName, 1);
	}

	//탐색 메소드
	public Value get(Key k) {
		return get(root, k);
	}

	public Value get(TreeMapNode n, Key k) {
		//k를 발견하지 못함
		if (n == null)
			return null;

		int t = n.getKey().compareTo(k);
		if (t > 0)
			return get(n.getLeft(), k);
		else if (t < 0) {
			return get(n.getRight(), k);
		} else {
			return (Value) n.getValue();
		}
	}

	//삽입 메소드
	public void put(Key k, Value v) {
		root = put(root, k, v);
	}

	public TreeMapNode put(TreeMapNode node, Key key, Value value) {
		if (node == null)
			return new TreeMapNode(key, value, 1);

		int t = node.getKey().compareTo(key);
		if (t > 0) {
			node.setLeft(put(node.getLeft(), key, value));
		} else if (t < 0) {
			node.setRight(put(node.getRight(), key, value));
		} else {
			node.setValue(value);
		}
		node.setHeight(fixHeight(node));
		return balance(node);
	}

	private TreeMapNode balance(TreeMapNode node) {//불균형처리
		if (getHeightDifference(node) > 1) { //노드 n의 왼쪽 서브트리가 높아서 불균형 발생
			if (getHeightDifference(node.getLeft()) < 0) { // 노드 왼쪽 자식노드의 오른쪽 서브트리가 높은 경우
				node.setLeft(rotateLeft(node.getLeft())); //Left 회전
			}
			node = rotateRight(node); //Right회전
		} else if (getHeightDifference(node) < -1) { //노드 n의 오른쪽 서브트리가 높아서 불균형 발생
			if (getHeightDifference(node.getRight()) > 0) { // 노드 n의 오른쪽 자식노드의 왼쪽 서브트리가 높은 경우
				node.setRight(rotateRight(node.getRight())); //right 회전
			}
			node = rotateLeft(node); //Left 회전
		}
		return node;
	}

	private int getHeightDifference(TreeMapNode node) {
		if (node == null)
			return 0;
		if (node.getLeft() != null && node.getRight() != null) {
			return node.getLeft().getHeight() - node.getRight().getHeight();
		} else if (node.getLeft() == null && node.getRight() != null) {
			return 0 - node.getRight().getHeight();
		} else if (node.getLeft() != null && node.getRight() == null) {
			return node.getLeft().getHeight();
		}
		return 0;
	}

	//최솟값 찾기 메소드
	public Key min() {
		if (root == null)
			return null;
		return (Key) min(root).getKey();
	}

	private TreeMapNode min(TreeMapNode n) {
		if (n.getLeft() == null)
			return n;
		return min(n.getLeft());
	}

	private TreeMapNode rotateRight(TreeMapNode node) {
		TreeMapNode target = node.getLeft(); //target TreeMapNode 왼쪽 자식노드
		node.setLeft(target.getRight()); //target TreeMapNode 왼쪽 자식노드 <- target TreeMapNode 왼쪽 자식노드의 오른쪽노드
		target.setRight(node);
		fixHeight(node, target);
		return target;
	}

	private TreeMapNode rotateLeft(TreeMapNode node) {
		TreeMapNode target = node.getRight();//target TreeMapNode 오른쪽 자식노드
		node.setRight(target.getLeft());//target TreeMapNode 오른쪽 자식노드 <- target TreeMapNode 오른쪽 자식노드의 왼쪽노드
		target.setLeft(node);
		fixHeight(node, target);
		return target;
	}

	private void fixHeight(TreeMapNode node, TreeMapNode target) {
		if (node != null) {
			node.setHeight(fixHeight(node));
		}
		if (target != null) {
			target.setHeight(fixHeight(target));
		}
	}

	public int fixHeight(TreeMapNode node) {
		if (node.getLeft() != null && node.getRight() != null) {
			return Math.max(node.getLeft().getHeight(), node.getRight().getHeight()) + 1;
		} else if (node.getLeft() == null && node.getRight() != null) {
			return node.getRight().getHeight() + 1;
		} else if (node.getLeft() != null && node.getRight() == null) {
			return node.getLeft().getHeight() + 1;
		} else {
			return 1;
		}
	}

	//레벨순회
	public ArrayList<Integer> levelorder() {

		ArrayList<Integer> keyList = new ArrayList();
		Queue<TreeMapNode> q = new LinkedList<TreeMapNode>();
		TreeMapNode target = null;
		q.add(root);
		while (!q.isEmpty()) {
			target = q.remove();
			keyList.add((Integer) target.getKey());
			if (target.getLeft() != null)
				q.add(target.getLeft());
			if (target.getRight() != null)
				q.add(target.getRight());
		}
		return keyList;
	}
}
