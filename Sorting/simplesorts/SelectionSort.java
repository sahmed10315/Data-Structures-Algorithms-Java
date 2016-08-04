package simplesorts;

/* 
 * Selection Sort 
 * Worst and Average Case Time Complexity: O(n^2) There are N swaps maximum and N^2 comparisons for worst case. Preferred if swap time is costly.
 * Best Case Time Complexity: O(n^2).
 * Auxiliary Space: O(1)
 * Sorting In Place: Yes
 * Stable: No
*/
public class SelectionSort {
	static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;

			for (int j = i + 1; j < arr.length; j++)
				if (arr[j] < arr[minIndex])
					minIndex = j;

			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 64, 25, 12, 22, 11 };
		selectionSort(arr);
		System.out.println("Sorted array");
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
