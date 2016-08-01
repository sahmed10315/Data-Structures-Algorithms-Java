package math.elementaryalgorithms;

/* Computes a^b 
 * Time complexity: O(b)
 * */
public class Exponent {

	public static void main(String []args) {
		System.out.println(power(5, 8));
	}
	
	static int power (int a, int b) {
		if (b < 0) 
			return 0;
		else if(b == 0)
			return 1;
		else 
			return a * power(a, b - 1);
	}
}