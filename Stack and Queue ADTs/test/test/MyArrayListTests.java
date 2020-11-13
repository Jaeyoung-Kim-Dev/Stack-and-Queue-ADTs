/**
 * ANNOTATIONS:
 * @Test -  The annotation @Test identifies that a method is a test method. 
 * @Ignore - Will ignore the test method. This is useful when the underlying code has been changed and 
 * 		the test case has not yet been adapted. Or if the execution time of this test is too long to be included. 
 * @Test(expected=Exception.class) - Fails, if the method does not throw the named exception. 
 * @Test(timeout=100) - Fails, if the method takes longer than 100 milliseconds.
 * 
 * ASSERTS: [] = optional message to display
 * fail([String]) - Let the method fail. Might be used to check that a certain part of the code is not reached. 
 * 		Or to have failing test before the test code is implemented.
 * assertTrue(boolean) - Will always be true/false. Can be used to predefine a test result, 
 * 		if the test is not yet implemented.
 * assertTrue([String], boolean condition) - Checks that the boolean condition is true.
 * assertsEquals([String], expected, actual) - Tests that two values are the same. 
 * 		Note: for arrays the reference is checked not the content of the arrays.
 * assertsEquals([String], expected, actual, tolerance) - Test that float or double values match. 
 * 		The tolerance is the number of decimals which must be the same.
 * assertNull([String], object) - Checks that the object is null.
 * assertNotNull([String], object) - Checks that the object is not null.
 * assertSame([String], expected, actual) - Checks that both variables refer to the same object.
 * assertNotSame([String], expected, actual) - Checks that both variables refer to different objects. 
 * 
 * For a list of all test classes - check out http://junit.org/javadoc/latest/
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.ListADT;
import utilities.MyArrayList;

/**
 * Tests the MyArrayList.
 * 
 * @author Jaeyoung Kim
 *
 */
class MyArrayListTests {
	private MyArrayList<String> myArrayListString;
	private MyArrayList<Integer> myArrayListInt;

