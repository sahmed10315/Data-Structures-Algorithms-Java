package implementation.linkedlist;

import singlylinkedlist.LinkedList;

public class StackLinkedList {
	private LinkedList theList;
 
	public StackLinkedList() // constructor
	{
		theList = new LinkedList();
	}
 
	public void push(int j) // put item on top of stack
	{
		theList.insertFirst(j);
	}
 
	public int pop() // take item from top of stack
	{
		LinkedList.Node n = theList.deleteFirst();
		return n.getData();

	}
 
	public boolean isEmpty() // true if stack is empty
	{
		return (theList.isEmpty());
	}
 
	public void displayStack() {
		System.out.print("Stack (top-->bottom): ");
		theList.printList();
	} 

	public static void main(String[] args) {
		StackLinkedList theStack = new StackLinkedList(); // make stack

		theStack.push(20); // push items
		theStack.push(40);

		theStack.displayStack(); // display stack

		theStack.push(60); // push items
		theStack.push(80);

		theStack.displayStack(); // display stack

		theStack.pop(); // pop items
		theStack.pop();

		theStack.displayStack(); // display stack
	} 
}
