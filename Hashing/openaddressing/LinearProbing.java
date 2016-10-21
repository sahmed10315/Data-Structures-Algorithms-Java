package openaddressing;

//LinearProbing.java
//demonstrates hash table with linear probing 
import java.io.*; 

class HashTable {
	private Integer[] hashArray; // array holds hash table
	private Integer arraySize;
	private Integer nonItem; // for deleted items 

	public HashTable(Integer size) // constructor
	{
		arraySize = size;
		hashArray = new Integer[arraySize];
		nonItem = new Integer(-1); // deleted item key is -1
	}
 
	public void displayTable() { 
		for (Integer j = 0; j < arraySize; j++) {
			if (hashArray[j] != null)
				System.out.println(hashArray[j] + " ");
			else
				System.out.println("** ");
		}
		System.out.println("");
	}
 
	public Integer hashFunc(Integer key) {
		return key % arraySize; // hash function
	}
 
	public void insert(Integer item)  
	{
		Integer key = item; // extract key
		Integer hashVal = hashFunc(key); // hash the key
										// until empty cell or -1,
		while (hashArray[hashVal] != null && hashArray[hashVal] != -1) {
			++hashVal; // go to next cell
			hashVal %= arraySize; // wraparound if necessary
		}
		hashArray[hashVal] = item; // insert item
	}

	public Integer delete(Integer key) // delete a Integer
	{
		Integer hashVal = hashFunc(key); // hash the key

		while (hashArray[hashVal] != null) // until empty cell,
		{ // found the key?
			if (hashArray[hashVal] == key) {
				Integer temp = hashArray[hashVal]; // save item
				hashArray[hashVal] = nonItem; // delete item
				return temp; // return item
			}
			++hashVal; // go to next cell
			hashVal %= arraySize; // wraparound if necessary
		}
		return null; // can't find item
	} 

	public Integer find(Integer key) // find item with key
	{
		Integer hashVal = hashFunc(key); // hash the key

		while (hashArray[hashVal] != null) // until empty cell,
		{ // found the key?
			if (hashArray[hashVal] == key)
				return hashArray[hashVal]; // yes, return item
			++hashVal; // go to next cell
			hashVal %= arraySize; // wraparound if necessary
		}
		return null; 
	} 
} 

public class LinearProbing {
	public static void main(String[] args) throws IOException {
		Integer aInteger;
		Integer aKey, size, n, keysPerCell;
		// get sizes 
		size = 15; 
		n = 10;
		keysPerCell = 10;
		// make table
		HashTable theHashTable = new HashTable(size);

		for (Integer j = 0; j < n; j++) // insert data
		{
			aKey = (int) (java.lang.Math.random() * keysPerCell * size);
			aInteger = new Integer(aKey);
			theHashTable.insert(aInteger);
		}
	}  
 
}  
