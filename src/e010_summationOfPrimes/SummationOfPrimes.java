/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *	
 * Find the sum of all the primes below two million.
 */
package e010_summationOfPrimes;

public class SummationOfPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long sum = 0L;
		boolean isPrime = true;
		long upperBound = 2000000L;

		for (int i = 2; i < upperBound; i++) {

			if (isPrime(i) == true)
				sum = sum + i;

			isPrime = true;
		}
		display(sum, upperBound);
	}

	public static boolean isPrime(int p) {

		for (int i = 2; i <= Math.sqrt(p); i++) {
			if (p % i == 0)
				return false;
		}
		return true;
	}

	public static void display(long sum, long upperBound) {
		System.out.println("The sum of all the primes below " + upperBound
				+ ": " + sum + ".");
	}

}
