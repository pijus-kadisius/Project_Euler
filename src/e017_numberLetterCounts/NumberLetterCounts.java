/*
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 
 * letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be 
 * used?
 *
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 
 * (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with
 * British usage.
 */

package e017_numberLetterCounts;

public class NumberLetterCounts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] singleNum = { "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine" };
		String[] teens = { "ten", "eleven", "twelve", "thirteen", "fourteen",
				"fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
		String[] tens = { "twenty", "thirty", "forty", "fifty", "sixty",
				"seventy", "eighty", "ninety" };
		String[] words = { "and", "hundred", "thousand" };

		int totalCount = 0;

		// 1-9
		int count1 = 0;
		for (String s : singleNum)
			count1 = count1 + s.length();

		// 10-19
		int count2 = 0;
		for (String s : teens)
			count2 = count2 + s.length();

		// 20-99
		int count3 = 0;

		for (String s : tens)
			count3 = count3 + (10 * s.length());
		// add numbers 1-9 to all tens (20,30, 40, etc...)
		count3 = count3 + 8 * count1;

		// 1-99
		int count4 = count1 + count2 + count3;

		// 100-999
		// 1-99: 9 times; singleNum: 100 times; and: 9*99 times; hundred: 900
		// times
		int count5 = 9 * count4 + 100 * count1 + (9 * 99) * words[0].length()
				+ 900 * (words[1].length());

		// 1-1000
		// 1-99 + 100-999 + 1000
		totalCount = count4 + count5 + singleNum[0].length()
				+ words[2].length();

		// Display message
		System.out
				.println("If the following numbers where written in words the corresponding number of letters would be used:\n");
		System.out.printf("Interval 1-9:\n# of Letters: " + count1
				+ "\n\nInterval 10-19:\n# of letters: " + count2
				+ "\n\nInterval 20-99:\n# of letters: " + count3
				+ "\n\nInterval 1-99:\n# of letters: " + count4
				+ "\n\nInterval 100-999:\n# of letters: " + count5
				+ "\n\nInterval: 1-1000:\n# of letters: " + totalCount + "\n\n");
		System.out
				.println("NOTE: Spaces or hyphens do not count. For example, 342 (three hundred and forty-two) "
						+ "\ncontains 23 letters and 115 (one hundred and fifteen) contains 20 letters. "
						+ "\nThe use of 'and' when writing out numbers is in compliance with British usage.");
	}

}
