package stringMatching;

import java.util.ArrayList;

public class NaiveMatching implements StringMatching {

	public ArrayList<Integer> match(String str, String pattern) {
		ArrayList<Integer> locationsFound = new ArrayList<Integer>();
		for (int i = 0; i <= str.length() - pattern.length(); i++) {
			if (pattern.equals(str.substring(i, i + pattern.length()))) {
				locationsFound.add(i);
			}
		}
		return locationsFound;
	}
}
