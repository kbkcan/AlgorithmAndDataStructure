package list.stack.practice;

import java.util.Stack;

import list.stack.ListStack;

public class BracketChecker {

	private String exp;
	private int expSize;
	private char testCh, openPair;

	public boolean testPair(String exp) {
		this.exp = exp;
		ListStack<Character> stack = new ListStack<Character>();
		expSize = this.exp.length();

		for (int i = 0; i < expSize; i++) {
			testCh = exp.charAt(i);

			switch (testCh) {
			case '(':
			case '[':
			case '{':
				stack.push(testCh);
				break;
			case ')':
			case ']':
			case '}':
				if (stack.isEmpty()) {
					return false;
				} else {
					openPair = stack.pop();
					if ((openPair == ')') && (testCh != '(') || (openPair == ']') && (testCh != '[')
							|| (openPair == '}') && (testCh != '{')) {
						return false;

					} else {
						break;
					}
				}
			}
		}

		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
