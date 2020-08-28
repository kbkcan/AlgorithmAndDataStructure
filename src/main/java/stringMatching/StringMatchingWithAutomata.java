package stringMatching;

import java.util.ArrayList;

public class StringMatchingWithAutomata implements StringMatching {

	private char[] alphabetSet;//사용되는 문자열 종류의 배열을 갖는다
	private int[][] transitionTable;//오토마타 수행에 사용되는 전이테이블
	private int currentState, finalState;//오토마타 수행에 사용되는 현제 state번호와 final state번호

	public StringMatchingWithAutomata() {//Default constructor
		alphabetSet = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '!', '.', ',' };
	}

	public StringMatchingWithAutomata(char[] alphabetSet) {
		this.alphabetSet = alphabetSet;
	}

	public void setAlphabetSet(char[] alphabetSet) {
		this.alphabetSet = alphabetSet;
	}

	public char[] getAlphabetSet() {
		return alphabetSet;
	}

	public ArrayList<Integer> match(String str, String pattern) {
		constructAutomata(pattern);
		ArrayList<Integer> locationsFound = new ArrayList<Integer>();
		int patternLength = pattern.length();
		int textLength = str.length();
		currentState = 0;
		for (int i = 0; i < textLength; i++) {
			currentState = transitionTable[currentState][charToIndex(str.charAt(i))];
			if (currentState == finalState) {
				//System.out.println(i - patternLength + " ~ " + i);
				locationsFound.add(i - patternLength);
			}
		}
		return locationsFound;
	}

	public boolean constructAutomata(String pattern) {
		transitionTable = new int[pattern.length() + 1][alphabetSet.length];
		// transitionTable[현제 state값][알파벳index값]
		finalState = pattern.length();
		for (int state = 0; state <= finalState; state++) { //q 오토마타 상태
			for (int i = 0; i < alphabetSet.length; i++) {
				char inputCharacter = alphabetSet[i];
				int stateOfreturn = Math.min(finalState + 1, state + 2);
				do {
					stateOfreturn--;
				} while (!isSuffix(pattern.substring(0, stateOfreturn), pattern.substring(0, state) + Character.toString(inputCharacter)));
				transitionTable[state][i] = stateOfreturn;
			}
		}
		return true;
	}

	public boolean isSuffix(String subsequence, String target) {// param1이 param2의 suffix인지 확인하는 함수
		int m = target.length();
		int n = subsequence.length();
		if (n > m)
			return false;
		String comp = target.substring(m - n);
		return comp.equals(subsequence);
	}

	public int charToIndex(char ch) {
		for (int i = 0; i < alphabetSet.length; i++) {
			if (ch == alphabetSet[i])
				return i;
		}
		throw new UnsupportedOperationException("Charset sequence is not Compatible (" + ch + ")");
	}

	public int[][] getTransitionTable() {
		return transitionTable;
	}

}
