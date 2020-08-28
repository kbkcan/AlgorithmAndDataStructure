package tree;

import java.util.LinkedList;
import java.util.Queue;

import tree.search.binarySearch.TreeMapNode;

public class BinaryTree<Key extends Comparable<Key>> {

	private TreeNode root;

	public BinaryTree() {
		root = null;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void preorder(TreeNode n) {
		if (n != null) {
			System.out.println(n.getKey() + " "); //노드 n 방문
			preorder(n.getLeft()); //n의 왼쪽 서브트리를 순회
			preorder(n.getRight());
		}
	}

	//중위 순회
	public void inorder(TreeNode n) {
		if (n != null) {
			inorder(n.getLeft()); //n의 왼쪽 서브트리를 순회
			System.out.println(n.getKey() + " "); //노드 n 방문
			inorder(n.getRight());
		}
	}

	//후위 순회
	public void postorder(TreeNode n) {
		if (n != null) {
			postorder(n.getLeft()); //n의 왼쪽 서브트리를 순회
			postorder(n.getRight());
			System.out.println(n.getKey() + " "); //노드 n 방문
		}
	}

	//레벨순회
	public void levelorder(TreeNode root) {

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode t;
		q.add(root);
		while (!q.isEmpty()) {
			t = q.remove();
			System.out.println(t.getKey() + " ");
			if (t.getLeft() != null)
				q.add(t.getLeft());
			if (t.getRight() != null)
				q.add(t.getRight());
		}
	}

	//n을 루트로 하는 트리에 있는 노드수
	public int size(TreeMapNode n) {
		if (n == null) {
			return 0;
		} else {
			return (1 + size(n.getLeft()) + size(n.getRight()));
		}
	}

	//n을 루트로하는 (서브)트리의 높이
	public int height(TreeMapNode n) {
		if (n == null)
			return 0;
		else
			return (1 + Math.max(height(n.getLeft()), height(n.getRight())));
	}

	//두 트리의 동일성 검사
	public static boolean isEqual(TreeNode n, TreeNode m) { //두 트리의 동일성 검사
		if (n == null || m == null) {
			return n == m;
		}

		if (n.getKey().compareTo(m.getKey()) != 0) {//둘다 null아니면 item비교
			return false;
		}
		return (isEqual(n.getLeft(), m.getLeft())) && (isEqual(n.getRight(), m.getRight()));
	}
}
