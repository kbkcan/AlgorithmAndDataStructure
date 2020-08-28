package list.array;

import java.util.NoSuchElementException;

public class MyArrayList<E> {
	private E a[]; //리스트의 항목들을 저장할 배열
	private int size; //리스트의 항목수

	public MyArrayList() {
		a = (E[]) new Object[1];
		size = 0;
	}

	public E peek(int k) { //k번째 항목을 리턴, 단순히 읽기만 한다.
		if (size == 0)
			throw new NoSuchElementException();//underflow 경우에 프로그램 정지
		return a[k];
	}

	public void insertLast(E newItem) { //가장 뒤에 새항목 삽입
		if (size == a.length)
			resize(2 * a.length);
		a[size++] = newItem; //length 는 배열의 길이, size는 배열의 항목수
	}

	public void insert(E newItem, int k) { //새 항목을 k-1번째 항목 다음에 삽입
		if (size == a.length)
			resize(2 * a.length);
		for (int i = size - 1; i >= k; i--) //한칸씩 뒤로이동
			a[i + 1] = a[i];
		a[k] = newItem;
	}

	private void resize(int newSize) { //배열크기 조절
		E[] t = (E[]) new Object[newSize];
		for (int i = 0; i < size; i++) {
			t[i] = a[i];
		}
		a = (E[]) t;
	}

	public E delete(int k) { //k번째 항목 삭제
		if (isEmpty())
			throw new NoSuchElementException(); // underflow 경우에 프로그램 정지
		E item = a[k];
		for (int i = k; i < a.length; i++) {
			a[i] = a[i + 1];
		}
		size--;
		if (size > 0 && size == a.length / 4)
			resize(a.length / 2);

		return item;
	}

	private boolean isEmpty() {
		return size==0;
	}

}
