package stringMatching;

import java.util.ArrayList;

public class RabinKarpStringMatching implements StringMatching {
	private char[] alphabetSet;
	private String pattern;
	private final int PRIME_NUMBER = 9973; //충분히 큰 소수
	private final char FIRST_CHAR = ' ';

	public RabinKarpStringMatching() {
		//alphabetSet = new char[] { FIRST_CHAR, 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		alphabetSet = new char[] { ' ', '}', '␠', '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', '>', '?', '@', FIRST_CHAR, 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_', '`', FIRST_CHAR, 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '{', '|', '}', '~' };
	}

	public ArrayList<Integer> match(String str, String pattern) {
		this.pattern = pattern;
		ArrayList<Integer> locationsFound = new ArrayList<Integer>();
		double patternValue = quantify(pattern);
		double strValueCutByPatternLength = quantify(str);
		int patternLength = pattern.length();
		int d = alphabetSet.length;
		double remainderDividedByPrimeNumber = (Math.pow(d, patternLength - 1)) % PRIME_NUMBER;
		for (int i = 0; i <= str.length() - patternLength; i++) {
			if (i != 0) {
				double charValueToBeSubtracted = ((str.charAt(i - 1) - FIRST_CHAR) * remainderDividedByPrimeNumber) % PRIME_NUMBER;
				double charValueToAdd = (str.charAt(i + patternLength - 1) - FIRST_CHAR);
				strValueCutByPatternLength = ((d * (strValueCutByPatternLength - charValueToBeSubtracted)) + charValueToAdd) % PRIME_NUMBER;
			}
			//			System.out.printf("strValueCutByPatternLength : %.0f , patternValue : %.0f %n", strValueCutByPatternLength, patternValue);
			if (patternValue == strValueCutByPatternLength) {
				if (pattern.equals(str.substring(i, i + patternLength)))
					locationsFound.add(i);
			}
		}

		return locationsFound;
	}

	public double quantify(String str) {
		double value = 0;
		double d = alphabetSet.length;
		for (int i = 0; i < pattern.length(); i++) {
			value = (d * value + (str.charAt(i) - FIRST_CHAR)) % PRIME_NUMBER;
			//	System.out.println("i :" + i + ", value :" + value);
		}
		return value;
	}

	public char[] getAlphabetSet() {
		return alphabetSet;
	}

	public void setAlphabetSet(char[] alphabetSet) {
		this.alphabetSet = alphabetSet;
	}
}
