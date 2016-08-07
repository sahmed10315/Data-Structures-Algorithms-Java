package queues.implementation.array.simple;

import java.util.EmptyStackException;

/* Array implementation of queue  We enqueue an item at the rear and dequeue an item from front. If we simply increment front and rear indices, then there may be problems, 
 * front may reach end of the array. The solution to this problem is to increase front and rear in circular manner by wrapping around.
 *
 * Insertion/Deletion: O(1), O(1)
 * Search/Access O(n), O(n)	
 * Space Complexity: O(n)
 */
public class Queue<T> {
	private int maxSize;
	private T[] queArray;
	private int front;
	private int rear;
	private int nItems;

	@SuppressWarnings("unchecked")
	public Queue(int s)
	{
		maxSize = s;
		queArray = (T[])new Object[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public void insert(T j) {
		if (rear == maxSize - 1) // deal with wrap around
			rear = -1;
		queArray[++rear] = j; // increment rear and insert
		nItems++; 
	}

	public T remove() {
		if(nItems == 0)
			throw new EmptyStackException();
		T temp = queArray[front++];
		if (front == maxSize) // deal with wrap around
			front = 0;
		nItems--;  
		return temp;
	}

	public T peekFront()  
	{
		if(nItems == 0)
			throw new EmptyStackException();
		return queArray[front];
	}

	public boolean isEmpty()  
	{
		return (nItems == 0);
	}

	public boolean isFull() 
	{
		return (nItems == maxSize);
	}

	public int size()  
	{
		return nItems;
	}

	public static void main(String[] args) {
		Queue<Integer> theQueue = new Queue<Integer>(5);

		theQueue.insert(10); 
		theQueue.insert(20);
		theQueue.insert(30);
		theQueue.insert(40);

		theQueue.remove(); // remove 3 items
		theQueue.remove(); 
		theQueue.remove(); 
		theQueue.insert(50); // insert 4 more items
		theQueue.insert(60); // (wraps around)
		theQueue.insert(70);
		theQueue.insert(80);

		while (!theQueue.isEmpty()) {
			long n = theQueue.remove();
			System.out.print(n);
			System.out.print(" ");
		}
		System.out.println("");
	}
}