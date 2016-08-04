package simplesorts;

/* 
 * Insertion Sort 
 * Worst and Average Case Time Complexity: O(n^2) comparisions and swaps. Happens when elements are sorted in reverse order.
 * Best Case Time Complexity: O(n) comparisions and O(1) swaps. Best case occurs when array is already sorted. It can also 
 * be useful when input array is almost sorted, only few elements are misplaced in complete big array.
 * Auxiliary Space: O(1)
 * Sorting In Place: Yes
 * Stable: Yes
*/
public class InsertionSort {

	static void insertionSort(int [] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			
			while(j >= 0 && arr[j] > key)
			{
				arr[j + 1] = arr[j];
				j--;
			}
			
			arr[j+1] = key;
		}
	}
	
	public static void main(String [] args) { 
        int arr[] = {64,25,12,22,11};
        insertionSort(arr);
        System.out.println("Sorted array");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
	}
}
