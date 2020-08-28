package sort.radix;

public class Bucket {
	/*
	 * 버킷 정렬은
	 * [1] 입력배열에서 각 숫자의 빈도수를 계산한다.
	 * [2] 버킷 인덱스 0부터 차례로 빈도수만큼 배열에 저장한다.
	 * */
	public static void sort(int[] intArr, int radix) {
		int[] bucket = new int[radix];
		for (int i = 0; i < radix; i++) {
			bucket[i] = 0;
		}
		for (int i = 0; i < intArr.length; i++) { //1단계 빈도수 계산
			bucket[intArr[i]]++;
		}

		int j = 0; //다음에 저장될 배열 intArr 의 인덱스
		for (int i = 0; i < radix; i++) {
			while ((bucket[i]-- != 0)) {
				intArr[j++] = i;
			}
		}

	}
}
