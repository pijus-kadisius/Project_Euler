/*
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if
 * this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as 
 * the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater 
 * than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced 
 * any further by analysis even though it is known that the greatest number that cannot be expressed as the 
 * sum of two abundant numbers is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */
package e023_nonAbundantSums;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NonAbundantSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> abundantL = new ArrayList<Integer>();
		boolean[] allNum = new boolean[28123];
		long sum = 0;

		// allNum array holds false for all indexed values [0...28123]
		for (int i = 0; i < allNum.length; i++)
			allNum[i] = false;

		/*
		 * find all abundant numbers in range [12...28123]; add obtained numbers
		 * to abundantL
		 */
		for (int i = 12; i < 28123; i++)
			if (getPropDivSum(i) > i)
				abundantL.add(i);

		/*
		 * for all indices of array allNum that can be expressed as the sum of
		 * two abundant numbers assign 'true' since we know that all numbers
		 * >=28123 can be expressed as a sum of two abundant numbers break once
		 * the sum reaches 28123
		 */
		for (int i = 0; i < abundantL.size(); i++) {
			for (int j = i; j < abundantL.size(); j++) {
				if (abundantL.get(i) + abundantL.get(j) >= 28123)
					break;

				allNum[abundantL.get(i) + abundantL.get(j)] = true;

			}
		}

		/*
		 * add all indices of allNum array that have not been marked true to
		 * 
		 * obtain the sum of all numbers that cannot be expressed as the sum of
		 * two abundant numbers.
		 */
		for (int i = 0; i < allNum.length; i++)
			if (allNum[i] == false)
				sum = sum + i;

		System.out
				.println("Sum of all the positive integers which cannot be written as the sum of two abundant numbers: "
						+ sum);
	}

	// returns the sum of the proper divisors of integer 'n'
	public static int getPropDivSum(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++)
			if (n % i == 0)
				sum = sum + i;

		return sum;
	}
}
