package utilities;

import exceptions.EmptyStackException;

/**
 * 
 * @author Jaeyoung Kim
 *
 * @param <E> Element
 */
@SuppressWarnings("serial")
public class MyStack<E> implements StackADT<E> {
	private MyArrayList<E> myArrayList;
	
	public MyStack() {
		this.myArrayList = new MyArrayList<E>();
	}

	@Override
	public void push(E e) {
		myArrayList.add(e);
	}

	@Override
	public E pop() throws EmptyStackException {
		return myArrayList.remove(myArrayList.size() - 1);
	}

	@Override
	public E peek() throws EmptyStackException {
		return myArrayList.get(myArrayList.size() - 1);
	}

	@Override
	public void clear() {
		myArrayList.clear();
	}

	@Override
	public boolean isEmpty() {
		return myArrayList.isEmpty();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean equals(StackADT that) {
		boolean equal = true;
		for (int i = 0; i < myArrayList.size() && !equal; i++) {
			if (myArrayList.get(i) != ((MyArrayList<E>) that).get(i)) {
				equal = false;
			}
		}
		return equal;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Iterator iterator() {
		return myArrayList.iterator();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() {
		return (E[]) myArrayList.toArray();
	}

	@Override
	public E[] toArray(E[] copy) {
		return myArrayList.toArray(copy);
	}

	@Override
	public int search(E e) {
		int index;
		String is;
		for (index = 0; index < myArrayList.size(); index++) {
			is = (String) myArrayList.get(index);
			if (e.equals((String) myArrayList.get(index))) {
				return index;				
			}
		}
		return -1;
	}

	@Override
	public boolean contains(E e) {
		return myArrayList.contains(e);
	}

	@Override
	public int size() {
		return myArrayList.size();
	}
}
