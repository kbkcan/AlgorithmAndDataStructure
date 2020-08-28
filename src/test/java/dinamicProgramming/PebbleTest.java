package dinamicProgramming;

import org.junit.Assert;
import org.junit.Test;

public class PebbleTest {

	static int[][] dataA = {
			{ 6, 7, 12, -5, 5, 3, 11, 3 }, 
			{ -8, 10, 14, 9, 7, 13, 8, 5 }, 
			{ 11, 12, 7, 4, 8, -2, 9, 4 } };

	@Test
	public void testPebbleBottomUp() {
		int[][] resultA = new int[8][4];//7개 열의 데이터, 4개 패턴 결과 용
		int result = Integer.MIN_VALUE;

		Pebble pebble = new Pebble();

		result = pebble.pebble(dataA, resultA);

		System.out.println("dataA");
		print(dataA);
		System.out.println("result=" + result);
		Assert.assertEquals(106, result);
		print(resultA);
	}

	private void print(int[][] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.printf("%4d",data[i][j]);
			}
			System.out.print("\n");
		}
	}

}
