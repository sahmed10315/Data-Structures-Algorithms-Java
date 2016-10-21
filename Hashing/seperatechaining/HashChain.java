package seperatechaining;

//HashChain.java
//Demonstrates hash table with separate chaining 
import java.io.*;

class HashTable {
	private SortedList[] hashArray; // array of lists
	private int arraySize;

	public HashTable(int size)  
	{
		arraySize = size;
		hashArray = new SortedList[arraySize]; // create array
		for (int j = 0; j < arraySize; j++) // fill array
			hashArray[j] = new SortedList(); // with lists
	}

	public void displayTable() {
		for (int j = 0; j < arraySize; j++) // for each cell,
		{
			System.out.print(j + ". "); // display cell number
			hashArray[j].displayList(); // display list
		}
	}

	public int hashFunc(int key) // hash function
	{
		return key % arraySize;
	}

	public void insert(Link theLink) // insert a link
	{
		int key = theLink.getKey();
		int hashVal = hashFunc(key); // hash the key
		hashArray[hashVal].insert(theLink); // insert at hashVal
	}

	public void delete(int key) 
	{
		int hashVal = hashFunc(key); // hash the key
		hashArray[hashVal].delete(key); // delete link
	}

	public Link find(int key) // find link
	{
		int hashVal = hashFunc(key); // hash the key
		Link theLink = hashArray[hashVal].find(key); // get link
		return theLink;
	}
}

public class HashChain {
	public static void main(String[] args) throws IOException {
		int aKey;
		Link aDataItem;
		int size, n, keysPerCell = 100;
		// get sizes
		size = 15;
		n = 10;
		// make table
		HashTable theHashTable = new HashTable(size);

		for (int j = 0; j < n; j++) // insert data
		{
			aKey = (int) (java.lang.Math.random() * keysPerCell * size);
			aDataItem = new Link(aKey);
			theHashTable.insert(aDataItem);
		}
	}
}
