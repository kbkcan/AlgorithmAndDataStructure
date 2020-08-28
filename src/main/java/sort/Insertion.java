package sort;

public class Insertion {

	//삽입한다고 생각하지 말고 버블정렬처럼 이전값과 비교하여 작으면 계속 바꾸면 된다.이전값보다 크면 멈춘다.
	public static void sort(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (SortUtil.isless(a[j], a[j - 1]))
					SortUtil.swap(a, j, j - 1);
				else
					break;
			}
		}
			
	}
}
