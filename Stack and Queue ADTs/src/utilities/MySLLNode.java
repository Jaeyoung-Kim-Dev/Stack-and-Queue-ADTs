/**
 * 
 */
package utilities;

import java.io.Serializable;

/**
 * @author kornk
 *
 */
public class MySLLNode {

	private Object data;

	private MySLLNode next;

	/**
	 * Creates a new node.
	 * @param data Data in a node.
	 */
	public MySLLNode(Object data) 
	{
		this.data = data;
	}

	/**
	 * Gets the data in the node.
	 * @return Object data
	 */
	public Object getData() 
	{
		return data;
	}

	/**
	 * Sets the data in the node.
	 * @param data New data to set.
	 */
	public void setData(Object data) 
	{
		this.data = data;
	}

	/**
	 * Gets the next node or null (if there is no next node).
	 * @return Next node.
	 */
	public MySLLNode getNext() 
	{
		return next;
	}

	/**
	 * Sets the next node.
	 * @param next node to set.
	 */
	public void setNext(MySLLNode next) 
	{
		this.next = next;
	}
}
