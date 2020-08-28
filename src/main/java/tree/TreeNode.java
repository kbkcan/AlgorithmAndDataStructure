package tree;

public class TreeNode<Key extends Comparable<Key>> {
	private Key key;
	private TreeNode<Key> left;
	private TreeNode<Key> right;

	public TreeNode() {
	}

	public TreeNode(Key key, TreeNode left, TreeNode right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}

	public Key getKey() {
		return key;
	}

	public TreeNode<Key> getLeft() {
		return left;
	}

	public TreeNode<Key> getRight() {
		return right;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public void setLeft(TreeNode<Key> left) {
		this.left = left;
	}

	public void setRight(TreeNode<Key> right) {
		this.right = right;
	}

}
