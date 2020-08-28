package tree;

import java.util.ArrayList;

import org.junit.Test;
import tree.search.avl.AVLTree;

public class AVLTreeTest {

	@Test
	public void putLLTest() {
		AVLTree avl = new AVLTree(30, "thirty");
		avl.put(20, "twenty");
		avl.put(10, "ten");
		avl.put(5, "ninety");
		ArrayList<Integer> keyList = avl.levelorder();
		//System.out.println(keyList.toString());
	}

	@Test
	public void putLRTest() {
		AVLTree avl = new AVLTree(30, "thirty");
		avl.put(10, "ten");
		avl.put(20, "twenty");
		avl.put(15, "fifteen");
		ArrayList<Integer> keyList = avl.levelorder();
		System.out.println(keyList.toString());
	}

	@Test
	public void putRRtest() {
		AVLTree avl = new AVLTree(10, "ten");
		avl.put(30, "thirty");
		avl.put(60, "sixty");
		avl.put(90, "ninety");
		ArrayList<Integer> keyList = avl.levelorder();
		//System.out.println(keyList.toString());
	}

	@Test
	public void putRLtest() {
		AVLTree avl = new AVLTree(10, "ten");
		avl.put(30, "thirty");
		avl.put(20, "sixty");
		avl.put(25, "ninety");
		ArrayList<Integer> keyList = avl.levelorder();
		//System.out.println(keyList.toString());
	}


}
