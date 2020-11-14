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
	public E pop() throws EmptyStackException;

	/**
	 * Returns the topmost element in a stack without removing it.
	 * 
	 * Precondition:
	 * 
	 * Postcondition:
	 * 
	 * @return Element at the top of the stack.
	 * 
	 * @throws EmptyStackException Thrown if stack has nothing to pop.
	 */
	public E peek() throws EmptyStackException;

	/**
	 * Makes a stack empty.
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
	 * To be equal two stacks must contain equal items appearing in the same order.
	 * 
	 * Precondition:
	 * 
	 * Postcondition:
	 * 
	 * @param that
	 * @return
	 */
	public boolean equals(StackADT<E> that);

	/**
	 * Returns an iterator over the items contained in this stack. The iterator¡¯s
	 * remove() method is not supported because it violates a stack¡¯s basic
	 * contract.
	 * 
	 * Precondition:
	 * 
	 * Postcondition:
	 * 
	 * @return
	 */
	public Iterator<E> iterator();

	/**
	 * Return an array containing all of the items in this stack. The top of the
	 * stack corresponds to the first element of the array.
	 * 
	 * Precondition:
	 * 
	 * Postcondition:
	 * 
	 * @return
	 */
	public Object[] toArray();

	/**
	 * 
	 * Precondition:
	 * 
	 * Postcondition:
	 * 
	 * @param copy
	 * @return
	 */
	public E[] toArray(E[] copy);

	/**
	 * Returns the position of an Element on the stack, with the top most Element
	 * being at position 1, and each Element deeper in the stack at depth + 1.
	 * 
	 * Precondition:
	 * 
	 * Postcondition:
	 * 
	 * @param o
	 * @return
	 */
	public int search(E o);

	/**
	 * 
	 * Precondition:
	 * 
	 * Postcondition:
	 * 
	 * @param o
	 * @return
	 */
	public boolean contains(E o);

	/**
	 * How many elements are there?
	 * 
	 * Precondition:
	 * 
	 * Postcondition:
	 * 
	 * @return
	 */
	public int size();

}

//E[] items = (E[])new Object[size];
