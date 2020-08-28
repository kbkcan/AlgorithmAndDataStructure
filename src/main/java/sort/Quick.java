package sort;

public class Quick {

	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int low, int high) {
		if (high <= low)
			return;
		int pivot = partition(a, low, high);
		sort(a, low, pivot - 1); // 피벗보다 작은 부분을 재귀 호출
		sort(a, pivot + 1, high); // 피벗보다 큰 부분을 재귀호출
	}

	private static int partition(Comparable[] a, int pivot, int high) {
		int low = pivot + 1;
		Comparable p = a[pivot];
		while (true) {
			while (low <= high && !SortUtil.isless(p, a[low])) //a[low]가 피벗보다 같거나 작으면 
				low++;
			while (high >= pivot && SortUtil.isless(p, a[high])) //a[high]가 피벗보다 크면
				high--;
			if (low >= high)
				break;
			SortUtil.swap(a, low, high);
		}
		SortUtil.swap(a, pivot, high);
		return high;
	}

}
