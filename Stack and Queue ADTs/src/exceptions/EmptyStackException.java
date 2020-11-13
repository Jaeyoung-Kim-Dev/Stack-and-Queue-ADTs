package exceptions;

/**
 * Empty stack exception
 * 
 * @author Jaeyoung Kim
 * 
 */
@SuppressWarnings("serial")
public class EmptyStackException extends Exception {

	public EmptyStackException()
	{
		super();
	}

	/**
	 * @param message error message specific to cause of error.
	 */
	public EmptyStackException(String message)
	{
		super(message);
	}
}
