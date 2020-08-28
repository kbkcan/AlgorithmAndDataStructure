package tree.search.binarySearch;

import java.util.LinkedList;
import java.util.Queue;

public class MyTreeMap<Key extends Comparable<Key>, Value> {

	private TreeMapNode root;

	public TreeMapNode getRoot() {
		return root;
	}

	public MyTreeMap(Key newId, Value newName) {
		root = new TreeMapNode(newId, newName);
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

	public TreeMapNode put(TreeMapNode n, Key k, Value v) {
		if (n == null)
			return new TreeMapNode(k, v);

		int t = n.getKey().compareTo(k);
		if (t > 0) {
			n.setLeft(put(n.getLeft(), k, v));
		} else if (t < 0) {
			n.setRight(put(n.getLeft(), k, v));
		} else {
			n.setValue(v);
		}
		return n;
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

	//최솟값 삭제 메소드
	public void deleteMin() {
		if (root == null)
			System.out.println("empty 트리");
		root = deleteMin(root);
	}

	public TreeMapNode deleteMin(TreeMapNode n) {
		if (n.getLeft() == null)
			return n.getRight();
		n.setLeft(deleteMin(n.getLeft()));
		return n;
	}

	//삭제 메소드
	public void delete(Key k) {
		root = delete(root, k);
	}

	private TreeMapNode delete(TreeMapNode n, Key k) {
		if (n == null)
			return null;
		int t = n.getKey().compareTo(k);
		if (t > 0) {
			n.setLeft(delete(n.getLeft(), k));
		} else if (t < 0) {
			n.setRight(delete(n.getRight(), k));
		} else { //키를 같은 노드를 찾았을 때
			if (n.getRight() == null) { // 삭제할 노드가 leaf노드 이거나, 자식노드를 하나만 가지고 있을 때
				return n.getLeft();
			}
			if (n.getLeft() == null) {// 왼쪽 자식노드를 하나만 가지고 있을 때
				return n.getLeft();
			}
			//자식노드가 모두 있을 때
			TreeMapNode target = n; // 삭제할 타겟노드
			n = min(target.getRight()); // n <- target노드를 삭제하고 넣을 key가 최소값인 노드
			n.setRight(deleteMin(target.getRight())); //최소값 노드에 target 오른쪽에 붙어 있는 노드에서 최소값 노드를 빼고 오른쪽 노드에 삽입
		}
		return n;
	}
}
