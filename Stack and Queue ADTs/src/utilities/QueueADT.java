/**
 * 
 */
package utilities;

import java.io.Serializable;

/**
 * @author Jaeyoung Kim
 * @param <E>
 *
 */
public interface QueueADT<E> extends Serializable {

	
	/**
	 * Mutator method to 'add to the tail of the queue
	 * 
	 * Precondition: A valid Queue object exists and an integer value is passed.
	 * 
	 * Postcondition:
	 * 
	 * @param o
	 */
	public void enqueue(E o);
	
	/**
	 * Mutator method to 'remove from the head of the queue
	 * 
	 * Precondition: A valid Queue object exists and an integer value is passed.
	 * 
	 * Postcondition:
	 * 
	 * @return
	 */
	public E dequeue();
	
	/**
	 * Accessor method to 'look at the element at the head of the queue
	 *
	 * Precondition: A valid Queue object exists and an integer value is passed.
	 * 
	 * Postcondition:
	 * 
	 * @return
	 */
	public E peek();
	
	/**
	 * Accessor method to 'Checks if the queue is empty.
	 * 
	 * Precondition: A valid Queue object exists and an integer value is passed.
	 * 
	 * Postcondition:
	 * 
	 * @return
	 */
	public boolean isEmpty(); 
	
	/**
	 * Accessor method to 'only if queue is of static capacity
	 * 
	 * Precondition: A valid Queue object exists and an integer value is passed.
	 * 
	 * Postcondition:
	 * 
	 * @return
	 */
	public boolean isFull();
	
	/**
	 * Mutator method to 'clear all elements from the queue
	 * 
	 * Precondition: A valid Queue object exists and an integer value is passed.
	 * 
	 * Postcondition:
	 * 
	 */
	public void dequeueAll();
	
	/**
	 * To be equal two stacks must contain equal items appearing in the same order.
	 * 
	 * Precondition: A valid Queue object exists and an integer value is passed.
	 * 
	 * Postcondition:
	 * 
	 * @param that
	 * @return
	 */
	public boolean equals(QueueADT<E> that);
	
	/**
	 *
	 * Precondition: A valid Queue object exists and an integer value is passed.
	 * 
	 * Postcondition:
	 * 
	 * @return
	 */
	public Object[] toArray();
	
	/**
	 * 
	 * 
	 * Precondition: A valid Queue object exists and an integer value is passed.
	 * 
	 * Postcondition:
	 * 
	 * @param copy
	 * @return
	 */
	public E[] toArray(E[] copy);
	
	/**
	 * 
	 * 
	 * Precondition: A valid Queue object exists and an integer value is passed.
	 * 
	 * Postcondition:
	 * 
	 * @return
	 */
	public Iterator<E> iterator();	
}
