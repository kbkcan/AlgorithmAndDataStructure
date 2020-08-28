package sort;

public class SortUtil {
	public static void swap(Comparable[] a, int i, int min) {
		Comparable tmp = a[i];
		a[i] = a[min];
		a[min] = tmp;
	}

	public static boolean isless(Comparable i, Comparable j) {
		return i.compareTo(j) < 0;
	}
	
	public static boolean greater(Comparable i, Comparable j) {
		return i.compareTo(j) < 0;
	}

}
