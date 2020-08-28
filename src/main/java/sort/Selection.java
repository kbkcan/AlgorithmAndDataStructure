package sort;

public class Selection {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (isless(a[j], a[min]))
					min = j;
			}
			swap(a, i, min);
		}
	}

	private static void swap(Comparable[] a, int i, int min) {
		Comparable tmp = a[i];
		a[i] = a[min];
		a[min] = tmp;
	}

	private static boolean isless(Comparable i, Comparable j) {
		return i.compareTo(j) < 0;
	}
}
