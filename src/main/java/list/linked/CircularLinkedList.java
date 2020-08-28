package list.linked;

import java.util.NoSuchElementException;

public class CircularLinkedList<E> {

	protected Node last;
	private int size;

	public CircularLinkedList() {
		last = null;
		size = 0;
	}

	public void insert(E newItem) { // last가 가리키는 노드의 다음에 새 노드 삽입
		Node newNode = new Node<E>(newItem, null);
		if (last == null) {
			newNode.setNext(newNode);
			last = newNode;
		} else {
			newNode.setNext(last.getNext());
			last.setNext(newNode);
		}
	}

	public Node delete() {//last가 가리키는 노드의 다음 노드를 제거
		if (isEmpty())
			throw new NoSuchElementException();
		Node target = last.getNext();
		if (target == last) { //리스트에 1개의 노드만 있는 경우
			last = null;
		} else {
			last.setNext(target.getNext());
			target.setNext(null);
		}
		size--;
		return target;
	}

	private boolean isEmpty() {
		return size==0;
	}

}
