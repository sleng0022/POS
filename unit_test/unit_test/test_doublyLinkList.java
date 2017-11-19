package unit_test;
import static org.junit.Assert.*;

import org.junit.Test;

import common.DoublyLinkList;
import common.EmptyExceptions;

public class test_doublyLinkList {

	@Test
	public final void test() throws EmptyExceptions 
	{
		DoublyLinkList <Integer> queue = new DoublyLinkList<Integer>();
		queue.insertLast(10);
		queue.insertLast(20);
		queue.insertLast(30);
		queue.insertLast(40);
		queue.removeFirst();
		queue.removeFirst();
		assertEquals(30, (int)queue.getHead());
		assertEquals(0, queue.searItemForward(10));
		assertEquals(1, queue.searItemForward(30));
		assertEquals(1, queue.searItemBackward(30));
		assertEquals(2, queue.size());
		
		DoublyLinkList <Integer> stack = new DoublyLinkList<Integer>();
		stack.insertLast(10);
		stack.insertLast(20);
		stack.insertLast(30);
		stack.insertLast(40);
		stack.removeLast();
		stack.removeLast();
		assertEquals(20, (int)stack.getTail());
	}

}
