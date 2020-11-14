package utilities;

/**
 * 
 * @author Jaeyoung Kim
 *
 * @param <E>
 */
@SuppressWarnings("serial")
public class MyQueue<E> implements QueueADT<E> {
	private MySLL<E> mySLL;

	/**
	 * @param myArrayList
	 */
	public MyQueue() {
		this.mySLL = new MySLL<E>();
	}

	@Override
	public void enqueue(E e) {
		mySLL.add(e);		
	}

	@Override
	public E dequeue() {
		return mySLL.remove(0);
	}

	@Override
	public E peek() {		
		return mySLL.get(0);
	}

	@Override
	public boolean isEmpty() {
		return mySLL.isEmpty();
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public void dequeueAll() {
		mySLL.clear();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(QueueADT<E> that) {
		boolean equal = true;		
		for (int i =0; i < mySLL.size() && !equal; i++) {
			if (mySLL.get(i) != ((MySLL<E>) that).get(i)) {
				equal = false;
			}
		}				
		return equal;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() {		
		return (E[]) mySLL.toArray();
	}

	@Override
	public E[] toArray(E[] copy) {
		return (E[]) mySLL.toArray(copy);
	}

	@Override
	public Iterator<E> iterator() {
		return mySLL.iterator();
	}

}
