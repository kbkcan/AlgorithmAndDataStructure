package sort;

import priorityQueue.BHeap;

public class Heap {

	public static void sort(Comparable[] a) {
		int heapSize = a.length - 1;
		for (int i = heapSize / 2; i > 0; i--) { // 힙 만들기
			downheap(a, i, heapSize);
		}
		while (heapSize > 1) { //힙정렬
			SortUtil.swap(a, 1, heapSize--);
			downheap(a, 1, heapSize);
		}
	}

	private static void downheap(Comparable[] a, int parent, int heapSize) {//부모노드의 인덱스
		while (2 * parent <= heapSize) { //i의 왼쪽 자식노드가 힙에 있으면
			int left = 2 * parent; //왼쪽 자식노드의 인덱스
			if (left < heapSize && SortUtil.isless(a[left], a[left + 1])) { //오른쪽 자식이 큰 경우
				left++;
			}
			if (!SortUtil.isless(a[parent], a[left])) { //부모노드가 자식승자와 같거나 작으면 루프중단
				break;
			}
			SortUtil.swap(a, parent, left);
			parent = left;
		}
	}
}
