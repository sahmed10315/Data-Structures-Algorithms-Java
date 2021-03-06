package fundamental.ADT;
/* Array Abstract data type implementation 
 * 					Access	Search	Insertion	Deletion
 * Time complexity: O(1)	O(n)	O(1)	    O(n)
 * 
 * Space complexity: O(N)
 * */
class Array {
	private long[] array;
	private int size;

	public Array(int max) {
		array = new long[max];
		size = 0;
	}

	/* Linear Search */
	public boolean find(long searchKey) {
		int j;
		for (j = 0; j < size; j++)
			if (array[j] == searchKey)
				return true;
		return false;
	}

	public void insert(long value) {
		array[size] = value;
		size++;
	}

	public boolean delete(long value) {
		int j;
		for (j = 0; j < size; j++)
			if (value == array[j]) {
				for (int k = j; k < size; k++)
					array[k] = array[k + 1];
				size--;
				return true;
			}
		return false;
	}

	public void display() {
		for (int j = 0; j < size; j++)
			System.out.print(array[j] + " ");
		System.out.println("");
	}
}

public class Arrays {

	public static void main(String[] args) {
		Array arr = new Array(100);

		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);

		arr.display();

		int searchKey = 35;
		if (arr.find(searchKey))
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can't find " + searchKey);

		arr.delete(00);
		arr.delete(55);
		arr.delete(99);

		arr.display();
	}
}