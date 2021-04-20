/**
 * 
 */
package utilities;

import java.util.NoSuchElementException;

/**
 * @author Jaeyoung Kim
 *
 */
public class MySLLIterator<E> implements Iterator<E> {
	private int position;
	private MySLL<E> mySLL;
	
	/**
	 * @param mySLL mySLL
	 */
	public MySLLIterator(MySLL<E> mySLL) {
		this.mySLL = mySLL;
	}

	@Override
	public boolean hasNext() {
		boolean inBounds = this.position < this.mySLL.size() - 1;
	       
		return inBounds;
	}

	@Override
	public E next() throws NoSuchElementException {
		if (!this.hasNext())
			throw new NoSuchElementException();
		
		this.position++;
		
		E item = this.mySLL.get(this.position);
		
		return item;
	}

}
