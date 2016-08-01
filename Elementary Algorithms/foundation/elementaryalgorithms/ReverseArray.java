package foundation.elementaryalgorithms;

/* Program to reverse an array 
 * Time complexity = O(N) 
 */
public class ReverseArray {
	public static void main(String [] args) {
		
		int [] intArray = { 1, 33, 46, 16, 76, 9 };
		
		for (int no : intArray)
			System.out.println(no);
		
		reverse(intArray);

		for (int no : intArray)
			System.out.println(no);
		
	}
	
	static void reverse(int [] array) {
		for(int i = 0; i < array.length / 2; i++) {
			int other = array.length - i - 1;
			int temp = array[i];
			array[i] = array[other];
			array[other] = temp;
		}
	}
}
