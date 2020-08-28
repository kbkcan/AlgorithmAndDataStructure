package priorityQueue;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class priorityQueueTest {
	BHeap heap;

	@Before
	public void before() {
		Entry[] entryArr = new Entry[16];
		entryArr[1] = new Entry(70);
		entryArr[2] = new Entry(90);
		entryArr[3] = new Entry(60);
		entryArr[4] = new Entry(50);
		entryArr[5] = new Entry(80);
		entryArr[6] = new Entry(30);
		entryArr[7] = new Entry(40);
		entryArr[8] = new Entry(45);
		entryArr[9] = new Entry(35);
		entryArr[10] = new Entry(20);
		entryArr[11] = new Entry(15);
		entryArr[12] = new Entry(10);

		heap = new BHeap(entryArr, 12);
	}

	@Test
	public void createHeapTest() {
		heap.createHeap();
		assertEquals(Arrays.deepToString(heap.getEntryArr()),
				"[null, 10, 15, 30, 35, 20, 60, 40, 45, 50, 90, 80, 70, null, null, null]");
	}

	@Test
	public void insertTest() {
		heap.createHeap();
		//System.out.println(Arrays.deepToString(heap.getEntryArr()));
		heap.insert(20, null);
		//System.out.println(Arrays.deepToString(heap.getEntryArr()));
		assertEquals(Arrays.deepToString(heap.getEntryArr()),
				"[null, 10, 15, 20, 35, 20, 30, 40, 45, 50, 90, 80, 70, 60, null, null]");
	}

	@Test
	public void deleteMinTest() {
		heap.createHeap();
		//System.out.println(Arrays.deepToString(heap.getEntryArr()));
		heap.deleteMin();
		//System.out.println(Arrays.deepToString(heap.getEntryArr()));
		assertEquals(Arrays.deepToString(heap.getEntryArr()),
				"[null, 15, 20, 30, 35, 70, 60, 40, 45, 50, 90, 80, null, null, null, null]");
	}



}
