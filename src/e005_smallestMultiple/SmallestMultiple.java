package e005_smallestMultiple;

/*
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */

public class SmallestMultiple {
	public static void main(String[] args) {

		display(1, 10, lcm(1, 10));

		display(1, 20, lcm(1, 20));
	}

	// Reduction by the greatest common divisor to find LCM
	public static int lcm(int a, int b) {

		for (int i = 1; i < b; i++) {
			a = Math.abs(a * i) / gcd(a, i);
		}

		return a;
	}

	// Euclidean Algorithm to find GCD
	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public static void display(int a, int b, int lcm) {
		System.out
				.println("The smallest possitive number that is evenly divisible by all numbers from "
						+ a + " to " + b + " is " + lcm + ".");
	}
}
