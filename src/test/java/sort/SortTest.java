package sort;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

import sort.radix.Bucket;
import sort.radix.Radix;

public class SortTest {

	Integer[] intArr = { 10, 5, 4, 8, 3, 2, 6, 7, 1, 9, 0 };
	Integer[] intArr2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	int[] bucketIntArr = { 2, 0, 5, 0, 3, 2, 5, 2, 3, 1, 0, 2 };
	int[] bucketIntArr2 = { 3, 1, 4, 2, 0, 2 };
	int[] bucketIntArr3 = { 0, 0, 0, 1, 2, 2, 2, 2, 3, 3, 5, 5 };

	Integer[] radixIntArr = { 251, 430, 301, 540, 551, 401, 2, 10, 124, 22, 204, 115 };
	Integer[] radixIntArr2 = { 2, 10, 22, 115, 124, 204, 251, 301, 401, 430, 540, 551 };

	@Test
	public void InsertionTest() {
		Insertion.sort(intArr);
		assertArrayEquals(intArr, intArr2);
	}

	@Test
	public void SelectionTest() {
		Selection.sort(intArr);
		assertArrayEquals(intArr, intArr2);
	}

	@Test
	public void ShellTest() {
		Shell.sort(intArr);
		assertArrayEquals(intArr, intArr2);
	}

	@Test
	public void HeapTest() {
		Integer[] intArr3 = new Integer[intArr.length + 1];
		System.arraycopy(intArr, 0, intArr3, 1, intArr.length);
		Heap.sort(intArr3);
		System.arraycopy(intArr3, 1, intArr, 0, intArr3.length - 1);
		assertArrayEquals(intArr, intArr2);
	}

	@Test
	public void MergeTest() {
		Merge.sort(intArr);
		assertArrayEquals(intArr, intArr2);
	}

	@Test
	public void QuickTest() {
		Quick.sort(intArr);
		assertArrayEquals(intArr, intArr2);
	}

	@Test
	public void BucketTest() {
		Bucket.sort(bucketIntArr, 10);
		assertArrayEquals(bucketIntArr, bucketIntArr3);

	}

	@Test
	public void RadixSort() {
		Radix.sort(radixIntArr);
		assertArrayEquals(radixIntArr, radixIntArr2);
	}
}
