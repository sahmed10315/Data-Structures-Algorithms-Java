package binaryheap;

//Heap.java
//demonstrates heaps
import java.io.*;

class Node {
	private int iData; // data item (key)

	public Node(int key) {
		iData = key;
	}

	public int getKey() {
		return iData;
	}

	public void setKey(int id) {
		iData = id;
	}
}

public class Heap {
	private Node[] heapArray;
	private int maxSize; // size of array
	private int currentSize; // number of nodes in array

	public Heap(int mx) // constructor
	{
		maxSize = mx;
		currentSize = 0;
		heapArray = new Node[maxSize]; // create array
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public boolean insert(int key) {
		if (currentSize == maxSize)
			return false;
		Node newNode = new Node(key);
		heapArray[currentSize] = newNode;
		trickleUp(currentSize++);
		return true;
	}

	public void trickleUp(int index) {
		int parent = (index - 1) / 2;
		Node bottom = heapArray[index];

		while (index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
			heapArray[index] = heapArray[parent]; // move it down
			index = parent;
			parent = (parent - 1) / 2;
		}
		heapArray[index] = bottom;
	}

	public Node remove() // delete item with max key
	{
		Node root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		return root;
	}

	public void trickleDown(int index) {
		int largerChild;
		Node top = heapArray[index]; // save root
		while (index < currentSize / 2) // while node has at
		{ // least one child,
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;
			// find larger child
			if (rightChild < currentSize && // (rightChild exists?)
					heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
				largerChild = rightChild;
			else
				largerChild = leftChild;
			// top >= largerChild?
			if (top.getKey() >= heapArray[largerChild].getKey())
				break;
			// shift child up
			heapArray[index] = heapArray[largerChild];
			index = largerChild; // go down
		} 
		heapArray[index] = top; // root to index
	}

	public boolean change(int index, int newValue) {
		if (index < 0 || index >= currentSize)
			return false;
		int oldValue = heapArray[index].getKey(); // remember old
		heapArray[index].setKey(newValue); // change to new

		if (oldValue < newValue) // if raised,
			trickleUp(index); // trickle it up
		else // if lowered,
			trickleDown(index); // trickle it down
		return true;
	}

	// Returns true if arr[i..n-1] represents a
	// max-heap
	boolean isHeap(int arr[]) {
		// Start from root and go till the last internal
		// node
		for (int i = 0; i <= (arr.length - 2) / 2; i++) {
			// If left child is greater, return false
			if (arr[2 * i + 1] > arr[i])
				return false;

			// If right child is greater, return false
			if (arr[2 * i + 2] > arr[i])
				return false;
		}
		return true;
	}

	boolean isHeapRec(int arr[], int i, int n) {
		// If a leaf node
		if (i > (n - 2) / 2)
			return true;

		// If an internal node and is greater than its children, and
		// same is recursively true for the children
		if (arr[i] >= arr[2 * i + 1] && arr[i] >= arr[2 * i + 2] && isHeapRec(arr, 2 * i + 1, n)
				&& isHeapRec(arr, 2 * i + 2, n))
			return true;

		return false;
	}

	public static void main(String[] args) throws IOException {
		Heap theHeap = new Heap(31);

		theHeap.insert(70); // insert 10 items
		theHeap.insert(40);
		theHeap.insert(50);
		theHeap.insert(20);
		theHeap.insert(60);
		theHeap.insert(100);
		theHeap.insert(80);
		theHeap.insert(30);
		theHeap.insert(10);
		theHeap.insert(90);
		theHeap.remove();
	}
}
