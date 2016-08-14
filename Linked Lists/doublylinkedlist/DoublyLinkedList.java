package doublylinkedlist;

/* ADT for a doubly linked list, where each node contains a pointer to the previous and next node.
 * The delete operation in DLL is more efficient if pointer to the node to be deleted is given.
 * In singly linked list, to delete a node, pointer to the previous node is needed. To get this previous node, sometimes the list is traversed. 
 * In DLL, we can get the previous node using previous pointer.
 *  */
public class DoublyLinkedList {

	static class Node {
		public long dData; // data item
		public Node next; // next link in list
		public Node previous; // previous link in list

		public Node(long d) // constructor
		{
			dData = d;
		}

		public void displayLink() // display this link
		{
			System.out.print(dData + " ");
		}
	}

	private Node first;
	private Node last;

	public DoublyLinkedList() // constructor
	{
		first = null; // no items on list yet
		last = null;
	}

	public boolean isEmpty() // true if no links
	{
		return first == null;
	}

	public void insertFirst(long dd) // insert at front of list
	{
		Node newLink = new Node(dd); // make new link

		if (isEmpty()) // if empty list,
			last = newLink; // newLink <-- last
		else
			first.previous = newLink; // newLink <-- old first
		newLink.next = first; // newLink --> old first
		first = newLink; // first --> newLink
	}

	public void insertLast(long dd) // insert at end of list
	{
		Node newLink = new Node(dd); // make new link
		if (isEmpty()) // if empty list,
			first = newLink; // first --> newLink
		else {
			last.next = newLink; // old last --> newLink
			newLink.previous = last; // old last <-- newLink
		}
		last = newLink; // newLink <-- last
	}

	public Node deleteFirst() // delete first link
	{ // (assumes non-empty list)
		Node temp = first;
		if (first.next == null) // if only one item
			last = null; // null <-- last
		else
			first.next.previous = null; // null <-- old next
		first = first.next; // first --> old next
		return temp;
	}

	public Node deleteLast() // delete last link
	{ // (assumes non-empty list)
		Node temp = last;
		if (first.next == null) // if only one item
			first = null; // first --> null
		else
			last.previous.next = null; // old previous --> null
		last = last.previous; // old previous <-- last
		return temp;
	}

	// insert dd just after key
	public boolean insertAfter(long key, long dd) { // (assumes non-empty list)
		Node current = first; // start at beginning
		while (current.dData != key) // until match is found,
		{
			current = current.next; // move to next link
			if (current == null)
				return false; // didn't find it
		}
		Node newLink = new Node(dd); // make new link

		if (current == last) // if last link,
		{
			newLink.next = null; // newLink --> null
			last = newLink; // newLink <-- last
		} else // not last link,
		{
			newLink.next = current.next; // newLink --> old next
											// newLink <-- old next
			current.next.previous = newLink;
		}
		newLink.previous = current; // old current <-- newLink
		current.next = newLink; // old current --> newLink
		return true; // found it, did insertion
	}

	public Node deleteKey(long key) // delete item w/ given key
	{ // (assumes non-empty list)
		Node current = first; // start at beginning
		while (current.dData != key) // until match is found,
		{
			current = current.next; // move to next link
			if (current == null)
				return null; // didn't find it
		}
		if (current == first) // found it; first item?
			first = current.next; // first --> old next
		else // not first
				// old previous --> old next
			current.previous.next = current.next;

		if (current == last) // last item?
			last = current.previous; // old previous <-- last
		else // not last
				// old previous <-- old next
			current.next.previous = current.previous;
		return current; // return value
	}

	public void displayForward() {
		System.out.print("List (first-->last): ");
		Node current = first; // start at beginning
		while (current != null) // until end of list,
		{
			current.displayLink(); // display data
			current = current.next; // move to next link
		}
		System.out.println("");
	}

	public void displayBackward() {
		System.out.print("List (last-->first): ");
		Node current = last; // start at end
		while (current != null) // until start of list,
		{
			current.displayLink(); // display data
			current = current.previous; // move to previous link
		}
		System.out.println("");
	}

	/* Function to reverse a Doubly Linked List */
	void reverse() {
		Node temp = null;
		Node current = first;

		/*
		 * swap next and prev for all nodes of doubly linked list
		 */
		while (current != null) {
			temp = current.previous;
			current.previous = current.next;
			current.next = temp;
			current = current.previous;
		}

		/*
		 * Before changing head, check for the cases like empty list and list
		 * with only one node
		 */
		if (temp != null) {
			first = temp.previous;
		}
	}

	public static void main(String[] args) { // make a new list
		DoublyLinkedList theList = new DoublyLinkedList();

		theList.insertFirst(22); // insert at front
		theList.insertFirst(44);
		theList.insertFirst(66);

		theList.insertLast(11); // insert at rear
		theList.insertLast(33);
		theList.insertLast(55);

		theList.displayForward(); // display list forward
		theList.displayBackward(); // display list backward

		theList.deleteFirst(); // delete first item
		theList.deleteLast(); // delete last item
		theList.deleteKey(11); // delete item with key 11

		theList.displayForward(); // display list forward

		theList.insertAfter(22, 77); // insert 77 after 22
		theList.insertAfter(33, 88); // insert 88 after 33

		theList.displayForward(); // display list forward
		theList.reverse();
		theList.displayForward(); // display list forward

	}
}