/**
 * 
 */
package utilities;

import java.io.Serializable;

import exceptions.EmptyStackException;

/**
 * The stack data type operations for a stack.
 * 
 * @author Jaeyoung Kim
 *
 */
public interface StackADT<E> extends Serializable {
	/**
	 * Pushes an element to the top of the stack.
	 * 
	 * Precondition:
	 * 
     * Postcondition:
	 * 
	 * @param e Element
	 */
	public void push(E e);

	/**
	 * Remove and returns the element at the top of the stack
	 * 
	 * Precondition:
	 * 
     * Postcondition:
     * 
	 * @return Element removed from Top of the stack.
	 *
	 * @throws EmptyStackException Thrown if stack has nothing to pop.
	 */
	public E Epop() throws EmptyStackException;

	/**
	 * Returns the element at the top of the stack without removing it from the stack.
	 * 
	 * Precondition:
	 * 
     * Postcondition:
	 * 
	 * @return Element at the top of the stack.
	 * 
	 * @throws EmptyStackException Thrown if stack has nothing to pop.
	 */
	public E peek( ) throws EmptyStackException;

	/**
	 * 
	 * Precondition:
	 * 
     * Postcondition:
     * 
	 * Clears everything from the stack.
	 */
	public void clear();

	/**
	 * Checks if the stack is empty.
	 * 
	 * Precondition:
	 * 
     * Postcondition:
     * 
	 * @return True if stack has nothing in it.
	 */
	public boolean isEmpty();
	
	
	
	
	
	
	
	/**
	 * How many elements are there?
	 * 
	 * @param e Element
	 */
	public void size(E e);

	// public void boolean equals( StackADT<E> that)

}


//E[] items = (E[])new Object[size];
