package tree;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;
import tree.search.redblack.MyTreeSet;

public class RedBlackTreeTest {

	@Test
	@Ignore
	public void putTest1() {
		MyTreeSet redBlackTree = new MyTreeSet();
		redBlackTree.put(30, "thirty");
		redBlackTree.put(20, "twenty");
		redBlackTree.put(70, "seventy");
		redBlackTree.put(10, "ten");
		redBlackTree.put(60, "sixty");
		redBlackTree.put(35, "thirty");
		ArrayList nodeList = redBlackTree.levelorder();
		//System.out.println(nodeList.toString());
	}
	
	@Test
	public void putTest2() {
		MyTreeSet redBlackTree = new MyTreeSet();
		redBlackTree.put(60, "sixty");
		redBlackTree.put(30, "thirty");
		redBlackTree.put(70, "seventy");
		redBlackTree.put(20, "twenty");
		redBlackTree.put(35, "thirty");
		redBlackTree.put(65, "sixtyFive");
		redBlackTree.put(80, "eighty");
		ArrayList nodeList = redBlackTree.levelorder();
		System.out.println(nodeList.toString());
	}

}
