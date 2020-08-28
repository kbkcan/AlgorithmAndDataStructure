package list.stack;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class ArrayStack<E> {

	private E s[]; //스택을 위한 배열
	private int top; //스택의 top항목의 배열 원소 인덱스

	public ArrayStack() {
		s = (E[]) new Object[1];
		top = -1;
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public E peek() { //스택 top 항목의 내용만을 리턴
		if (isEmpty())
			throw new EmptyStackException();
		return s[top];
	}

	public void push(E newItem) {
		if (size() == s.length) {
			resize(s.length * 2);
		}
		s[++top] = newItem;

	}

	public E pop() {//pop연산
		if (isEmpty())
			throw new EmptyStackException();
		E item = s[top];
		s[top--] = null;
		if (size() > 0 && size() == s.length / 4)
			resize(s.length / 2);
		return item;
	}

	private void resize(int length) {
		E t[] = (E[]) new Object[length];
		for (int i = 0; i < s.length; i++) {
			t[i] = s[i];
		}
		s = t;
	}

}
