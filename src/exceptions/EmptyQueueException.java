package exceptions;

/**
 * Empty queue exception
 * 
 * @author Jaeyoung Kim
 * 
 */
@SuppressWarnings("serial")
public class EmptyQueueException extends Exception {

	public EmptyQueueException()
	{
		super();
	}

	/**
	 * @param message error message specific to cause of error.
	 */
	public EmptyQueueException(String message)
	{
		super(message);
	}
}
