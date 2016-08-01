package foundation.elementaryalgo;

/* 
 * Find minimum and maximum number in an array 
 * Time complexity = O(N) 
 * */
public class MinMax {
	public static void main(String [] args) {
		
		int [] array = {44, 31, 14, 5, 22, 55, 234, 11, 54, 22}; 
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int x : array) {
			if (x < min) 
				min = x;
			if (x > max)
				max = x;
		}
		
		System.out.println("Minimum: " + min);
		System.out.println("Maximum: " + max);
	}
}
