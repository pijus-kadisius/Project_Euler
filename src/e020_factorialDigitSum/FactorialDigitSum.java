/* n! means n × (n − 1) × ... × 3 × 2 × 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 */

package e020_factorialDigitSum;

import java.math.BigInteger;

public class FactorialDigitSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "";
		int sum = 0;
		num = factBigInt(100);
		sum = getDigitSum(factBigInt(100));

		display(num, sum);
	}

	public static String factBigInt(int n) {
		BigInteger bi = new BigInteger("" + n);
		BigInteger temp = null;

		for (int i = 1; i <= n; i++) {
			temp = new BigInteger("" + i);
			bi = bi.multiply(temp);
		}
		return bi.toString();
	}

	public static int getDigitSum(String n) {
		int sum = 0;
		for (int i = 0; i < n.length(); i++) {
			sum = sum + Integer.parseInt(n.substring(i, i + 1));
		}
		return sum;
	}

	public static void display(String num, int sum) {
		String out = "100! = " + num
				+ "\nThe sum of the digits in the number 100!:\n" + sum;
		System.out.println(out);
	}

}
