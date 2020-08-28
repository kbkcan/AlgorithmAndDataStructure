package stringMatching;

import java.util.ArrayList;
import java.util.Arrays;

public class BoyerMooreHorspool implements StringMatching {

	public ArrayList<Integer> match(String text, String pattern) {

		ArrayList<Integer> locationFound = new ArrayList<Integer>();
		int patternSize = pattern.length();
		int textSize = text.length();
		int[] jumpTable = makeJumpTable(pattern);

		int i = 1;

		while (i <= textSize - patternSize + 1) {
			int j = patternSize - 1;
			int k = i + patternSize - 1;
			while (j > 0 && pattern.charAt(j) == text.charAt(k)) {
				j--;
				k--;
			}
			if (j == 0) {
				locationFound.add(i);
			}
			i = i + jumpTable[text.charAt(i + patternSize - 1)];
		}
		return locationFound;
	}

	public int[] makeJumpTable(String pattern) {
		int patternSize = pattern.length(); //패턴의 길이
		final int SIZE_OF_CARACTER_SET = (int) Math.pow(2, Character.SIZE);
		int jumpTable[] = new int[SIZE_OF_CARACTER_SET];
		Arrays.fill(jumpTable, patternSize);
		for (int i = 0; i < patternSize - 1; i++) {
			jumpTable[pattern.charAt(i)] = patternSize - i - 1;
		}
		return jumpTable;
	}
}
