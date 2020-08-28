package hashtable;

public class Chaining<K, V> {
	private int tableSize = 13;
	private Node[] a = new Node[tableSize];

	public static class Node {
		private Object key;
		private Object data;
		private Node next;

		public Node(Object key, Object data, Node next) {
			this.key = key;
			this.data = data;
			this.next = next;
		}

		public Object getKey() {
			return key;
		}

		public Object getData() {
			return data;
		}
	}

	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % tableSize;
	}

	public V get(K key) {
		int i = hash(key);
		for (Node x = a[i]; x != null; x = x.next) {
			if (key.equals(x.key))
				return (V) x.data;
		}
		return null;
	}

	private void put(K key, V data) {
		int i = hash(key);
		for (Node x = a[i]; x != null; x = x.next) {
			if (key.equals(a[i])) {
				x.data = data;
				return;
			}
			a[i] = new Node(key, data, a[i]);
		}
	}

}
