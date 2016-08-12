package advancedsorts;

public class MergeSort {
	public void mergesort(int[] array) {
		int[] workspace = new int[array.length];
		mergesort(array, workspace, 0, array.length - 1);
	}

	private void mergesort(int[] array, int[] workspace, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergesort(array, workspace, low, middle); // Sort left half
			mergesort(array, workspace, middle + 1, high); // Sort right half
			merge(array, workspace, low, middle, high); // Merge them
		}
	}

	private void merge(int[] array, int[] workspace, int low, int middle, int high) {
		/* Copy both halves into a helper array */
		for (int i = low; i <= high; i++) {
			workspace[i] = array[i];
		}

		int workspaceLeft = low;
		int workspaceRight = middle + 1;
		int current = low;

		/*
		 * Iterate through helper array. Compare the left and right half,
		 * copying back the smaller element from the two halves into the
		 * original array.
		 */
		while (workspaceLeft <= middle && workspaceRight <= high) {
			if (workspace[workspaceLeft] <= workspace[workspaceRight]) {
				array[current++] = workspace[workspaceLeft++];
			} else { // If right element is smaller than left element
				array[current++] = workspace[workspaceRight++];
			}
		}

		/*
		 * Copy the rest of the left side of the array into the target array
		 */
		int remaining = middle - workspaceLeft;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = workspace[workspaceLeft + i];
		}
	}

	public static void main(String[] args) { 
		int [] arr = {13, 54, 12, 67, 34, 43, 77, 25, 92, 176, 44, 6 };
		MergeSort mergeSort = new MergeSort();
		mergeSort.mergesort(arr);
		
		for(int x : arr)
			System.out.println(x);
	}

}