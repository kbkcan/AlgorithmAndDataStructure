package stringMatching;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class StringMatchingWithAutomataTest {

	@Test
	public void test() {
		StringMatchingWithAutomata automata = new StringMatchingWithAutomata();
		ArrayList<Integer> locationsFound= automata.match("abcdabcdabcwz","abcdabcwz");
		ArrayList<Integer> expected =new ArrayList<Integer>();
		expected.add(3);
		assertEquals(expected.toString(), locationsFound.toString());
	}

}
