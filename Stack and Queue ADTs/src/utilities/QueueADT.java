/**
 * 
 */
package utilities;

import java.io.Serializable;

/**
 * @author kornk
 * @param <E>
 *
 */
public interface QueueADT<E> extends Serializable {

	
	/**
	 * add to the tail of the queue
	 * 
	 * Precondition:
	 * 
	 * Postcondition:
	 * 
	 * @param o
	 */
	public void enqueue(E o);
	
	/**
	 * remove from the head of the queue
	 * 
	 * Precondition:
	 * 
	 * Postcondition:
	 * 
	 * @return
	 */
	public E dequeue();
	
	/**
	 * look at the element at the head of the queue
	 *
	 * Precondition:
	 * 
	 * Postcondition:
	 * 
	 * @return
	 */
	public E peek();
	
	/**
	 * Checks if the queue is empty.
	 * 
	 * Precondition:
	 * 
	 * Postcondition:
	 * 
	 * @return
	 */
	public boolean isEmpty(); 
	
	/**
	 * only if queue is of static capacity
	 * 
	 * Precondition:
	 * 
	 * Postcondition:
	 * 
	 * @return
	 */
	public boolean isFull();
	
	/**
	 * clear all elements from the queue
	 * 
	 * Precondition:
	 * 
	 * Postcondition:
	 * 
	 */
	public void dequeueAll();
	
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
	public boolean equals(QueueADT<E> that);
	
	/**
	 * 
	 * @return
	 */
	public Object[] toArray();
	
	/**
	 * 
	 * @param copy
	 * @return
	 */
	public E[] toArray(E[] copy);
	
	/**
	 * 
	 * @return
	 */
	public Iterator<E> iterator();	
}
