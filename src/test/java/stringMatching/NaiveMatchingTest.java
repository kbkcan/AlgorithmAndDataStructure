package stringMatching;

import java.util.ArrayList;

import org.junit.Test;

public class NaiveMatchingTest {

	@Test
	public void test() {
		NaiveMatching stringMatching = new NaiveMatching();
		ArrayList<Integer> locationsFound = stringMatching.match("abcdabcdabcwz","abcdabcwz");
		System.out.println(locationsFound);
		
	}

}
