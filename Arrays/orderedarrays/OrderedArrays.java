package orderedarrays;
/* Ordered Array Abstract data type implementation 
 * 					Access	Search	Insertion	Deletion
 * Time complexity: O(1)	O(LogN)	O(N)	    O(n)
 * 
 * Space complexity: O(N)
 * */
class OrderedArray {

	private long[] array;  
	private int size;  

	public OrderedArray(int max)  
	{
		array = new long[max];  
		size = 0;
	}
 
	public int size() {
		return size;
	}
 
	/* Binary Search */
	public int find(long searchKey) {
		int low = 0;
		int high = size - 1;
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;
			
			if (array[mid] < searchKey)
				low = mid + 1;  
			else if (array[mid] > searchKey)
				high = mid - 1;  
			else
				return mid;
		}
		return -1;
	}  

	public void insert(long value) 
	{
		int j;
		for (j = 0; j < size; j++) // find where it goes through linear search
			if (array[j] > value)
				break;
		
		for (int k = size; k > j; k--) // move bigger ones up
			array[k] = array[k - 1];
		array[j] = value; 
		size++; 
	}  

	public boolean delete(long value) {
		int j = find(value);
		if (j == -1) // can't find it
			return false;
		else 
		{
			for (int k = j; k < size; k++) // move bigger ones down
				array[k] = array[k + 1];
			size--;
			return true;
		}
	}

	public void display() 
	{
		for (int j = 0; j < size; j++) 
			System.out.print(array[j] + " "); 
		System.out.println("");
	}
} 

public class OrderedArrays {
	public static void main(String[] args) { 
		OrderedArray arr = new OrderedArray(100);   

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

		int searchKey = 55;
		if (arr.find(searchKey) != -1)
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can't find " + searchKey);

		arr.display();  

		arr.delete(00); 
		arr.delete(55);
		arr.delete(99);

		arr.display(); 
	} 
}  