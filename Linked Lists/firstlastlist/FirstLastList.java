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
	public FirstLastList()
	{
		first = null;
		last = null;
	}

	/* Returns true if list is empty*/
	public boolean isEmpty() 
	{
		return first == null;
	}

	/* Insert at front of list. Two links have to be updated accordingly */
	public void insertFirst(long dd) 
	{
		Node newLink = new Node(dd); // make new link

		if (isEmpty()) // if empty list,
			last = newLink; // newLink <-- last
		newLink.next = first; // newLink --> old first
		first = newLink; // first --> newLink
	}

	/* Insert at last of link, since we keep the last node, 
	 * we dont have to iterate to find it.
	 */
	public void insertLast(long dd) 
	{
		Node newLink = new Node(dd); // make new link
		if (isEmpty()) // if empty list,
			first = newLink; // first --> newLink
		else
			last.next = newLink; // old last --> newLink
		last = newLink; // newLink <-- last
	}

	/* Delete first node */
	public long deleteFirst()
	{
		long temp = first.dData;
		if (first.next == null) // if only one item
			last = null; // null <-- last
		first = first.next; // first --> old next
		return temp;
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

		theList.displayList(); // display the list

		theList.deleteFirst(); // delete first two items
		theList.deleteFirst();

		theList.displayList(); // display again
	}
}