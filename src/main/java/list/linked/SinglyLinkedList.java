package list.linked;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {

	protected Node head;
	private int size;

	public SinglyLinkedList() {
		head = null;
		size = 0;
	}

	public int search(E target) { //item 이 target 인 것을 탐색
		Node p = head;
		for (int k = 0; k < size; k++) {
			if (p.getNext().getItem() == target)
				return k;
			p = p.getNext();
		}
		return -1;
	}

	public void insertFront(E newItem) { // 연결리스트 맨 앞에 새 노드 삽입
		head = new Node<E>(newItem, head);
		size++;
	}

	public void insertAfter(E newItem, Node p) { // 노드 p 바로 다음에 새 노드 삽입
		p.setNext(new Node<E>(newItem, p.getNext()));
		size++;
	}

	public void deleteFront() { //리스트의 첫 노드 삭제
		if (isEmpty())
			throw new NoSuchElementException();
		head = head.getNext();
		size--;
	}

	public void deleteAfter(Node p) { //p가 가리키는 노드의 다음 노드를 삭제
		if (p == null)
			throw new NoSuchElementException();

		Node t = p.getNext();
		p.setNext(t.getNext());
		t.setNext(null);
		size--;
	}

	private boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

}
