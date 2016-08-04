package simplesorts;
/* 
 * Bubble Sort 
 * Worst and Average Case Time Complexity: O(n^2). Worst case occurs when array is reverse sorted. There are N^2 swaps and N^2 comparisions for worst case
 * Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
 * Auxiliary Space: O(1)
 * Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
 * Sorting In Place: Yes
 * Stable: Yes
*/

public class BubbleSort {

	public static void bubbleSort(int[] arr) {
		boolean swapped;

		for (int i = 0; i < arr.length - 1; i++) {

			swapped = false;
			for (int j = 0; j < arr.length - 1 - i; j++)
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;

				}
			if (swapped == false)
				break;
		}
	}
}
