package math.elementaryalgorithms;

/* 
 * Calculate prime of a number 
 * Time complexity: O(sqrt(n))
 * */

public class IsPrime {
	
	public static void main(String [] args) {
		System.out.println(isPrime(17));
	}
	
	static boolean isPrime (int n) {
		for (int x = 2; x <= Math.sqrt(n); x++) {
			if (n % x == 0) 
				return false;
		}
		return true;
	}
}
