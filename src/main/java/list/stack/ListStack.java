package list.stack;

import java.util.EmptyStackException;

import list.linked.Node;

public class ListStack<E> {
	private Node<E> top; //스택 top 항목을 가진 Node를 가리키기 위해 top은 맨 앞을 보고 있음
	private int size; //스택의 항목 수

	public ListStack() {
		top = null;
		size = 0;
	}

	public int size() { //스택의 항목의 수를 리턴
		return size;
	}

	public boolean isEmpty() { //스택이 empty이면 true리턴
		return size == 0;
	}

	public E peek() {//스택 top항목만을 리턴
		if (isEmpty())
			throw new EmptyStackException();
		return top.getItem();
	}

	public void push(E newItem) { //list의 앞부분에서 insert가 일어남
		Node<E> newNode = new Node(newItem, top);
		top = newNode;
		size++;
	}

	public E pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		E item = top.getItem();
		top = top.getNext();
		size --;

		return item;
	}
}
