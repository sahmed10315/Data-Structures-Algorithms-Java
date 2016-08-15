package circularlinkedlist;

/* Circular linked lists are useful for implementation of queue. Unlike singly linked list implementation, 
 * we don’t need to maintain two pointers for front and rear if we use circular linked list. We can maintain a 
 * pointer to the last inserted node and front can always be obtained as next of last.
 */
public class CircularLinkedList {

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

	/* insert link at the first location */
	void insertFirst(int data) {
		// create a link
		Node link = new Node(data);

		if (head == null) {
			head = link;
			link.next = head;

		} else {

			Node last = head;
			while (last.next != head)
				last = last.next;
			last.next = link;
			// point it to old first node
			link.next = head;
			// point first to new first node
			head = link;
		}

	}

	/* Insert at end */
	void addAtEnd(int data) {
		// create a link
		Node link = new Node(data);
		// If list is empty
		if (head == null) {
			// making the next pointer of the new Node as Null
			link.next = head;
			// making the new Node as Head
			head = link;

		} else {
			// getting the last node
			Node last = head;
			while (last.next != head)
				last = last.next;
			last.next = link;
			// making the next pointer of new node point to head
			link.next = head;
		}
	}

	/* Function to print nodes in a given Circular linked list */
	void printList() {
		if (head != null) {
			Node temp = head;
			do {
				System.out.println(temp.data);
				temp = temp.next;
			} while (temp != head);
		}
	}

	/* Search for a given value */
	Node search(int x) {
		Node temp = head;

		if (temp == null)
			return null;

		if (temp.data == x)
			return head;

		while (temp.next != head && temp.data != x) {
			// until we reach the end or we find a Node with data x, we keep
			// moving
			temp = temp.next;
		}
		return temp;
	}

	/* Delete node with value x */
	Node deleteNode(int x) {
		// searching the Node with data x
		Node n = search(x);
		Node temp = head;
		if (temp == null) {
			return null;
		} else if (temp == n) {

			Node last = head;
			while (last.next != head)
				last = last.next;
			head = head.next;
			last.next = head;
			return n;
		} else {
			while (temp.next != n) {
				temp = temp.next;
			}
			temp.next = n.next;
			return n;
		}
	}

	/* Insert in a sorted manner in the list */
	void sortedInsert(int data) {
		Node newNode = new Node(data);
		Node current = head;

		// Case 1 of the above algo
		if (current == null) {
			newNode.next = newNode;
			head = newNode;

		}

		// Case 2 of the above algo
		else if (current.data >= newNode.data) {

			/*
			 * If value is smaller than head's value then we need to change next
			 * of last node
			 */
			while (current.next != head)
				current = current.next;

			current.next = newNode;
			newNode.next = head;
			head = newNode;
		}
		// Case 3 of the above algo
		else {

			/* Locate the node before the point of insertion */
			while (current.next != head && current.next.data < newNode.data)
				current = current.next;

			newNode.next = current.next;
			current.next = newNode;
		}
	}

	public static void main(String[] args) {
		CircularLinkedList theList = new CircularLinkedList();
		theList.insertFirst(22); // insert four items
		theList.insertFirst(44); // insert four items
		theList.insertFirst(41); // insert four items
		theList.insertFirst(39); // insert four items

		theList.addAtEnd(1); // insert four items
		theList.addAtEnd(14); // insert four items

		theList.insertFirst(64); // insert four items

		theList.printList();
		System.out.println();
		theList.deleteNode(41);
		theList.deleteNode(64);
		theList.deleteNode(14);

		theList.sortedInsert(11);
		theList.sortedInsert(21);
		theList.printList(); // display list

	}
}