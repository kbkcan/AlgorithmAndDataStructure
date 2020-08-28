package list.linked;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {
	protected DoubleLinkedNode head, tail;
	protected int size;

	public MyLinkedList() {
		head = new DoubleLinkedNode(null, null, null);
		tail = new DoubleLinkedNode(null, head, null);
		head.setNext(tail);
		size = 0;
	}

	public void insertBefore(DoubleLinkedNode target, E newItem) { //target 이 가리키는 노드 앞에 삽입
		DoubleLinkedNode preNode = target.getPrevious();
		DoubleLinkedNode newNode = new DoubleLinkedNode<E>(newItem, preNode, target);
		preNode.setNext(newNode);
		newNode.setPrevious(preNode);
		size++;
	}

	public void insertAfter(DoubleLinkedNode target, E newItem) { //target이 가리키는 노드 뒤에 삽입
		DoubleLinkedNode nextNode = (DoubleLinkedNode) target.getNext();
		DoubleLinkedNode newNode = new DoubleLinkedNode(newItem, target, nextNode);
		target.setNext(newNode);
		nextNode.setPrevious(newNode);
		size++;
	}

	public void delete(DoubleLinkedNode target) {
		if (target == null)
			throw new NoSuchElementException();
		
		DoubleLinkedNode preNode = target.getPrevious();
		DoubleLinkedNode nextNode = (DoubleLinkedNode) target.getNext();
		preNode.setNext(nextNode);
		nextNode.setPrevious(preNode);
		size--;
	}
}
