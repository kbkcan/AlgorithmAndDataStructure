package stringMatching;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class KMPStringMatchingTest {

	@Test
	public void test() {
		KMPStringMatching stringMatching = new KMPStringMatching();
		String parent = "ababacabacaababacaaba";
		String pattern = "abacaaba";
		int[] table = stringMatching.makeTable(pattern);
		System.out.println(Arrays.toString(table));
		ArrayList<Integer> locationsFound = stringMatching.match(parent, pattern);
		System.out.println(locationsFound.toString());
	}

}
