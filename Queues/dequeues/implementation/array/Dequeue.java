package dequeues.implementation.array;

/* 
 * Deque or Double Ended Queue is a generalized version of Queue data structure that allows insert and delete at both ends.
 * 
 * If we restrict to insertLeft() and removeLeft(), the deque acts like a stack. If we restrict insertLeft() and
 * removeRight(), it acts like a queue.
 */
public class Dequeue {
	private long[] queArray;
	private int maxSize;
	private int nItems;
	private int left;
	private int right;

	private boolean isEmpty() {
		return nItems == 0;
	}

	private boolean isFull() {
		return nItems == maxSize;
	}

	public Dequeue(int maxSize) {
		this.maxSize = maxSize;
		queArray = new long[maxSize];
		nItems = 0;
		left = maxSize;
		right = -1;
	}

	public void insertLeft(long j) {
		if (isFull())
			throw new RuntimeException("It is full");

		if (left == 0)
			left = maxSize;
		queArray[--left] = j;
		nItems++;
	}

	public void insertRight(long i) {
		if (isFull())
			throw new RuntimeException("It is full");

		if (right == maxSize - 1)
			right = -1;
		queArray[++right] = i;
		nItems++;
	}

	public long removeLeft() {
		if (isEmpty())
			throw new RuntimeException("It is empty");

		long temp = queArray[left++];
		
		if (left == maxSize - 1)
			left = -1;
		nItems--;
		return temp;
	}

	public long removeRight() {
		if (isEmpty())
			throw new RuntimeException("It is empty");

		long temp = queArray[right--];
		
		if (right < 0)
			right = maxSize - 1;
		nItems--;
		return temp;
	}

}