package singlylinkedlist.sorted;

/* Singly linked list to insert values in sorted order 
 * Runtime complexity for insertion : O(N)
 * Runtime complexity for deletion : O(1)
 * */
public class SortedList {
	Node head; // head of list

	/* Linked list Node */
	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/* function to insert a new_node in a sorted list. */
	void sortedInsert(int key) {
		Node newNode = new Node(key);
		Node current;

		/* Special case for head node */
		if (head == null || head.data >= newNode.data) {
			newNode.next = head;
			head = newNode;
		} else {

			/* Locate the node before point of insertion. */
			current = head;

			while (current.next != null && current.next.data < newNode.data)
				current = current.next;

			newNode.next = current.next;
			current.next = newNode;
		}
	}

	/* Function to print linked list */
	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	/* Driver function to test above methods */
	public static void main(String args[]) {
		SortedList llist = new SortedList();
		llist.sortedInsert(5);
		llist.sortedInsert(10);
		llist.sortedInsert(7);
		llist.sortedInsert(4);
		llist.sortedInsert(1);
		llist.sortedInsert(9);
		System.out.println("Created Linked List");
		llist.printList();
	}
}
