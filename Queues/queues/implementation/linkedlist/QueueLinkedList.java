package queues.implementation.linkedlist;

import firstlastlist.FirstLastList;

public class QueueLinkedList {
	private FirstLastList theList;

	public QueueLinkedList() // constructor
	{
		theList = new FirstLastList();
	} // make a 2-ended list

	public boolean isEmpty() // true if queue is empty
	{
		return theList.isEmpty();
	}

	public void insert(long j) // insert, rear of queue
	{
		theList.insertLast(j);
	}

	public long remove() // remove, front of queue
	{
		return theList.deleteFirst();
	}

	public void displayQueue() {
		System.out.print("Queue (front-->rear): ");
		theList.displayList();
	}

	public static void main(String[] args) {
		QueueLinkedList theQueue = new QueueLinkedList();
		theQueue.insert(20); // insert items
		theQueue.insert(40);

		theQueue.displayQueue(); // display queue

		theQueue.insert(60); // insert items
		theQueue.insert(80);

		theQueue.displayQueue(); // display queue

		theQueue.remove(); // remove items
		theQueue.remove();

		theQueue.displayQueue(); // display queue
	}
}
