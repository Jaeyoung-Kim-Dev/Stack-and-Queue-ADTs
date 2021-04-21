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
	 * Mutator method to push an element to the top of the stack.
	 * 
	 * Precondition: A valid Stack object exists and an element is passed.
	 * 
	 * Postcondition: Element is inserted to the top of the stack.
	 * 
	 * @param e Element which is needed to be inserted.
	 */
	public void push(E e);

	/**
	 * Mutator method to remove and returns the element at the top of the stack.
	 * 
	 * Precondition: A valid Stack object exists.
	 * 
	 * Postcondition: Element at the top of the stack is removed and returned.
	 * 
	 * @return Element removed from Top of the stack.
	 *
	 * @throws EmptyStackException Thrown if stack has nothing to pop.
	 */
	public E pop() throws EmptyStackException;

	/**
	 * Accessor method to return the topmost element in a stack without removing it.
	 * 
	 * Precondition: A valid Stack object exists.
	 * 
	 * Postcondition: The topmost element is returned without removing it.
	 * 
	 * @return Element at the top of the stack.
	 * 
	 * @throws EmptyStackException Thrown if stack has nothing to pop.
	 */
	public E peek() throws EmptyStackException;

	/**
	 * Mutator method to make a stack empty.
	 * 
	 * Precondition: A valid Stack object exists.
	 * 
	 * Postcondition: Stack is empty.
	 * 
	 */
	public void clear();

	/**
	 * Accessor method to check if the stack is empty.
	 * 
	 * Precondition: A valid Stack object exists.
	 * 
	 * Postcondition: It returns true if stack is empty otherwise it returns False.
	 * 
	 * @return True if stack has nothing in it.
	 */
	public boolean isEmpty();

	/**
	 * Accessor method to check if two stacks contain equal items appearing in the
	 * same order.
	 * 
	 * Precondition: A valid Stack object exists and a stack is passed.
	 * 
	 * Postcondition: It returns true if two stacks contain equal items appearing in
	 * the same order otherwise it returns False.
	 * 
	 * @param that Stack which is needed to be compared.
	 * @return True if two stacks contain equal items appearing in the same order
	 */
	public boolean equals(StackADT<E> that);

	/**
	 * Returns an iterator over the items contained in this stack.
	 * 
	 * Precondition: A valid Stack object exists.
	 * 
	 * Postcondition: It returns an iterator over the items contained in this stack.
	 * 
	 * @return Iterator over the items contained in this stack
	 */
	public Iterator<E> iterator();

	/**
	 * Returns an array containing all of the items in this stack. The top of the
	 * stack corresponds to the first element of the array.
	 * 
	 * Precondition: A valid Stack object exists.
	 * 
	 * Postcondition: It returns an array containing all of the items in this stack.
	 * 
	 * @return Array containing all of the items in this stack
	 */
	public Object[] toArray();

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence. The runtime type of the returned array is that of the specified
	 * array.
	 * 
	 * Precondition: A valid Stack object exists and an array is passed.
	 * 
	 * Postcondition: It returns an array containing all of the elements in this
	 * list in proper sequence
	 * 
	 * @param copy Array into which the elements of the Stack are to be stored.
	 * @return array containing all of the elements in this list in proper sequence
	 */
	public E[] toArray(E[] copy);

	/**
	 * Accessor method to return the position of an Element on the stack, with the
	 * topmost Element being at position 1, and each Element deeper in the stack at
	 * depth + 1.
	 * 
	 * Precondition: A valid Stack object exists and an element is passed.
	 * 
	 * Postcondition: It returns the position of an Element on the stack.
	 * 
	 * @param e Element to be searched.
	 * @return the position of an Element on the stack
	 */
	public int search(E e);

	/**
	 * Accessor method to check whether a specific element is present in the Stack
	 * or not.
	 * 
	 * Precondition: A valid Stack object exists and an element is passed.
	 * 
	 * Postcondition: It returns true if a specific element is present in the Stack
	 * otherwise it returns False.
	 * 
	 * @param e element that needs to be tested if it is present in the Stack or not
	 * @return True if the element is present in the Stack otherwise it returns
	 *         False.
	 */
	public boolean contains(E e);

	/**
	 * Accessor method to return the number of Elements on the stack.
	 * 
	 * Precondition: A valid Stack object exists.
	 * 
	 * Postcondition: It returns the number of Elements on the stack.
	 * 
	 * @return the number of Elements on the stack
	 */
	public int size();
}