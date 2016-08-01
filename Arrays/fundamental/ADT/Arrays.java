package fundamental.ADT;

class Array {
	private long[] array;
	private int nElems;

	public Array(int max) {
		array = new long[max];
		nElems = 0;
	}

	/* Linear Search */
	public boolean find(long searchKey) {
		int j;
		for (j = 0; j < nElems; j++)
			if (array[j] == searchKey)
				return true;
		return false;
	}

	public void insert(long value) {
		array[nElems] = value;
		nElems++;
	}

	public boolean delete(long value) {
		int j;
		for (j = 0; j < nElems; j++)
			if (value == array[j]) {
				for (int k = j; k < nElems; k++)
					array[k] = array[k + 1];
				nElems--;
				return true;
			}
		return false;
	}

	public void display() {
		for (int j = 0; j < nElems; j++)
			System.out.print(array[j] + " ");
		System.out.println("");
	}
}

public class Arrays {

	public static void main(String[] args) {
		int maxSize = 100;
		Array arr;
		arr = new Array(maxSize);

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