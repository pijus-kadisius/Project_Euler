	/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is
9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
 */

package e004_largestPalindromeProduct;

public class LargestPalindromeProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int upperNum = 999;
		int lowerNum = 100;
		int palindromeProduct = 0;
		int largestPalindromeProduct = 0;

		for (int i = 100; i <= upperNum; i++) {
			for (int j = 999; j >= lowerNum; j--) {
				palindromeProduct = i * j;

				if (isPalindrome("" + palindromeProduct) == true) {
					if (palindromeProduct > largestPalindromeProduct)
						largestPalindromeProduct = i * j;
				}
			}
		}
		System.out
				.println("The largest palindrome made from the product of two 3-digit numbers: "
						+ largestPalindromeProduct + ".");
	}

	// checks if string is a palindrome
	public static boolean isPalindrome(String s) {
		int i1 = 0;
		int i2 = s.length() - 1;

		while (i2 > i1) {
			if (s.charAt(i2) != s.charAt(i1))
				return false;

			i1++;
			i2--;
		}
		return true;
	}

}
