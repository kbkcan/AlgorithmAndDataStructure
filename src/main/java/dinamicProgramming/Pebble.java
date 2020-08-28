package dinamicProgramming;

public class Pebble {

	//양립할 수 있는 패턴정보 배열 (문제의 row값이 변경이 되면 동적으로 변경할 필요있음)
	static int[][] availablePatterns = {
			{ 1, 2 }, //0번 패턴  (1,2 패턴 양립가능)
			{ 0, 2, 3 }, //1번 패턴  (0,2,3 패턴 양립가능)
			{ 0, 1 }, //2번 패턴  (2 패턴 양립 가능)
			{ 1 } //3번 패턴  (1 패턴 양립가능)
	};

	public int pebble(int[][] data, int[][] maxScoreResult) {

		//첫번째 열 데이터 설정
		for (int pattern = 0; pattern < 4; pattern++) {
			maxScoreResult[0][pattern] = getTheSumOfColumnScore(data, 0, pattern);
		}

		int tmp = 0;
		int result = 0;

		for (int i = 1; i < data[0].length; i++) {
			result = Integer.MIN_VALUE;

			for (int pattern = 0; pattern < 4; pattern++) {
				//p와 양립하는 패턴 q
				int[] compatilePatterns = availablePatterns[pattern];
				tmp = getPreviosMaxValue(maxScoreResult, i - 1, compatilePatterns) + getTheSumOfColumnScore(data, i, pattern);
				maxScoreResult[i][pattern] = tmp;//결과저장

				if (tmp > result) {
					result = tmp;
				}
			}
		}

		return result;
	}

	private int getPreviosMaxValue(int[][] maxScoreResult, int row, int[] compatilePatterns) {

		int result = Integer.MIN_VALUE;
		int tmp = 0;

		for (int k = 0; k < compatilePatterns.length; k++) {
			tmp = maxScoreResult[row][compatilePatterns[k]];
			if (tmp > result) {
				result = tmp;
			}
		}

		return result;
	}

	private int getTheSumOfColumnScore(int[][] data, int column, int pattern) {
		switch (pattern) {
		case 0:
			return data[0][column];
		case 1:
			return data[1][column];
		case 2:
			return data[2][column];
		case 3:
		default:
			return data[0][column] + data[2][column];
		}
	}

}
