package simplesorts;
/* 
 * Bubble Sort 
 * Worst and Average Case Time Complexity: O(n^2). Worst case occurs when array is reverse sorted. There are N^2 swaps and N^2 comparisions for worst case
 * Best Case Time Complexity: O(n). Best case occurs when array is already sorted or may have some out-of-order elements nearly in position. 
 * Bubble sort has advantage to detect list is already sorted giving best time O(N). However, insertion sort is preferred as it also have that mechanism but performs better
 * on a sorted list.
 * Auxiliary Space: O(1)
 * Space complexity: O(N)
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
