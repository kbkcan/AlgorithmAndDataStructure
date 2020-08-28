package sort;

public class Shell {

	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 4;//3x+1 간격
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && SortUtil.isless(a[j], a[j - h]); j = j - h) {
					SortUtil.swap(a, j, j - h);
				}
			}
			h = h / 3;
		}

	}

}
