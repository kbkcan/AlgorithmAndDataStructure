package dinamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixChainTest {

	@Test
	public void test() {
		int[] matricesRowColumnNum = {10,5,20,7,15,3};
		MatrixChain chain = new MatrixChain(matricesRowColumnNum);
		//assertEquals(7500, chain.getMinMultiplyCount());
		System.out.println(chain.getMinMultiplyCount());
	}
	


}
