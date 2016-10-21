package seperatechaining;

class SortedList {
	private Link first;  
	
	public void insert(Link theLink) 
	{
		int key = theLink.getKey();
		Link previous = null; // start at first
		Link current = first;
		// until end of list,
		while (current != null && key > current.getKey()) {
			previous = current;
			current = current.next; // go to next item
		}
		if (previous == null) // if beginning of list,
			first = theLink; // first --> new link
		else // not at beginning,
			previous.next = theLink; // prev --> new link
		theLink.next = current; // new link --> current
	}

	public void delete(int key)
	{ 
		Link previous = null; // start at first
		Link current = first; 
		while (current != null && key != current.getKey()) {
			previous = current;
			current = current.next; // go to next link
		}
		// disconnect link
		if (previous == null) // if beginning of list
			first = first.next; // delete first link
		else // not at beginning
			previous.next = current.next; // delete current link
	}

	public Link find(int key)
	{
		Link current = first;
		
		while (current != null && current.getKey() <= key) {
			if (current.getKey() == key) // is this the link?
				return current; // found it, return link
			current = current.next; // go to next item
		}
		return null; 
	}

	public void displayList() {
		System.out.print("List (first-->last): ");
		Link current = first; // start at beginning of list
		while (current != null) // until end of list,
		{
			current.displayLink(); // print data
			current = current.next; // move to next link
		}
		System.out.println("");
	}
}