	/**
	 * @Before - Will execute the method before each test. This method can prepare
	 *         the test environment (e.g. read input data, initialize the class).
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		myArrayListString = new MyArrayList<>();
		myArrayListInt = new MyArrayList<>();
	}

	/**
	 * @After - Will execute the method after each test. This method can cleanup the
	 *        test environment (e.g. delete temporary data, restore defaults).
	 * 
	 * @throws java.lang.Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {
		myArrayListString.clear();
		myArrayListInt.clear();
	}
	
	/**
	 * Adding an element at the end of the list.
	 */
	@Test
	public void testAppend() {
		this.myArrayListString.add("a");
		this.myArrayListString.add("b");
		this.myArrayListString.add("c");
		this.myArrayListString.add("d");

		try {
			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> c -> d
			 */

			// Test the linked list is not empty.
			assertFalse(this.myArrayListString.isEmpty());

			// Test the size is 4
			assertEquals(4, myArrayListString.size());

			// Test the values as per index
			assertEquals("a", myArrayListString.get(0));
			assertEquals("b", myArrayListString.get(1));
			assertEquals("c", myArrayListString.get(2));
			assertEquals("d", myArrayListString.get(3));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 	Adding an element at index - pass
	 */
	@Test
	public void testAdd() {
		this.myArrayListString.add("a");
		this.myArrayListString.add("b");
		this.myArrayListString.add("c");
		this.myArrayListString.add("d");

		try {			
			
			this.myArrayListString.add(2, "e");
			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> e -> c -> d
			 */

			// Test the linked list is not empty.
			assertFalse(this.myArrayListString.isEmpty());

			// Test the size is 5
			assertEquals(5, myArrayListString.size());			

			// Test the values as per index
			assertEquals("a", myArrayListString.get(0));
			assertEquals("b", myArrayListString.get(1));
			assertEquals("e", myArrayListString.get(2));
			assertEquals("c", myArrayListString.get(3));
			assertEquals("d", myArrayListString.get(4));

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
		this.myArrayListString.add("a");
		this.myArrayListString.add("b");
		this.myArrayListString.add("c");
		this.myArrayListString.add("d");

		try {
			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> c -> d
			 */
			
			assertEquals("c", myArrayListString.set(2, "e"));
			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> e -> d
			 */

			// Test the linked list is not empty.
			assertFalse(this.myArrayListString.isEmpty());

			// Test the size is 4
			assertEquals(4, myArrayListString.size());

			// Test the values as per index
			assertEquals("a", myArrayListString.get(0));
			assertEquals("b", myArrayListString.get(1));
			assertEquals("e", myArrayListString.get(2));
			assertEquals("d", myArrayListString.get(3));

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
		this.myArrayListString.add("a");
		this.myArrayListString.add("b");
		this.myArrayListString.add("c");
		this.myArrayListString.add("d");

		try {
			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> c -> d
			 */

			// Test the linked list is not empty.
			assertFalse(this.myArrayListString.isEmpty());

			// Test the size is 4
			assertEquals(4, myArrayListString.size());

			// Test the values as per index
			assertEquals("a", myArrayListString.get(0));
			assertEquals("b", myArrayListString.get(1));
			assertEquals("c", myArrayListString.get(2));
			assertEquals("d", myArrayListString.get(3));

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
		this.myArrayListString.add("a");
		this.myArrayListString.add("b");
		this.myArrayListString.add("c");
		this.myArrayListString.add("d");

		try {
			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> c -> d
			 */

			// Test the linked list is not empty.
			assertFalse(this.myArrayListString.isEmpty());

			// Test the size is 4
			assertEquals(4, myArrayListString.size());

			// Test the values as per index
			assertEquals("a", myArrayListString.get(0));
			assertEquals("b", myArrayListString.get(1));
			assertEquals("c", myArrayListString.get(2));
			assertEquals("d", myArrayListString.get(3));

			// Elements existing in the list
			assertEquals(true, myArrayListString.contains("a"));
			assertEquals(true, myArrayListString.contains("b"));
			assertEquals(true, myArrayListString.contains("c"));
			assertEquals(true, myArrayListString.contains("d"));

			// Elements doesn't exist in the list
			assertEquals(false, myArrayListString.contains("e"));

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
		this.myArrayListString.add("a");
		this.myArrayListString.add("b");
		this.myArrayListString.add("c");
		this.myArrayListString.add("d");

		try {
			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> c -> d
			 */

			// Test the linked list is not empty.
			assertFalse(this.myArrayListString.isEmpty());

			// Test the size is 4
			assertEquals(4, myArrayListString.size());

			// Test the values as per index
			assertEquals("a", myArrayListString.get(0));
			assertEquals("b", myArrayListString.get(1));
			assertEquals("c", myArrayListString.get(2));
			assertEquals("d", myArrayListString.get(3));

			// Remove the element at index 2
			myArrayListString.remove(2);

			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> d
			 */

			// Test the size is 3
			assertEquals(3, myArrayListString.size());

			// Test the values as per index
			assertEquals("a", myArrayListString.get(0));
			assertEquals("b", myArrayListString.get(1));
			assertEquals("d", myArrayListString.get(2));

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
		this.myArrayListString.add("a");
		this.myArrayListString.add("b");
		this.myArrayListString.add("c");
		this.myArrayListString.add("d");

		try {
			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> c -> d
			 */

			// Test the linked list is not empty.
			assertFalse(this.myArrayListString.isEmpty());

			// Test the size is 4
			assertEquals(4, myArrayListString.size());

			// Test the values as per index
			assertEquals("a", myArrayListString.get(0));
			assertEquals("b", myArrayListString.get(1));
			assertEquals("c", myArrayListString.get(2));
			assertEquals("d", myArrayListString.get(3));

			// Remove the element the element "c"
			myArrayListString.remove("c");

			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> d
			 */

			// Test the size is 3
			assertEquals(3, myArrayListString.size());

			// Test the values as per index
			assertEquals("a", myArrayListString.get(0));
			assertEquals("b", myArrayListString.get(1));
			assertEquals("d", myArrayListString.get(2));

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
		this.myArrayListString.add("a");
		this.myArrayListString.add("b");
		this.myArrayListString.add("c");
		this.myArrayListString.add("d");

		try {
			/**
			 * Linked list should now be:
			 * 
			 * a -> b -> c -> d
			 */

			// Test the linked list is not empty.
			assertFalse(this.myArrayListString.isEmpty());

			// Test the size is 4
			assertEquals(4, myArrayListString.size());

			// Clear elements in the list
			myArrayListString.clear();

			// Test the linked list is empty.
			assertTrue(this.myArrayListString.isEmpty());

			// Test the size is 0
			assertEquals(0, myArrayListString.size());

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
