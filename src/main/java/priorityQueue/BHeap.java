package priorityQueue;

public class BHeap<Key extends Comparable<Key>, Value> {
	private Entry[] entryArr;
	private int[] position;
	private int size;

	public BHeap(Entry[] entryArr, int size) {
		this.entryArr = entryArr;
		this.size = size;
		position = new int[entryArr.length];
		for (int i = 0; i < position.length; i++) {
			position[i] = i;
			if (entryArr[i] != null) {
				position[i] = i;
			}
		}
	}

	public int size() {
		return size;
	}

	public void createHeap() {
		for (int i = size / 2; i > 0; i--) {
			downheap(i);
		}
	}

	private void downheap(int i) {//부모노드의 인덱스
		while (2 * i <= size) { //i의 왼쪽 자식노드가 힙에 있으면
			int left = 2 * i; //왼쪽 자식노드의 인덱스
			if (left < size && greater(left, left + 1)) {
				left++;
			}
			if (!greater(i, left)) { //부모노드가 자식승자와 같거나 작으면 루프중단
				break;
			}
			swap(i, left);
			i = left;
		}
	}

	public void insert(Key key, Value value) {
		Entry tmp = new Entry(key, value);
		entryArr[++size] = tmp;
		upheap(size);
	}

	private void upheap(int j) { //현재 노드의 인덱스
		while (j > 1 && greater(j / 2, j)) { // 현재 노드가 루트가 아니고 동시에 부모가 크면
			swap(j / 2, j);
			j = j / 2;
		}
	}

	//최솟값 삭제
	public Entry deleteMin() {
		Entry min = entryArr[1];
		swap(1, size--); //힙의 마지막 항목과 교환하고 힙 크기 1 감소
		entryArr[size + 1] = null;
		downheap(1);
		return min;
	}


	public Entry[] getEntryArr() {
		return entryArr;
	}

	private boolean greater(int i, int j) {
		return (entryArr[i].getKey().compareTo(entryArr[j].getKey())) > 0;
	}

	private void swap(int i, int j) {
		Entry tmp = entryArr[i];
		entryArr[i] = entryArr[j];
		entryArr[j] = tmp;

		swapPosition(i, j);

	}

	private void swapPosition(int entryIndex1, int entryIndex2) {
		int positionIndex1 = -1;
		int positionIndex2 = -1;
		for (int i = 0; i < entryArr.length; i++) {
			if (position[i] == entryIndex1) {
				positionIndex1 = i;
			}
			if (position[i] == entryIndex2) {
				positionIndex2 = i;
			}
		}

		int tmp = position[positionIndex1];
		position[positionIndex1] = position[positionIndex2];
		position[positionIndex2] = tmp;

	}

	public int[] getPosition() {
		return position;
	}


}
