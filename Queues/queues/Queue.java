package queues;

class QueueADT {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;

	public QueueADT(int s)
	{
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public void insert(long j) {
		if (rear == maxSize - 1) // deal with wraparound
			rear = -1;
		queArray[++rear] = j; // increment rear and insert
		nItems++; 
	}

	public long remove() {
		long temp = queArray[front++];
		if (front == maxSize) // deal with wraparound
			front = 0;
		nItems--;  
		return temp;
	}

	public long peekFront()  
	{
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
}

public class Queue {
	public static void main(String[] args) {
		QueueADT theQueue = new QueueADT(5);

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