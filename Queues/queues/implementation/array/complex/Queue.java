package queues.implementation.array.complex;

import java.util.EmptyStackException;
/* Array implementation of queue without keeping track of current no of items. This approach makes the size, isFull and empty method complicated.
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
 
	@SuppressWarnings("unchecked")
	public Queue(int s)
	{
		maxSize = s + 1;
		// array is 1 cell larger
		queArray = (T[])new Object[maxSize]; // than requested
		front = 0;
		rear = -1;
	}
 
	public void insert(T j) // put item at rear of queue
	{
		if (rear == maxSize - 1)
			rear = -1;
		queArray[++rear] = j;
	}
 
	public T remove() 
	{
		if(isEmpty())
			throw new EmptyStackException();
		T temp = queArray[front++];
		if (front == maxSize)
			front = 0;
		return temp;
	}
 
	public T peek() 
	{
		if(isEmpty())
			throw new EmptyStackException();
		return queArray[front];
	}
 
	public boolean isEmpty() 
	{
		return (rear + 1 == front || (front + maxSize - 1 == rear));
	}
 
	public boolean isFull()
	{
		return (rear + 2 == front || (front + maxSize - 2 == rear));
	}
 
	public int size() 
	{
		if (rear >= front)
			// contiguous sequence
			return rear - front + 1;
		else
			// broken sequence
			return (maxSize - front) + (rear + 1);
	} 
}
