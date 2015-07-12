/*
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 */

package e016_powerDigitSum;

import java.math.BigInteger;

public class PowerDigitSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pow = 1000;
		String base = "2";
		int sum = 0;
		String bigNumber = "";

		BigInteger a = new BigInteger("1");
		BigInteger temp = null;

		for (int i = 1; i <= pow; i++) {
			temp = new BigInteger(base);
			a = a.multiply(temp);
		}

		bigNumber = a.toString();
		for (int i = 0; i < bigNumber.length(); i++) {

			sum = sum + Integer.parseInt(bigNumber.substring(i, (i + 1)));

		}
		display(bigNumber, sum);
	}

	public static void display(String bigNum, int sum) {
		String out = "2^1000 = " + bigNum
				+ "\nThe sum of the digits of the number 2^100 is " + sum + ".";
		System.out.println(out);
	}

}
