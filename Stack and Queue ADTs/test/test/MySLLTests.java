/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.MyArrayList;
import utilities.MySLL;

/**
 * @author kornk
 *
 */
class MySLLTests {
	private MySLL<String> mySSLString;
	private MySLL<Integer> mySSLInt;

	/**
	 * @Before - Will execute the method before each test. This method can prepare
	 *         the test environment (e.g. read input data, initialize the class).
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		mySSLString = new MySLL<>();
		mySSLInt = new MySLL<>();
	}

	/**
	 * @After - Will execute the method after each test. This method can cleanup the
	 *        test environment (e.g. delete temporary data, restore defaults).
	 * 
	 * @throws java.lang.Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {
		mySSLString.clear();
		mySSLInt.clear();
	}

	/**
	 * Adding an element at the end of the list.
	 */
	@Test
	public void testAppend() {
		this.mySSLString.add("a");
		this.mySSLString.add("b");
		this.mySSLString.add("c");
		this.mySSLString.add("d");

		try {
			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> c -> d
			 */

			// Test the linked list is not empty.
			assertFalse(this.mySSLString.isEmpty());

			// Test the size is 4
			assertEquals(4, mySSLString.size());

			// Test the values as per index
			assertEquals("a", mySSLString.get(0));
			assertEquals("b", mySSLString.get(1));
			assertEquals("c", mySSLString.get(2));
			assertEquals("d", mySSLString.get(3));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Adding an element at index
	 */
	@Test
	public void testAdd() {
		this.mySSLString.add("a");
		this.mySSLString.add("b");
		this.mySSLString.add("c");
		this.mySSLString.add("d");

		try {			
			
			mySSLString.add(2, "e");
			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> e -> c -> d
			 */

			// Test the linked list is not empty.
			assertFalse(this.mySSLString.isEmpty());

			// Test the size is 5
			assertEquals(5, mySSLString.size());

			// Test the values as per index
			assertEquals("a", mySSLString.get(0));
			assertEquals("b", mySSLString.get(1));
			assertEquals("e", mySSLString.get(2));
			assertEquals("c", mySSLString.get(3));
			assertEquals("d", mySSLString.get(4));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Replacing an element at index
	 */
	@Test
	public void testReplace() {
		this.mySSLString.add("a");
		this.mySSLString.add("b");
		this.mySSLString.add("c");
		this.mySSLString.add("d");

		try {
			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> c -> d
			 */
			
			assertEquals("c", mySSLString.set(2, "e"));
			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> e -> d
			 */

			// Test the linked list is not empty.
			assertFalse(this.mySSLString.isEmpty());

			// Test the size is 4
			assertEquals(4, mySSLString.size());

			// Test the values as per index
			assertEquals("a", mySSLString.get(0));
			assertEquals("b", mySSLString.get(1));
			assertEquals("e", mySSLString.get(2));
			assertEquals("d", mySSLString.get(3));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Getting an element
	 */
	@Test
	public void testGet() {
		this.mySSLString.add("a");
		this.mySSLString.add("b");
		this.mySSLString.add("c");
		this.mySSLString.add("d");

		try {
			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> c -> d
			 */

			// Test the linked list is not empty.
			assertFalse(this.mySSLString.isEmpty());

			// Test the size is 4
			assertEquals(4, mySSLString.size());

			// Test the values as per index
			assertEquals("a", mySSLString.get(0));
			assertEquals("b", mySSLString.get(1));
			assertEquals("c", mySSLString.get(2));
			assertEquals("d", mySSLString.get(3));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Getting an element
	 */
	@Test
	public void testFind() {
		this.mySSLString.add("a");
		this.mySSLString.add("b");
		this.mySSLString.add("c");
		this.mySSLString.add("d");

		try {
			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> c -> d
			 */

			// Test the linked list is not empty.
			assertFalse(this.mySSLString.isEmpty());

			// Test the size is 4
			assertEquals(4, mySSLString.size());

			// Test the values as per index
			assertEquals("a", mySSLString.get(0));
			assertEquals("b", mySSLString.get(1));
			assertEquals("c", mySSLString.get(2));
			assertEquals("d", mySSLString.get(3));

			// Elements existing in the list
			assertEquals(true, mySSLString.contains("a"));
			assertEquals(true, mySSLString.contains("b"));
			assertEquals(true, mySSLString.contains("c"));
			assertEquals(true, mySSLString.contains("d"));

			// Elements doesn't exist in the list
			assertEquals(false, mySSLString.contains("e"));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Getting an element
	 */
	@Test
	public void testRemoveIndex() {
		this.mySSLString.add("a");
		this.mySSLString.add("b");
		this.mySSLString.add("c");
		this.mySSLString.add("d");

		try {
			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> c -> d
			 */

			// Test the linked list is not empty.
			assertFalse(this.mySSLString.isEmpty());

			// Test the size is 4
			assertEquals(4, mySSLString.size());

			// Test the values as per index
			assertEquals("a", mySSLString.get(0));
			assertEquals("b", mySSLString.get(1));
			assertEquals("c", mySSLString.get(2));
			assertEquals("d", mySSLString.get(3));

			// Remove the element at index 2
			mySSLString.remove(2);

			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> d
			 */

			// Test the size is 3
			assertEquals(3, mySSLString.size());

			// Test the values as per index
			assertEquals("a", mySSLString.get(0));
			assertEquals("b", mySSLString.get(1));
			assertEquals("d", mySSLString.get(2));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Getting an element
	 */
	@Test
	public void testRemoveElement() {
		this.mySSLString.add("a");
		this.mySSLString.add("b");
		this.mySSLString.add("c");
		this.mySSLString.add("d");

		try {
			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> c -> d
			 */

			// Test the linked list is not empty.
			assertFalse(this.mySSLString.isEmpty());

			// Test the size is 4
			assertEquals(4, mySSLString.size());

			// Test the values as per index
			assertEquals("a", mySSLString.get(0));
			assertEquals("b", mySSLString.get(1));
			assertEquals("c", mySSLString.get(2));
			assertEquals("d", mySSLString.get(3));

			// Remove the element the element "c"
			mySSLString.remove("c");

			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> d
			 */

			// Test the size is 3
			assertEquals(3, mySSLString.size());

			// Test the values as per index
			assertEquals("a", mySSLString.get(0));
			assertEquals("b", mySSLString.get(1));
			assertEquals("d", mySSLString.get(2));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Clearing elements in the list
	 */
	@Test
	public void testClear() {
		this.mySSLString.add("a");
		this.mySSLString.add("b");
		this.mySSLString.add("c");
		this.mySSLString.add("d");

		try {
			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> c -> d
			 */

			// Test the linked list is not empty.
			assertFalse(this.mySSLString.isEmpty());

			// Test the size is 4
			assertEquals(4, mySSLString.size());

			// Clear elements in the list
			mySSLString.clear();

			// Test the linked list is empty.
			assertTrue(this.mySSLString.isEmpty());

			// Test the size is 0
			assertEquals(0, mySSLString.size());

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 
	 */
	@Test
	public void testToArrayElement() {
		assertTrue(false);
		
	}
	
	/**
	 * 
	 */
	@Test
	public void testToArrayObject() {
		assertTrue(false);
		
	}

	/**
	 * 
	 */
	@Test
	public void testIterator() {
		assertTrue(false);
		
	}
}
