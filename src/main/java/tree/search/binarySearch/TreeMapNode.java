package tree.search.binarySearch;

public class TreeMapNode<Key extends Comparable<Key>, Value> {

	protected Key key;
	protected Value value;
	protected int height;
	protected TreeMapNode<Key, Value> left;
	protected TreeMapNode<Key, Value> right;

	protected TreeMapNode() {
	}

	public TreeMapNode(Key key, TreeMapNode left, TreeMapNode right) {
		this.key = key;
		this.left = left;
		this.right = right;
		this.value = null;
	}

	public TreeMapNode(Key key, Value value) {
		this.key = key;
		this.value = value;
		left = right = null;
	}

	public TreeMapNode(Key key, Value value, int height) {
		this.key = key;
		this.value = value;
		this.height = height;
		left = right = null;
	}

	public Key getKey() {
		return key;
	}

	public TreeMapNode<Key, Value> getLeft() {
		return left;
	}

	public TreeMapNode<Key, Value> getRight() {
		return right;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public void setLeft(TreeMapNode<Key, Value> left) {
		this.left = left;
	}

	public void setRight(TreeMapNode<Key, Value> right) {
		this.right = right;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isNull() {
		return false;
	}

	@Override
	public String toString() {
		return "(" + key + "," + value + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeMapNode other = (TreeMapNode) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
}
