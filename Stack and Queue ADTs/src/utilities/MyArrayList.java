/**
 * 
 */
package utilities;

/**
 * @author kornk
 *
 */
public class MyArrayList<E> implements ListADT<E> {

	/**
	 * ArrayList for object.
	 */
	private Object[] arrayList;

	/**
	 * The number of elements in the array.
	 */
	private int size;

	/**
	 * @param arrayList
	 * @param size
	 */
	public MyArrayList() {
		this.size = 0;
		this.arrayList = new Object[this.size];
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void clear() {
		this.size = 0;
		arrayList = null;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		try {			
			this.size++;
			
			Object[] tempObjs = new Object[size];

			for (int i = 0; i < size; i++) {
				if (i < index) {
					tempObjs[i] = arrayList[i];
				} else if (i == index) {
					tempObjs[i] = toAdd;
				} else {
					tempObjs[i] = arrayList[i-1];
				}
			}

			arrayList = tempObjs;

			return true;
		} catch (NullPointerException e) {
			return false;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		try {
			this.size++;
			
			Object[] tempObjs = new Object[size];

			for (int i = 0; i < size - 1; i++) {
				tempObjs[i] = arrayList[i];
			}

			tempObjs[size - 1] = toAdd;

			arrayList = tempObjs;
			return true;			
		} catch (NullPointerException e) {
			return false;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		try {
			
			int newSize = size + toAdd.size();
			Object[] tempObjs = new Object[newSize];
			
			for (int i = size; i < newSize; i++) {
				tempObjs[i] = arrayList[i];
			}

			for (int i = 0; i < newSize; i++) {
				if (i < size) {
					tempObjs[i] = arrayList[i];
				} else {
					tempObjs[i] = toAdd.get(i - size + 1);
				}
			}
			
			tempObjs[size] = toAdd;

			arrayList = tempObjs;
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		return (E) arrayList[index];
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {

		try {
			this.size--;
			
			Object[] tempObjs = new Object[size];
			Object tempObj = null;

			for (int i = 0; i < size + 1; i++) {
				if (i < index) {
					tempObjs[i] = arrayList[i];
				} else if (i == index) {
					tempObj = arrayList[i];
				} else {
					tempObjs[i-1] = arrayList[i];
				}
			}

			arrayList = tempObjs;

			return (E) tempObj;
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		try {
			int index = 0;

			while (arrayList[index] != toRemove) {
				index++;
			}
			return (E) remove(index);
		} catch (NullPointerException e) {
			return null;
		}
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		E temp = (E) arrayList[index];
		arrayList[index] = toChange;
		return temp;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		for (int i = 0; i < size; i++) {
			if (arrayList[i] == toFind)
				return true;
		}
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyArrayListIterator<E>(this);
	}

	/**
	 * to use Iterator
	 * 
	 * Get ListADT implementation
	 * 
	 * Get the iterator Iterator<String> it = list.iterator();
	 * 
	 * Loop through the list while (it.hasNext()) { String element = it.next(); }
	 * 
	 * try catch nosuchelement
	 */

}
