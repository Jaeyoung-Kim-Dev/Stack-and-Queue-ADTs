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

/**
 * Tests the MyArrayList.
 * 
 * @author kornk
 *
 */
class MyArrayListTests {
	private ListADT<Integer> list;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {
	}
		
	/**
	 * 	
	 */
	@Test
	public void testAdd() {
		int expected = 1;
		
		try {
			this.list.add(1);
			
			assertFalse(this.list.isEmpty());
			
			int actual = this.list.get(0);
			assertEquals(expected, actual);	
		} catch (NullPointerException e) {
			fail("");
		} catch (IndexOutOfBoundsException e) {
			fail("");
		}
		
	}
	
	/**
	 * 	
	 */
	@Test
	public void testAddInvalid() {
		
		assertTrue(this.list.isEmpty());
		
		try {
			int actual = this.list.get(0);	
			
			fail("List is not empty");
		} catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	
	/**
	 * 	
	 */
	@Test
	public void testAppending() {
		//fail("Not yet implemented");
	}
	
	/**
	 * 	
	 */
	@Test
	public void testReplacing() {
		//fail("Not yet implemented");
	}
	
	/**
	 * 	
	 */
	@Test
	public void testClearingAll() {
		//fail("Not yet implemented");
	}
	
	/**
	 * 	
	 */
	@Test
	public void testGetting() {
		//fail("Not yet implemented");
	}
	
	/**
	 * 	
	 */
	@Test
	public void testFinding() {
		//fail("Not yet implemented");
	}
	
	

}
