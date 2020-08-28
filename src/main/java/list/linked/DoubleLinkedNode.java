package list.linked;

public class DoubleLinkedNode<E> extends Node {

	private E item;
	private DoubleLinkedNode previous;
	private DoubleLinkedNode next;

	public DoubleLinkedNode(E newItem, DoubleLinkedNode p, DoubleLinkedNode q) {
		item = newItem;
		previous = p;
		next = q;
	}

	public DoubleLinkedNode getPrevious() {
		return previous;
	}

	public void setPrevious(DoubleLinkedNode p) {
		this.previous = p;
	}

}
