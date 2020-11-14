/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.EmptyStackException;
import utilities.MyArrayList;
import utilities.MyStack;

/**
 * @author Jaeyoung Kim
 *
 */
class MyStackTests {
	private MyStack<String> myStackString;
	private MyStack<Integer> myStackInt;

	/**
	 * @Before - Will execute the method before each test. This method can prepare
	 *         the test environment (e.g. read input data, initialize the class).
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		myStackString = new MyStack<>();
		myStackInt = new MyStack<>();
	}

	/**
	 * @After - Will execute the method after each test. This method can cleanup the
	 *        test environment (e.g. delete temporary data, restore defaults).
	 * 
	 * @throws java.lang.Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {
		myStackString.clear();
		myStackInt.clear();
	}

	@Test
	void testPush() {
		this.myStackString.push("a");
		this.myStackString.push("b");
		this.myStackString.push("c");
		this.myStackString.push("d");

		// Test the stack is not empty.
		assertFalse(this.myStackString.isEmpty());

		// Test the size is 4
		assertEquals(4, myStackString.size());

	}

	@Test
	void testPop() {
		this.myStackString.push("a");
		this.myStackString.push("b");
		this.myStackString.push("c");
		this.myStackString.push("d");

		try {
			/**
			 * Stack should now be:
			 * 
			 * a -> b -> c -> d
			 */

			// Test the values as per index
			assertEquals("a", myStackString.pop());
			assertEquals("b", myStackString.pop());
			assertEquals("c", myStackString.pop());
			assertEquals("d", myStackString.pop());

		} catch (EmptyStackException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testPeek() {
		this.myStackString.push("a");
		this.myStackString.push("b");
		this.myStackString.push("c");
		this.myStackString.push("d");

		try {
			/**
			 * Stack should now be:
			 * 
			 * a -> b -> c -> d
			 */
			// Test the size is 4
			assertEquals(4, myStackString.size());

			assertEquals("a", myStackString.peek());

			// Test the size is still 4
			assertEquals(4, myStackString.size());

		} catch (EmptyStackException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testClear() {
		this.myStackString.push("a");
		this.myStackString.push("b");
		this.myStackString.push("c");
		this.myStackString.push("d");

		// Test the stack is not empty.
		assertFalse(this.myStackString.isEmpty());

		myStackString.clear();

		// Test the stack is empty.
		assertTrue(this.myStackString.isEmpty());
	}
	
	@Test
	void isEmpty() {
		// Test the stack is empty.
		assertTrue(this.myStackString.isEmpty());

		this.myStackString.push("a");
		this.myStackString.push("b");
		this.myStackString.push("c");
		this.myStackString.push("d");

		// Test the stack is not empty.
		assertFalse(this.myStackString.isEmpty());
	}

	@Test
	void isEquals() {
		this.myStackString.push("a");
		this.myStackString.push("b");
		this.myStackString.push("c");
		this.myStackString.push("d");

		MyStack<String> temp = new MyStack<>();
		
		temp.push("a");
		temp.push("b");
		temp.push("c");
		temp.push("d");
		
		// Test the stack is not empty.
		assertTrue(this.myStackString.equals(temp));
	}
	
	@Test
	void testToArray() {
		this.myStackString.push("a");
		this.myStackString.push("b");
		this.myStackString.push("c");
		this.myStackString.push("d");
		
		Object[] temp = this.myStackString.toArray();
		
		// Test the index 2 is "c"
		assertEquals("c", temp[2]);
	}
	
	@Test
	void testSearch() {
		this.myStackString.push("a");
		this.myStackString.push("b");
		this.myStackString.push("c");
		this.myStackString.push("d");
		
		// Test the index of "c" is 3
		assertEquals(3, myStackString.search("c"));
	}
	
	@Test
	void testContains() {
		this.myStackString.push("a");
		this.myStackString.push("b");
		this.myStackString.push("c");
		this.myStackString.push("d");
		
		// Test the stack is not empty.
		assertTrue(this.myStackString.contains("c"));
	}
	
	@Test
	void testSize() {
		// Test the size is 0
		assertEquals(0, myStackString.size());
		
		this.myStackString.push("a");
		this.myStackString.push("b");
		this.myStackString.push("c");
		this.myStackString.push("d");

		// Test the size is 4
		assertEquals(4, myStackString.size());
	}

}
