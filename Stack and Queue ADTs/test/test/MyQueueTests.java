/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.MyQueue;
import utilities.MyStack;

/**
 * @author Jaeyoung Kim
 *
 */
class MyQueueTests {
	private MyQueue<String> myQueueString;
	private MyQueue<Integer> myQueueInt;

	/**
	 * @Before - Will execute the method before each test. This method can prepare
	 *         the test environment (e.g. read input data, initialize the class).
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		myQueueString = new MyQueue<>();
		myQueueInt = new MyQueue<>();
	}

	/**
	 * @After - Will execute the method after each test. This method can cleanup the
	 *        test environment (e.g. delete temporary data, restore defaults).
	 * 
	 * @throws java.lang.Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {
		myQueueString.dequeueAll();
		myQueueInt.dequeueAll();
	}

	@Test
	void testEnqueue() {
		this.myQueueString.enqueue("a");
		this.myQueueString.enqueue("b");
		this.myQueueString.enqueue("c");
		this.myQueueString.enqueue("d");

		// Test the queue is not empty.
		assertFalse(this.myQueueString.isEmpty());

		// Test the values at the first
		assertEquals("a", myQueueString.peek());
	}

	@Test
	void testDequeue() {
		this.myQueueString.enqueue("a");
		this.myQueueString.enqueue("b");
		this.myQueueString.enqueue("c");
		this.myQueueString.enqueue("d");

		// Remove the first value
		this.myQueueString.dequeue();

		// Test the values at the first
		assertEquals("b", myQueueString.peek());
	}

	@Test
	void testPeek() {
		this.myQueueString.enqueue("a");
		this.myQueueString.enqueue("b");
		this.myQueueString.enqueue("c");
		this.myQueueString.enqueue("d");

		// Test the values at the first
		assertEquals("a", myQueueString.peek());
	}

	@Test
	void isEmpty() {
		// Test the stack is empty.
		assertTrue(this.myQueueString.isEmpty());

		this.myQueueString.enqueue("a");
		this.myQueueString.enqueue("b");
		this.myQueueString.enqueue("c");
		this.myQueueString.enqueue("d");

		// Test the stack is not empty.
		assertFalse(this.myQueueString.isEmpty());
	}

	@Test
	void isFull() {
		assertFalse(this.myQueueString.isFull());
	}

	@Test
	void testDequeueAll() {
		// Test the stack is empty.
		assertTrue(this.myQueueString.isEmpty());

		this.myQueueString.enqueue("a");
		this.myQueueString.enqueue("b");
		this.myQueueString.enqueue("c");
		this.myQueueString.enqueue("d");

		this.myQueueString.dequeueAll();
		
		// Test the stack is empty.
		assertTrue(this.myQueueString.isEmpty());
	}

	@Test
	void isEquals() {
		this.myQueueString.enqueue("a");
		this.myQueueString.enqueue("b");
		this.myQueueString.enqueue("c");
		this.myQueueString.enqueue("d");

		MyQueue<String> temp = new MyQueue<>();
		
		temp.enqueue("a");
		temp.enqueue("b");
		temp.enqueue("c");
		temp.enqueue("d");
		
		// Test the stack is not empty.
		assertTrue(this.myQueueString.equals(temp));
	}
	
	@Test
	void testToArrayElement() {
		String[] temp = { "a", "b" };

		this.myQueueString.enqueue("c");
		this.myQueueString.enqueue("d");

		Object[] myArrayString = myQueueString.toArray(temp);

		// Test the values as per index
		assertEquals("a", myArrayString[0]);
		assertEquals("b", myArrayString[1]);
	}
	
	@Test
	void testToArrayObject() {
		this.myQueueString.enqueue("a");
		this.myQueueString.enqueue("b");
		this.myQueueString.enqueue("c");
		this.myQueueString.enqueue("d");
		
		Object[] temp = this.myQueueString.toArray();
		
		// Test the index 2 is "c"
		assertEquals("c", temp[2]);
	}
	
	@Test
	void isFullInvalid() {
		assertTrue(!this.myQueueString.isFull());
	}
	
}
