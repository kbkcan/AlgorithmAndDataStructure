package stringMatching;

import java.util.ArrayList;
import java.util.Arrays;

public class KMPStringMatching implements StringMatching {

	@Override
	public ArrayList<Integer> match(String parent, String pattern) {
		ArrayList<Integer> locationsFound = new ArrayList<Integer>();
		int[] table = makeTable(pattern);
		int parentSize = parent.length();
		int patternSize = pattern.length();
		int j = 0;
		for (int i = 0; i < parentSize; i++) {
			while (j > 0 && parent.charAt(i) != pattern.charAt(j)) {
				j = table[j - 1];
			}
			if (parent.charAt(i) == pattern.charAt(j)) {
				if (j == patternSize - 1) {
					locationsFound.add(i - patternSize + 2);
					j = table[j];
				} else {
					j++;
				}
			}
		}
		return locationsFound;
	}

	public int[] makeTable(String pattern) {
		int patternSize = pattern.length();
		int[] table = new int[patternSize];
		int j = 0;
		for (int i = 1; i < patternSize; i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = table[j - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(j)) {
				table[i] = ++j;
			}
		}
		return table;
	}
}
