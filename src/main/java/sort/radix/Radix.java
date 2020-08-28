package sort.radix;

public class Radix {

	public static void sort(Integer[] intArr) {
		final int R = 10;
		int N = intArr.length;
		int[] t = new int[N];
		for (int k = 10; k <= 1000; k = k * 10) {
			int[] startIndex = new int[R + 1];
			for (int i = 0; i < N; i++) { //빈도수 계산
				startIndex[(intArr[i] % k) / (k / 10) + 1]++;
			}
			for (int r = 0; r < R; r++) { //각 버킷 인덱스 값이 저장될 배열 t의 시작 인덱스 계산
				startIndex[r + 1] = startIndex[r + 1] + startIndex[r];
			}
			for (int i = 0; i < N; i++) { //intArr[]를 배열 t에 차례로 저장
				t[startIndex[(intArr[i] % k) / (k / 10)]++] = intArr[i];
			}
			for (int i = 0; i < N; i++) {
				intArr[i] = t[i];
			}
			System.out.println(k/10+"의 자리 정렬결과:");
			for (int i = 0; i < N; i++) {
				System.out.printf("%03d ",intArr[i]);
			}
			System.out.println();
			System.out.println();
		}
	}

}
