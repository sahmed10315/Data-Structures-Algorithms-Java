package math.elementaryalgorithms;

public class Modulus {
	public static void main(String[] args) {
		System.out.println(modulus(44, 3));
	}

	static int modulus(int a, int b) {
		if (b <= 0)
			return -1;

		int div = a / b;
		return a - div * b;
	}
}
