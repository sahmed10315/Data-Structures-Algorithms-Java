package dynamicarray.arraylist;

/* Dynamic Array Abstract data type (ArrayList) implementation 
 * 					Access	Search	Insertion/Deletion at end	     Insertion/Deletion at beginning 		Insertion/Deletion at middle
 * Time complexity: O(1)	O(n)		O(1) amortized	   							 O(n)							 O(n)
 * 
 * Space complexity: O(N)
 * */
import java.util.Arrays;

public class ArrayList<E> {
	private int size;
	private static final int DEFAULT_CAPACITY = 10;
	private Object elements[];

	public ArrayList() {
		elements = new Object[DEFAULT_CAPACITY];
		size = 0;
	}

	public ArrayList(int capacity) {
		elements = new Object[capacity];
		size = 0;
	}

	public void add(E e) {
		if (size == elements.length) {
			ensureCapacity();
		}
		elements[size++] = e;
	}

	public void clear() {
		size = 0;
	}

	private void ensureCapacity() {
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
	}

	// Replaces the element at the specified position
	public E set(int index, int element) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
		}
		@SuppressWarnings("unchecked")
		E oldValue = (E) elements[index];
		elements[index] = element;
		return (E) oldValue;
	}

	@SuppressWarnings("unchecked")
	public E get(int i) {
		if (i >= size || i < 0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
		}
		return (E) elements[i];
	}

	public int size() {
		return size;
	}

	public int capacity() {
		return elements.length;
	}
}
