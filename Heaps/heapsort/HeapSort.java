package heapsort;

//heapSort.java
//demonstrates heap sort 
import java.io.*;

class Node {
	private int iData;

	public Node(int key)
	{
		iData = key;
	}

	public int getKey() {
		return iData;
	}
}

class Heap {
	private Node[] heapArray;
	private int maxSize; // size of array
	private int currentSize; // number of items in array

	public Heap(int mx) 
	{
		maxSize = mx;
		currentSize = 0;
		heapArray = new Node[maxSize];
	}

	public Node remove() // delete item with max key
	{ // (assumes non-empty list)
		Node root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		return root;
	} // end remove()

	public void trickleDown(int index) {
		int largerChild;
		Node top = heapArray[index]; // save root
		while (index < currentSize / 2) // not on bottom row
		{
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;
			// find larger child
			if (rightChild < currentSize && // right ch exists?
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
		} // end while
		heapArray[index] = top; // root to index
	}  

	public void displayArray() {
		for (int j = 0; j < maxSize; j++)
			System.out.print(heapArray[j].getKey() + " ");
		System.out.println("");
	}

	public void insertAt(int index, Node newNode) {
		heapArray[index] = newNode;
	}

	public void incrementSize() {
		currentSize++;
	}
}

public class HeapSort {
	public static void main(String[] args) throws IOException {
		int size, j;

		size = 15;
		Heap theHeap = new Heap(size);

		for (j = 0; j < size; j++) // fill array with
		{ // random nodes
			int random = (int) (java.lang.Math.random() * 100);
			Node newNode = new Node(random);
			theHeap.insertAt(j, newNode);
			theHeap.incrementSize();
		}

		System.out.print("Random: ");
		theHeap.displayArray(); // display random array

		for (j = size / 2 - 1; j >= 0; j--) // make random array into heap
			theHeap.trickleDown(j);

		System.out.print("Heap:   ");
		theHeap.displayArray(); // dislay heap array

		for (j = size - 1; j >= 0; j--) // remove from heap and
		{ // store at array end
			Node biggestNode = theHeap.remove();
			theHeap.insertAt(j, biggestNode);
		}
		System.out.print("Sorted: ");
		theHeap.displayArray(); // display sorted array
	}
}
