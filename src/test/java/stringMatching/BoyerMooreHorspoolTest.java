package stringMatching;

import java.util.ArrayList;

import org.junit.Test;

public class BoyerMooreHorspoolTest {

	@Test
	public void BoyerMooreHorspoolTest() {

		BoyerMooreHorspool bmh = new BoyerMooreHorspool();
		String parent = "GCAGA5AGCAGAGAGCAGAGAG";
		String pattern = "GCAGAGAG";
		int patternSize = pattern.length();
		int[] jumpTable = bmh.makeJumpTable(pattern);
		System.out.print("jumpTable :");
		for (int i = 0; i < patternSize; i++) {
			System.out.printf("%3d", jumpTable[pattern.charAt(i)]);
		}
		System.out.println();
		
		ArrayList<Integer> locationFound = bmh.match(parent, pattern);
		System.out.println(locationFound);
		
	}

}
