package openaddressing;

//hashDouble.java
//demonstrates hash table with double hashing
//to run this program: C:>java HashDoubleApp
import java.io.*;

class HashTable {
	private Integer[] hashArray; // array is the hash table
	private int arraySize;
	private Integer nonItem; // for deleted items

	HashTable(int size) 
	{
		arraySize = size;
		hashArray = new Integer[arraySize];
		nonItem = new Integer(-1);
	}

	public void displayTable() {
		System.out.print("Table: ");
		for (int j = 0; j < arraySize; j++) {
			if (hashArray[j] != null)
				System.out.print(hashArray[j] + " ");
			else
				System.out.print("** ");
		}
		System.out.println("");
	}

	public int hashFunc1(int key) {
		return key % arraySize;
	}

	public int hashFunc2(int key) {
		// non-zero, less than array size, different from hF1
		// array size must be relatively prime to 5, 4, 3, and 2
		return 5 - key % 5;
	}

	// insert a Integer
	public void insert(int key, Integer item)
	{
		int hashVal = hashFunc1(key); // hash the key
		int stepSize = hashFunc2(key); // get step size
										// until empty cell or -1
		while (hashArray[hashVal] != null && hashArray[hashVal] != -1) {
			hashVal += stepSize; // add the step
			hashVal %= arraySize; // for wraparound
		}
		hashArray[hashVal] = item; // insert item
	} // end insert()

	public Integer delete(int key) // delete a Integer
	{
		int hashVal = hashFunc1(key); // hash the key
		int stepSize = hashFunc2(key); // get step size

		while (hashArray[hashVal] != null) // until empty cell,
		{ // is correct hashVal?
			if (hashArray[hashVal] == key) {
				Integer temp = hashArray[hashVal]; // save item
				hashArray[hashVal] = nonItem; // delete item
				return temp; // return item
			}
			hashVal += stepSize; // add the step
			hashVal %= arraySize; // for wraparound
		}
		return null; // can't find item
	} // end delete()

	public Integer find(int key) // find item with key 
	{
		int hashVal = hashFunc1(key); // hash the key
		int stepSize = hashFunc2(key); // get step size

		while (hashArray[hashVal] != null) // until empty cell,
		{ // is correct hashVal?
			if (hashArray[hashVal] == key)
				return hashArray[hashVal]; // yes, return item
			hashVal += stepSize; // add the step
			hashVal %= arraySize; // for wraparound
		}
		return null; // can't find item
	}
}

public class DoubleHashing {
	public static void main(String[] args) throws IOException {
		int aKey;
		Integer aInteger;
		int size, n;
		size = 15;
		n = 10;
		// make table
		HashTable theHashTable = new HashTable(size);

		for (int j = 0; j < n; j++) // insert data
		{
			aKey = (int) (java.lang.Math.random() * 2 * size);
			aInteger = new Integer(aKey);
			theHashTable.insert(aKey, aInteger);
		}
	}
}
