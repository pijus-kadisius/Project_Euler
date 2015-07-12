/*The following iterative sequence is defined for the set of positive integers:
 *
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 *
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
package e014_longestCollatzSeq;

public class LongestCollatzSeq {

	static int count = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int firstOfSequence = 0;
		int maxSequence = 0;
		int temp = 0;

		for (int i = 1; i < 1000001; i++) {
			temp = check(i);
			if (temp > maxSequence) {
				maxSequence = temp;
				firstOfSequence = i;
			}
			count = 1;
		}

		System.out.println("Starting Number: " + firstOfSequence
				+ "\nSequence Length: " + maxSequence);
	}

	// recursively find the length of the Collatz Sequence starting at integer
	// n; if n is int instead of long does not work
	public static int check(long n) {
		if (n == 1)
			return count;
		if (n % 2 == 0) {
			count++;
			check(n / 2);
		} else {
			count++;
			check(3 * n + 1);
		}
		return count;
	}
}
