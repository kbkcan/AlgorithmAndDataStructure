package tree;

import org.junit.BeforeClass;
import org.junit.Test;
import tree.search.binarySearch.MyTreeMap;

public class BinarySearchTreeTest {
	MyTreeMap bst;
	@BeforeClass
	public void BinarySearchTree() {
		bst = new MyTreeMap(50,"Apple");
	}

	@Test
	public void put() {
		bst.put(30,"Lemon");
		bst.put(80,"Mango");
		bst.put(10,"Cherry");
		bst.put(40,"Orange");
		bst.put(90,"Lime");
		bst.put(35,"pear");
	
	}
}
