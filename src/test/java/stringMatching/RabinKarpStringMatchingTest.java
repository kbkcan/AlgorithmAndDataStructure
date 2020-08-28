package stringMatching;

import java.util.ArrayList;

import org.junit.Test;

public class RabinKarpStringMatchingTest {

	@Test
	public void test() {
		RabinKarpStringMatching stringMatching = new RabinKarpStringMatching();
		ArrayList<Integer> locationsFound = stringMatching.match("eeaabceeaabceedb", "edb");
		System.out.println(locationsFound);

	}
}