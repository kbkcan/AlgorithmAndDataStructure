package priorityQueue;

public class Entry<Key extends Comparable<Key>, Value> {
	private Key key;
	private Value value;

	public Entry(Key key, Value value) {
		this.key = key;
		this.value = value;
	}

	public Entry(Key key) {
		this.key = key;
		this.value = null;
	}

	public Key getKey() {
		return key;
	}

	public Value getValue() {
		return value;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	@Override
	public String toString() {
		if (value == null) {
			return this.key.toString();
		}
		return "(" + key + "," + value + ")";
	}

}
