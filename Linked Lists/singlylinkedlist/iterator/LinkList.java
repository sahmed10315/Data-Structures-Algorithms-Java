package singlylinkedlist.iterator; 

class LinkList {

	public static class Node {
		public long dData; // data item
		public Node next; // next link in list

		public Node(long dd) // constructor
		{
			dData = dd;
		}

		public void displayLink() // display ourself
		{
			System.out.print(dData + " ");
		}
	}

	private Node first;

	public LinkList() // constructor
	{
		first = null;
	}

	public Node getFirst() // get value of first
	{
		return first;
	}

	public void setFirst(Node f) // set first to new link
	{
		first = f;
	}

	public boolean isEmpty() // true if list is empty
	{
		return first == null;
	}

	public ListIterator getIterator() // return iterator
	{
		return new ListIterator(this); // initialized with
	}

	public void displayList() {
		Node current = first; // start at beginning of list
		while (current != null) // until end of list,
		{
			current.displayLink(); // print data
			current = current.next; // move to next link
		}
		System.out.println("");
	}
}