package math.elementaryalgorithms;

public class SquareRoot {
	
	public static void main(String [] args) {
		System.out.println(squrerootSimple(64));
		System.out.println(squareRootBinSearch(64));

	}
	
	static int squrerootSimple(int n ) {
		for (int guess = 1; guess * guess <= n ; guess++)
			if (guess * guess == n)
				return guess;
		
		return -1;
	}
	
	static int squareRootBinSearch(int n) {
		return sqrt_helper(n , 1, n);
	}
	
	static int sqrt_helper(int n, int min, int max) {
		
		if (max < min) return -1;
		
		int guess = (min + max) / 2;
		if (guess * guess == n) 
			return guess;
		else if(guess * guess < n)
			return sqrt_helper(n, guess + 1, max);
		else
			return sqrt_helper(n, 1, guess - 1);
	}
}