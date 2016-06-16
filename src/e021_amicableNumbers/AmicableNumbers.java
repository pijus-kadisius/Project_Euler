/*
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 *
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called 
 * amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 */

package e021_amicableNumbers;

import java.util.ArrayList;
import java.util.Iterator;

public class AmicableNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> amicablePairs = findAmicPairs(10001);
		int amicPairSum = getSum(amicablePairs);

		display(amicablePairs, amicPairSum);

	}

	// takes integer n as parameter, returns an arrayList containing all proper
	// divisors of n.
	public static ArrayList<Integer> getPropDiv(int n) {
		ArrayList<Integer> div = new ArrayList<Integer>();
		for (int i = 1; i < n; i++)
			if (n % i == 0)
				div.add(i);

		return div;
	}

	// takes arrayList<Integers> as paramater; returns the sum of all elements
	// in the ArrayList
	public static int getSum(ArrayList<Integer> a) {
		int sum = 0;
		for (int i = 0; i < a.size(); i++)
			sum = sum + a.get(i);

		return sum;
	}

	public static ArrayList<Integer> findAmicPairs(int upperBound) {
		int[] l = new int[upperBound];
		ArrayList<Integer> amic = new ArrayList<Integer>();

		for (int i = 1; i < 10001; i++) {
			l[i] = getSum(getPropDiv(i));
			for (int j = 1; j < i; j++)
				if (l[i] == j && l[j] == i) {
					amic.add(i);
					amic.add(j);
				}

		}
		return amic;
	}

	// displays formatted output
	public static void display(ArrayList<Integer> amicPairs, int sum) {
		String out = "";
		out = out + "Amicable pairs of numbers under 10000:\n\n";

		Iterator<Integer> i = amicPairs.iterator();

		while (i.hasNext() == true) {
			out = out + "[" + i.next() + " " + i.next() + "]\n";
		}

		out = out + "\nThe sum of all the amicable numbers under 10000:\n"
				+ sum;
		System.out.println(out);
	}
}
