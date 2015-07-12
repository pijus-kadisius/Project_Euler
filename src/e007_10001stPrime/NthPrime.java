/*
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 */

package e007_10001stPrime;

public class NthPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int primeToFind = 10001;

		int primeCount = 0;
		int currentNum = 2;
		int nthPrime = 0;

		while (primeCount < primeToFind) {

			if (isPrime(currentNum) == true) {
				primeCount++;
			}

			if (primeCount == 10001)
				nthPrime = currentNum;

			if (currentNum == 2)
				currentNum++;
			else
				currentNum = currentNum + 2;
		}

		display(primeToFind, nthPrime);
	}

	public static boolean isPrime(int p) {

		for (int i = 2; i <= Math.sqrt(p); i++) {
			if (p % i == 0)
				return false;
		}
		return true;
	}

	public static void display(int nthPrime, int primeVal) {
		System.out.println("The " + nthPrime + "st prime number is " + primeVal + ".");
	}
}