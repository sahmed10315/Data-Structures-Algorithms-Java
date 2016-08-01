package math.elementaryalgorithms;

public class Powersof2 {

	public static void main(String[] args) {
		System.out.println(powersOf2(100));
	}

	static int powersOf2(int n) {
		if (n == 1) {
			System.out.println(1);
			return 1;
		} else {
			int prev = powersOf2(n / 2);
			int curr = prev * 2;
			System.out.println(curr);
			return curr;
		}
	}
}
