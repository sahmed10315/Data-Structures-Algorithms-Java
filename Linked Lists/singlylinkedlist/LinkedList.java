package singlylinkedlist;

import java.util.EmptyStackException;

public class LinkedList {

	private Node head; // head of list

	/* Linked list Node */
	public static class Node {
		int data;
		Node next;

		// Constructor to create a new node
		Node(int d) {
			data = d;
		}
		public int getData() {
			return data;
		}
	}

	/*
	 * This function is in LinkedList class. Inserts a new Node at front of the
	 * list. This method is defined inside LinkedList class shown above
	 */
	public void insertFirst(int no) {
		Node newNode = new Node(no);

		newNode.next = head;

		head = newNode;
	}

	/*
	 * This function is in LinkedList class. Inserts a new node after the given
	 * prev_node. This method is defined inside LinkedList class shown above
	 */
	public void insertAfter(Node prevNode, int newData) {
		if (prevNode == null) {
			System.out.println("The given previous node cannot be null");
			return;
		}

		Node newNode = new Node(newData);

		newNode.next = prevNode.next;

		prevNode.next = newNode;
	}

	/*
	 * Insert a new node at the end.
	 */
	public void insertLast(int newData) {
		Node newNode = new Node(newData);

		if (head == null) {
			head = new Node(newData);
			return;
		}

		newNode.next = null;

		Node last = head;
		while (last.next != null)
			last = last.next;

		last.next = newNode;
	}

	public Node deleteFirst() // delete first item
	{
		if (head == null)
			throw new EmptyStackException();
		Node temp = head;
		head = head.next;
		return temp;
	}

	/* Given a key, deletes the first occurrence of key in linked list */
	void deleteNode(int key) {
		// Store head node
		Node current = head, prev = null;

		// If head node itself holds the key to be deleted
		if (current != null && current.data == key) {
			head = current.next; // Changed head
			return;
		}

		// Search for the key to be deleted, keep track of the
		// previous node as we need to change temp.next
		while (current != null && current.data != key) {
			prev = current;
			current = current.next;
		}

		// If key was not present in linked list
		if (current == null)
			return;

		// Unlink the node from linked list
		prev.next = current.next;
	}

	/*
	 * Given a reference (pointer to pointer) to the head of a list and a
	 * position, deletes the node at the given position
	 */
	void deleteNodeAtPos(int position) {
		// If linked list is empty
		if (head == null)
			return;

		// Store head node
		Node temp = head;

		// If head needs to be removed
		if (position == 0) {
			head = temp.next; // Change head
			return;
		}

		// Find previous node of the node to be deleted
		for (int i = 0; temp != null && i < position - 1; i++)
			temp = temp.next;

		// If position is more than number of ndoes
		if (temp == null || temp.next == null)
			return;

		// Node temp->next is the node to be deleted
		// Store pointer to the next of node to be deleted
		Node next = temp.next.next;

		temp.next = next; // Unlink the deleted node from list
	}

	/* Returns count of nodes in linked list */
	public int getCount() {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	/* Returns count of nodes in linked list */
	public int getCountRec(Node node) {
		// Base case
		if (node == null)
			return 0;

		// Count is this node plus rest of the list
		return 1 + getCountRec(node.next);
	}

	/* Wrapper over getCountRec() */
	public int getCountRecursive() {
		return getCountRec(head);
	}

	/* Search no in linked list */
	boolean search(int no) {
		Node current = head; // Initialize current
		while (current != null) {
			if (current.data == no)
				return true;
			current = current.next;
		}
		return false;
	}

	boolean searchRecursive(Node head, int x) {
		// Base case
		if (head == null)
			return false;

		// If key is present in current node, return true
		if (head.data == x)
			return true;

		// Recur for remaining list
		return searchRecursive(head.next, x);
	}

	public boolean isEmpty() // true if list is empty
	{
		return (head == null);
	}

	/* This function prints contents of linked list starting from head */
	public void printList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList theList = new LinkedList(); // make new list

		theList.insertFirst(22); // insert four items
		theList.insertFirst(44); // insert four items

		theList.insertFirst(41); // insert four items

		theList.insertFirst(39); // insert four items

		theList.printList();

		while (!theList.isEmpty()) // until it's empty,
		{
			Node aLink = theList.deleteFirst(); // delete link
			System.out.print("Deleted " + aLink.data); // display it
			System.out.println("");
		}
		theList.printList(); // display list

	}
}
