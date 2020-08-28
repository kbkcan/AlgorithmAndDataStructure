package list;

import static org.junit.Assert.*;

import list.queue.ArrayQueue;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayQueueTest {

	static ArrayQueue queue;
	
	@BeforeClass
	public static void testArrayQueue() {
		queue = new ArrayQueue<String>();
	}

	@Test
	public void testAdd() {
		queue.add("1");
		queue.add("2");
		queue.add("3");
		queue.add("4");
		assertTrue(queue.size()==4);
	}

	@Test
	public void testRemove() {
		queue.add("1");
		queue.add("2");
		queue.add("3");
		queue.add("4");
		assertTrue(queue.remove().equals("1"));
	}

}
