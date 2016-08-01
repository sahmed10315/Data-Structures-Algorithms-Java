package math.elementaryalgorithms;

/* Sum digits in a number 
 * Runtime Complexity: O(logN). Runtime will be the no of digits in the number. A number with d digits can have a value up to 10^d. If n = 10^d, then d = log n. 
 * */
public class SumDigits {

	public static int sumDigits(int n) {
		int sum = 0;
		while(n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
	
	public static void main(String [] args) {
		System.out.println(sumDigits(123456789));
	}
}