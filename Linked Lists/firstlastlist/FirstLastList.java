package firstlastlist;

/* ADT class for a singly linked list containing a node for last item too.
 * Search complexity : O(N)
 * Insert/Delete at beginning: O(1)
 * Insert/Delete at end: O(1) if node is known, O(N) if unknown
 * Insert/Delete in middle: O(N) + O(1)
 * Space: O(N)
 * */
public class FirstLastList {
	private Node first; // ref to first link
	private Node last; // ref to last link

	class Node {
		public long dData; // data item
		public Node next; // next link in list

		public Node(long d) // constructor
		{
			dData = d;
		}

		public void displayLink() // display this link
		{
			System.out.print(dData + " ");
		}
	}

	/* Constructor */
	public FirstLastList() {
		first = null;
		last = null;
	}

	/* Returns true if list is empty */
	public boolean isEmpty() {
		return first == null;
	}

	/* Insert at front of list. Two links have to be updated accordingly */
	public void insertFirst(long dd) {
		Node newLink = new Node(dd); // make new link

		if (isEmpty()) // if empty list,
			last = newLink; // newLink <-- last
		newLink.next = first; // newLink --> old first
		first = newLink; // first --> newLink
	}

	/*
	 * Insert at last of link, since we keep the last node, we dont have to
	 * iterate to find it.
	 */
	public void insertLast(long dd) {
		Node newLink = new Node(dd); // make new link
		if (isEmpty()) // if empty list,
			first = newLink; // first --> newLink
		else
			last.next = newLink; // old last --> newLink
		last = newLink; // newLink <-- last
	}

	/* Delete first node */
	public long deleteFirst() {
		long temp = first.dData;
		if (first.next == null) // if only one item
			last = null; // null <-- last
		first = first.next; // first --> old next
		return temp;
	}

	/* Delete first node */
	public long deleteLast() {
		if (first == null)
			return -1;
		long temp = last.dData;
		if (first.next == null) // if only one item
		{
			last = null; // null <-- last
			first = null;
		} else {
			Node curr = first;

			while (curr.next != last)
				curr = curr.next;

			curr.next = null;
			last = curr;
		}

		return temp;
	}

	boolean insertAfter(int elem, int data) {
		Node newElem, curPos = first;
		newElem = new Node(data);
		newElem.next = null;

		/* Insert at beginning of list */
		if (first == null) {
			newElem.next = first;
			first = newElem;
			last = first;
			return true;
		}
		/* Special case for empty list */
		if (last.dData == elem) {
			last.next = newElem;
			last = newElem;
			return true;
		}
		while (curPos != null) {
			if (curPos.dData == elem) {
				newElem.next = curPos.next;
				curPos.next = newElem;
				return true;
			}
			curPos = curPos.next;
		}
		return false;
	}

	boolean delete(int elem) {

		if (first == null)
			return false;

		if (elem == first.dData) {
			if (first.next == null) // if only one item
				last = null; // null <-- last
			first = first.next; // first --> old next
			return true;
		}

		Node curPos = first;
		while (curPos != null) {
			if (curPos.next.dData == elem) {
				curPos.next = curPos.next.next;
				if (curPos.next == null)
					last = curPos;
				return true;
			}
			curPos = curPos.next;
		}
		return false;
	}

	/* Display the list from beginning */
	public void displayList() {
		System.out.print("List (first-->last): ");
		Node current = first; // start at beginning
		while (current != null) // until end of list,
		{
			current.displayLink(); // print data
			current = current.next; // move to next link
		}
		System.out.println("");
	}

	public static void main(String[] args) { // make a new list
		FirstLastList theList = new FirstLastList();

		theList.insertFirst(22); // insert at front
		theList.insertFirst(44);
		theList.insertFirst(66);

		theList.insertLast(11); // insert at rear
		theList.insertLast(33);
		theList.insertLast(55);
		theList.insertFirst(82);
		theList.insertLast(23);
		theList.insertFirst(91);
		theList.displayList(); // display the list

		theList.insertAfter(33, 1);

		theList.insertAfter(44, 2);

		theList.insertAfter(23, 3);

		theList.insertAfter(91, 4);
		// theList.delete(55);
		// theList.delete(11);
		// theList.delete(23);
		// theList.delete(91);
		theList.displayList(); // display again
	}
}