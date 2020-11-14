package utilities;

/**
 * 
 * @author Jaeyoung Kim
 *
 * @param <E>
 */
@SuppressWarnings("serial")
public class MySLL<E> implements ListADT<E> {

	/**
	 * The first node in the linked list.
	 */
	private MySLLNode head;

	/**
	 * The number of nodes in the linked list.
	 */
	private int size;

	/**
	 * 
	 */
	public MySLL() {
		this.head = null;
		this.size = 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		try {
			if (toAdd == null) {
				throw new NullPointerException();
			}

			if (index >= size) {
				throw new IndexOutOfBoundsException();
			}

			MySLLNode newNode = new MySLLNode(toAdd);

			if (index == 0) {
				// Set next of new node to head
				// This must be done before we change the head.
				newNode.setNext(head);

				// Set head to new node
				head = newNode;

				// Increment the size
				size++;

			} else if (index == size) {
				add(toAdd);

			} else {
				MySLLNode findPositionNode = head;
				MySLLNode nextPositionNode = findPositionNode.getNext();
				for (int i = 0; i < index - 1; i++) {
					findPositionNode = findPositionNode.getNext();
					nextPositionNode = findPositionNode.getNext();
				}
				// set the previous index Node's next to the new Node
				findPositionNode.setNext(newNode);

				// set the new Node's next to the next index Node.
				newNode.setNext(nextPositionNode);

				// Increment the size
				size++;
			}

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
			if (toAdd == null) {
				throw new NullPointerException();
			}

			MySLLNode newNode = new MySLLNode(toAdd);

			if (isEmpty()) {
				// Set next of new node to head
				// This must be done before we change the head.
				newNode.setNext(head);

				// Set head to new node
				head = newNode;
			} else {
				// Set the last node to head.
				MySLLNode lastNode = head;
				for (int i = 0; i < size() - 1; i++) {
					lastNode = lastNode.getNext();
				}
				lastNode.setNext(newNode);
			}

			// Increment the size
			size++;

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
			for (int i = 0; i < toAdd.size(); i++) {
				this.add(toAdd.get(i));
			}
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		try {
			MySLLNode temp = head;

			if (index >= size) {
				throw new IndexOutOfBoundsException();
			}

			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}

			return (E) temp.getData();
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		try {
			if (index >= size) {
				throw new IndexOutOfBoundsException();
			}

			if (index == 0) {
				MySLLNode temp = head;

				// Set head to new node.
				head = temp.getNext();

				// Set the deleted one's next to null.
				temp.setNext(null);

				// Decrement the size
				size--;

				return (E) temp;

			} else {
				MySLLNode previousNode = head;
				MySLLNode targetNode = previousNode.getNext();
				for (int i = 0; i < index - 1; i++) {
					previousNode = previousNode.getNext();
					targetNode = previousNode.getNext();
				}
				// set the previous index Node's next to the Node(to be deleted)' next Node
				previousNode.setNext(targetNode.getNext());

				// set the target Node which isn't in use anymore to null for the next.
				targetNode.setNext(null);

				// Decrement the size
				size--;

				return (E) targetNode;
			}
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		try {
			MySLLNode temp = head;

			int index = 0;

			while (temp.getData() != toRemove) {
				temp = temp.getNext();
				index++;

				if (temp == null) {
					// return -1; //TODO: If this list does not contain the element, it is
					// unchanged. What does it mean?
				}
			}
			return (E) remove(index);
		} catch (NullPointerException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		try {
			if (toChange == null) {
				throw new NullPointerException();
			}

			if (index >= size) {
				throw new IndexOutOfBoundsException();
			}

			MySLLNode newNode = new MySLLNode(toChange);
			MySLLNode findPositionNode = head;
			MySLLNode nextPositionNode = findPositionNode.getNext();
			for (int i = 0; i < index - 1; i++) {
				findPositionNode = findPositionNode.getNext();
				nextPositionNode = findPositionNode.getNext();
			}
			// set the previous index Node's next to the new Node
			findPositionNode.setNext(newNode);

			// set the new Node's next to the replaced Node's next.
			newNode.setNext(nextPositionNode.getNext());

			// set the placed Node's next which isn't in use anymore to null.
			nextPositionNode.setNext(null);

			return (E) nextPositionNode.getData();
		} catch (NullPointerException e) {
			return null;
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		boolean isContain = false;

		try {
			if (toFind == null) {
				throw new NullPointerException();
			}
			MySLLNode currentNode = head;

			for (int i = 0; i < size && !isContain; i++) {
				if (currentNode.getData().equals(toFind)) {
					isContain = true;
				}
				currentNode = currentNode.getNext();
			}
			return isContain;
		} catch (NullPointerException e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		E[] temp = (E[]) new Object[toHold.length];		
		for (int i = 0; i < toHold.length; i++) {
			temp[i] = toHold[i];
		}
		return temp;
	}

	@Override
	public Object[] toArray() {
		Object[] temp = new Object[this.size];		
		for (int i = 0; i < this.size; i++) {
			temp[i] = this.get(i);
		}
		return temp;
	}

	@Override
	public Iterator<E> iterator() {
		return new MySLLIterator<E>(this);
	}

}
