/*
 * The sum of the squares of the first ten natural numbers is,
 *1^2 + 2^2 + ... + 10^2 = 385
 *
 *The square of the sum of the first ten natural numbers is,
 *(1 + 2 + ... + 10)^2 = 552 = 3025
 *
 *Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum 
 *is 3025 − 385 = 2640.
 *
 *Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the 
 *sum.
 */

package e006_sumSquareDifference;

public class SumSquareDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sumOfSquares = 0;
		int squareOfSums = 0;
		int difference = 0;

		int temp = 0;

		//Sum = k(k+1)/2
		squareOfSums = (100*(101)/2)*(100*(101)/2);
	
		for (int i = 0; i <= 100; i++)
			sumOfSquares = sumOfSquares + (i * i);
		
		difference = squareOfSums - sumOfSquares;

		display(sumOfSquares, squareOfSums, difference);
	}

	public static void display(int sumOfS, int squareOfS, int dif) {
		System.out.println("Sum of squares: " + sumOfS + "\nSquare of sums: "
				+ squareOfS + "\nDifference: " + dif);
	}
}
