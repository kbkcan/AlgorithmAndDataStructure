package list.queue;

import java.util.NoSuchElementException;

import list.linked.Node;

public class ListQueue<E> {
	private Node<E> front, rear;
	private int size;

	public ListQueue() {
		front = rear = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void add(E newItem) {
		Node newNode = new Node(newItem, null);
		if (isEmpty()) {
			front = newNode;
		} else {
			rear.setNext(newNode);
		}
		rear = newNode;
		size++;
	}

	public E remove() {
		if (isEmpty())
			throw new NoSuchElementException();
		E item = front.getItem();
		front = front.getNext();
		if (isEmpty())
			rear = null;
		size--;
		return item;
	}
}
