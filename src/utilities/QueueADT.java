/**
 * 
 */
package utilities;

import java.io.Serializable;

/**
 * The queue data type operations for a queue.
 * 
 * @author Jaeyoung Kim
 * 
 */
public interface QueueADT<E> extends Serializable {
	/**
	 * Mutator method to add to the tail of the queue.
	 * 
	 * Precondition: A valid Queue object exists and an element is passed.
	 * 
	 * Postcondition: Element is inserted to the tail of the queue.
	 * 
	 * @param e Element which is needed to be inserted.
	 */
	public void enqueue(E e);
	
	/**
	 * Mutator method to remove from the head of the queue.
	 * 
	 * Precondition: A valid Queue object exists.
	 * 
	 * Postcondition: It removes from the head of the queue and return the element.
	 * 
	 * @return Element removed from the head of the queue.
	 */
	public E dequeue();
	
	/**
	 * Accessor method to look at the element at the head of the queue.
	 *
	 * Precondition: A valid Queue object exists.
	 * 
	 * Postcondition: It returns the element at the head of the queue.
	 * 
	 * @return Element at the head of the queue.
	 */
	public E peek();
	
	/**
	 * Accessor method to check if the queue is empty.
	 * 
	 * Precondition: A valid Queue object exists.
	 * 
	 * Postcondition: It returns true if the queue is empty otherwise it returns False.
	 * 
	 * @return True if stack has nothing in it.
	 */
	public boolean isEmpty(); 
	
	/**
	 * Accessor method to only if queue is of static capacity.
	 * 
	 * Precondition: A valid Queue object exists.
	 * 
	 * Postcondition: It returns true if queue is of static capacity otherwise it returns False.
	 * 
	 * @return True if queue is of static capacity.
	 */
	public boolean isFull();
	
	/**
	 * Mutator method to clear all elements from the queue.
	 * 
	 * Precondition: A valid Queue object exists.
	 * 
	 * Postcondition: Queue is empty.
	 * 
	 */
	public void dequeueAll();
	
	/**
	 * Accessor method to check if two queues contain equal items appearing in the
	 * same order.
	 * 
	 * Precondition: A valid Queue object exists and a queue is passed.
	 * 
	 * Postcondition: It returns true if two queues contain equal items appearing in
	 * the same order otherwise it returns False.
	 * 
	 * @param that Queue which is needed to be compared.
	 * @return True if two queues contain equal items appearing in the same order.
	 */
	public boolean equals(QueueADT<E> that);
	
	/**
	 * Returns an array containing all of the items in this queue.
	 *
	 * Precondition: A valid Queue object exists.
	 * 
	 * Postcondition: It returns an array containing all of the items in this queue.
	 * 
	 * @return Array containing all of the items in this queue.
	 */
	public Object[] toArray();
	
	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence. The runtime type of the returned array is that of the specified
	 * array.
	 * 
	 * Precondition: A valid Queue object exists and an array is passed.
	 * 
	 * Postcondition: It returns an array containing all of the elements in this
	 * list in proper sequence
	 * 
	 * @param copy Array into which the elements of the queue are to be stored.
	 * @return array containing all of the elements in this list in proper sequence
	 */
	public E[] toArray(E[] copy);
	
	/**
	 * Returns an iterator over the items contained in this stack.
	 * 
	 * Precondition: A valid Queue object exists and an element is passed.
	 * 
	 * Postcondition: It returns an iterator over the items contained in this stack.
	 * 
	 * @return Iterator over the items contained in this stack
	 */
	public Iterator<E> iterator();	
}
